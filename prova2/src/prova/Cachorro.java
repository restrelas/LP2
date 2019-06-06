package prova;

import prova.Animal;

public class Cachorro extends Animal {

    public Cachorro(int id){
        this.idade = 0;
        this.peso = 0.4;
        this.id = id;
        this.tipo = "CAO";
    }


    public String toString(){
        return tipo + " " + id + " - " + peso + " kg - " + idade + (peso > 10 ? " - M" : " - P");
    }
    public void crescer(){
        peso+=0.7;
        idade++;
    }
}
