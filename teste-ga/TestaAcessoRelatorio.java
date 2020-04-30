//Gustavo Graeff - 1807360

import java.io.File;
import java.io.IOException;

public class TestaAcessoRelatorio {

    public static void main(String[] args) {
        int tamanhoDaLista = 50;
        AcessoRelatorio acessoRelatorio = new AcessoRelatorio(50);

        File file = new File("src/registrosDeAcessos.txt");

        if (!file.exists()) {
            try {
                if (file.exists()) return;
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            acessoRelatorio.carregarArquivo(file);
        } catch (Exception e) {
            System.out.println();
            System.out.println("Capacidade máxima de registros não é suficiente!");
            System.out.println("Serão exibidos apenas " + tamanhoDaLista + " registros, conforme sua escolha!");
            System.out.println();
        }

        acessoRelatorio.exibirInfo();
        acessoRelatorio.exibirMaiorTempoAcesso();
        try {
            acessoRelatorio.salvarArquivo(new File("src/registrosDeAcessosFormatados.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
