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

public class ShowdownPokemonTransformer implements
    PokemonTransformer<ShowdownPokemon>,
    shared.core.domain.Service.ShowdownPokemonTransformer<Pokemon>
{

    public ShowdownPokemon transform(Pokemon pokemon) {
        return new ShowdownPokemon(
            pokemon.getBasePokemon().name(),
            pokemon.getNickname(),
            pokemon.getGender().value(),
            pokemon.getItem().name(),
            pokemon.getAbility().name(),
            pokemon.getLevel().value(),
            pokemon.isShiny(),
            this.transformEffortValues(pokemon.getEffortValues()),
            pokemon.getNature().name(),
            this.transformIndividualValues(pokemon.getIndividualValues()),
            pokemon.getMoves().moves().stream().map(Move::name).toArray(String[]::new)
        );
    }

    private Map<Stat, Integer> transformEffortValues(EffortValues effortValues) {
        Map<Stat, Integer> evs = new HashMap<>();

        if (effortValues.healthPoints() != 0) {
            evs.put(Stat.HP, effortValues.healthPoints());
        }

        if (effortValues.attack() != 0) {
            evs.put(Stat.HP, effortValues.attack());
        }

        if (effortValues.defense() != 0) {
            evs.put(Stat.HP, effortValues.defense());
        }

        if (effortValues.specialAttack() != 0) {
            evs.put(Stat.HP, effortValues.specialAttack());
        }

        if (effortValues.specialDefense() != 0) {
            evs.put(Stat.HP, effortValues.specialDefense());
        }

        if (effortValues.speed() != 0) {
            evs.put(Stat.HP, effortValues.speed());
        }

        return evs;
    }

    private Map<Stat, Integer> transformIndividualValues(IndividualValues individualValues) {
        Map<Stat, Integer> ivs = new HashMap<>();

        if (individualValues.healthPoints() != 0) {
            ivs.put(Stat.HP, individualValues.healthPoints());
        }

        if (individualValues.attack() != 0) {
            ivs.put(Stat.HP, individualValues.attack());
        }

        if (individualValues.defense() != 0) {
            ivs.put(Stat.HP, individualValues.defense());
        }

        if (individualValues.specialAttack() != 0) {
            ivs.put(Stat.HP, individualValues.specialAttack());
        }

        if (individualValues.specialDefense() != 0) {
            ivs.put(Stat.HP, individualValues.specialDefense());
        }

        if (individualValues.speed() != 0) {
            ivs.put(Stat.HP, individualValues.speed());
        }
        return ivs;
    }

    public Pokemon reverseTransform(ShowdownPokemon data) {
        return null;
    }
}
