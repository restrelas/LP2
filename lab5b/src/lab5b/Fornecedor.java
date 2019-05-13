package lab5b;

public class Fornecedor {
    private String nome;
    private String email;
    private String telefone;

    public Fornecedor(String nome, String email, String telefone){
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String toString(){
        return nome + " - " + email + " - " + telefone;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}
