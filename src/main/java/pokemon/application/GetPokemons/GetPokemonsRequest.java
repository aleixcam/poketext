package pokemon.application.GetPokemons;

public class GetPokemonsRequest {

    private int pokedexId;
    private String name;
    private String type;

    public GetPokemonsRequest(String pokedexId, String name, String type) {
        this.pokedexId = Integer.parseInt(pokedexId);
        this.name = name;
        this.type = type;
    }

    int getPokedexId() {
        return pokedexId;
    }

    String getName() {
        return name;
    }

    String getType() {
        return type;
    }
}
