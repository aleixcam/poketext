package teambuilder.pokemon.infrastructure.Transformer;

import shared.core.domain.ShowdownPokemon;
import shared.move.domain.Move;
import shared.pokemon.domain.EffortValues;
import shared.pokemon.domain.IndividualValues;
import shared.pokemon.domain.Stat;
import teambuilder.pokemon.domain.Pokemon;
import teambuilder.pokemon.domain.Service.PokemonTransformer;

import java.util.HashMap;
import java.util.Map;

final public class ShowdownPokemonTransformer implements PokemonTransformer<ShowdownPokemon> {

    public ShowdownPokemon transform(Pokemon pokemon) {
        EffortValues effortValues = pokemon.getEffortValues();
        IndividualValues individualValues = pokemon.getIndividualValues();
        return new ShowdownPokemon(
            pokemon.getBasePokemon().name(),
            pokemon.getNickname(),
            pokemon.getGender() != null ? pokemon.getGender().value() : Character.MIN_VALUE,
            pokemon.getItem().name(),
            pokemon.getAbility().name(),
            pokemon.getLevel().value(),
            pokemon.isShiny(),
            transformStats(
                    effortValues.healthPoints(),
                    effortValues.attack(),
                    effortValues.defense(),
                    effortValues.specialAttack(),
                    effortValues.specialDefense(),
                    effortValues.speed()
            ),
            pokemon.getNature().name(),
            transformStats(
                    individualValues.healthPoints(),
                    individualValues.attack(),
                    individualValues.defense(),
                    individualValues.specialAttack(),
                    individualValues.specialDefense(),
                    individualValues.speed()
            ),
            pokemon.getMoves().moves().stream().map(Move::name).toArray(String[]::new)
        );
    }

    private Map<Stat, Integer> transformStats(
            int healthPoints,
            int attack,
            int defense,
            int specialAttack,
            int specialDefense,
            int speed
    ) {
        Map<Stat, Integer> values = new HashMap<>();

        if (healthPoints != 0) {
            values.put(Stat.HP, healthPoints);
        }

        if (attack != 0) {
            values.put(Stat.ATK, attack);
        }

        if (defense != 0) {
            values.put(Stat.DEF, defense);
        }

        if (specialAttack != 0) {
            values.put(Stat.SPA, specialAttack);
        }

        if (specialDefense != 0) {
            values.put(Stat.SPD, specialDefense);
        }

        if (speed != 0) {
            values.put(Stat.SPE, speed);
        }

        return values;
    }

    public Pokemon reverseTransform(ShowdownPokemon data) {
        return null;
    }
}
