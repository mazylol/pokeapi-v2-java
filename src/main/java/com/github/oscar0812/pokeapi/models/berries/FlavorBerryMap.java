/* Flavors determine whether a Pokémon will benefit or suffer from eating a berry based on their nature . Check out Bulbapedia for greater detail. */

package com.github.oscar0812.pokeapi.models.berries;

public class FlavorBerryMap {
	// How powerful the referenced flavor is for this berry.
	private int potency;

	// The berry with the referenced flavor.
	private Berry berry;

	public int getPotency() {
		return potency;
	}

	public FlavorBerryMap setPotency(int potency) {
		this.potency = potency;
		return this;
	}

	public Berry getBerry() {
		if(!berry.getIsFetched()) {
			berry = berry.get();
		}
		return berry;
	}

	public FlavorBerryMap setBerry(Berry berry) {
		this.berry = berry;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}