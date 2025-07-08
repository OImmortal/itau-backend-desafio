package api.itau.backend.controllers;

import api.itau.backend.models.Transacao;
import api.itau.backend.services.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService = new TransacaoService();

    @PostMapping
    public ResponseEntity<Transacao> criarTransacao(@RequestBody Transacao transacao) {
        return transacaoService.postTransacao(transacao);
    }

    @DeleteMapping
    public ResponseEntity excluirTransacao() {
        transacaoService.deleteAllTrasacoes();
        return  ResponseEntity.ok().build();
    }

}
