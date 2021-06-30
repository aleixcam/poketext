package shared.core.infrastructure.Controller;

import indexer.ability.application.Command.SearchAbilitiesCommand;
import shared.core.domain.Command.Menu;
import indexer.pokedex.infrastructure.controller.PokedexController;
import indexer.item.application.Command.SearchItemsCommand;
import indexer.move.application.Command.SearchMovesCommand;
import indexer.pokemon.application.Command.SearchPokemonsCommand;
import showdown.player.legacy.Jugadors;
import teambuilder.pokemon.infrastructure.Controller.PokemonController;
import teambuilder.team.infrastructure.Controller.TeamController;

final public class AppController {

    public void showdown(String... args) {
        Jugadors.iniciarCombat();
    }

    public void teamBuilder(String... args) {
        TeamController teamController = new TeamController();
        PokemonController pokemonController = new PokemonController();

        Menu menu = new Menu("POKETEXT: CONSTRUCTOR D'EQUIPS");
        menu.register("C", teamController::create, "Crear un nou equip");
        menu.register("M", teamController::edit, "Modificar un equip");
        menu.register("E", teamController::remove, "Eliminar un equip");
        menu.register("P", pokemonController::remove, "Eliminar un Pokèmon");

        menu.execute();
    }

    public void indexer(String... args) {
        PokedexController receiver = new PokedexController();

        Menu menu = new Menu("POKETEXT: POKÈDEX");
        menu.register("P", SearchPokemonsCommand.of(receiver), "Cerca Pokèmons");
        menu.register("M", SearchMovesCommand.of(receiver), "Cerca Moviments");
        menu.register("O", SearchItemsCommand.of(receiver), "Cerca Objectes");
        menu.register("A", SearchAbilitiesCommand.of(receiver), "Cerca Habilitats");

        menu.execute();
    }
}
