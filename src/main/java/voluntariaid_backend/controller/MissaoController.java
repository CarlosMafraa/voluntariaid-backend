package voluntariaid_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import voluntariaid_backend.model.Missao;
import voluntariaid_backend.service.MissaoService;

import java.util.List;

@RestController
@RequestMapping("/missoes")
@CrossOrigin(origins = "*")
public class MissaoController {
    @Autowired
    private MissaoService service;

    @PostMapping
    public Missao criar(@RequestBody Missao missao) {
        return service.salvar(missao);
    }

    @GetMapping
    public List<Missao> listar() {
        return service.listarTodas();
    }
}
