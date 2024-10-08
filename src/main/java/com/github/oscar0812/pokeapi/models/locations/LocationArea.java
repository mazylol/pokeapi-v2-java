/* Location areas are sections of areas, such as floors in a building or cave. Each area has its own set of possible Pokémon encounters. */

package com.github.oscar0812.pokeapi.models.locations;

import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.models.utility.Name;
import com.github.oscar0812.pokeapi.models.utility.NamedAPIResource;
import com.github.oscar0812.pokeapi.utils.Information;
import java.util.ArrayList;

public class LocationArea extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// The internal id of an API resource within game data.
	private int game_index;

	// A list of methods in which Pokémon may be encountered in this area and how likely the method will occur depending on the version of the game.
	private ArrayList<EncounterMethodRate> encounter_method_rates;

	// The region this location area can be found in.
	private Location location;

	// The name of this resource listed in different languages.
	private ArrayList<Name> names;

	// A list of Pokémon that can be encountered in this area along with version specific details about the encounter.
	private ArrayList<PokemonEncounter> pokemon_encounters;

	public int getId() {
		return id;
	}

	public LocationArea setId(int id) {
		this.id = id;
		return this;
	}

	public int getGameIndex() {
		return game_index;
	}

	public LocationArea setGameIndex(int game_index) {
		this.game_index = game_index;
		return this;
	}

	public ArrayList<EncounterMethodRate> getEncounterMethodRates() {
		return encounter_method_rates;
	}

	public LocationArea setEncounterMethodRates(ArrayList<EncounterMethodRate> encounter_method_rates) {
		this.encounter_method_rates = encounter_method_rates;
		return this;
	}

	public Location getLocation() {
		if(!location.getIsFetched()) {
			location = location.get();
		}
		return location;
	}

	public LocationArea setLocation(Location location) {
		this.location = location;
		return this;
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public LocationArea setNames(ArrayList<Name> names) {
		this.names = names;
		return this;
	}

	public ArrayList<PokemonEncounter> getPokemonEncounters() {
		return pokemon_encounters;
	}

	public LocationArea setPokemonEncounters(ArrayList<PokemonEncounter> pokemon_encounters) {
		this.pokemon_encounters = pokemon_encounters;
		return this;
	}

	private static LocationArea get(String url) {
		LocationArea obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), LocationArea.class);
		obj.setIsFetched(true);
		return obj;
	}

	public LocationArea get() {
		return LocationArea.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		 return NamedAPIResourceList.getList("location-area", limit, offset);
	}

	public static LocationArea getById(int id) {
		return get("https://pokeapi.co/api/v2/location-area/" + id);
	}

	public static LocationArea getByName(String name) {
		return get("https://pokeapi.co/api/v2/location-area/" + name);
	}
}