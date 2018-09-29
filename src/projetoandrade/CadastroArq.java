package projetoandrade;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CadastroArq {
    private static ObjectInputStream input;
    private static ObjectOutputStream output;

    public void openToRead(String nomeArq) {
        File arquivo = new File(nomeArq);
        if (arquivo.exists() == false) {
            System.out.println("Arquivo não existe!");
            return;
        }
        try {
            FileInputStream arq = new FileInputStream(nomeArq);
            input = new ObjectInputStream(arq);
        } catch (IOException ioException) {
            System.err.println("Error ao tentar abrir o arquivo para leitura.");
            System.exit(1);
        }
    }

    public void openToReWrite(String nomeArq) {
        File arq = new File(nomeArq);
        if (arq.exists() == false) {
            try {
                FileOutputStream fOut = new FileOutputStream(nomeArq);
                output = new ObjectOutputStream(fOut);
                System.out.println("Arquivo aberto pra escrita!");
            } catch (IOException ioException) {
                System.err.println("Erro ao tentar abrir o arquivo para gravacao.");
                System.exit(1);
            }
        } else {
            try {
                FileOutputStream fOut = new FileOutputStream(nomeArq);
                output = new ObjectOutputStream(fOut);
                System.out.println("Arquivo aberto pra escrita!");
            } catch (IOException ioException) {
                System.err.println("Erro ao tentar abrir o arquivo para gravacao.");
                System.exit(1);
            }
        }
    }

    public void closeAfterRead() {
        try {
            if (input != null) {
                input.close();
                input = null;
                System.out.println("Fechou com sucesso!");
            }
        } catch (IOException ioException) {
            System.err.println("ERRO AO FECHAR ARQUIVO!");
            System.exit(1);
        }
    }

    public void closeAfterWrite() {
        try {
            if (output != null) {
                output.close();
                output = null;
                System.out.println("Fechou com sucesso!");
            }
        } catch (IOException ioException) {
            System.err.println("ERRO AO FECHAR ARQUIVO!");
            System.exit(1);
        }
    }

    public static void gravaCliente(Cliente p) {
        try {
            if (output != null) {
                output.writeObject(p);
                output.flush();// pra gravar <
                System.out.println("Gravacao efetuada com sucesso!");
            }
        } catch (IOException ioException) {
            System.err.println("Error ao gravar");
            System.exit(1);
        }
    }

    public static void gravaConta(Conta c) {
        RegConta conta = new RegConta(c.getNumeroConta(), c.getTipo(), c.getCliente().getCpf(), c.getSaldo(), c.getCredito());
        try {
            if (output != null) {
                output.writeObject(conta);
                output.flush();// pra gravar <
                System.out.println("Gravacao de conta efetuada com sucesso!");
            }
        } catch (IOException ioException) {
            System.err.println("Error ao gravar conta");
            System.exit(1);
        }
    }

    public void inicializaTreeConta(Banco ba) {
        RegConta reg;
        NoCliente buscaCliente;
        Conta conta;
        if (this.input != null) {
            try {
                while (true) {
                   reg = (RegConta) input.readObject();
                   //BUSCA UM CLIENTE NA ARVORE DE CLIENTES
                   buscaCliente = ba.getrCliente().busca(reg.getCpf());
                   if(reg.getTipo() == true){
                       conta = new Conta(reg.getNumeroConta(), buscaCliente.getInfo(), reg.getSaldo(), reg.getCredito(), reg.getTipo());
                   }else{
                       conta = new Conta(reg.getNumeroConta(), buscaCliente.getInfo(), reg.getSaldo());
                   }
                   //INSERE NA ARVORE, LENDO DO ARQUIVO
                   ba.getrConta().inserir(conta);
                }
            }catch (EOFException eofException) {
                System.out.println("Fim de arquivo Conta");
                //System.exit(1);
            }catch (ClassNotFoundException classNotFoundException) {
                System.err.println("Classe nao encontrada");
                System.exit(1);
            }catch (IOException ioException) {
                System.out.println(ioException);
                System.err.println("Erro ao tentar ler o arquivo conta");
                System.exit(1);
            }
        }
    }
    public void inicializaTreeCliente(Banco ba) {
        Cliente cliente;
        if (input != null) {
            try {
                while (true) {
                   cliente = (Cliente) input.readObject();
                   ba.getrCliente().inserir(cliente);
                }
            }catch (EOFException eofException) {
                System.out.println("Fim de arquivo Cliente");
                //System.exit(1);
            }catch (ClassNotFoundException classNotFoundException) {
                System.err.println("Classe nao encontrada");
                System.exit(1);
            }catch (IOException ioException) {
                System.err.println("Erro ao tentar ler o arquivo");
                System.exit(1);
            }
        }
    }
    
    public void gravarConta (NoTree node) {
        if (node != null) {
            gravaConta(node.getInfo());
            System.out.println(node.getInfo().getNumeroConta());
            gravarConta(node.getEsq());
            gravarConta(node.getDir());
        }
        
    }
    
    public void gravarCliente(NoCliente node){
        if (node != null) {
            gravaCliente(node.getInfo());
            System.out.println(node.getInfo().getCpf());
            gravarCliente(node.getEsq());
            gravarCliente(node.getDir());
        }
    }
}
 