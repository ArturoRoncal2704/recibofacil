package pe.recibofacil.backend.errores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ManejadorDeErrores {

    @ExceptionHandler(CorreoYaRegistradoException.class)
    public ResponseEntity<Map<String, List<String>>> correoYaRegistrado(CorreoYaRegistradoException error) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Map.of("mensajes", List.of(error.getMessage())));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> datosInvalidos(MethodArgumentNotValidException error) {
        List<String> mensajes = error.getBindingResult().getFieldErrors().stream()
                .map(campo -> campo.getDefaultMessage())
                .toList();
        return ResponseEntity.badRequest().body(Map.of("mensajes", mensajes));
    }
}