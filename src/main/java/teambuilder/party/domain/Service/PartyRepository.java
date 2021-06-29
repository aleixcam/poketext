package teambuilder.party.domain.Service;

public interface PartyRepository {

    String[] list();
    String[][][] get(String ref);
    void remove(String ref);
}
