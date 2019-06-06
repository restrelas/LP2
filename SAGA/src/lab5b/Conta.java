package lab5b;

import java.util.ArrayList;
import java.util.HashMap;

public class Conta {
    private ArrayList<Compra> compras;

    public Conta(String data, Produto p){
        compras = new ArrayList<Compra>();
        compras.add(new Compra(new Data(data), p));
    }
    public void adicionaCompra(String data, Produto p){
        compras.add(new Compra(new Data(data), p));
    }
    public String getDebito(){
        double debito = 0;
        for(Compra it : compras){
            debito += it.getProduto().getPreco();
        }
        return String.format("%.2f", debito);
    }
    public String exibeContas(){
        String ans = "";
        for(Compra it : compras){
            ans += " | " + it.toString();
        }
        return ans;
    }
}
