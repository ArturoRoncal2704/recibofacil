CREATE TABLE usuarios (
                          id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                          correo VARCHAR(255) NOT NULL UNIQUE,
                          contrasena_cifrada VARCHAR(255) NOT NULL,
                          creado_en TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT now()
);