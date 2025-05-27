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

    @GetMapping("/{nome}/localidade")
    public List<NomeInfo> porLocalidade(@PathVariable String nome) {
        return ibgeService.getPorLocalidade(nome);
    }

    @GetMapping("/{nome}/periodo")
    public List<NomeInfo.Res> nomePorPeriodo(@PathVariable String nome,
                                             @RequestParam int inicio,
                                             @RequestParam int fim) {
        List<NomeInfo> lista = ibgeService.getPorNome(nome);
        return ibgeService.filtrarPorDecada(lista.get(0).getRes(), inicio, fim);
    }

    @GetMapping("/ranking/localidade")
    public List<NomeInfo> rankingPorLocalidade(@RequestParam String localidade) {
        return ibgeService.getRankingPorLocalidade(localidade);
    }
}
