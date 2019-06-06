package prova;

import java.util.Comparator;

public abstract class Animal{

    protected double peso;
    protected int idade;
    protected int id;
    protected String tipo;

    public abstract String toString();
    public abstract void crescer();

    public int getId(){
        return this.id;
    }
    public double getPeso(){
        return this.peso;
    }
    public int getIdade(){
        return this.idade;
    }
}
