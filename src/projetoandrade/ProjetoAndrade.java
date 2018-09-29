package projetoandrade;

import java.util.Scanner;

public class ProjetoAndrade {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Banco ba = Banco.getInstance();
        String num, ArqCliente = "Clientes.dat", ArqConta = "Contas.dat";
        int op;
        CadastroArq cad = new CadastroArq();
        
        cad.openToRead(ArqCliente);
        cad.inicializaTreeCliente(ba);
        cad.closeAfterRead();
        cad.openToRead(ArqConta);
        cad.inicializaTreeConta(ba);
        cad.closeAfterRead();
        
        System.out.println("-_-_-_-_-_-_-INICIO DO PROGRAMA!-_-_-_-_-_-_-");
        do{
            Menu.opcao();
            System.out.print("Op: ");
            op = in.nextInt();
            switch(op){
                case 1:
                    System.out.println("Digite o numero da conta que deseja cadastrar: ");
                    in.nextLine();
                    num = in.nextLine();
                    // WHILE VALIDA A QUANTIDADE DE DIGITOS NO NUMERO DA CONTA
                    while(num.length() == 0 || num.length() < 3 || num.length() > 3){
                        System.out.println("Numero da conta inválido! Digite novamente!");
                        num = in.nextLine();
                    }
                    // COLOCA A NOVA CONTA NA ARVORE
                    ba.cadastrarConta(num);
                    break;
                case 2:
                    System.out.println("Digite o numero da conta que deseja remover:");
                    in.nextLine();
                    num = in.nextLine();
                    // WHILE VALIDA A QUANTIDADE DE DIGITOS NO NUMERO DA CONTA
                    while(num.length() == 0 || num.length() < 3 || num.length() > 3){
                        System.out.println("Numero da conta inválido! Digite novamente!");
                        num = in.nextLine();
                    }
                    //REMOVE A CONTA DA ARVORE
                    ba.removerConta(num);
                    break;
                case 3:
                    System.out.println("Digite o numero da conta que deseja alterar:");
                    in.nextLine();
                    num = in.nextLine();
                    // WHILE VALIDA A QUANTIDADE DE DIGITOS NO NUMERO DA CONTA
                    while(num.length() == 0 || num.length() < 3 || num.length() > 3){
                        System.out.println("Numero da conta inválido! Digite novamente!");
                        num = in.nextLine();
                    }
                    //ALTERA UMA CONTA
                    ba.alterarConta(num);
                    break;
                case 4:
                    System.out.println("Digite o numero da conta que deseja exibir:");
                    in.nextLine();
                    num = in.nextLine();
                    // WHILE VALIDA A QUANTIDADE DE DIGITOS NO NUMERO DA CONTA
                    while(num.length() == 0 || num.length() < 3 || num.length() > 3){
                        System.out.println("Numero da conta inválido! Digite novamente!");
                        num = in.nextLine();
                    }
                    //EXIBE UMA CONTA
                    ba.exibeUmaC(num);
                    break;
                case 5: 
                    System.out.println("Lista de todas as contas:");
                    //EXIBE TODAS AS CONTAS DA ARVORE
                    ba.exibirContas();
                    break;
                case 6:
                    System.out.println("Digite o numero do CPF que deseja cadastrar:");
                    in.nextLine();
                    num = in.nextLine();
                    // WHILE VALIDA A QUANTIDADE DE DIGITOS NO NUMERO DA CONTA
                    while(num.length() == 0 || num.length() < 3 || num.length() > 3){
                        System.out.println("Numero do cpf inválido! Digite novamente!");
                        num = in.nextLine();
                    }
                    // COLOCA UM CLIENTE NA ARVORE
                    ba.cadastrarCliente(num);
                    break;
                case 7:
                    System.out.println("Digite o numero do CPF que deseja remover:");
                    in.nextLine();
                    num = in.nextLine();
                    // WHILE VALIDA A QUANTIDADE DE DIGITOS NO NUMERO DA CONTA
                    while(num.length() == 0 || num.length() < 3 || num.length() > 3){
                        System.out.println("Numero do cpf inválido! Digite novamente!");
                        num = in.nextLine();
                    }
                    //REMOVE UM CLIENTE DA ARVORE
                    ba.removerCliente(num);
                    break;
                case 8:
                    System.out.println("Digite o numero do CPF que deseja alterar:");
                    in.nextLine();
                    num = in.nextLine();
                    // WHILE VALIDA A QUANTIDADE DE DIGITOS NO NUMERO DA CONTA
                    while(num.length() == 0 || num.length() < 3 || num.length() > 3){
                        System.out.println("Numero do cpf inválido! Digite novamente!");
                        num = in.nextLine();
                    }
                    //ALTERA UM CLIENTE NA ARVORE
                    ba.alterarCliente(num);
                    break;
                case 9:
                    System.out.println("Digite o numero do CPF que deseja exibir:");
                    in.nextLine();
                    num = in.nextLine();
                    // WHILE VALIDA A QUANTIDADE DE DIGITOS NO NUMERO DA CONTA
                    while(num.length() == 0 || num.length() < 3 || num.length() > 3){
                        System.out.println("Numero do cpf inválido! Digite novamente!");
                        num = in.nextLine();
                    }
                    ba.exibeUmCli(num);
                    break;
                case 10:
                    System.out.println("Lista de todos os cliente.");
                    ba.exibirClientes();
                    break;
                case 0:
                    cad.openToReWrite(ArqCliente);
                    ba.gravarArvCliente(ba.getrCliente().getRaiz());
                    cad.closeAfterWrite();
                    cad.openToReWrite(ArqConta);
                    ba.gravarArvConta(ba.getrConta().getRaiz());
                    cad.closeAfterWrite();
                    System.out.println("Hasta La Vista! Baby.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }while(op != 0);
    }
}
