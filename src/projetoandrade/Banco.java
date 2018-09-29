package projetoandrade;

import java.util.Scanner;

public class Banco {
    
    private TreeConta rConta;
    private TreeCliente rCliente;
    private static Banco ba;
    
    private Banco () {
        rConta = new TreeConta();
        rCliente = new TreeCliente();
    }
    
    public static Banco getInstance(){
        if(ba == null){
            ba = new Banco();
        }
        return ba;
    }

    public TreeConta getrConta() {
        return rConta;
    }

    public void setrConta(TreeConta rConta) {
        this.rConta = rConta;
    }

    public TreeCliente getrCliente() {
        return rCliente;
    }

    public void setrCliente(TreeCliente rCliente) {
        this.rCliente = rCliente;
    }
    
    //FUNCIONALIDADES DAS CONTAS DO BANCO
    
    public void cadastrarConta(String nCont){
        NoTree c = rConta.busca(nCont);
        Scanner in = new Scanner(System.in);
        while (c != null){
            System.out.println("Conta ja cadastrada! Digite novamente: ");
            nCont = in.nextLine();
            c = rConta.busca(nCont);
        }
        if(c == null){
            Conta c1;
            NoCliente cl;
            String cpf, t;
            double saldo;
            System.out.println("Digite o cpf do cliente: ");
            cpf = in.nextLine();
            //WHILE PARA VALIDAR O CPF(SIMPLES)
            while(cpf.length() == 0){
                System.out.println("CPF inválido! Digite novamente!");
                cpf = in.nextLine();
            }
            //AQUI VAI BUSCAR UM CLIENTE PARA COLOCAR NO OBJETO CONTA
            cl = this.rCliente.busca(cpf);
            if(cl == null){ // SE O CLIENTE NAO ESTIVER CADASTRADO, NAO É POSSIVEL CADASTRAR UMA CONTA
                System.out.println("Cliente nao cadastrado. Porfavor cadastre um cliente e depois cadastre uma conta!");
                return;
            }else{
                System.out.println("Digite o saldo da conta: ");
                saldo = in.nextDouble(); in.nextLine();
                //WHILE PARA VALIDAR O SALDO (SIMPLES)
                while(saldo < 0){
                    System.out.println("Saldo inválido! Digite novamente!");
                    saldo = in.nextDouble(); in.nextLine();
                }
                System.out.println("Conta Especial ou Simples? [E/S]");
                System.out.println("Conta Especial tem credito adicional no valor de R$ 2000,00");
                t = in.nextLine();
                t = t.toUpperCase();
                //WHILE PARA VALIDAR A OPÇÃO
                while(!t.equalsIgnoreCase("E") && !t.equalsIgnoreCase("S")){
                    System.out.println("Opção inválida! Digite novamente!");
                    t = in.nextLine();
                    t = t.toUpperCase();
                }
                switch(t){
                    case "E":
                        // TROCAS AS CONTAS PRA FICAR SO UMA CLASSE CONTA
                        c1 = new Conta(nCont, cl.getInfo(), saldo, true);
                        rConta.inserir(c1);
                        break;
                    case "S":
                        c1 = new Conta(nCont, cl.getInfo(), saldo);
                        rConta.inserir(c1);
                        break;
                }
                System.out.println("Conta cadastrada com sucesso!");
            }
            
            
        }
    }
    
    public void consultaSaldo(String nCont, TreeConta r){
        NoTree c = r.busca(nCont);
        if(c == null){
            System.out.println("Conta nao encontrada!");
        }else{
            System.out.println("Conta: "+ nCont + "\nSaldo: " + c.getInfo().getSaldo());
        }
    }
    
    public void deposito(String nCont){
        Scanner in = new Scanner(System.in);
        double dep;
        NoTree c = rConta.busca(nCont);
        if(c == null){
            System.out.println("Conta não encontrada!");
            return;
        }else{
            System.out.println("Qual o valor do deposito?");
            dep = in.nextInt(); in.nextLine();
            c.getInfo().setSaldo(c.getInfo().getSaldo() + dep);
            System.out.println("Valor depositado!");
        }
    }
    
    public void removerConta(String nCont){
        rConta.remover(nCont);
        System.out.println("COnta removida com sucesso!");
    }
    
    public void exibirContas(){
        this.rConta.exibirNivel(this.rConta.getRaiz());
        this.rConta.exibirOrd();
    }
    
    public void exibeUmaC(String nCont){
        NoTree c = this.rConta.busca(nCont);
        if(c == null){
            System.out.println("Conta não cadastrada!");
        }else{
            System.out.println(c.getInfo());
        }
    }
    
