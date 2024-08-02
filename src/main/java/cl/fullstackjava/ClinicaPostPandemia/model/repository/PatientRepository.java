package cl.fullstackjava.ClinicaPostPandemia.model.repository;

import cl.fullstackjava.ClinicaPostPandemia.model.dto.Patient;

import java.util.List;

public interface PatientRepository {
    List<Patient> findAll();
    Patient findById(int id);
    boolean update(Patient patient);
    boolean create(Patient patient);
    boolean delete(int id);
}
