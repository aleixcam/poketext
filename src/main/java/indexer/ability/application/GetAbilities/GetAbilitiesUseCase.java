package indexer.ability.application.GetAbilities;

import indexer.ability.application.AbilityTransformer;
import indexer.ability.domain.AbilityCriteria;
import indexer.ability.domain.AbilityRepository;
import indexer.ability.domain.AbilitiesCollection;

public class GetAbilitiesUseCase<T> {

    private AbilityRepository repository;
    private AbilityTransformer<T> transformer;

    public GetAbilitiesUseCase(AbilityRepository repository, AbilityTransformer<T> transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    public T execute(String name) {
        AbilityCriteria criteria = new AbilityCriteria();
        criteria.setName(name);

        AbilitiesCollection items = this.repository.findByCriteria(criteria);
        return this.transformer.transform(items);
    }
}
