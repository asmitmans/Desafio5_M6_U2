package cl.fullstackjava.ClinicaPostPandemia.model.service;

import cl.fullstackjava.ClinicaPostPandemia.model.dto.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> findAll();
    Patient findById(int id);
    boolean update(Patient patient);
    boolean create(Patient patient);
    boolean delete(int id);
}
