package prova;

import prova.Animal;

public class Elefante extends Animal {

    public Elefante(int id){
        this.idade = 0;
        this.peso = 120;
        this.id = id;
        this.tipo = "FANTE";
    }

    public String toString(){
        return tipo + " " + id + " - " + peso + " kg - " + idade + " - G";
    }
    public void crescer(){
        peso+=(idade > 20 ? 0 : 250);
        idade++;
    }
}
