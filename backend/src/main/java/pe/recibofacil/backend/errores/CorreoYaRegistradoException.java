package pe.recibofacil.backend.errores;

public class CorreoYaRegistradoException extends RuntimeException {

    public CorreoYaRegistradoException() {
        super("Ese correo ya está en uso. Inicia sesión o usa otro correo.");
    }
}