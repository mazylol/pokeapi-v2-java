/* Super contest effects refer to the effects of moves when used in super contests. */

package com.github.oscar0812.pokeapi.models.contests;

import com.github.oscar0812.pokeapi.models.moves.Move;
import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.models.utility.APIResource;
import com.github.oscar0812.pokeapi.models.utility.FlavorText;
import com.github.oscar0812.pokeapi.utils.Information;
import java.util.ArrayList;

public class SuperContestEffect extends APIResource {
	// The identifier for this resource.
	private int id;

	// The level of appeal this super contest effect has.
	private int appeal;

	// The flavor text of this super contest effect listed in different languages.
	private ArrayList<FlavorText> flavor_text_entries;

	// A list of moves that have the effect when used in super contests.
	private ArrayList<Move> moves;

	public int getId() {
		return id;
	}

	public SuperContestEffect setId(int id) {
		this.id = id;
		return this;
	}

	public int getAppeal() {
		return appeal;
	}

	public SuperContestEffect setAppeal(int appeal) {
		this.appeal = appeal;
		return this;
	}

	public ArrayList<FlavorText> getFlavorTextEntries() {
		return flavor_text_entries;
	}

	public SuperContestEffect setFlavorTextEntries(ArrayList<FlavorText> flavor_text_entries) {
		this.flavor_text_entries = flavor_text_entries;
		return this;
	}

	public ArrayList<Move> getMoves() {
		return moves;
	}

	public SuperContestEffect setMoves(ArrayList<Move> moves) {
		this.moves = moves;
		return this;
	}

	private static SuperContestEffect get(String url) {
		SuperContestEffect obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), SuperContestEffect.class);
		obj.setIsFetched(true);
		return obj;
	}

	public SuperContestEffect get() {
		return SuperContestEffect.get(this.getUrl());
	}

	public static SuperContestEffect getById(int id) {
		return get("https://pokeapi.co/api/v2/super-contest-effect/" + id);
	}
}