package controller;

public class Cotizacion {

    // Atributos
    private String ciclo;
    private String evalua;
    private Double actual = 0.0;
    private Double anterior = 0.0;

    // Constructor vacío
    public Cotizacion() { }

    public Cotizacion(String ciclo, Double anterior) {
		super();
		this.ciclo = ciclo;
		this.anterior = anterior;
	}
    
    // Constructor con parámetros
    public Cotizacion(String ciclo, Double actual, Double anterior) {
        this.ciclo = ciclo;
        this.actual = actual;
        this.anterior = anterior;
        setEvalua(); // Calculamos automáticamente la evaluación
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getEvalua() {
        return evalua;
    }

    /**
     * Calcula el valor de "evalua" en base a actual y anterior.
     */
    public void setEvalua() {

        if (actual == null || actual == 0.0) {
            this.evalua = "NO COTIZA";
            return;
        }

        if (anterior == null) anterior = 0.0;

        if (actual > anterior) {
            this.evalua = "Mayor";
        } else if (actual < anterior) {
            this.evalua = "Menor";
        } else {
            this.evalua = "Igual";
        }
    }

    public Double getActual() {
        return actual;
    }

    public void setActual(Double actual) {
        this.actual = actual;
        setEvalua(); // recalcular automáticamente
    }

    public Double getAnterior() {
        return anterior;
    }

    public void setAnterior(Double anterior) {
        this.anterior = anterior;
        setEvalua(); // recalcular automáticamente
    }
}
