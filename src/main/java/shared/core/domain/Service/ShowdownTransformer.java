package shared.core.domain.Service;

public interface ShowdownTransformer<T, S> {

    S transform(T team);
    T reverseTransform(S data);
}