    public void alterarConta(String nCont){
        NoTree c = this.rConta.busca(nCont);
        Scanner in = new Scanner(System.in);
        String r;
        if(c == null){
            return;
        }else if(c.getInfo().getTipo() == true){
            System.out.println("Essa conta é do tipo ESPECIAL, deseja alterar o tipo para SIMPLES? [S/n]");
            r = in.nextLine();
            r.toUpperCase();
            while(!r.equalsIgnoreCase("S") && !r.equalsIgnoreCase("N")){
                System.out.println("Opção inválida! Digite novamente: ");
                r = in.nextLine();
            }
            if(r.equalsIgnoreCase("S") == true){
                c.getInfo().setTipo(false);
                c.getInfo().setCredito(0);
            }
        }else{
            System.out.println("Essa conta é do tipo SIMPLES, deseja alterar o tipo para ESPECIAL? [S/n]");
            r = in.nextLine();
            r.toUpperCase();
            while(!r.equalsIgnoreCase("S") && !r.equalsIgnoreCase("N")){
                System.out.println("Opção inválida! Digite novamente: ");
                r = in.nextLine();
            }
            if(r.equalsIgnoreCase("S") == true){
                c.getInfo().setTipo(true);
                c.getInfo().setCredito(2000);
            }
        }
        System.out.println("Conta alterada com sucesso!");
    }
    
    //FIM DAS FUNCIONALIDADES DE CONTAS DO BANCO
    
    //FUNCIONALIDADES DOS CLIENTES DO BANCO
    public void cadastrarCliente(String cpf){
        NoCliente c = rCliente.busca(cpf);
        Scanner in = new Scanner(System.in);
        while (c != null){
            System.out.println("Cliente ja cadastrado! Informe outro cpf: ");
            cpf = in.nextLine();
            c = rCliente.busca(cpf);
        }
        if(c == null){
            String nome, email, tel;
            System.out.println("Digite o nome do cliente: ");
            nome = in.nextLine();
            System.out.println("Digite o e-mail do cliente: ");
            email = in.nextLine();
            System.out.println("Digite o telefone do cliente: ");
            tel = in.nextLine();
            Cliente cl = new Cliente(cpf, nome, email, tel);
            this.rCliente.inserir(cl);
            System.out.println("Cliente cadastrado com sucesso!!");
        }
    }
    
    public void removerCliente(String cpf){
        this.rCliente.remover(cpf);
        System.out.println("Cliente removido com sucesso!");
    }
    
    public void exibirClientes(){
        this.rCliente.exibirNivel(this.rCliente.getRaiz());
        this.rCliente.exibirOrd();
    }
    
    public void exibeUmCli(String cpf){
        NoCliente c = this.rCliente.busca(cpf);
        if(c == null){
            System.out.println("Conta não cadastrada!");
        }else{
            System.out.println(c.getInfo());
        }
    }
    
     public void alterarCliente(String cpf){
        NoCliente c = this.rCliente.busca(cpf);
        Scanner in = new Scanner(System.in);
        int r;
        String nome, email, tel, re;
        if(c == null){
            return;
        }else{
            do{
                System.out.println("O que deseja alterar?");
                //CHAMA UM VIEW MENU
                Menu.opAltCliente();
                System.out.println("Op: ");
                r = in.nextInt(); in.nextLine();
                switch(r){
                    case 1:
                        System.out.println("Digite o novo nome: ");
                        nome = in.nextLine();
                        c.getInfo().setNome(nome); break;
                    case 2:
                        System.out.println("Digite o novo e-mail: ");
                        email = in.nextLine();
                        c.getInfo().setEmail(email);break;
                    case 3:
                        System.out.println("Digite o novo telefone: ");
                        tel = in.nextLine();
                        c.getInfo().setTel(tel); break;
                    case 4:
                        System.out.println("Digite o novo nome: ");
                        nome = in.nextLine();
                        c.getInfo().setNome(nome);
                        System.out.println("Digite o novo e-mail: ");
                        email = in.nextLine();
                        c.getInfo().setEmail(email);
                        System.out.println("Digite o novo telefone: ");
                        tel = in.nextLine();
                        c.getInfo().setTel(tel);break;
                    default:
                        System.out.println("Opçao inválida! digite novamente.");
                }
                System.out.println("Deseja Continuar? [S/n]");
                re = in.nextLine();
                re.toUpperCase();
            }while(re.equalsIgnoreCase("S"));
        }
    }
    //FIM DAS FUNCIONALIDADES DOS CLIENTES DO BANCO
     
     //METÓDOS PARA PERSISTÊNCIA DOS DADOS DE CLIENTES E CONTAS
     public void gravarArvCliente(NoCliente c){
         if(c != null){
             gravarArvCliente(c.getEsq());
             CadastroArq.gravaCliente(c.getInfo());
             gravarArvCliente(c.getDir());
         }
     }
     
     public void gravarArvConta(NoTree c){
         if(c != null){
             gravarArvConta(c.getEsq());
             CadastroArq.gravaConta(c.getInfo());
             gravarArvConta(c.getDir());
         }
     }
    
}
