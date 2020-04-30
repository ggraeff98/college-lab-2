//Gustavo Graeff - 1807360

import java.io.File;
import java.io.IOException;

public interface IAcessoRelatorio {
    public void carregarArquivo(File file) throws IOException;
    public void exibirInfo();
    public void exibirMaiorTempoAcesso();
    public void salvarArquivo(File file) throws IOException;
}
