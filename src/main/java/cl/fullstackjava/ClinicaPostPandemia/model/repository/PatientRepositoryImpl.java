package cl.fullstackjava.ClinicaPostPandemia.model.repository;

import cl.fullstackjava.ClinicaPostPandemia.model.dto.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepositoryImpl implements PatientRepository {

    private static final Logger logger = LoggerFactory.getLogger(PatientRepositoryImpl.class);

    JdbcTemplate template;

    public PatientRepositoryImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Patient> findAll() {
        logger.info("Ejecutando consulta para obtener todos los pacientes");
        String sql = "SELECT id, first_name, last_name, date_of_birth, address, rut, email, admission_date, discharge_date, diagnosis FROM pacientes ORDER BY id ASC";
        return template.query(sql, new BeanPropertyRowMapper<>(Patient.class));
    }

    @Override
    public Patient findById(int id) {
        logger.info("Ejecutando consulta para obtener datos del paciente con id: {}", id);
        String sql = "SELECT id, first_name, last_name, date_of_birth, address, rut, email, admission_date, discharge_date, diagnosis FROM pacientes WHERE id = ?";
        return template.queryForObject(sql,new Object[]{id}, new BeanPropertyRowMapper<>(Patient.class));
    }

    @Override
    public boolean update(Patient patient) {
        logger.info("Ejecutando consulta para actualizar datos de paciente: {} {}", patient.getFirstName(), patient.getLastName());
        String sql = "UPDATE pacientes SET first_name = ?, last_name = ?, date_of_birth = ?, address = ?, rut = ?, email = ?, discharge_date = ?, diagnosis = ? WHERE id = ?";
        return template.update(sql, patient.getFirstName(), patient.getLastName(), patient.getDateOfBirth(), patient.getAddress(), patient.getRut(), patient.getEmail(), patient.getDischargeDate(), patient.getDiagnosis(), patient.getId()) > 0;
    }

    @Override
    public boolean create(Patient patient) {
        logger.info("Creando registro del paciente: {} {}", patient.getFirstName(), patient.getLastName());
        String sql = "INSERT INTO pacientes (first_name, last_name, date_of_birth, address, rut, email, admission_date, diagnosis) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return template.update(sql, patient.getFirstName(), patient.getLastName(), patient.getDateOfBirth(), patient.getAddress(), patient.getRut(), patient.getEmail(), patient.getAdmissionDate(), patient.getDiagnosis()) > 0;
    }

    @Override
    public boolean delete(int id) {
        logger.info("Eliminando registro del paciente id : {}", id);
        String sql = "DELETE FROM pacientes WHERE id = ?";
        return template.update(sql, id) > 0;
    }

}