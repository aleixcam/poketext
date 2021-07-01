package teambuilder.team.infrastructure.Transformer;

import shared.core.domain.ShowdownPokemon;
import teambuilder.pokemon.domain.Pokemon;
import teambuilder.pokemon.infrastructure.Transformer.ShowdownPokemonTransformer;
import teambuilder.team.domain.Service.TeamTransformer;
import teambuilder.team.domain.Team;

import java.util.Arrays;

public class ShowdownTeamTransformerImpl implements
    TeamTransformer<ShowdownPokemon[]>,
    shared.core.domain.Service.ShowdownTeamTransformer<Team>
{

    private final ShowdownPokemonTransformer pokemonTransformer;

    public ShowdownTeamTransformerImpl(ShowdownPokemonTransformer pokemonTransformer) {
        this.pokemonTransformer = pokemonTransformer;
    }

    public ShowdownPokemon[] transform(Team team) {
        return team.pokemons().stream()
                .map(this.pokemonTransformer::transform)
                .toArray(ShowdownPokemon[]::new);
    }

    public Team reverseTransform(ShowdownPokemon[] data) {
        return Team.fromPokemons(
                Arrays.stream(data).map(this.pokemonTransformer::reverseTransform).toArray(Pokemon[]::new)
        );
    }
}
