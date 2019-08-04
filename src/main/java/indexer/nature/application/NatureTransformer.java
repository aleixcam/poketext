package indexer.nature.application;

import indexer.nature.domain.NaturesCollection;

public interface NatureTransformer {

    String[][] assemble(NaturesCollection collection);
}
