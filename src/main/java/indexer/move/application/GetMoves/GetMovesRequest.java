package indexer.move.application.GetMoves;

public class GetMovesRequest {

    private String name;
    private String type;
    private int pokemonId;

    public GetMovesRequest(String name, String type) {
        this.name = name;
        this.type = type;
        this.pokemonId = 0;
    }

    String getName() {
        return name;
    }

    String getType() {
        return type;
    }

    int getPokemonId() {
        return pokemonId;
    }
}
