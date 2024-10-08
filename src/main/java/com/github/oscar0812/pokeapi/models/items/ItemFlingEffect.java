/* The various effects of the move "Fling" when used with different items. */

package com.github.oscar0812.pokeapi.models.items;

import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.models.utility.Effect;
import com.github.oscar0812.pokeapi.models.utility.NamedAPIResource;
import com.github.oscar0812.pokeapi.utils.Information;
import java.util.ArrayList;

public class ItemFlingEffect extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// The result of this fling effect listed in different languages.
	private ArrayList<Effect> effect_entries;

	// A list of items that have this fling effect.
	private ArrayList<Item> items;

	public int getId() {
		return id;
	}

	public ItemFlingEffect setId(int id) {
		this.id = id;
		return this;
	}

	public ArrayList<Effect> getEffectEntries() {
		return effect_entries;
	}

	public ItemFlingEffect setEffectEntries(ArrayList<Effect> effect_entries) {
		this.effect_entries = effect_entries;
		return this;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public ItemFlingEffect setItems(ArrayList<Item> items) {
		this.items = items;
		return this;
	}

	private static ItemFlingEffect get(String url) {
		ItemFlingEffect obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), ItemFlingEffect.class);
		obj.setIsFetched(true);
		return obj;
	}

	public ItemFlingEffect get() {
		return ItemFlingEffect.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		 return NamedAPIResourceList.getList("item-fling-effect", limit, offset);
	}

	public static ItemFlingEffect getById(int id) {
		return get("https://pokeapi.co/api/v2/item-fling-effect/" + id);
	}

	public static ItemFlingEffect getByName(String name) {
		return get("https://pokeapi.co/api/v2/item-fling-effect/" + name);
	}
}