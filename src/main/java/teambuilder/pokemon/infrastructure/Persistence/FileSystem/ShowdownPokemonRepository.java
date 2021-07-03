package teambuilder.pokemon.infrastructure.Persistence.FileSystem;

import shared.core.domain.ShowdownPokemon;
import shared.core.infrastructure.Persistence.FileSystem.ShowdownFileSystemManager;
import teambuilder.pokemon.domain.Pokemon;
import teambuilder.pokemon.domain.Service.PokemonRepository;
import teambuilder.pokemon.domain.Service.PokemonTransformer;

public class ShowdownPokemonRepository implements PokemonRepository<Pokemon> {

    private final ShowdownFileSystemManager fileSystemManager;
    private final PokemonTransformer<ShowdownPokemon> transformer;

    public ShowdownPokemonRepository(
            ShowdownFileSystemManager fileSystemManager,
            PokemonTransformer<ShowdownPokemon> transformer
    ) {
        this.fileSystemManager = fileSystemManager;
        this.transformer = transformer;
        this.fileSystemManager.setDirectory("data/memory/pokemon");
    }

    public String[] list() {
        return this.fileSystemManager.list();
    }

    public Pokemon get(String ref) {
        return this.transformer.reverseTransform(this.fileSystemManager.importOne(ref));
    }

    public void remove(String ref) {
        this.fileSystemManager.erase(ref);
    }
}
