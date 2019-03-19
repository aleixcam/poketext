package application.ability.GetAbilities;

import application.ability.AbilityAssembler;
import domain.ability.AbilityCriteria;
import domain.ability.AbilityRepository;
import domain.ability.AbilitiesCollection;

public class GetAbilitiesService {

    private AbilityRepository repository;
    private AbilityAssembler assembler;

    public GetAbilitiesService(AbilityRepository repository, AbilityAssembler assembler) {
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
