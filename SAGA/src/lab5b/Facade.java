package lab5b;

import easyaccept.EasyAccept;

public class Facade {

    private SAGA saga;

    public  static void main(String[] args){
        args = new String[] {"lab5b.Facade", "acceptance_tests/use_case_1.txt", "acceptance_tests/use_case_2.txt", "acceptance_tests/use_case_3.txt",
                                "acceptance_tests/use_case_4.txt", "acceptance_tests/use_case_5.txt", "acceptance_tests/use_case_6.txt",
                                "acceptance_tests/use_case_7.txt"};
        EasyAccept.main(args);
    }

    public Facade(){
        saga = new SAGA();
    }
    //US1
    public String adicionaCliente(String cpf, String nome, String email, String local){
        return saga.adicionaCliente(cpf, nome, email, local);
    }
    public String exibeCliente(String cpf){
        return saga.exibeCliente(cpf);
    }
    public String exibeClientes(){
        return saga.exibeClientes();
    }
    public void editaCliente(String cpf, String atributo, String novoValor){
        saga.editaCliente(cpf, atributo, novoValor);
    }
    public void removeCliente(String cpf){
        saga.removeCliente(cpf);
    }
    //US2
    public String adicionaFornecedor(String nome, String email, String telefone){
        return saga.adicionaFornecedor(nome, email, telefone);
    }
    public String exibeFornecedor(String nome){
        return saga.exibeFornecedor(nome);
    }
    public void editaFornecedor(String nome, String atributo, String novoValor){
        saga.editaFornecedor(nome, atributo, novoValor);
    }
    public void removeFornecedor(String nome){
        saga.removeFornecedor(nome);
    }
    //US3
    public void adicionaProduto(String fornecedor, String nome, String descricao, double preco){
        saga.adicionaProduto(fornecedor, nome, descricao, preco);
    }
    public String exibeProduto(String nome, String descricao, String fornecedor){
        return saga.exibeProduto(nome, descricao, fornecedor);
    }
    public String editaProduto(String nome, String descricao, String fornecedor, double preco){
        return saga.editaProduto(nome, descricao, fornecedor, preco);
    }
    public void removeProduto(String nome, String descricao, String fornecedor){
        saga.removeProduto(nome, descricao, fornecedor);
    }
    //US4
    public String exibeFornecedores(){
        return saga.exibeFornecedores();
    }
    public String exibeProdutos(){
        return saga.exibeProdutos();
    }
    public String exibeProdutosFornecedor(String nomeFornecedor){
        return saga.exibeProdutosFornecedor(nomeFornecedor);
    }
    //US5
    public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos){
        saga.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
    }
    public void editaCombo(String nome, String descricao, String fornecedor, double novoFator){
        saga.editaCombo(nome, descricao, fornecedor, novoFator);
    }
    //US6
    public void adicionaCompra(String cpf, String fornecedor, String data, String nome, String descricao){
        saga.adicionaCompra(cpf, fornecedor, data, nome, descricao);
    }
    public String getDebito(String cpf, String fornecedor){
        return saga.getDebito(cpf, fornecedor);
    }
    public String exibeContas(String cpf, String fornecedor){
        return saga.exibeContas(cpf, fornecedor);
    }
    public String exibeContasClientes(String cpf){
        return saga.exibeContasClientes(cpf);
    }
    public void realizaPagamento(String cpf, String fornecedor){
        saga.realizaPagamento(cpf, fornecedor);
    }
}
