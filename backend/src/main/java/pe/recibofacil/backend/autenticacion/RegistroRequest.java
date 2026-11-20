package pe.recibofacil.backend.autenticacion;

import jakarta.validation.constraints.*;

import java.nio.charset.StandardCharsets;


        public record RegistroRequest(
                @NotBlank(message = "Ingresa tu correo.")
                @Size(max = 254, message = "El correo no puede tener más de 254 caracteres.")
                @Email(message = "El correo no tiene un formato válido. Ejemplo: maria@correo.com")
                String correo,

                @NotBlank(message = "Ingresa una contraseña.")
                @Size(max = 64, message = "La contraseña no puede tener más de 64 caracteres.")
                @Pattern(
                        regexp = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$",
                        message = "La contraseña debe tener mínimo 8 caracteres e incluir al menos una letra y un número.")
                String contrasena
        ) {

                @AssertTrue(message = "La contraseña contiene demasiados caracteres especiales. Usa una más corta.")
                public boolean isContrasenaDentroDelLimiteDeBytes() {
                        return contrasena == null || contrasena.getBytes(StandardCharsets.UTF_8).length <= 72;
                }
        }