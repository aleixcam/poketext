package domain.nature;

import java.util.ArrayList;

public class NaturesCollection {

    private ArrayList<Nature> natures = new ArrayList<>();

    public void add(Nature nature) {
        natures.add(nature);
    }

    public ArrayList<Nature> getNatures() {
        return natures;
    }
}
