package ability.application.GetAbilities;

import ability.application.AbilityTransformer;
import ability.domain.AbilityCriteria;
import ability.domain.AbilityRepository;
import ability.domain.AbilitiesCollection;

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
