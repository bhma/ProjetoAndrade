package projetoandrade;

import java.util.Scanner;

public class Menu {
    public static void opcao(){
        System.out.println();
        System.out.println("1 - Cadastrar uma nova conta.");
        System.out.println("2 - Remover uma conta.");
        System.out.println("3 - Modificar uma conta.");
        System.out.println("4 - Exibir uma conta.");
        System.out.println("5 - Exibir TODAS as conta.");
        System.out.println("6 - Cadastrar um novo cliente.");
        System.out.println("7 - Remover um cliente.");
        System.out.println("8 - Modificar um cliente.");
        System.out.println("9 - Exibir um cliente.");
        System.out.println("10 - Exibir TODOS os cliente.");
        System.out.println("0 - Sair do programa.");
    }
    
    public static void opCadastrarConta(){
        System.out.println("-_-_-_-_-_-_-CADASTRO DE CONTA-_-_-_-_-_-_-");
    }
    
    public static void opRemoverConta(){
        System.out.println("-_-_-_-_-_-_-REMOÇÃO DE CONTA-_-_-_-_-_-_-");
    }
    
    public static void opAlteraConta(){
        System.out.println("-_-_-_-_-_-_-ALTERAÇÃO DE CONTA-_-_-_-_-_-_-");
    }
    
    public static void opExibirConta(){
        System.out.println("-_-_-_-_-_-_-LISTANDO CONTA-_-_-_-_-_-_-");
    }
    
    public static void opAltCliente(){
        System.out.println("1 - Só o nome.");
        System.out.println("2 - Só o e-mail.");
        System.out.println("3 - Só o telefone.");
        System.out.println("4 - Todos os campos.");
    }
}
