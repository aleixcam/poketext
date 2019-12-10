package indexer.nature.domain;

import java.util.ArrayList;

public class NatureCollection {

    private ArrayList<Nature> natures = new ArrayList<>();

    public void add(Nature nature) {
        natures.add(nature);
    }

    public ArrayList<Nature> getNatures() {
        return natures;
    }
}
