package shared.core.domain.Service;

import shared.core.domain.ShowdownPokemon;

public interface ShowdownTeamTransformer<T> {

    ShowdownPokemon[] transform(T team);
    T reverseTransform(ShowdownPokemon[] data);
}
