package showdown.battle.domain;

import showdown.battle.domain.ValueObject.Weather;
import showdown.player.domain.Player;
import showdown.pokemon.domain.Pokemon;

public class Battle {

    private Weather weather;
    private Player ownPokemon;
    private Pokemon opposingPokemon;

    public void start() {

    }

    public void sendPokemon(Pokemon pokemon) {

    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
