package pe.recibofacil.backend.autenticacion;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.recibofacil.backend.errores.CorreoYaRegistradoException;
import pe.recibofacil.backend.usuario.Usuario;
import pe.recibofacil.backend.usuario.UsuarioRepository;

@Service
public class AutenticacionService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AutenticacionService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioResponse registrar(RegistroRequest solicitud) {
        String correo = solicitud.correo().trim().toLowerCase();

        if (usuarioRepository.existsByCorreo(correo)) {
            throw new CorreoYaRegistradoException();
        }

        String contrasenaCifrada = passwordEncoder.encode(solicitud.contrasena());
        Usuario guardado = usuarioRepository.save(new Usuario(correo, contrasenaCifrada));

        return new UsuarioResponse(guardado.getId(), guardado.getCorreo());
    }
}