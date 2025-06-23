package voluntariaid_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import voluntariaid_backend.dto.missao.MissaoCreateDTO;
import voluntariaid_backend.dto.missao.MissaoResponseDTO;
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
    public ResponseEntity<MissaoResponseDTO> criar(@RequestBody MissaoCreateDTO missao) {
        try {
            MissaoResponseDTO response = service.salvar(missao);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<MissaoResponseDTO>> listar() {
        try {
            List<MissaoResponseDTO> missoes = service.listarTodas();
            return ResponseEntity.ok(missoes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissaoResponseDTO> buscarPorId(@PathVariable Long id) {
        try {
            MissaoResponseDTO missao = service.buscarPorId(id);
            return ResponseEntity.ok(missao);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMissao(@PathVariable Long id) {
        try {
            service.deletarMissao(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

