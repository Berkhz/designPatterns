package com.example.ibgenomes.service;

import com.example.ibgenomes.model.NomeInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IbgeService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://servicodados.ibge.gov.br/api/v2/censos/nomes";

    public List<NomeInfo> getPorNome(String nome) {
        String url = BASE_URL + "/" + nome;

        try {
            NomeInfo[] resposta = restTemplate.getForObject(url, NomeInfo[].class);
            if (resposta == null || resposta.length == 0) {
                throw new RuntimeException("Nome não encontrado.");
            }
            return Arrays.asList(resposta);
        } catch (HttpServerErrorException e) {
            System.out.println("Erro ao acessar a API do IBGE: " + e.getStatusCode());
            throw new RuntimeException("API do IBGE fora do ar. Tente novamente mais tarde.");
        }
    }


    public List<NomeInfo> comparar(List<String> nomes) {
        String nomesConcatenados = String.join("|", nomes);
        String url = BASE_URL + "/" + nomesConcatenados;

        try {
            NomeInfo[] resposta = restTemplate.getForObject(url, NomeInfo[].class);
            if (resposta == null || resposta.length == 0) {
                throw new RuntimeException("Nenhum nome encontrado.");
            }
            return Arrays.asList(resposta);
        } catch (HttpServerErrorException e) {
            System.out.println("Erro ao acessar a API do IBGE: " + e.getStatusCode());
            throw new RuntimeException("API do IBGE fora do ar. Tente novamente mais tarde.");
        }
    }

    public List<NomeInfo> getPorLocalidade(String nome) {
        String url = BASE_URL + "/" + nome + "?groupBy=UF";

        try {
            NomeInfo[] resposta = restTemplate.getForObject(url, NomeInfo[].class);
            if (resposta == null || resposta.length == 0) {
                throw new RuntimeException("Nenhum dado encontrado para o nome.");
            }
            return Arrays.asList(resposta);
        } catch (HttpServerErrorException e) {
            System.out.println("Erro ao acessar a API do IBGE: " + e.getStatusCode());
            throw new RuntimeException("API do IBGE fora do ar. Tente novamente mais tarde.");
        }
    }

    public List<NomeInfo> getPorDecada(int decada) {
        String url = BASE_URL + "/ranking/?decada=" + decada;

        try {
            NomeInfo[] resposta = restTemplate.getForObject(url, NomeInfo[].class);
            if (resposta == null || resposta.length == 0) {
                throw new RuntimeException("Nenhum dado encontrado para a década.");
            }
            return Arrays.asList(resposta);
        } catch (HttpServerErrorException e) {
            System.out.println("Erro ao acessar a API do IBGE: " + e.getStatusCode());
            throw new RuntimeException("API do IBGE fora do ar. Tente novamente mais tarde.");
        }
    }

    public List<NomeInfo.Res> filtrarPorDecada(List<NomeInfo.Res> lista, int inicio, int fim) {
        return lista.stream()
                .filter(r -> {
                    String decadaStr = r.getPeriodo().substring(1, 5);
                    int decada = Integer.parseInt(decadaStr);
                    return decada >= inicio && decada <= fim;
                })
                .collect(Collectors.toList());
    }

    public List<NomeInfo> getRankingPorLocalidade(String localidade) {
        String url = BASE_URL + "/ranking?localidade=" + localidade;

        try {
            System.out.println(restTemplate.getForObject(url, NomeInfo[].class));
            NomeInfo[] resposta = restTemplate.getForObject(url, NomeInfo[].class);
            if (resposta == null || resposta.length == 0) {
                throw new RuntimeException("Nenhum dado encontrado para a localidade.");
            }
            return Arrays.asList(resposta);
        } catch (HttpServerErrorException e) {
            System.out.println("Erro ao acessar a API do IBGE: " + e.getStatusCode());
            throw new RuntimeException("API do IBGE fora do ar. Tente novamente mais tarde.");
        }
    }
}
