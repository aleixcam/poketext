package indexer.ability.application.GetAbilities;

import indexer.ability.application.AbilityTransformer;
import indexer.ability.domain.AbilityCriteria;
import indexer.ability.domain.AbilityRepository;
import indexer.ability.domain.AbilitiesCollection;

public class GetAbilitiesUseCase {

    private AbilityRepository repository;
    private AbilityTransformer assembler;

    public GetAbilitiesUseCase(AbilityRepository repository, AbilityTransformer assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public String[][] execute(String name) {
        AbilityCriteria criteria = new AbilityCriteria();
        criteria.setName(name);

        AbilitiesCollection items = this.repository.findByCriteria(criteria);
        return this.assembler.assemble(items);
    }
}
