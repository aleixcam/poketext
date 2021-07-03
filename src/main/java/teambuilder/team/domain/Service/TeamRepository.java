package teambuilder.team.domain.Service;

public interface TeamRepository<R> {

    String[] list();
    R get(String ref);
    void remove(String ref);
}
