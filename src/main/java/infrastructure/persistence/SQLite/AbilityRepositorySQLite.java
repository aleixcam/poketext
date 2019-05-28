package infrastructure.persistence.SQLite;

import domain.ability.Ability;
import domain.ability.AbilitiesCollection;
import domain.ability.AbilityCriteria;
import domain.ability.AbilityRepository;
import infrastructure.service.LanguageService;

import java.util.List;
import java.util.Objects;

final public class AbilityRepositorySQLite extends SQLiteRepository implements AbilityRepository {

    public AbilitiesCollection findByCriteria(AbilityCriteria criteria) {
        List<String[]> rowset = executeQuery("select f.ability_id, n.name, f.flavor_text\n"
                + "from ability_flavor_text f, ability_names n\n"
                + "where f.ability_id = n.ability_id\n"
                + "and f.language_id = " + LanguageService.ENGLISH + "\n"
                + "and n.local_language_id = " + LanguageService.ENGLISH + "\n"
                + "and f.version_group_id = 16\n"
                + (!Objects.equals(criteria.getName(), "") ? "and n.name like '%" + criteria.getName() + "%'" : ""));

        return buildAbilities(rowset);
    }

    private AbilitiesCollection buildAbilities(List<String[]> rowset) {
        AbilitiesCollection abilities = new AbilitiesCollection();
        for (String[] row : rowset) {
            Ability ability = new Ability();
            ability.setId(row[0]);
            ability.setName(row[1]);
            ability.setEffect(row[2]);

            abilities.add(ability);
        }

        return abilities;
    }
}
