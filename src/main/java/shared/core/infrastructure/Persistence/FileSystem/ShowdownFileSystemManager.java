package shared.core.infrastructure.Persistence.FileSystem;

import shared.core.infrastructure.Transformer.FileSystemShowdownTransformer;

import java.util.List;

public class ShowdownFileSystemManager<T> extends FileSystemManager<T> {

    public final FileSystemShowdownTransformer showdownTransformer;

    public ShowdownFileSystemManager(FileSystemShowdownTransformer showdownTransformer) {
        this.showdownTransformer = showdownTransformer;
    }

    protected T importData(List<String> data) {
        return this.showdownTransformer.toTeam(data.toArray(new String[0]));
    }

    protected String[] exportData(T team) {
        return this.showdownTransformer.fromTeam(team);
    }
}
