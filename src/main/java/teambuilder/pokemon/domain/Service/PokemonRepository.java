package teambuilder.pokemon.domain.Service;

public interface PokemonRepository<R> {

    String[] list();
    R get(String ref);
    void remove(String ref);
}
