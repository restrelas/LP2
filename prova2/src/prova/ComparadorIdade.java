package prova;

import prova.Animal;

import java.util.Comparator;

public class ComparadorIdade implements Comparator {

    @Override
    public int compare(Object o, Object t1) {
        Animal a = (Animal)o; Animal b = (Animal)t1;
        if (a.getIdade() == b.getIdade()) return 0;
        if (a.getIdade() > b.getIdade()) return 1;
        return -1;
    }

}

