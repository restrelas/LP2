package prova;

import prova.Animal;

public class Morcego extends Animal {

    public Morcego(int id){
        this.idade = 0;
        this.peso = 0.002;
        this.id = id;
        this.tipo = "BAT";
    }

    public String toString(){
        return tipo + " " + id + " - " + peso + " kg - " + idade + " - P";
    }
    public void crescer(){
        peso += 0.002;
        idade++;
    }


}
