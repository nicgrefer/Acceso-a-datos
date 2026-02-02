package com.gf.ejer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import com.gf.ejer.model.*;

public interface ClienteRepository extends JpaRepository<Clientes,Long>{

}
