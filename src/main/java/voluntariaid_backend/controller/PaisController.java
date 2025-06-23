package voluntariaid_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import voluntariaid_backend.model.Pais;
import voluntariaid_backend.service.PaisService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paises")
@CrossOrigin(origins = "*")

public class PaisController {
    @Autowired
    private PaisService service;

    @GetMapping
    public List<Pais> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Pais> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Pais salvar(@RequestBody Pais pais) {
        return service.salvar(pais);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
