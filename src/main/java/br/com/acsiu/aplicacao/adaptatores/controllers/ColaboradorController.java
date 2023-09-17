package br.com.acsiu.aplicacao.adaptatores.controllers;

import java.util.List;

import br.com.acsiu.dominio.dto.ColaboradorResponseDTO;
import br.com.acsiu.dominio.util.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acsiu.dominio.dto.ColaboradorDTO;
import br.com.acsiu.dominio.portas.interfaces.IColaboradorServicePort;

@RestController
@RequestMapping("colaborador")
public class ColaboradorController {

    private final IColaboradorServicePort colaboradorServicePort;

    public ColaboradorController(IColaboradorServicePort colaboradorServicePort) {
        this.colaboradorServicePort = colaboradorServicePort;
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody ColaboradorDTO dto) {
        colaboradorServicePort.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Utils.getMessage("operacao.realizada.sucesso"));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> alterar(@PathVariable Integer id, @RequestBody ColaboradorDTO dto) {
        colaboradorServicePort.alterar(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(Utils.getMessage("operacao.realizada.sucesso"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable Integer id) {
        colaboradorServicePort.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(Utils.getMessage("operacao.realizada.sucesso"));
    }
    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> getColaboradores() {
        return ResponseEntity.ok(colaboradorServicePort.buscarColaboradores());
    }

    @GetMapping("/buscar-por-nome/{nome}")
    public ResponseEntity<?> buscar(@PathVariable String nome) {
        return ResponseEntity.ok(colaboradorServicePort.buscarPorNome(nome));
    }

}
