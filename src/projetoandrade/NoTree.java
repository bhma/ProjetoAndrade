package projetoandrade;

public class NoTree {
    private Conta info;
    private NoTree dir;
    private NoTree esq;
    private int fatbal;

    public NoTree(Conta info) {
        this.info = info;
    }

    public Conta getInfo() {
        return info;
    }

    public void setInfo(Conta info) {
        this.info = info;
    }

    public NoTree getDir() {
        return dir;
    }

    public void setDir(NoTree dir) {
        this.dir = dir;
    }

    public NoTree getEsq() {
        return esq;
    }

    public void setEsq(NoTree esq) {
        this.esq = esq;
    }

    public int getFatbal() {
        return fatbal;
    }

    public void setFatbal(int fatbal) {
        this.fatbal = fatbal;
    }
}