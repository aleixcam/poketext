package application.nature.GetNatures;

import application.nature.NatureAssembler;
import domain.nature.NatureRepository;
import domain.nature.NaturesCollection;

public class GetNaturesService {

    private NatureRepository repository;
    private NatureAssembler assembler;

    public GetNaturesService(NatureRepository repository, NatureAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public String[][] execute() {
        NaturesCollection natures = this.repository.findAll();
        return this.assembler.assemble(natures);
    }
}
