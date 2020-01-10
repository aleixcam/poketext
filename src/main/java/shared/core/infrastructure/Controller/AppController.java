package shared.core.infrastructure.Controller;

import indexer.ability.application.Command.SearchAbilitiesCommand;
import shared.core.domain.Command.Menu;
import indexer.pokedex.infrastructure.controller.PokedexController;
import indexer.item.application.Command.SearchItemsCommand;
import indexer.move.application.Command.SearchMovesCommand;
import indexer.pokemon.application.Command.SearchPokemonsCommand;
import showndown.player.legacy.Jugadors;
import teambuilder.pokemon.application.Command.RemovePokemonCommand;
import teambuilder.team.application.Command.CreateTeamCommand;
import teambuilder.team.application.Command.EditTeamCommand;
import teambuilder.team.application.Command.RemoveTeamCommand;
import teambuilder.team.infrastructure.Controller.TeamController;

final public class AppController {

    public void play() {
        Jugadors.iniciarCombat();
    }

    public void teamBuilder() {
        TeamController receiver = new TeamController();

        Menu menu = new Menu("POKETEXT: CONSTRUCTOR D'EQUIPS");
        menu.register("C", CreateTeamCommand.of(receiver), "Crear un nou equip");
        menu.register("M", EditTeamCommand.of(receiver), "Modificar un equip");
        menu.register("E", RemoveTeamCommand.of(receiver), "Eliminar un equip");
        menu.register("P", RemovePokemonCommand.of(receiver), "Eliminar un Pokèmon");

        menu.execute();
    }

    public void pokedex() {
        PokedexController receiver = new PokedexController();

        Menu menu = new Menu("POKETEXT: POKÈDEX");
        menu.register("P", SearchPokemonsCommand.of(receiver), "Cerca Pokèmons");
        menu.register("M", SearchMovesCommand.of(receiver), "Cerca Moviments");
        menu.register("O", SearchItemsCommand.of(receiver), "Cerca Objectes");
        menu.register("A", SearchAbilitiesCommand.of(receiver), "Cerca Habilitats");

        menu.execute();
    }
}
