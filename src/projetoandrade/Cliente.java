package projetoandrade;

import java.io.Serializable;

public class Cliente implements Serializable{
    private String cpf;
    private String nome;
    private String email;
    private String tel;

    public Cliente(String cpf, String nome, String email, String tel) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.tel = tel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Cliente{ " + "cpf: " + cpf + ", nome: " + nome + ", email: " + email + ", tel: " + tel + " }";
    }
    
    
}
