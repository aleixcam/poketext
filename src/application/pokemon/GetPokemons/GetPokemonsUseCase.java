package application.pokemon.GetPokemons;

import application.pokemon.PokemonAssembler;
import domain.pokemon.*;

public class GetPokemonsUseCase {

    private PokemonRepository repository;
    private PokemonAssembler assembler;

    public GetPokemonsUseCase(PokemonRepository repository, PokemonAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public String[][] execute(int pokedex_id, String name, String type) {
        PokemonCriteria criteria = new PokemonCriteria();
        criteria.setPokedexId(pokedex_id);
        criteria.setName(name);
        criteria.setType(type);

        PokemonsCollection pokemons = this.repository.findByCriteria(criteria);
        return this.assembler.assemble(pokemons);
    }
}
