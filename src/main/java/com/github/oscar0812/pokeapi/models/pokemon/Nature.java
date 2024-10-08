/* Natures influence how a Pokémon's stats grow. See Bulbapedia for greater detail. */

package com.github.oscar0812.pokeapi.models.pokemon;

import com.github.oscar0812.pokeapi.models.berries.BerryFlavor;
import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.models.utility.Name;
import com.github.oscar0812.pokeapi.models.utility.NamedAPIResource;
import com.github.oscar0812.pokeapi.utils.Information;
import java.util.ArrayList;

public class Nature extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// The stat decreased by 10% in Pokémon with this nature.
	private Stat decreased_stat;

	// The stat increased by 10% in Pokémon with this nature.
	private Stat increased_stat;

	// The flavor hated by Pokémon with this nature.
	private BerryFlavor hates_flavor;

	// The flavor liked by Pokémon with this nature.
	private BerryFlavor likes_flavor;

	// A list of Pokéathlon stats this nature effects and how much it effects them.
	private ArrayList<NatureStatChange> pokeathlon_stat_changes;

	// A list of battle styles and how likely a Pokémon with this nature is to use them in the Battle Palace or Battle Tent.
	private ArrayList<MoveBattleStylePreference> move_battle_style_preferences;

	// The name of this resource listed in different languages.
	private ArrayList<Name> names;

	public int getId() {
		return id;
	}

	public Nature setId(int id) {
		this.id = id;
		return this;
	}

	public Stat getDecreasedStat() {
		if(!decreased_stat.getIsFetched()) {
			decreased_stat = decreased_stat.get();
		}
		return decreased_stat;
	}

	public Nature setDecreasedStat(Stat decreased_stat) {
		this.decreased_stat = decreased_stat;
		return this;
	}

	public Stat getIncreasedStat() {
		if(!increased_stat.getIsFetched()) {
			increased_stat = increased_stat.get();
		}
		return increased_stat;
	}

	public Nature setIncreasedStat(Stat increased_stat) {
		this.increased_stat = increased_stat;
		return this;
	}

	public BerryFlavor getHatesFlavor() {
		if(!hates_flavor.getIsFetched()) {
			hates_flavor = hates_flavor.get();
		}
		return hates_flavor;
	}

	public Nature setHatesFlavor(BerryFlavor hates_flavor) {
		this.hates_flavor = hates_flavor;
		return this;
	}

	public BerryFlavor getLikesFlavor() {
		if(!likes_flavor.getIsFetched()) {
			likes_flavor = likes_flavor.get();
		}
		return likes_flavor;
	}

	public Nature setLikesFlavor(BerryFlavor likes_flavor) {
		this.likes_flavor = likes_flavor;
		return this;
	}

	public ArrayList<NatureStatChange> getPokeathlonStatChanges() {
		return pokeathlon_stat_changes;
	}

	public Nature setPokeathlonStatChanges(ArrayList<NatureStatChange> pokeathlon_stat_changes) {
		this.pokeathlon_stat_changes = pokeathlon_stat_changes;
		return this;
	}

	public ArrayList<MoveBattleStylePreference> getMoveBattleStylePreferences() {
		return move_battle_style_preferences;
	}

	public Nature setMoveBattleStylePreferences(ArrayList<MoveBattleStylePreference> move_battle_style_preferences) {
		this.move_battle_style_preferences = move_battle_style_preferences;
		return this;
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public Nature setNames(ArrayList<Name> names) {
		this.names = names;
		return this;
	}

	private static Nature get(String url) {
		Nature obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), Nature.class);
		obj.setIsFetched(true);
		return obj;
	}

	public Nature get() {
		return Nature.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		 return NamedAPIResourceList.getList("nature", limit, offset);
	}

	public static Nature getById(int id) {
		return get("https://pokeapi.co/api/v2/nature/" + id);
	}

	public static Nature getByName(String name) {
		return get("https://pokeapi.co/api/v2/nature/" + name);
	}
}