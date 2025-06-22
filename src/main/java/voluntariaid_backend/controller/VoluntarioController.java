package voluntariaid_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import voluntariaid_backend.model.Voluntario;
import voluntariaid_backend.service.VoluntarioService;

import java.util.List;

@RestController
@RequestMapping("/voluntarios")
@CrossOrigin(origins = "*")
public class VoluntarioController {
    @Autowired
    private VoluntarioService service;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Voluntario voluntario) {
        try {
            Voluntario novo = service.salvar(voluntario);
            return ResponseEntity.ok(novo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Voluntario> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voluntario> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
