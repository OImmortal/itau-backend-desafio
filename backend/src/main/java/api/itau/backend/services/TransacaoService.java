package api.itau.backend.services;

import api.itau.backend.models.Transacao;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransacaoService {
    private List<Transacao> transacoes = new ArrayList<>();

    public ResponseEntity<Transacao> postTransacao(Transacao transacao) {

        try {
            if (Float.isNaN(transacao.getValor()) && transacao.getDataHora() == null) return ResponseEntity.unprocessableEntity().build();
            if (transacao.getValor() < 0) return ResponseEntity.unprocessableEntity().build();
            if (transacao.getDataHora().isAfter(OffsetDateTime.now())) return ResponseEntity.unprocessableEntity().build();

            transacoes.add(transacao);
            return ResponseEntity.created(URI.create("")).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    public void deleteAllTrasacoes() {
        transacoes.clear();
    }

}
