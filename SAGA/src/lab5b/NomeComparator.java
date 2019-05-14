package lab5b;

import java.util.Comparator;

public class NomeComparator implements Comparator<Nomeavel> {
    @Override
    public int compare(Nomeavel nomeavel, Nomeavel t1) {
        return nomeavel.getNome().compareTo(t1.getNome());
    }
}
