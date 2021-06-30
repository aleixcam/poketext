package showdown.pokemon.infrastructure.Service;

import shared.move.domain.Move;
import showdown.pokemon.domain.Pokemon;
import shared.type.domain.Type;
import shared.type.infrastructure.injector.TypeInfrastructureInjector;
import shared.type.infrastructure.persistence.SQLite.SQLiteTypeRepository;

public class EffectivenessService {

    public double calculate(Pokemon pokemon, Move move) {
        return damageFactor(pokemon.getPrimaryType(), move.type())
                * (pokemon.getSecondaryType() == null ? 100 : damageFactor(pokemon.getSecondaryType(), move.type()))
                * 0.0001;
    }

    private int damageFactor(Type target, Type damage) {
        return typeRepository().getDamageFactor(target, damage);
    }

    private SQLiteTypeRepository typeRepository() {
        return TypeInfrastructureInjector.injectTypeRepository();
    }
}
