package es.jcyl.cursofswd.porhacer.excepciones;

public class PorHacerExcepcion extends Exception {

    private static final long serialVersionUID = 1L;
    private String errorMessage;

    public PorHacerExcepcion() { super(); }

    public PorHacerExcepcion(String message) {
        super(message);
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
