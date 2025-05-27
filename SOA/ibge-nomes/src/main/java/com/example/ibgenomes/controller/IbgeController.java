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
}
