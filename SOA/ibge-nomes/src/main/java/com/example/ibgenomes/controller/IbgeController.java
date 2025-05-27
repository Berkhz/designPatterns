package com.example.ibgenomes.controller;

import com.example.ibgenomes.model.NomeInfo;
import com.example.ibgenomes.service.IbgeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nomes")
public class IbgeController {

    private final IbgeService ibgeService;

    public IbgeController(IbgeService ibgeService) {
        this.ibgeService = ibgeService;
    }

    @GetMapping("/{nome}")
    public List<NomeInfo> buscarPorNome(@PathVariable String nome) {
        return ibgeService.getPorNome(nome);
    }

    @PostMapping("/comparar")
    public List<NomeInfo> compararNomes(@RequestBody List<String> nomes) {
        return ibgeService.comparar(nomes);
    }

    @GetMapping("/{nome}/localidade/{id}")
    public List<NomeInfo> porLocalidade(@PathVariable String nome, @PathVariable int id) {
        return ibgeService.getPorLocalidade(nome, id);
    }

    @GetMapping("/{nome}/periodo")
    public List<NomeInfo.Res> nomePorPeriodo(@PathVariable String nome,
                                             @RequestParam int inicio,
                                             @RequestParam int fim) {
        List<NomeInfo> lista = ibgeService.getPorNome(nome);
        return ibgeService.filtrarPorDecada(lista.get(0).getRes(), inicio, fim);
    }
}
