package voluntariaid_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import voluntariaid_backend.model.Cidade;
import voluntariaid_backend.service.CidadeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cidades")
@CrossOrigin(origins = "*")

public class CidadeController {

    @Autowired
    private CidadeService service;

    @GetMapping
    public List<Cidade> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Cidade> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Cidade salvar(@RequestBody Cidade cidade) {
        return service.salvar(cidade);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
