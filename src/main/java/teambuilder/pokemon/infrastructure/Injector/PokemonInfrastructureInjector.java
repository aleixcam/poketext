package teambuilder.pokemon.infrastructure.Injector;

import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import teambuilder.pokemon.infrastructure.Persistence.FileSystem.CSVPokemonRepository;
import teambuilder.pokemon.infrastructure.Persistence.FileSystem.ShowdownPokemonRepository;
import teambuilder.pokemon.infrastructure.Transformer.ShowdownPokemonTransformer;

public class PokemonInfrastructureInjector {

    public static CSVPokemonRepository csvPokemonRepository() {
        return new CSVPokemonRepository(
            SharedInfrastructureInjector.csvFileSystemManager()
        );
    }

    public static ShowdownPokemonRepository showdownPokemonRepository() {
        return new ShowdownPokemonRepository(
            SharedInfrastructureInjector.showdownFileSystemManager(),
            showdownPokemonTransformer()
        );
    }

    public static ShowdownPokemonTransformer showdownPokemonTransformer() {
        return new ShowdownPokemonTransformer();
    }
}
