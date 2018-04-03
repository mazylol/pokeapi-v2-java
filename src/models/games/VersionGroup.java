package models.games;
/*
{
    "id": 1,
    "name": "red-blue",
    "order": 1,
    "generation": {
        "name": "generation-i",
        "url": "http://pokeapi.co/api/v2/generation/1/"
    },
    "move_learn_methods": [{
        "name": "level-up",
        "url": "http://pokeapi.co/api/v2/move-learn-method/1/"
    }],
    "pokedexes": [{
        "name": "kanto",
        "url": "http://pokeapi.co/api/v2/pokedex/2/"
    }],
    "regions": [{
        "name": "kanto",
        "url": "http://pokeapi.co/api/v2/region/1/"
    }],
    "versions": [{
        "name": "red",
        "url": "http://pokeapi.co/api/v2/version/1/"
    }]
}
*/

public class VersionGroup extends models.common.NamedAPIResource {
	// The identifier for this version group resource
	private int id;

	// Order for sorting. Almost by date of release, except similar versions are grouped together.
	private int order;

	// The generation this version was introduced in
	private models.games.Generation generation;

	// A list of methods in which Pokémon can learn moves in this version group
	private java.util.ArrayList<models.moves.MoveLearnMethod> move_learn_methods;

	// A list of Pokédexes introduces in this version group
	private java.util.ArrayList<models.games.Pokedex> pokedexes;

	// A list of regions that can be visited in this version group
	private java.util.ArrayList<models.locations.Region> regions;

	// The versions this version group owns
	private java.util.ArrayList<models.games.Version> versions;

	private static VersionGroup get(String url) {
		String json = api.Information.fromInternet(url);
		VersionGroup obj = new com.google.gson.Gson().fromJson(json, VersionGroup.class);
		return obj;
	}

	public static models.resource.NamedAPIResourceList getList(int limit, int offset){
		String json = api.Information.fromInternet("https://pokeapi.co/api/v2/berry/?limit="+Math.abs(limit)+"&offset="+ Math.abs(offset));
		return (new com.google.gson.Gson()).fromJson(json, models.resource.NamedAPIResourceList.class);
	}

	public static VersionGroup getById(int id) {
		return get("https://pokeapi.co/api/v2/version-group/" + id);
	}

	public static VersionGroup getByName(String name) {
		return get("https://pokeapi.co/api/v2/version-group/" + name);
	}

	public int getId() {
		return id;
	}

	public VersionGroup setId(int id) {
		this.id = id;
		return this;
	}

	public int getOrder() {
		return order;
	}

	public VersionGroup setOrder(int order) {
		this.order = order;
		return this;
	}

	public models.games.Generation getGeneration() {
		return generation;
	}

	public VersionGroup setGeneration(models.games.Generation generation) {
		this.generation = generation;
		return this;
	}

	public java.util.ArrayList<models.moves.MoveLearnMethod> getMoveLearnMethods() {
		return move_learn_methods;
	}

	public VersionGroup setMoveLearnMethods(java.util.ArrayList<models.moves.MoveLearnMethod> move_learn_methods) {
		this.move_learn_methods = move_learn_methods;
		return this;
	}

	public java.util.ArrayList<models.games.Pokedex> getPokedexes() {
		return pokedexes;
	}

	public VersionGroup setPokedexes(java.util.ArrayList<models.games.Pokedex> pokedexes) {
		this.pokedexes = pokedexes;
		return this;
	}

	public java.util.ArrayList<models.locations.Region> getRegions() {
		return regions;
	}

	public VersionGroup setRegions(java.util.ArrayList<models.locations.Region> regions) {
		this.regions = regions;
		return this;
	}

	public java.util.ArrayList<models.games.Version> getVersions() {
		return versions;
	}

	public VersionGroup setVersions(java.util.ArrayList<models.games.Version> versions) {
		this.versions = versions;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}