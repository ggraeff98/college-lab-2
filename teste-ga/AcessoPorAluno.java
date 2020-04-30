//Gustavo Graeff - 1807360

public class AcessoPorAluno {
    private int matricula;
    private String login;
    private int acessos;
    private int downloads;
    private int horas;

    public AcessoPorAluno(int matricula, String login, int acessos, int downloads, int horas) {
        this.matricula = matricula;
        this.login = login;
        this.acessos = acessos;
        this.downloads = downloads;
        this.horas = horas;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAcessos() {
        return acessos;
    }

    public void setAcessos(int acessos) {
        this.acessos = acessos;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return  matricula + "\t" +
                login + "\t" +
                acessos + "\t" +
                downloads + "\t" +
                horas + "\t" +
                ((double)downloads)/acessos + "\t" +
                ((double)horas)/acessos + "\t";
    }
}
