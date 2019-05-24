package lab5b;

public class SAGA {
    private ControlerClientes c1;
    private ControlerFornecedores c2;

    public SAGA(){
        c1 = new ControlerClientes();
        c2 = new ControlerFornecedores();
    }
    //US1
    public String adicionaCliente(String cpf, String nome, String email, String local){
        return c1.adicionaCliente(cpf, nome, email, local);
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
    //US2
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
    //US3
    public void adicionaProduto(String fornecedor, String nome, String descricao, double preco){
        c2.adicionaProduto(fornecedor, nome, descricao, preco);
    }
    public String exibeProduto(String nome, String descricao, String fornecedor){
        return c2.exibeProduto(nome, descricao, fornecedor);
    }
    public String editaProduto(String nome, String descricao, String fornecedor, double preco){
        return c2.editaProduto(nome, descricao, fornecedor, preco);
    }
    public void removeProduto(String nome, String descricao, String fornecedor){
        c2.removeProduto(nome, descricao, fornecedor);
    }
    //US4
    public String exibeFornecedores(){
        return c2.exibeFornecedores();
    }
    public String exibeProdutos(){
        return c2.exibeProdutos();
    }
    public String exibeProdutosFornecedor(String nomeFornecedor){
        return c2.exibeProdutosFornecedor(nomeFornecedor);
    }
    //US5
    public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos){
        c2.adicionaCombo(fornecedor, nome, descricao, fator, produtos);
    }
    public void editaCombo(String nome, String descricao, String fornecedor, double novoFator){
        c2.editaCombo(nome, descricao, fornecedor, novoFator);
    }
    //US6
    public void adicionaCompra(String cpf, String fornecedor, String data, String nome, String descricao){
        if(fornecedor == null || fornecedor.equals("")) throw new IllegalArgumentException("Erro ao cadastrar compra: fornecedor nao pode ser vazio ou nulo.");
        if(cpf == null || cpf.equals("")) throw new IllegalArgumentException("Erro ao cadastrar compra: cpf nao pode ser vazio ou nulo.");
        if(cpf.length() != 11) throw new Error("Erro ao cadastrar compra: cpf invalido.");
        if(data == null || data.equals("")) throw new IllegalArgumentException("Erro ao cadastrar compra: data nao pode ser vazia ou nula.");
        if(nome == null || nome.equals("")) throw new IllegalArgumentException("Erro ao cadastrar compra: nome do produto nao pode ser vazio ou nulo.");
        if(descricao == null || descricao.equals("")) throw new IllegalArgumentException("Erro ao cadastrar compra: descricao do produto nao pode ser vazia ou nula.");
        c1.adicionaCompra(cpf, fornecedor, data, c2.getProduto(fornecedor, nome, descricao));
    }
    public String getDebito(String cpf, String fornecedor){
        if(cpf == null || cpf.equals("")) throw new IllegalArgumentException("Erro ao recuperar debito: cpf nao pode ser vazio ou nulo.");
        if(cpf.length() != 11) throw new Error("Erro ao recuperar debito: cpf invalido.");
        if(fornecedor == null || fornecedor.equals("")) throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao pode ser vazio ou nulo.");
        if(!c2.checkFornecedor(fornecedor)) throw new IllegalArgumentException("Erro ao recuperar debito: fornecedor nao existe.");
        return c1.getDebito(cpf, fornecedor);
    }
    public String exibeContas(String cpf, String fornecedor){
        if(fornecedor == null || fornecedor.equals("")) throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao pode ser vazio ou nulo.");
        if(cpf == null || cpf.equals("")) throw new IllegalArgumentException("Erro ao exibir conta do cliente: cpf nao pode ser vazio ou nulo.");
        if(cpf.length() != 11) throw new Error("Erro ao exibir conta do cliente: cpf invalido.");
        if(!c2.checkFornecedor(fornecedor)) throw new IllegalArgumentException("Erro ao exibir conta do cliente: fornecedor nao existe.");
        return c1.exibeContas(cpf, fornecedor);
    }
    public String exibeContasClientes(String cpf){
        if(cpf == null || cpf.equals("")) throw new IllegalArgumentException("Erro ao exibir contas do cliente: cpf nao pode ser vazio ou nulo.");
        if(cpf.length() != 11) throw new Error("Erro ao exibir contas do cliente: cpf invalido.");
        return c1.exibeContasClientes(cpf);
    }
    public void realizaPagamento(String cpf, String fornecedor){
        if(cpf == null || cpf.equals("")) throw new IllegalArgumentException("Erro no pagamento de conta: cpf nao pode ser vazio ou nulo.");
        if(cpf.length() != 11) throw new Error("Erro no pagamento de conta: cpf invalido.");
        if(fornecedor == null ||  fornecedor.equals("")) throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao pode ser vazio ou nulo.");
        if(!c2.checkFornecedor(fornecedor)) throw new IllegalArgumentException("Erro no pagamento de conta: fornecedor nao existe.");
        c1.realizaPagamento(cpf, fornecedor);
    }
}
