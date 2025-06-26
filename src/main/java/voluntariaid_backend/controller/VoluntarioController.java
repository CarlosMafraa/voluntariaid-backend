package voluntariaid_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import voluntariaid_backend.dto.voluntario.VoluntarioCreateDTO;
import voluntariaid_backend.dto.voluntario.VoluntarioResponseDTO;
import voluntariaid_backend.service.VoluntarioService;

import java.util.List;

@RestController
@RequestMapping("/voluntarios")
@CrossOrigin(origins = "*")
public class VoluntarioController {
    @Autowired
    private VoluntarioService service;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody VoluntarioCreateDTO voluntario) {
        try {
            VoluntarioResponseDTO response = service.salvar(voluntario);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor");
        }
    }


    @GetMapping
    public ResponseEntity<Page<VoluntarioResponseDTO>> listarTodos(Pageable pageable) {
        Page<VoluntarioResponseDTO> voluntarios = service.listarTodos(pageable);
        return ResponseEntity.ok(voluntarios);
    }


    @GetMapping("/{id}")
    public ResponseEntity<VoluntarioResponseDTO> buscarPorId(@PathVariable Long id) {
        try {
            VoluntarioResponseDTO voluntario = service.buscarPorId(id);
            return ResponseEntity.ok(voluntario);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            service.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
