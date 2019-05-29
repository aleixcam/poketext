package move.domain;

public class MoveCriteria {

    private int pokemon_id;
    private String name;
    private String type;

    public int getPokemonId() {
        return pokemon_id;
    }

    public void setPokemonId(int pokemon_id) {
        this.pokemon_id = pokemon_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
