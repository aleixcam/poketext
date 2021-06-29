package indexer.move.infrastructure.persistence.SQLite;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import indexer.move.domain.Move;
import indexer.move.domain.MoveCriteria;
import indexer.move.domain.MoveRepository;
import indexer.move.domain.MoveCollection;
import shared.core.infrastructure.Persistence.SQLite.SQLiteManager;
import shared.core.infrastructure.Service.LanguageService;

final public class SQLiteMoveRepository implements MoveRepository {

    private final SQLiteManager repository;

    public SQLiteMoveRepository(SQLiteManager repository) {
        this.repository = repository;
    }

    public MoveCollection findByCriteria(MoveCriteria criteria) {
        List<Map<String, Object>> list = repository.executeQuery("select distinct(m.id), n.name, t.name as type, d.identifier, m.power, m.accuracy, m.pp, f.flavor_text\n"
                + "from pokemon_moves p, move_names n, moves m, type_names t, move_flavor_text f, move_damage_classes d\n"
                + "where m.id = p.move_id\n"
                + "and m.id = n.move_id\n"
                + "and t.type_id = m.type_id\n"
                + "and m.id = f.move_id\n"
                + "and m.damage_class_id = d.id\n"
                + "and p.version_group_id = 16\n"
                + "and f.version_group_id = 16\n"
                + "and n.local_language_id = " + LanguageService.ENGLISH + "\n"
                + "and t.local_language_id = " + LanguageService.ENGLISH + "\n"
                + "and f.language_id = " + LanguageService.ENGLISH + "\n"
                + (criteria.getPokemonId() > 0 ? ("and p.pokemon_id = " + criteria.getPokemonId() + "\n") : "")
                + (!Objects.equals(criteria.getName(), "") ? ("and n.name like '%" + criteria.getName() + "%'\n") : "")
                + (!Objects.equals(criteria.getType(), "") ? ("and t.name like '%" + criteria.getType() + "%'\n") : "")
                + "order by m.id");

        return buildMoves(list);
    }

    private MoveCollection buildMoves(List<Map<String, Object>> list) {
        MoveCollection moves = new MoveCollection();
        for (Map<String, Object> row : list) {
            moves.add(Move.instance(row));
        }

        return moves;
    }
}
