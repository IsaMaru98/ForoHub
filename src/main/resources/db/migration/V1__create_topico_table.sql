CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fechaCreacion VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL,
    respuestas TEXT
);