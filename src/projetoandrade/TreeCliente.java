package projetoandrade;

public class TreeCliente {
    private NoCliente raiz;
    private boolean statusIns;
    private boolean statusRm;
    
    public TreeCliente() {
        this.raiz = null;
    }

    public NoCliente getRaiz() {
        return raiz;
    }

    public void setRaiz(NoCliente raiz) {
        this.raiz = raiz;
    }
    
    public void inserir(Cliente c){
        NoCliente novo = new NoCliente(c);
        this.raiz = inserirAvl(this.raiz, novo);
    }
    
    private NoCliente inserirAvl(NoCliente r, NoCliente novo){
        if(r == null){
            r = novo;
           this.statusIns = true;
        }else if(novo.getInfo().getCpf().compareToIgnoreCase(r.getInfo().getCpf()) < 0){
            //ESSE IF TESTA SE O VALOR NOVO É MENOR DO QUE A RAIZ
            r.setEsq(inserirAvl(r.getEsq(), novo));
            if(statusIns){
                switch(r.getFatbal()){
                    case 0:
                        r.setFatbal(-1);break;
                    case 1:
                        r.setFatbal(0); 
                        this.statusIns = false; break;
                    case -1:
                       r = rotacionaDir(r);break;
                }
        }
        }else if(novo.getInfo().getCpf().compareToIgnoreCase(r.getInfo().getCpf()) > 0){
            //ESSE IF TESTA SE O VALOR NOVO É MAIOR DO QUE A RAIZ
            r.setDir(inserirAvl(r.getDir(), novo));
            if (statusIns){
                switch(r.getFatbal()){
                    case 0:
                        r.setFatbal(1);break;
                    case 1:
                       r = rotacionaEsq(r); break;
                    case -1:
                        r.setFatbal(0);
                        this.statusIns = false; break;
                }
            }
        }else{
            //AQUI AVISA QUE JÁ ESTA CADASTRADO
            System.out.println("O numero de cpf informado já esta cadastrado!");
        }
        return r;
    }
    
    private NoCliente rotacionaDir(NoCliente a){
        NoCliente b;
        b = a.getEsq();
        if(b.getFatbal() == -1){
            return rtDir(a);
        }else{
            return rtDuplaDir(a);
        }
    }
    
    private NoCliente rotacionaEsq(NoCliente a){
        NoCliente b = a.getDir();
        if(b.getFatbal() == 1){
            return rtEsq(a);
        }else{
            return reDuplaEsq(a);
        }
    }
    
    private NoCliente rtDir(NoCliente a){
        NoCliente b = a.getEsq();
        a.setEsq(b.getDir());
        b.setDir(a);
        a.setFatbal(0);
        b.setFatbal(0);
        //a = b;
        this.statusIns = false;
        return b;
    }
    
    private NoCliente rtDuplaDir(NoCliente a){
        NoCliente b = a.getEsq(), c = b.getDir();
        b.setDir(c.getEsq());
        c.setEsq(b);
        a.setEsq(c.getDir());
        c.setDir(a);
        if(c.getFatbal() == -1){
            a.setFatbal(1);
        }else{
            a.setFatbal(0);
        }
        if(c.getFatbal() == 1){
            b.setFatbal(-1);
        }else{
            b.setFatbal(0);
        }
        //a = c;
        c.setFatbal(0);
        this.statusIns = false;
        return c;
    }
    
    private NoCliente rtEsq(NoCliente a){
        NoCliente b = a.getDir();
        a.setDir(b.getEsq());
        b.setEsq(a);
        a.setFatbal(0);
        b.setFatbal(0);
        //a = b;
        this.statusIns = false;
        return b;
    }
    
    private NoCliente reDuplaEsq(NoCliente a){
        NoCliente b = a.getDir(), c = b.getEsq();
        b.setEsq(c.getDir());
        c.setDir(b);
        a.setDir(c.getEsq());
        c.setEsq(a);
        if(c.getFatbal() == 1){
            a.setFatbal(-1);
        }else{
            a.setFatbal(0);
        }
        if(c.getFatbal() == -1){
            b.setFatbal(1);
        }else{
            b.setFatbal(0);
        }
        //a = c;
        c.setFatbal(0);
        this.statusIns = false;
        return c;
    }
    
