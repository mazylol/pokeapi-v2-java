/* Types are properties for Pokémon and their moves. Each type has three properties: which types of Pokémon it is super effective against, which types of Pokémon it is not very effective against, and which types of Pokémon it is completely ineffective against. */

package com.github.oscar0812.pokeapi.models.pokemon;

import com.github.oscar0812.pokeapi.models.games.Generation;
import com.github.oscar0812.pokeapi.models.moves.Move;
import com.github.oscar0812.pokeapi.models.moves.MoveDamageClass;
import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.models.utility.GenerationGameIndex;
import com.github.oscar0812.pokeapi.models.utility.Name;
import com.github.oscar0812.pokeapi.models.utility.NamedAPIResource;
import com.github.oscar0812.pokeapi.utils.Information;
import java.util.ArrayList;

public class Type extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// A detail of how effective this type is toward others and vice versa.
	private TypeRelations damage_relations;

	// A list of game indices relevent to this item by generation.
	private ArrayList<GenerationGameIndex> game_indices;

	// The generation this type was introduced in.
	private Generation generation;

	// The class of damage inflicted by this type.
	private MoveDamageClass move_damage_class;

	// The name of this resource listed in different languages.
	private ArrayList<Name> names;

	// A list of details of Pokémon that have this type.
	private ArrayList<TypePokemon> pokemon;

	// A list of moves that have this type.
	private ArrayList<Move> moves;

	public int getId() {
		return id;
	}

	public Type setId(int id) {
		this.id = id;
		return this;
	}

	public TypeRelations getDamageRelations() {
		return damage_relations;
	}

	public Type setDamageRelations(TypeRelations damage_relations) {
		this.damage_relations = damage_relations;
		return this;
	}

	public ArrayList<GenerationGameIndex> getGameIndices() {
		return game_indices;
	}

	public Type setGameIndices(ArrayList<GenerationGameIndex> game_indices) {
		this.game_indices = game_indices;
		return this;
	}

	public Generation getGeneration() {
		if(!generation.getIsFetched()) {
			generation = generation.get();
		}
		return generation;
	}

	public Type setGeneration(Generation generation) {
		this.generation = generation;
		return this;
	}

	public MoveDamageClass getMoveDamageClass() {
		if(!move_damage_class.getIsFetched()) {
			move_damage_class = move_damage_class.get();
		}
		return move_damage_class;
	}

	public Type setMoveDamageClass(MoveDamageClass move_damage_class) {
		this.move_damage_class = move_damage_class;
		return this;
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public Type setNames(ArrayList<Name> names) {
		this.names = names;
		return this;
	}

	public ArrayList<TypePokemon> getPokemon() {
		return pokemon;
	}

	public Type setPokemon(ArrayList<TypePokemon> pokemon) {
		this.pokemon = pokemon;
		return this;
	}

	public ArrayList<Move> getMoves() {
		return moves;
	}

	public Type setMoves(ArrayList<Move> moves) {
		this.moves = moves;
		return this;
	}

	private static Type get(String url) {
		Type obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), Type.class);
		obj.setIsFetched(true);
		return obj;
	}

	public Type get() {
		return Type.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		 return NamedAPIResourceList.getList("type", limit, offset);
	}

	public static Type getById(int id) {
		return get("https://pokeapi.co/api/v2/type/" + id);
	}

	public static Type getByName(String name) {
		return get("https://pokeapi.co/api/v2/type/" + name);
	}
}