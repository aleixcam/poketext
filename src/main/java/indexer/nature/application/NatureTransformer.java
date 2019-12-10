package indexer.nature.application;

import indexer.nature.domain.NatureCollection;

public interface NatureTransformer<T> {

    T transform(NatureCollection collection);
}