    public void remover(String cpf){
        removerAvl(this.raiz, cpf);
    }
    
    private NoCliente removerAvl(NoCliente r, String cpf){
        int rm = 0;
        if(r == null){
            System.out.println("Cliente nao encontrado!");
            return null;
        }else if(cpf.compareToIgnoreCase(r.getInfo().getCpf()) < 0){
            r.setEsq(removerAvl(r.getEsq(), cpf));
            rm = -1;
            return verifica(r, rm);
        }else if(cpf.compareToIgnoreCase(r.getInfo().getCpf()) > 0){
            r.setDir(removerAvl(r.getDir(), cpf));
            rm = 1;
            return verifica(r, rm);
        }else{
            if(r.getEsq() == null && r.getDir() == null){
                return null;
            }else if(r.getEsq() == null){
                return r.getDir();
            }else if(r.getDir() == null){
                return r.getEsq();
            }else{
                r.setInfo(minDir(r.getDir()).getInfo());
                r.setDir(removerAvl(r.getDir(), r.getInfo().getCpf()));
                return verifica(r, 1);
            }
        }
    }
    
    public NoCliente verifica(NoCliente r, int rm){
        int bal = r.getFatbal();
        if(rm == 1){
            switch(bal){
                case 0:
                    r.setFatbal(-1);break;
                case 1:
                    r.setFatbal(0);break;
                case -1:
                    r = rotacionaDir(r);break;
            }
        }else if (rm == -1){
            switch(bal){
                case 0:
                    r.setFatbal(1);break;
                case 1:
                    r = rotacionaEsq(r); break;
                case -1:
                    r.setFatbal(0);break;
            }
        }
        return r;
    }
    
    public NoCliente minDir(NoCliente t){
        if(t.getEsq() == null){
            return t;
        }else{
            t =t.getEsq();
            return minDir(t);
        }
    }
    
    public void exibirPre(){
        preOrdem(this.raiz);
    }
    public void exibirOrd(){
        emOrdem(this.raiz);
    }
    
    public void emOrdem(NoCliente r){
        if(r != null){
            emOrdem(r.getEsq());
            System.out.println(r.getInfo());
            emOrdem(r.getDir());
        }
    }
    
    public void preOrdem(NoCliente r){
        if(r == null){
            return;
        }
        System.out.println(r.getInfo());
        preOrdem(r.getEsq());
        preOrdem(r.getDir());
        
    }
    
    public void exibirNivel(NoCliente r){
        if(r != null){
            if(r == this.raiz){
                System.out.println(r.getInfo());
            }
            if(r.getDir() == null && r.getEsq() == null){
                
            }else if(r.getDir() == null){
                System.out.println(r.getEsq().getInfo());
            }else if(r.getEsq() == null){
                System.out.println(r.getDir().getInfo());
            }else{
                System.out.println(r.getEsq().getInfo());
                System.out.println(r.getDir().getInfo());
            }
            System.out.println();
            exibirNivel(r.getEsq());
            exibirNivel(r.getDir());
        }
    }
    
    public NoCliente busca(String nCont){
        NoCliente e = buscaAvl(nCont, this.raiz);
        return e;
    }
    
    private NoCliente buscaAvl(String nCont, NoCliente r){
        if(r == null){
            return r;
        }else if(nCont.compareToIgnoreCase(r.getInfo().getCpf()) < 0){
            return buscaAvl(nCont, r.getEsq());
        }else if(nCont.compareToIgnoreCase(r.getInfo().getCpf()) > 0){
            return buscaAvl(nCont, r.getDir());
        }else{
            return r;
        }
    }
    
    public void gravarEmOrdem(NoCliente r){
        if(r != null){
            emOrdem(r.getEsq());
            
            emOrdem(r.getDir());
        }
    }
}
