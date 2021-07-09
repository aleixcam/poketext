package teambuilder.pokemon.infrastructure.Controller;

import shared.core.infrastructure.Service.ReaderService;
import teambuilder.pokemon.infrastructure.Injector.PokemonInfrastructureInjector;

final public class PokemonController {

    public void remove(String... args) {
        PokemonInfrastructureInjector.csvPokemonRepository().remove(ReaderService.read());
    }
}
