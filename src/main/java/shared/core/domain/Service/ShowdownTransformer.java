package shared.core.domain.Service;

public interface ShowdownTransformer<T> {

    <R> R toTeam(T data);
    <R> R toPokemon(T data);
    <S> T fromTeam(S team);
    <S> T fromPokemon(S pokemon);
}
