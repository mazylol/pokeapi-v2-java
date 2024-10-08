/* Contest types are categories judges used to weigh a Pokémon's condition in Pokémon contests. Check out Bulbapedia for greater detail. */

package com.github.oscar0812.pokeapi.models.contests;

import com.github.oscar0812.pokeapi.models.berries.BerryFlavor;
import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.models.utility.NamedAPIResource;
import com.github.oscar0812.pokeapi.utils.Information;
import java.util.ArrayList;

public class ContestType extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// The berry flavor that correlates with this contest type.
	private BerryFlavor berry_flavor;

	// The name of this contest type listed in different languages.
	private ArrayList<ContestName> names;

	public int getId() {
		return id;
	}

	public ContestType setId(int id) {
		this.id = id;
		return this;
	}

	public BerryFlavor getBerryFlavor() {
		if(!berry_flavor.getIsFetched()) {
			berry_flavor = berry_flavor.get();
		}
		return berry_flavor;
	}

	public ContestType setBerryFlavor(BerryFlavor berry_flavor) {
		this.berry_flavor = berry_flavor;
		return this;
	}

	public ArrayList<ContestName> getNames() {
		return names;
	}

	public ContestType setNames(ArrayList<ContestName> names) {
		this.names = names;
		return this;
	}

	private static ContestType get(String url) {
		ContestType obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), ContestType.class);
		obj.setIsFetched(true);
		return obj;
	}

	public ContestType get() {
		return ContestType.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		 return NamedAPIResourceList.getList("contest-type", limit, offset);
	}

	public static ContestType getById(int id) {
		return get("https://pokeapi.co/api/v2/contest-type/" + id);
	}

	public static ContestType getByName(String name) {
		return get("https://pokeapi.co/api/v2/contest-type/" + name);
	}
}