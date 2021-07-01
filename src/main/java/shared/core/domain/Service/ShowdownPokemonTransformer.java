package shared.core.domain.Service;

import shared.core.domain.ShowdownPokemon;

public interface ShowdownPokemonTransformer<T> {

    ShowdownPokemon transform(T team);
    T reverseTransform(ShowdownPokemon data);
}
