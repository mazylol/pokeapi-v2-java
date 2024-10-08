/* Languages for translations of API resource information. */

package com.github.oscar0812.pokeapi.models.utility;

import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.models.utility.NamedAPIResource;
import com.github.oscar0812.pokeapi.utils.Information;
import java.util.ArrayList;

public class Language extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// Whether or not the games are published in this language.
	private boolean official;

	// The two-letter code of the country where this language is spoken. Note that it is not unique.
	private String iso639;

	// The two-letter code of the language. Note that it is not unique.
	private String iso3166;

	// The name of this resource listed in different languages.
	private ArrayList<Name> names;

	public int getId() {
		return id;
	}

	public Language setId(int id) {
		this.id = id;
		return this;
	}

	public boolean getOfficial() {
		return official;
	}

	public Language setOfficial(boolean official) {
		this.official = official;
		return this;
	}

	public String getIso639() {
		return iso639;
	}

	public Language setIso639(String iso639) {
		this.iso639 = iso639;
		return this;
	}

	public String getIso3166() {
		return iso3166;
	}

	public Language setIso3166(String iso3166) {
		this.iso3166 = iso3166;
		return this;
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public Language setNames(ArrayList<Name> names) {
		this.names = names;
		return this;
	}

	private static Language get(String url) {
		Language obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), Language.class);
		obj.setIsFetched(true);
		return obj;
	}

	public Language get() {
		return Language.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		 return NamedAPIResourceList.getList("language", limit, offset);
	}

	public static Language getById(int id) {
		return get("https://pokeapi.co/api/v2/language/" + id);
	}

	public static Language getByName(String name) {
		return get("https://pokeapi.co/api/v2/language/" + name);
	}
}