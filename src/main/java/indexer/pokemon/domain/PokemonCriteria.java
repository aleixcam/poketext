package indexer.pokemon.domain;

public class PokemonCriteria {

    private int pokedexId;
    private String name;
    private String type;
    private String idField;

    public int getPokedexId() {
        return pokedexId;
    }

    public void setPokedexId(int pokedexId) {
        this.pokedexId = pokedexId;
        this.idField = pokedexId == 1 ? "p.id" : "d.pokedex_number";
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
        return idField;
    }
}
