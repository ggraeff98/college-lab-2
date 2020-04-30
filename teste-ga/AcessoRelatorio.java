//Gustavo Graeff - 1807360

import java.io.*;

public class AcessoRelatorio implements IAcessoRelatorio {
    AcessoPorAluno[] acessoPorAluno;
    int listaDeAcessosPorAluno = 0;
    int primeiro = 0;
    int index1 = 0;
    int segundo = 0;
    int index2 = 0;

    AcessoRelatorio(int tamanhoDaLista) {
        acessoPorAluno = new AcessoPorAluno[tamanhoDaLista];
    }

    @Override
    public void carregarArquivo(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();

        while(line != null) {
            String[] acesso = line.split(";");
            int jaExiste = 0;

            for (int i = 0; i < acessoPorAluno.length; i++) {
                if (acessoPorAluno[i] != null) {
                    if (Integer.parseInt(acesso[0]) == acessoPorAluno[i].getMatricula()) {
                        acessoPorAluno[i].setAcessos(acessoPorAluno[i].getAcessos() + 1);
                        acessoPorAluno[i].setDownloads(acessoPorAluno[i].getDownloads() + Integer.parseInt(acesso[4]));
                        acessoPorAluno[i].setHoras(acessoPorAluno[i].getHoras() + Integer.parseInt(acesso[5]));
                        jaExiste++;
                    }
                }
            }
            if (jaExiste == 0) {
                AcessoPorAluno book = new AcessoPorAluno(
                        Integer.parseInt(acesso[0]),
                        acesso[1],
                        1,
                        Integer.parseInt(acesso[4]),
                        Integer.parseInt(acesso[5])
                );
                acessoPorAluno[listaDeAcessosPorAluno] = book;
                listaDeAcessosPorAluno++;
            }
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    @Override
    public void exibirInfo() {
        if (acessoPorAluno[0] == null) {
            System.out.println("Nenhum registro para ser mostrado!");
            return;
        }
        System.out.println("Acessos por Aluno");
        System.out.println("=====================================================================");
        for (int i = 0; i < acessoPorAluno.length; i++) {
            if (acessoPorAluno[i] != null) System.out.println(acessoPorAluno[i].toString());
        }
        System.out.println("=====================================================================");
        System.out.println();
    }

    @Override
    public void exibirMaiorTempoAcesso() {
        if (acessoPorAluno[0] == null) {
            System.out.println("Nenhum registro para ser mostrado!");
            return;
        }
        primeiro = 0;
        index1 = 0;
        segundo = 0;
        index2 = 0;

        for (int i = 0; i < acessoPorAluno.length; i++) {
            if (acessoPorAluno[i] != null && acessoPorAluno[i].getHoras() > primeiro) {
                primeiro = acessoPorAluno[i].getHoras();
                index1 = i;
            }
        }

        for (int i = 0; i < acessoPorAluno.length; i++) {
            if (acessoPorAluno[i] != null &&
                    acessoPorAluno[i].getHoras() <= primeiro &&
                    acessoPorAluno[i].getHoras() > segundo &&
                    acessoPorAluno[i].getMatricula() != acessoPorAluno[index1].getMatricula()) {
                segundo = acessoPorAluno[i].getHoras();
                index2 = i;
            }
        }

        System.out.println("Alunos com Maior Tempo de Acesso ao Portal de Periódicos da Capes");
        System.out.println("=====================================================================");
        System.out.println(acessoPorAluno[index1].toString());
        System.out.println(acessoPorAluno[index2].toString());
        System.out.println("=====================================================================");
        System.out.println();
    }

    @Override
    public void salvarArquivo(File file) throws IOException {
        if (acessoPorAluno[0] == null) {
            System.out.println("Nenhum registro para ser gravado!");
            return;
        }

        FileWriter fw = new FileWriter(file);

        fw.write("Alunos com Maior Tempo de Acesso ao Portal de Periódicos da Capes");
        fw.write("\n");
        fw.write("=====================================================================");
        fw.write("\n");
        for (int i = 0; i < acessoPorAluno.length; i++) {
            if (acessoPorAluno[i] == null) break;
            fw.write(acessoPorAluno[i].toString());
            fw.write("\n");
        }
        fw.write("=====================================================================");
        fw.close();
    }
}
