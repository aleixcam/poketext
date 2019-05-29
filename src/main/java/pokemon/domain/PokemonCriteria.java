package pokemon.domain;

public class PokemonCriteria {

    private int pokedex_id;
    private String name;
    private String type;
    private String id_field;

    public int getPokedexId() {
        return pokedex_id;
    }

    public void setPokedexId(int pokedex_id) {
        this.pokedex_id = pokedex_id;
        this.id_field = pokedex_id == 1 ? "p.id" : "d.pokedex_number";
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

    public String getIdField() {
        return id_field;
    }
}
