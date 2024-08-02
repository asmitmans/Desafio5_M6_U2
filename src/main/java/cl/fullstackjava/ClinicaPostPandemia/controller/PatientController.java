package cl.fullstackjava.ClinicaPostPandemia.controller;

import cl.fullstackjava.ClinicaPostPandemia.model.dto.Patient;
import cl.fullstackjava.ClinicaPostPandemia.model.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping
    public String listPatients(Model model) {
        logger.info("Solicitud para listar todos los pacientes");
        model.addAttribute("patients", service.findAll());
        return "patients";
    }

    @GetMapping("create")
    public String createPatientForm(Model model) {
        logger.info("Solicitud para mostrar formulario de creación de paciente");
        model.addAttribute("patient", new Patient());
        return "create-patient";
    }

    @PostMapping("create")
    public String createPatient(@ModelAttribute("patient") Patient patient) {
        logger.info("Solicitud para crear nuevo paciente");
        service.create(patient);
        return "redirect:/patients";
    }

    @GetMapping("/{id}/edit")
    public String updatePatientForm(@PathVariable int id, Model model) {
        logger.info("Solicitud para mostrar formulario de edicion de paciente");
        Patient patient = service.findById(id);
        if (patient != null) {
            model.addAttribute("patient", patient);
            return "edit-patient";
        } else {
            logger.warn("Paciente con id : {} no encontrado",id);
            return "redirect:/patients";
        }
    }

    @PostMapping("/edit")
    public String updatePatient(@ModelAttribute("patient") Patient patient) {
        logger.info("Actualizando el paciente con id : {}", patient.getId());
        service.update(patient);
        return "redirect:/patients";
    }

    @PostMapping("/{id}/delete")
    public String deletePatient(@PathVariable int id) {
        logger.info("Solicitud para eliminar el paciente con id : {}", id);
        service.delete(id);
        return "redirect:/patients";
    }

}
