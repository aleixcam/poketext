package ability.infrastructure.persistence.SQLite;

import ability.domain.Ability;
import ability.domain.AbilitiesCollection;
import ability.domain.AbilityCriteria;
import ability.domain.AbilityRepository;
import common.domain.SQLiteRepository;
import common.infrastructure.service.LanguageService;

import java.util.List;
import java.util.Objects;

final public class AbilityRepositoryImpl implements AbilityRepository {

    private final SQLiteRepository repository;

    public AbilityRepositoryImpl(SQLiteRepository repository) {
        this.repository = repository;
    }

    public AbilitiesCollection findByCriteria(AbilityCriteria criteria) {
        List<String[]> list = repository.executeQuery("select f.ability_id, n.name, f.flavor_text\n"
                + "from ability_flavor_text f, ability_names n\n"
                + "where f.ability_id = n.ability_id\n"
                + "and f.language_id = " + LanguageService.ENGLISH + "\n"
                + "and n.local_language_id = " + LanguageService.ENGLISH + "\n"
                + "and f.version_group_id = 16\n"
                + (!Objects.equals(criteria.getName(), "") ? "and n.name like '%" + criteria.getName() + "%'" : ""));

        return buildAbilities(list);
    }

    private AbilitiesCollection buildAbilities(List<String[]> list) {
        AbilitiesCollection abilities = new AbilitiesCollection();
        for (String[] row : list) {
            Ability ability = new Ability();
            ability.setId(row[0]);
            ability.setName(row[1]);
            ability.setEffect(row[2]);

            abilities.add(ability);
        }

        return abilities;
    }
}
