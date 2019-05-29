package nature.application;

import nature.domain.NaturesCollection;

public interface NatureTransformer {

    String[][] assemble(NaturesCollection collection);
}
