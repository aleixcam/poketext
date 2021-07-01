package shared.core.infrastructure.Persistence.FileSystem;

import shared.core.domain.Service.ShowdownPokemonTransformer;

import java.util.List;

public class ShowdownPokemonFileSystemManager<T> extends FileSystemManager<T> {

    private final ShowdownPokemonTransformer<T> transformer;

    public ShowdownPokemonFileSystemManager(ShowdownPokemonTransformer<T> transformer) {
        this.transformer = transformer;
    }

    protected T importData(List<String> data) {
        return this.transformer.reverseTransform(null);
    }

    protected String[] exportData(T team) {
        return null;
    }
}
