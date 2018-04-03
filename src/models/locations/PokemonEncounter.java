package models.locations;
public class PokemonEncounter {
	// The Pokémon being encountered
	private models.pokemon.Pokemon pokemon;

	// A list of versions and encounters with Pokémon that might happen in the referenced location area
	private java.util.ArrayList<models.common.VersionEncounterDetail> version_details;

	public models.pokemon.Pokemon getPokemon() {
		return pokemon;
	}

	public PokemonEncounter setPokemon(models.pokemon.Pokemon pokemon) {
		this.pokemon = pokemon;
		return this;
	}

	public java.util.ArrayList<models.common.VersionEncounterDetail> getVersionDetails() {
		return version_details;
	}

	public PokemonEncounter setVersionDetails(java.util.ArrayList<models.common.VersionEncounterDetail> version_details) {
		this.version_details = version_details;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}