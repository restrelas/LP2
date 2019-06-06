package prova;

import prova.Animal;

import java.util.Comparator;

public class ComparadorPeso implements Comparator {

        @Override
        public int compare(Object o, Object t1){
            Animal a = (Animal)o; Animal b = (Animal)t1;
            if(a.getPeso() == b.getPeso()) return 0;
            if(a.getPeso() > b.getPeso()) return 1;
            return -1;
        }
}
