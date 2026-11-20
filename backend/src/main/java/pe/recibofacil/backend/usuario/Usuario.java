package pe.recibofacil.backend.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(name = "contrasena_cifrada", nullable = false)
    private String contrasenaCifrada;

    @Column(name = "creado_en", insertable = false, updatable = false)
    private OffsetDateTime creadoEn;

    protected Usuario() {
    }

    public Usuario(String correo, String contrasenaCifrada) {
        this.correo = correo;
        this.contrasenaCifrada = contrasenaCifrada;
    }

    public Long getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasenaCifrada() {
        return contrasenaCifrada;
    }

    public OffsetDateTime getCreadoEn() {
        return creadoEn;
    }
}