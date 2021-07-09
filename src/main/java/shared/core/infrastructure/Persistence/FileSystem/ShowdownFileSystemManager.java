package shared.core.infrastructure.Persistence.FileSystem;

import org.apache.commons.lang3.ArrayUtils;
import shared.core.domain.ShowdownPokemon;
import shared.pokemon.domain.Stat;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

final public class ShowdownFileSystemManager extends FileSystemManager<ShowdownPokemon> {

    public ShowdownPokemon importOne(String ref) {
        return null;
    }

    public ShowdownPokemon[] importMany(String ref) {
        return null;
    }

    public void exportOne(String ref, ShowdownPokemon pokemon) {
        this.write(ref, this.toShowdown(pokemon));
    }

    public void exportMany(String ref, ShowdownPokemon[] team) {
        String[] data = new String[0];

        for (ShowdownPokemon pokemon : team) {
            ArrayUtils.addAll(data, this.toShowdown(pokemon), new String[1]);
        }

        this.write(ref, data);
    }

    private String[] toShowdown(ShowdownPokemon pokemon) {
        ArrayList<String> export = new ArrayList<>();

        export.add(
            pokemon.hasNickname()
                ? String.format("%s (%s)", pokemon.getNickname(), pokemon.getName())
                : String.format("%s", pokemon.getName())
                + (pokemon.hasGender() ? String.format("(%s)", pokemon.getGender()) : "")
                + (pokemon.hasItem() ? String.format(" @ %s", pokemon.getItem()) : "")
        );

        export.add(String.format("Ability: %s", pokemon.getAbility()));

        if (pokemon.getLevel() != 100) {
            export.add(String.format("Level: %d", pokemon.getLevel()));
        }

        if (pokemon.isShiny()) {
            export.add("Shiny: Yes");
        }

        if (pokemon.getEffortValues().size() > 0) {
            export.add(String.format("EVs: %s", this.exportStats(pokemon.getEffortValues())));
        }

        export.add(String.format("%s Nature", pokemon.getNature()));

        if (pokemon.getIndividualValues().size() > 0) {
            export.add(String.format("IVs: %s", this.exportStats(pokemon.getIndividualValues())));
        }

        return export.toArray(new String[0]);
    }

    private String exportStats(Map<Stat, Integer> stats) {
        return String.join(
            " / ",
            stats.entrySet().stream()
                .map(iv -> String.format("%d %s", iv.getValue(), transformStatName(iv)))
                .collect(Collectors.joining())
        );
    }

    private String transformStatName(Map.Entry<Stat, Integer> stat) {
        switch (stat.getKey()) {
            case HP:
                return "HP";
            case ATK:
                return "Atk";
            case DEF:
                return "Def";
            case SPA:
                return "SpA";
            case SPD:
                return "SpD";
            case SPE:
                return "Spe";
            default:
                throw new IllegalStateException("Unexpected value: " + stat.getKey());
        }
    }
}
