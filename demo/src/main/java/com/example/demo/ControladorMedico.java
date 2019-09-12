
package com.example.demo;

        import java.util.List;
        import org.springframework.web.bind.annotation.DeleteMapping;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.PutMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorMedico {

    private final Repositorio_Medico repository;

    ControladorMedico(Repositorio_Medico repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/medico")
    List<Medico> all() {
        return repository.findAll();
    }

    @PostMapping("/medico")
    Medico newMedico(@RequestBody Medico newMedico) {
        return repository.save(newMedico);
    }

    // Single item

    @GetMapping("/medico/{id}")
    Medico one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new MedicoNotFoundException(id));        // error de MedicoNotFoundException ??
    }

    @PutMapping("/medico/{id}")
    Medico replaceMedico(@RequestBody Medico newMedico, @PathVariable Long id) {

        return repository.findById(id)
                .map(medico -> {
                    medico.setNombre(newMedico.getNombre());
                    medico.setEspecialidad(newMedico.getEspecialidad());
                    medico.setCargo(newMedico.getCargo());
                    return repository.save(medico);
                })
                .orElseGet(() -> {
                    newMedico.setId(id);
                    return repository.save(newMedico);
                });
    }

    @DeleteMapping("/medico/{id}")
    void deleteMedico(@PathVariable Long id) {
        repository.deleteById(id);
    }
}