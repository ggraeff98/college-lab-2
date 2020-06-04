package com.college.exercise;
//Gustavo Graeff - 1807360
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Relatorio {
    StaticList<Utilidade> utilidadeStaticList;

    Relatorio(int tamanhoDaLista) {
        utilidadeStaticList = new StaticList<>(tamanhoDaLista);
    }

    public void carregarArquivo(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        int index = 0;

        while (line != null) {
            String[] lavagem = line.split(";");
            boolean jaExiste = false;

            Utilidade utilidade = new Utilidade(
                    lavagem[0],
                    lavagem[1],
                    Integer.parseInt(lavagem[2]),
                    lavagem[3],
                    Integer.parseInt(lavagem[4]),
                    1);

            for (int i = 0; i < utilidadeStaticList.numElements(); i++) {
                if (utilidadeStaticList.get(i).getMatricula() == utilidade.getMatricula() &&
                    utilidadeStaticList.get(i).getTipo().equals(utilidade.getTipo()) &&
                    utilidadeStaticList.get(i).getDano().equals(utilidade.getDano())) {
                    utilidadeStaticList.get(i).setQtde(utilidadeStaticList.get(i).getQtde() + utilidade.getQtde());
                    utilidadeStaticList.get(i).setTempo(utilidadeStaticList.get(i).getTempo() + utilidade.getTempo());
                    jaExiste = true;
                }
            }

            if (!jaExiste) {
                utilidadeStaticList.insert(utilidade, index);
                index++;
            }
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
    }

    public void exibir () {
        System.out.println("Matr.\tLavador\tUtil.\tQtde\tTempo\tT.Médio\tDano");
        for (int i = 0; i < utilidadeStaticList.numElements(); i++) {
            System.out.println(utilidadeStaticList.get(i).toString());
        }
    }

    public void exibirResumo () {
        double tempoTotal = 0;
        int quantidadeTotalLavada = 0;
        double tempoMedioTotal = 0;
        double semDano = 0;
        double comDano = 0;

        for (int i = 0; i < utilidadeStaticList.numElements(); i++) {
            tempoTotal += utilidadeStaticList.get(i).getTempo();
            quantidadeTotalLavada += utilidadeStaticList.get(i).getQtde();
            if (utilidadeStaticList.get(i).getDano().equals(Utilidade.Dano.NENHUM.getDescricao())) {
                semDano += utilidadeStaticList.get(i).getQtde();
            } else {
                comDano += utilidadeStaticList.get(i).getQtde();
            }
        }

        tempoMedioTotal = tempoTotal/quantidadeTotalLavada;

        System.out.println();
        System.out.println("Qtde total lavado: " + quantidadeTotalLavada);
        System.out.println("Tempo médio total: " + String.format("%.2f", tempoMedioTotal));
        System.out.println("Sem dano: " + String.format("%.2f", ((semDano/quantidadeTotalLavada)*100)) + "%");
        System.out.println("Com dano: " + String.format("%.2f", (comDano/quantidadeTotalLavada)*100) + "%");
    }
}
