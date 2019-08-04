package indexer.nature.application.GetNatures;

import indexer.nature.application.NatureTransformer;
import indexer.nature.domain.NatureRepository;
import indexer.nature.domain.NaturesCollection;

public class GetNaturesUseCase {

    private NatureRepository repository;
    private NatureTransformer assembler;

    public GetNaturesUseCase(NatureRepository repository, NatureTransformer assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public String[][] execute() {
        NaturesCollection natures = this.repository.findAll();
        return this.assembler.assemble(natures);
    }
}
