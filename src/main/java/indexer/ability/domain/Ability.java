package indexer.ability.domain;

import org.apache.commons.lang3.math.NumberUtils;

public class Ability {

    private int id;
    private String name;
    private String effect;

    public Ability(
        int id,
        String name,
        String effect
    ) {
        this.id = id;
        this.name = name;
        this.effect = effect;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getEffect() {
        return effect;
    }

    public static Ability instance(String[] array){
        try {
            return Ability.class.getDeclaredConstructor(
                int.class,
                String.class,
                String.class
            ).newInstance(
                NumberUtils.isParsable(array[0]) ? Integer.parseInt(array[0]) : 0,
                array[1],
                array[2]
            );
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();

            return null;
        }
    }
}
