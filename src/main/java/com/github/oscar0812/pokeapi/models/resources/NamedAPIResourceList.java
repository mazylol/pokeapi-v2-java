package com.github.oscar0812.pokeapi.models.resources;

import com.github.oscar0812.pokeapi.models.utility.NamedAPIResource;
import com.github.oscar0812.pokeapi.utils.Information;
import java.util.ArrayList;

public class NamedAPIResourceList {
	// The total number of resources available from this API.
	private int count;

	// The URL for the next page in the list.
	private String next;

	// The URL for the previous page in the list.
	private boolean previous;

	// A list of named API resources.
	private ArrayList<NamedAPIResource> results;

	public int getCount() {
		return count;
	}

	public NamedAPIResourceList setCount(int count) {
		this.count = count;
		return this;
	}

	public String getNext() {
		return next;
	}

	public NamedAPIResourceList setNext(String next) {
		this.next = next;
		return this;
	}

	public boolean getPrevious() {
		return previous;
	}

	public NamedAPIResourceList setPrevious(boolean previous) {
		this.previous = previous;
		return this;
	}

	public ArrayList<NamedAPIResource> getResults() {
		return results;
	}

	public NamedAPIResourceList setResults(ArrayList<NamedAPIResource> results) {
		this.results = results;
		return this;
	}

	private static NamedAPIResourceList get(String url) {
		return new com.google.gson.Gson().fromJson(Information.fromInternet(url), NamedAPIResourceList.class);
	}

	public static NamedAPIResourceList getList(String endpoint, int limit, int offset) {
		String json = Information.fromInternet("https://pokeapi.co/api/v2/" + endpoint + "/?limit=" + Math.abs(limit) + "&offset=" + Math.abs(offset));
		return (new com.google.gson.Gson()).fromJson(json, NamedAPIResourceList.class);
	}

	public static NamedAPIResourceList getByEndpoint(String endpoint) {
		return get("https://pokeapi.co/api/v2/" + endpoint);
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}