# Desafío -Pacientes Clínica post Pandemia

**URL**  
http://localhost:8080

**Configuración BD**
* /src/main/resources/database.properties
* /src/main/java/cl/fullstackjava/ClinicaPostPandemia/AppConfig.java

**Tabla usada**
```sql
-- Borrar la tabla si existe
DROP TABLE IF EXISTS pacientes;

-- Crear la tabla de pacientes
CREATE TABLE pacientes (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,
    address VARCHAR(100),
    rut VARCHAR(12) NOT NULL,
    email VARCHAR(100),
    admission_date DATE NOT NULL,
    discharge_date DATE,
    diagnosis VARCHAR(255)
);

-- Insertar 5 pacientes genéricos
INSERT INTO pacientes (first_name, last_name, date_of_birth, address, rut, email, admission_date, discharge_date, diagnosis)
VALUES 
('Juan', 'Pérez', '1985-06-15', 'El Aromo 123', '111111111-1', 'juan.perez@mail.com', '2024-07-20', NULL, 'Influenza'),
('María', 'Gómez', '1990-02-25', 'Arturo Prat 888', '222222222-2', 'maria.gomez@mail.com', '2024-07-21', NULL, 'Fractura de pierna'),
('Carlos', 'López', '1978-11-12', 'Arturo Prat 911', '333333333-3', 'carlos.lopez@mail.com', '2024-07-22', NULL, 'Neumonía'),
('Ana', 'Soto', '2000-03-30', 'Las Palmeras 456', '444444444-4', 'a.soto@mail.com', '2024-07-23', '2024-07-24', 'Gastroenteritis'),
('Andres', 'Muñoz', '1995-09-10', 'Los Robles 789', '555555555-5', 'andres.m@mail.com', '2024-07-24', '2024-07-24', 'Dolor de cabeza');
```
