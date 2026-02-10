# APUNTES DETALLADOS - SPRING BOOT Y POSTMAN

## ÍNDICE
1. [Introducción a Spring Boot](#introducción-a-spring-boot)
2. [Estructura del Proyecto](#estructura-del-proyecto)
3. [Componentes Principales de Spring](#componentes-principales-de-spring)
4. [APIs REST y Endpoints](#apis-rest-y-endpoints)
5. [Integración con Postman](#integración-con-postman)
6. [Persistencia con JPA](#persistencia-con-jpa)
7. [Configuración y Dependencias](#configuración-y-dependencias)
8. [Buenas Prácticas y Ejemplos](#buenas-prácticas-y-ejemplos)

---

## INTRODUCCIÓN A SPRING BOOT

### ¿Qué es Spring Boot?
Spring Boot es un framework que simplifica la creación de aplicaciones Spring listas para producción. Proporciona:

- **Configuración automática**: Reduce la necesidad de configuración manual
- **Starter dependencies**: Facilita la inclusión de dependencias comunes
- **Servidor embebido**: No requiere instalación de servidor externo
- **Métricas y health checks**: Monitoreo incorporado

### Versiones Utilizadas
- **Spring Boot**: 4.0.2 (Maven) / 4.0.1 (Gradle)
- **Java**: 17 (Maven) / 21 (Gradle)
- **MySQL**: Base de datos relacional

---

## ESTRUCTURA DEL PROYECTO

### Organización por Proyectos
El workspace contiene múltiples proyectos Spring Boot, cada uno enfocado en diferentes aspectos:

```
springt4.32.2/
├── rest/                    # API REST básica
├── jpa-1/                   # JPA con usuarios
├── jpa-2/                   # JPA con relaciones deportivas
├── jpa-4/                   # JPA con sucursales bancarias
├── jpa-ejerBanca/          # Dominio bancario completo
├── jpa-ejerCompeticionesSkills/ # Competiciones deportivas
├── jpa-ejerSociedadMercantil/  # Sociedad mercantil
└── thym/                   # Thymeleaf para vistas web
```

### Estructura Típica de un Proyecto
```
proyecto/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/package/
│   │   │       ├── controller/  # @RestController
│   │   │       ├── service/     # @Service
│   │   │       ├── repository/  # JpaRepository
│   │   │       ├── model/       # @Entity
│   │   │       └── Application.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
├── pom.xml o build.gradle
└── HELP.md
```

---

## COMPONENTES PRINCIPALES DE SPRING

### 1. Controllers (@RestController)

#### UsuarioController (jpa-1)
```java
@RestController
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarios;
    
    @GetMapping({"/","usuarios"})
    public List<Usuario> getAll(){
        return (List<Usuario>) usuarios.findAll();
    }
    
    @PostMapping("/insert")
    public void createUser(@RequestBody Usuario user) {
        usuarios.save(user);
    }
    
    @PutMapping("/update")
    public void updateUser(@RequestBody Usuario user) {
        usuarios.save(user);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        usuarios.delete(id);
    }
}
```

#### HolaController (rest)
```java
@RestController
public class HolaController {
    
    @GetMapping(value = "/index", produces = MediaType.APPLICATION_JSON_VALUE)
    public String index() {
        return "Hola Mundo";
    }
}
```

#### BancoController (jpa-ejerBanca)
```java
@RestController
public class BancoController {
    
    @Autowired
    ClientesServices clientes;
    @Autowired
    CuentasServices cuentas;
    
    @PostMapping("/cliente")
    public void crearClientes(@RequestBody Clientes cli) {
        clientes.save(cli);
    }
    
    @PostMapping("/cuenta")
    public void crearCuenta(@RequestBody Cuentas cue) {
        cuentas.save(cue);
    }
    
    @GetMapping("/clientes")
    public List<Clientes> getAll(){
        return (List<Clientes>) clientes.findAll();
    }
}
```

### 2. Services (@Service)

#### Interfaz de Servicio
```java
public interface UsuarioService {
    List<Usuario> findAll();
    void save(Usuario usuario);
    Usuario findById(Long id);
    void delete(Long id);
}
```

#### Implementación del Servicio
```java
@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public java.util.List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    
    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    
    @Override
    public Usuario findById(Long id) {
        Optional<Usuario> userResult = usuarioRepository.findById(id);
        return null; // ⚠️ Error: debería retornar el usuario o lanzar excepción
    }
    
    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
```

### 3. Repositories (JpaRepository)

```java
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Spring Data JPA proporciona automáticamente:
    // - save()
    // - findById()
    // - findAll()
    // - deleteById()
    // - count()
    // - existsById()
}
```

### 4. Entities (@Entity)

#### Usuario (jpa-1)
```java
@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    
    @Id
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellidos")
    private String apellido;
    
    @Column(name = "edad")
    private Long edad;
}
```

#### Club con Relaciones (jpa-2)
```java
@Entity
@Table(name = "clubes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Club {
    @Id
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @OneToOne  // Un club tiene un entrenador
    private Entrenador entrenador;
    
    @OneToMany
    @JoinColumn(name = "id_club")
    private List<Jugador> jugadores;
    
    @ManyToMany
    private List<Competicion> competicions;
}
```

---

## APIS REST Y ENDPOINTS

### Proyecto REST (puerto por defecto 8080)
```
GET /index
Response: "Hola Mundo"
Content-Type: application/json
```

### Proyecto JPA-1 (puerto 84)
```
GET /usuarios
Response: List<Usuario>
Content-Type: application/json

POST /insert
Body: {"id": 1, "nombre": "Juan", "apellido": "Pérez", "edad": 25}
Response: 201 Created

PUT /update
Body: {"id": 1, "nombre": "Juan", "apellido": "García", "edad": 26}
Response: 200 OK

DELETE /delete/{id}
Response: 204 No Content
```

### Proyecto Banco (jpa-ejerBanca)
```
POST /cliente
Body: {
  "id": 1,
  "nombre": "Ana",
  "apellido": "López",
  "dni": "12345678A"
}

POST /cuenta
Body: {
  "id": 1,
  "numero": "ES1234567890",
  "saldo": 1000.50,
  "cliente": {"id": 1}
}

GET /clientes
Response: List<Clientes>
```

---

## INTEGRACIÓN CON POSTMAN

### ¿Qué es Postman?
Postman es una herramienta para probar y documentar APIs REST. Permite:
- Enviar peticiones HTTP con diferentes métodos
- Gestionar colecciones de peticiones
- Automatizar tests
- Documentar APIs

### Configuración de Postman para estos Proyectos

#### 1. Variables de Entorno
```json
{
  "local": {
    "base_url": "http://localhost",
    "puerto_rest": "8080",
    "puerto_jpa1": "84",
    "puerto_jpa2": "85"
  }
}
```

#### 2. Colección Sugerida para JPA-1

**Crear Usuario**
```http
POST {{local.base_url}}:{{local.puerto_jpa1}}/insert
Content-Type: application/json

{
  "id": 1,
  "nombre": "Juan",
  "apellido": "Pérez",
  "edad": 25
}
```

**Listar Todos los Usuarios**
```http
GET {{local.base_url}}:{{local.puerto_jpa1}}/usuarios
```

**Actualizar Usuario**
```http
PUT {{local.base_url}}:{{local.puerto_jpa1}}/update
Content-Type: application/json

{
  "id": 1,
  "nombre": "Juan",
  "apellido": "García",
  "edad": 26
}
```

**Eliminar Usuario**
```http
DELETE {{local.base_url}}:{{local.puerto_jpa1}}/delete/1
```

#### 3. Tests Automatizados en Postman

**Test para Crear Usuario**
```javascript
pm.test("Status code is 201", function () {
    pm.response.to.have.status(201);
});

pm.test("Response time is less than 200ms", function () {
    pm.expect(pm.response.responseTime).to.be.below(200);
});
```

**Test para Listar Usuarios**
```javascript
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response is array", function () {
    pm.expect(pm.response.json()).to.be.an('array');
});

pm.test("Array has users", function () {
    pm.expect(pm.response.json().length).to.be.above(0);
});
```

#### 4. Ejemplos de Uso con Postman

**Ejemplo 1: Crear y Verificar Usuario**
1. **POST** `/insert` con datos de usuario
2. **GET** `/usuarios` para verificar que se creó
3. **GET** `/usuarios/{id}` para obtener usuario específico

**Ejemplo 2: Flujo Completo CRUD**
1. **POST** `/insert` - Crear usuario
2. **GET** `/usuarios` - Listar todos
3. **PUT** `/update` - Modificar usuario
4. **GET** `/usuarios` - Verificar modificación
5. **DELETE** `/delete/{id}` - Eliminar usuario
6. **GET** `/usuarios` - Confirmar eliminación

---

## PERSISTENCIA CON JPA

### Configuración de Base de Datos

#### application.properties (jpa-1)
```properties
spring.application.name=jpa-1
spring.datasource.url=jdbc:mysql://localhost:3306/prueba
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
server.port=84
```

#### application.properties (jpa-2)
```properties
spring.application.name=jpa-2
spring.datasource.url=jdbc:mysql://localhost:3306/deportes
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=85
```

### Tipos de Relaciones JPA

#### @OneToOne (Uno a Uno)
```java
@Entity
public class Entrenador {
    @Id
    private Long id;
    private String nombre;
    
    @OneToOne(mappedBy = "entrenador")
    private Club club;
}
```

#### @OneToMany (Uno a Muchos)
```java
@Entity
public class Club {
    @Id
    private Long id;
    
    @OneToMany
    @JoinColumn(name = "id_club")
    private List<Jugador> jugadores;
}

@Entity
public class Jugador {
    @Id
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_club")
    private Club club;
}
```

#### @ManyToMany (Muchos a Muchos)
```java
@Entity
public class Club {
    @Id
    private Long id;
    
    @ManyToMany
    @JoinTable(
        name = "club_competicion",
        joinColumns = @JoinColumn(name = "club_id"),
        inverseJoinColumns = @JoinColumn(name = "competicion_id")
    )
    private List<Competicion> competiciones;
}
```

### Operaciones CRUD con JPA

#### Create (Crear)
```java
@PostMapping("/insert")
public void createUser(@RequestBody Usuario user) {
    usuarios.save(user);
}
```

#### Read (Leer)
```java
@GetMapping("/usuarios")
public List<Usuario> getAll(){
    return (List<Usuario>) usuarios.findAll();
}

@GetMapping("/usuarios/{id}")
public Usuario getById(@PathVariable Long id){
    return usuarios.findById(id).orElse(null);
}
```

#### Update (Actualizar)
```java
@PutMapping("/update")
public void updateUser(@RequestBody Usuario user) {
    usuarios.save(user);
}
```

#### Delete (Eliminar)
```java
@DeleteMapping("/delete/{id}")
public void deleteUser(@PathVariable Long id) {
    usuarios.delete(id);
}
```

---

## CONFIGURACIÓN Y DEPENDENCIAS

### Maven (pom.xml)

#### Dependencias Principales
```xml
<dependencies>
    <!-- Spring Boot Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-webmvc</artifactId>
    </dependency>
    
    <!-- Spring Data JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <!-- MySQL Driver -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    
    <!-- DevTools -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
</dependencies>
```

### Gradle (build.gradle)

#### Dependencias Principales
```gradle
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-webmvc'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    testImplementation 'org.springframework.boot:spring-boot-starter-webmvc-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}
```

### Configuración de Lombok

Lombok reduce código boilerplate generando automáticamente:
- Getters y setters (`@Data`)
- Constructores (`@NoArgsConstructor`, `@AllArgsConstructor`)
- `toString()`, `equals()`, `hashCode()`

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private Long id;
    private String nombre;
    private String apellido;
    private Long edad;
}
```

---

## BUENAS PRÁCTICAS Y EJEMPLOS

### 1. Estructura de Paquetes Recomendada

```
com.company.project/
├── controller/
│   ├── UsuarioController.java
│   └── ClienteController.java
├── service/
│   ├── UsuarioService.java
│   ├── UsuarioServiceImpl.java
│   └── ClienteService.java
├── repository/
│   ├── UsuarioRepository.java
│   └── ClienteRepository.java
├── model/
│   ├── Usuario.java
│   └── Cliente.java
├── dto/
│   ├── UsuarioDTO.java
│   └── ClienteDTO.java
├── exception/
│   ├── UsuarioNotFoundException.java
│   └── GlobalExceptionHandler.java
└── config/
    ├── DatabaseConfig.java
    └── SecurityConfig.java
```

### 2. Manejo de Excepciones

#### Custom Exception
```java
public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(Long id) {
        super("Usuario no encontrado con id: " + id);
    }
}
```

#### Global Exception Handler
```java
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUsuarioNotFound(
            UsuarioNotFoundException ex) {
        
        ErrorResponse error = new ErrorResponse(
            "USUARIO_NO_ENCONTRADO",
            ex.getMessage()
        );
        
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
```

### 3. DTOs (Data Transfer Objects)

#### UsuarioDTO
```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nombreCompleto;  // nombre + apellido
    private Integer edad;
    
    // Constructor desde Entity
    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nombreCompleto = usuario.getNombre() + " " + usuario.getApellido();
        this.edad = usuario.getEdad().intValue();
    }
}
```

### 4. Validación con Bean Validation

#### Entity con Validaciones
```java
@Entity
public class Usuario {
    
    @Id
    @NotNull(message = "El ID no puede ser nulo")
    private Long id;
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;
    
    @Email(message = "El email debe ser válido")
    private String email;
    
    @Min(value = 18, message = "La edad mínima es 18")
    @Max(value = 120, message = "La edad máxima es 120")
    private Integer edad;
}
```

#### Controller con Validación
```java
@PostMapping("/insert")
public ResponseEntity<Usuario> createUser(
        @Valid @RequestBody Usuario usuario,
        BindingResult result) {
    
    if (result.hasErrors()) {
        return ResponseEntity.badRequest().build();
    }
    
    Usuario savedUser = usuarios.save(usuario);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
}
```

### 5. Tests con JUnit 5

#### Test de Controller
```java
@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private UsuarioService usuarioService;
    
    @Test
    void shouldGetAllUsuarios() throws Exception {
        List<Usuario> usuarios = Arrays.asList(
            new Usuario(1L, "Juan", "Pérez", 25L)
        );
        
        when(usuarioService.findAll()).thenReturn(usuarios);
        
        mockMvc.perform(get("/usuarios"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].nombre", is("Juan")));
    }
}
```

### 6. Configuración de Seguridad Básica

#### SecurityConfig
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults());
        
        return http.build();
    }
}
```

### 7. Documentación con OpenAPI/Swagger

#### Dependencia
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.0.0</version>
</dependency>
```

#### Configuración
```java
@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Usuarios")
                .version("1.0")
                .description("API para gestión de usuarios"));
    }
}
```

---

## POSTMAN - GUÍA PRÁCTICA COMPLETA

### 1. Instalación y Configuración

#### Pasos Iniciales
1. Descargar Postman desde [postman.com](https://www.postman.com)
2. Crear cuenta gratuita
3. Instalar aplicación de escritorio (recomendado)

#### Configuración del Workspace
```
Workspace: Spring Boot APIs
Tipo: Personal
Descripción: APIs para testing de proyectos Spring Boot
```

### 2. Creación de Colecciones

#### Colección: Spring Boot JPA-1
```json
{
  "info": {
    "name": "Spring Boot JPA-1",
    "description": "APIs para gestión de usuarios",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "variable": [
    {
      "key": "base_url",
      "value": "http://localhost:84",
      "type": "string"
    }
  ]
}
```

### 3. Peticiones Detalladas

#### GET - Listar Todos los Usuarios
```http
GET {{base_url}}/usuarios
Headers:
  Content-Type: application/json
  Accept: application/json

Tests:
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});

pm.test("Response has users array", function () {
    pm.expect(pm.response.json()).to.be.an('array');
});
```

#### POST - Crear Nuevo Usuario
```http
POST {{base_url}}/insert
Headers:
  Content-Type: application/json

Body (raw JSON):
{
  "id": 1,
  "nombre": "Carlos",
  "apellido": "Rodríguez",
  "edad": 30
}

Tests:
pm.test("Status code is 200 or 201", function () {
    pm.expect(pm.response.code).to.be.oneOf([200, 201]);
});

pm.test("User created successfully", function () {
    if (pm.response.code === 200 || pm.response.code === 201) {
        pm.environment.set("last_created_id", "1");
    }
});
```

#### PUT - Actualizar Usuario
```http
PUT {{base_url}}/update
Headers:
  Content-Type: application/json

Body:
{
  "id": 1,
  "nombre": "Carlos",
  "apellido": "Sánchez",
  "edad": 31
}

Tests:
pm.test("User updated successfully", function () {
    pm.response.to.have.status(200);
});
```

#### DELETE - Eliminar Usuario
```http
DELETE {{base_url}}/delete/1
Headers:
  Content-Type: application/json

Tests:
pm.test("User deleted successfully", function () {
    pm.response.to.have.status(204);
});
```

### 4. Automatización de Tests

#### Test Suite Completo
```javascript
// Test Suite para CRUD de Usuarios
pm.test("CRUD Operations Test Suite", function () {
    
    // Test 1: GET all users
    pm.test("GET /usuarios - Should return array", function () {
        pm.expect(pm.response.json()).to.be.an('array');
    });
    
    // Test 2: POST create user
    pm.test("POST /insert - Should create user", function () {
        pm.expect(pm.response.code).to.be.oneOf([200, 201]);
    });
    
    // Test 3: Response time
    pm.test("Response time < 500ms", function () {
        pm.expect(pm.response.responseTime).to.be.below(500);
    });
    
    // Test 4: Content-Type
    pm.test("Content-Type is JSON", function () {
        pm.expect(pm.response.headers.get("Content-Type")).to.include("application/json");
    });
});
```

### 5. Variables y Entornos

#### Variables de Entorno
```json
{
  "local": {
    "base_url": "http://localhost",
    "puerto_jpa1": "84",
    "puerto_jpa2": "85",
    "puerto_rest": "8080"
  },
  "production": {
    "base_url": "https://api.miempresa.com",
    "puerto_jpa1": "443",
    "puerto_jpa2": "443",
    "puerto_rest": "443"
  }
}
```

#### Variables Globales
```javascript
// En el script de pruebas
pm.globals.set("api_version", "v1");
pm.globals.set("timeout", "5000");

// Usar en peticiones
GET {{base_url}}:{{puerto_jpa1}}/{{api_version}}/usuarios
```

### 6. Flujos de Trabajo (Workflows)

#### Workflow: Crear y Verificar Usuario
```javascript
// Script de prueba para POST /insert
if (pm.response.code === 200 || pm.response.code === 201) {
    // Guardar ID para siguientes peticiones
    const userId = pm.response.json().id;
    pm.environment.set("current_user_id", userId);
    
    // Ejecutar automáticamente GET para verificar
    postman.setNextRequest("Get User by ID");
} else {
    postman.setNextRequest(null);
}
```

#### Workflow: Eliminar después de Test
```javascript
// Script de prueba final
if (pm.environment.get("cleanup_after_test") === "true") {
    postman.setNextRequest("Delete User");
} else {
    postman.setNextRequest(null);
}
```

### 7. Documentación en Postman

#### Descripción de API
```markdown
# API de Usuarios

## Descripción
API para la gestión de usuarios en el sistema.

## Autenticación
Actualmente sin autenticación (modo desarrollo).

## Endpoints

### GET /usuarios
Retorna la lista completa de usuarios.

**Response:**
```json
[
  {
    "id": 1,
    "nombre": "Juan",
    "apellido": "Pérez",
    "edad": 25
  }
]
```

### POST /insert
Crea un nuevo usuario.

**Request Body:**
```json
{
  "id": 1,
  "nombre": "Juan",
  "apellido": "Pérez",
  "edad": 25
}
```
```

### 8. Monitoreo y Performance

#### Tests de Performance
```javascript
// Performance tests
pm.test("Response time is acceptable", function () {
    pm.expect(pm.response.responseTime).to.be.below(1000);
});

pm.test("Server is responding quickly", function () {
    if (pm.response.responseTime > 500) {
        console.warn("Slow response detected: " + pm.response.responseTime + "ms");
    }
});
```

#### Health Check
```http
GET {{base_url}}/actuator/health
Tests:
pm.test("Health check passed", function () {
    pm.expect(pm.response.json().status).to.eql("UP");
});
```

---

## CONCLUSIONES Y RECOMENDACIONES

### Resumen del Proyecto
Este conjunto de proyectos Spring Boot proporciona una excelente base para aprender:

1. **Desarrollo de APIs REST** con Spring Boot
2. **Persistencia de datos** con Spring Data JPA
3. **Relaciones entre entidades** con JPA/Hibernate
4. **Testing de APIs** con Postman
5. **Buenas prácticas** en desarrollo de software

### Próximos Pasos Recomendados

#### Para Spring Boot
1. **Añadir Spring Security** para autenticación
2. **Implementar DTOs** para separar capas
3. **Crear tests unitarios** y de integración
4. **Añadir logging** con SLF4J
5. **Implementar caching** con Redis

#### Para Postman
1. **Crear colecciones completas** para cada API
2. **Automatizar tests** con Newman
3. **Configurar CI/CD** para testing automático
4. **Documentar APIs** con descripciones detalladas
5. **Monitorear performance** de los endpoints

### Mejoras Identificadas

#### Código
- Corregir `findById()` en `UsuarioServiceImpl`
- Añadir manejo de excepciones
- Implementar validaciones
- Crear DTOs para transferencia de datos

#### Testing
- Crear tests de integración completos
- Añadir tests de rendimiento
- Implementar tests con diferentes escenarios
- Configurar testing automatizado

#### Postman
- Crear colecciones organizadas
- Implementar tests automatizados
- Añadir documentación detallada
- Configurar monitoreo de APIs

Este proyecto representa una base sólida para el desarrollo de aplicaciones web modernas con Spring Boot y proporciona las herramientas necesarias para testing profesional con Postman.