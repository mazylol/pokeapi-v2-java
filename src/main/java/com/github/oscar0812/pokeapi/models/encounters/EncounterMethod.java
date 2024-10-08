/* Methods by which the player might can encounter Pokémon in the wild, e.g., walking in tall grass. Check out Bulbapedia for greater detail. */

package com.github.oscar0812.pokeapi.models.encounters;

import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.models.utility.Name;
import com.github.oscar0812.pokeapi.models.utility.NamedAPIResource;
import com.github.oscar0812.pokeapi.utils.Information;
import java.util.ArrayList;

public class EncounterMethod extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// A good value for sorting.
	private int order;

	// The name of this resource listed in different languages.
	private ArrayList<Name> names;

	public int getId() {
		return id;
	}

	public EncounterMethod setId(int id) {
		this.id = id;
		return this;
	}

	public int getOrder() {
		return order;
	}

	public EncounterMethod setOrder(int order) {
		this.order = order;
		return this;
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public EncounterMethod setNames(ArrayList<Name> names) {
		this.names = names;
		return this;
	}

	private static EncounterMethod get(String url) {
		EncounterMethod obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), EncounterMethod.class);
		obj.setIsFetched(true);
		return obj;
	}

	public EncounterMethod get() {
		return EncounterMethod.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		 return NamedAPIResourceList.getList("encounter-method", limit, offset);
	}

	public static EncounterMethod getById(int id) {
		return get("https://pokeapi.co/api/v2/encounter-method/" + id);
	}

	public static EncounterMethod getByName(String name) {
		return get("https://pokeapi.co/api/v2/encounter-method/" + name);
	}
}