package com.college.exercise;
//Gustavo Graeff - 1807360
public class Utilidade {
    private String tipo;
    private String dano;
    private int matricula;
    private String lavador;
    private int tempo;
    private int qtde;

    Utilidade(String tipo, String dano, int matricula, String lavador, int tempo, int qtde) {
        this.tipo = tipo;
        this.dano = dano;
        this.matricula = matricula;
        this.lavador = lavador;
        this.tempo = tempo;
        this.qtde = qtde;
    }

    public enum Dano {
        NENHUM("NENHUM"),
        TRINCADO("TRINCADO"),
        RISCADO("RISCADO");

        private String descricao;

        Dano(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public enum Tipo {
        PRATO("PRATO"),
        COPO("COPO"),
        COLHER("COLHER"),
        FACA("FACA"),
        GARFO("GARFO");

        private String descricao;

        Tipo(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getLavador() {
        return lavador;
    }

    public void setLavador(String lavador) {
        this.lavador = lavador;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        return  "\t" + matricula +
                "\t" + lavador +
                "\t" + tipo +
                "\t" + qtde +
                "\t\t" + tempo +
                "\t\t" + String.format("%.2f", (double) tempo/qtde) +
                "\t" + dano;
    }
}
