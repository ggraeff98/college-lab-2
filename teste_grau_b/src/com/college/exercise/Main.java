package com.college.exercise;
//Gustavo Graeff - 1807360
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int tamanhoDaLista = 50;
        Relatorio relatorio = new Relatorio(tamanhoDaLista);
        File file = new File("src/lavagem2.csv");

        try {
            relatorio.carregarArquivo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        relatorio.exibir();

        relatorio.exibirResumo();
    }
}
