package shared.core.infrastructure.Transformer;

import shared.core.domain.Service.ShowdownTransformer;

public class FileSystemShowdownTransformer implements ShowdownTransformer<String[]> {

    @Override
    public <R> R toTeam(String[] data) {
        return null;
    }

    @Override
    public <R> R toPokemon(String[] data) {
        return null;
    }

    @Override
    public <T> String[] fromTeam(T team) {
        return new String[0];
    }

    @Override
    public <T> String[] fromPokemon(T pokemon) {
        return new String[0];
    }
}
