package teambuilder.team.domain.Service;

public interface TeamRepository {

    String[] list();
    <R> R get(String ref);
    void remove(String ref);
}
