package showdown.player.domain;

import showdown.battle.domain.Battle;
import showdown.party.domain.Party;
import showdown.pokemon.domain.Pokemon;

public final class Player {

    private final Party party;
    private final Battle battle;

    public Player(Party party, Battle battle) {
        this.party = party;
        this.battle = battle;
    }

    public Party getParty() {
        return party;
    }

    public void enterBattle() {
        battle.sendPokemon(this.party.getPokemon(0));
    }

    public void switchPokemon(Pokemon pokemon) {
        battle.sendPokemon(pokemon);
    }
}
