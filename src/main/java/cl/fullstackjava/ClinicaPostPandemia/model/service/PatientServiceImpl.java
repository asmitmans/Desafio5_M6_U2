package cl.fullstackjava.ClinicaPostPandemia.model.service;

import cl.fullstackjava.ClinicaPostPandemia.model.dto.Patient;
import cl.fullstackjava.ClinicaPostPandemia.model.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);

    PatientRepository repository;

    public PatientServiceImpl(PatientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Patient> findAll() {
        return repository.findAll();
    }

    @Override
    public Patient findById(int id) {
        return repository.findById(id);
    }

    @Override
    public boolean update(Patient patient) {
        return repository.update(patient);
    }

    @Override
    public boolean create(Patient patient) {
        if (patient.getAdmissionDate() == null) {
            patient.setAdmissionDate(LocalDate.now());
        }
        repository.create(patient);
        return true;
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }
}