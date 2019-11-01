package indexer.nature.application;

import indexer.nature.domain.NaturesCollection;

public interface NatureTransformer<T> {

    T transform(NaturesCollection collection);
}
