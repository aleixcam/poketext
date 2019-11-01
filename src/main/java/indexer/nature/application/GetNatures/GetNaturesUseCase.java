package indexer.nature.application.GetNatures;

import indexer.nature.application.NatureTransformer;
import indexer.nature.domain.NatureRepository;
import indexer.nature.domain.NaturesCollection;

public class GetNaturesUseCase<T> {

    private NatureRepository repository;
    private NatureTransformer<T> transformer;

    public GetNaturesUseCase(NatureRepository repository, NatureTransformer<T> transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    public T execute() {
        NaturesCollection natures = this.repository.findAll();
        return this.transformer.transform(natures);
    }
}
