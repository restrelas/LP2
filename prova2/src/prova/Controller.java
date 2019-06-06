package prova;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Controller {
    private HashMap<String, Animal> animais;
    private int id;
    private String estrategia;

    public Controller(){
        animais = new HashMap<>();
        id = 0;
        estrategia = "";
    }
    public int cadastrarCachorroFilhote(){
        animais.put(String.valueOf(++id), new Cachorro(id));
        return id;
    }
    public int cadastrarElefanteFilhote(){
        animais.put(String.valueOf(++id), new Elefante(id));
        return id;
    }
    public int cadastrarMorcegoFilhote(){
        animais.put(String.valueOf(++id), new Morcego(id));
        return id;
    }
    public String exibirAnimal(int id){
        if(id < 1 || id > this.id) throw new IllegalArgumentException("Erro ao exibir animal: id invalido.");
        if(!animais.containsKey(String.valueOf(id))) throw new IllegalArgumentException("Erro ao exibir animal: animal nao existe");
        return animais.get(String.valueOf(id)).toString();
    }
    public void crescer(int id){
        if(id < 1 || id > this.id) throw new IllegalArgumentException("Erro em crescer animal: id invalido.");
        animais.get(String.valueOf(id)).crescer();
    }

    public void configurarRemocao(String estrategia){
        if(estrategia == null || (!estrategia.equals("PESO") && !estrategia.equals("IDADE"))) throw new IllegalArgumentException(("Erro ao comfigurar estrategia: parametro nao suportado."));
        this.estrategia = estrategia;
    }
    public int remover(){
        if(estrategia.equals("")) throw new RuntimeException("Erro ao remover: estrategia ainda nao definida.");
        Comparator comparador;
        if(estrategia.equals("IDADE")) comparador = new ComparadorIdade();
        else comparador = new ComparadorPeso();
        if(!animais.isEmpty()){
            Animal a = Collections.max(animais.values(), comparador);
            int temp = a.getId();
            animais.remove(String.valueOf(temp));
            return temp;
        }
        return 0;
    }
}
