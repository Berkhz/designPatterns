package com.example.ibgenomes.model;

import java.util.List;

public class NomeInfo {
    private String nome;
    private List<Res> res;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Res> getRes() { return res; }
    public void setRes(List<Res> res) { this.res = res; }

    public static class Res {
        private String periodo;
        private int frequencia;

        public String getPeriodo() { return periodo; }
        public void setPeriodo(String periodo) { this.periodo = periodo; }

        public int getFrequencia() { return frequencia; }
        public void setFrequencia(int frequencia) { this.frequencia = frequencia; }
    }
}
