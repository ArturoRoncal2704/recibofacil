package pe.recibofacil.backend.autenticacion;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegistroRequest(
        @NotBlank(message = "Ingresa tu correo.")
        @Email(message = "El correo no tiene un formato válido. Ejemplo: maria@correo.com")
        String correo,

        @NotBlank(message = "Ingresa una contraseña.")
        @Pattern(
                regexp = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$",
                message = "La contraseña debe tener mínimo 8 caracteres e incluir al menos una letra y un número.")
        String contrasena
) {
}