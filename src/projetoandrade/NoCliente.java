package projetoandrade;

public class NoCliente {
    private Cliente info;
    private NoCliente dir;
    private NoCliente esq;
    private int fatBal;

    public NoCliente(Cliente info) {
        this.info = info;
    }

    public Cliente getInfo() {
        return info;
    }

    public void setInfo(Cliente info) {
        this.info = info;
    }

    public NoCliente getDir() {
        return dir;
    }

    public void setDir(NoCliente dir) {
        this.dir = dir;
    }

    public NoCliente getEsq() {
        return esq;
    }

    public void setEsq(NoCliente esq) {
        this.esq = esq;
    }

    public int getFatbal() {
        return fatBal;
    }

    public void setFatbal(int fatBal) {
        this.fatBal = fatBal;
    }
    
    
}
