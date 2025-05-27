package com.example.ibgenomes.service;

import com.example.ibgenomes.model.NomeInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class IbgeService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://servicodados.ibge.gov.br/api/v2/nomes";

    public List<NomeInfo> getPorNome(String nome) {
        String url = BASE_URL + "/" + nome;
        NomeInfo[] resposta = restTemplate.getForObject(url, NomeInfo[].class);
        return Arrays.asList(resposta);
    }

    public List<NomeInfo> comparar(List<String> nomes) {
        String url = BASE_URL + "/compare";
        NomeInfo[] resposta = restTemplate.postForObject(url, nomes, NomeInfo[].class);
        return Arrays.asList(resposta);
    }
}
