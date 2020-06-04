package com.college.exercise;
//Gustavo Graeff - 1807360
import java.io.File;
import java.io.IOException;

public interface IRelatorio {
    public void carregar(File file) throws IOException;
    public void exibir();
    public void exibirResumo();
}
