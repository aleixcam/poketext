package indexer.ability.infrastructure.persistence.SQLite;

import indexer.ability.domain.Ability;
import indexer.ability.domain.AbilityCollection;
import indexer.ability.domain.AbilityCriteria;
import indexer.ability.domain.AbilityRepository;
import shared.domain.Service.SQLiteRepository;
import shared.infrastructure.Service.LanguageService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

final public class AbilityRepositoryImpl implements AbilityRepository {

    private final SQLiteRepository repository;

    public AbilityRepositoryImpl(SQLiteRepository repository) {
        this.repository = repository;
    }

    public AbilityCollection findByCriteria(AbilityCriteria criteria) {
        List<Map<String, Object>> list = repository.executeQuery("select f.ability_id, n.name, f.flavor_text\n"
                + "from ability_flavor_text f, ability_names n\n"
                + "where f.ability_id = n.ability_id\n"
                + "and f.language_id = " + LanguageService.ENGLISH + "\n"
                + "and n.local_language_id = " + LanguageService.ENGLISH + "\n"
                + "and f.version_group_id = 16\n"
                + (!Objects.equals(criteria.getName(), "") ? "and n.name like '%" + criteria.getName() + "%'" : ""));

        return buildAbilities(list);
    }

    private AbilityCollection buildAbilities(List<Map<String, Object>> list) {
        AbilityCollection abilities = new AbilityCollection();
        for (Map<String, Object> row : list) {
            abilities.add(Ability.instance(row));
        }

        return abilities;
    }
}
