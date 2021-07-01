package teambuilder.pokemon.domain.Service;

import teambuilder.pokemon.domain.Pokemon;

public interface PokemonTransformer<T> {

    T transform(Pokemon pokemon);
    Pokemon reverseTransform(T data);
}
