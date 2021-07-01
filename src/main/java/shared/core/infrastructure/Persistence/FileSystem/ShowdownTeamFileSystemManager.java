package shared.core.infrastructure.Persistence.FileSystem;

import shared.core.domain.Service.ShowdownTeamTransformer;

import java.util.List;

public class ShowdownTeamFileSystemManager<T> extends FileSystemManager<T> {

    private final ShowdownTeamTransformer<T> transformer;

    public ShowdownTeamFileSystemManager(ShowdownTeamTransformer<T> transformer) {
        this.transformer = transformer;
    }

    protected T importData(List<String> data) {
        return this.transformer.reverseTransform(null);
    }

    protected String[] exportData(T team) {
        return null;
    }
}
