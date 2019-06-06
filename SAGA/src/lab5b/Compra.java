package lab5b;

public class Compra {
    private Data data;
    private Produto p;

    public Compra(Data data, Produto p){
        this.data = data;
        this.p = p;
    }

    public Produto getProduto(){
        return this.p;
    }

    @Override
    public String toString(){
        return p.getNome() + " - " + data.toString();
    }
}
