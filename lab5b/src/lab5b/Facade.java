package lab5b;

import easyaccept.EasyAccept;

public class Facade {

    private ControlerClientes c1;
    private ControlerFornecedores c2;

    public  static void main(String[] args){
        args = new String[] {"lab5b.Facade", "acceptance_tests/use_case_1.txt", "acceptance_tests/use_case_2.txt"};
        EasyAccept.main(args);
    }

    public Facade(){
        c1 = new ControlerClientes();
        c2 = new ControlerFornecedores();
    }
    public String adicionaCliente(String cpf, String nome, String email, String local){
        return c1.cadastrarCliente(cpf, nome, email, local);
    }
    public String exibeCliente(String cpf){
        return c1.exibeCliente(cpf);
    }
    public String exibeClientes(){
        return c1.exibeClientes();
    }
    public void editaCliente(String cpf, String atributo, String novoValor){
        c1.editaCliente(cpf, atributo, novoValor);
    }
    public void removeCliente(String cpf){
        c1.removeCliente(cpf);
    }
    public String adicionaFornecedor(String nome, String email, String telefone){
        return c2.adicionaFornecedor(nome, email, telefone);
    }
    public String exibeFornecedor(String nome){
        return c2.exibeFornecedor(nome);
    }
    public void editaFornecedor(String nome, String atributo, String novoValor){
        c2.editaFornecedor(nome, atributo, novoValor);
    }
    public void removeFornecedor(String nome){
        c2.removeFornecedor(nome);
    }
}
