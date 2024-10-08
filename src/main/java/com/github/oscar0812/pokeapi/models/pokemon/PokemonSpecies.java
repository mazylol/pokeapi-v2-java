/* A Pokémon Species forms the basis for at least one Pokémon. Attributes of a Pokémon species are shared across all varieties of Pokémon within the species. A good example is Wormadam; Wormadam is the species which can be found in three different varieties, Wormadam-Trash, Wormadam-Sandy and Wormadam-Plant. */

package com.github.oscar0812.pokeapi.models.pokemon;

import com.github.oscar0812.pokeapi.models.evolution.EvolutionChain;
import com.github.oscar0812.pokeapi.models.games.Generation;
import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.models.utility.Description;
import com.github.oscar0812.pokeapi.models.utility.FlavorText;
import com.github.oscar0812.pokeapi.models.utility.Name;
import com.github.oscar0812.pokeapi.models.utility.NamedAPIResource;
import com.github.oscar0812.pokeapi.utils.Information;
import java.util.ArrayList;

public class PokemonSpecies extends NamedAPIResource {
	// The identifier for this resource.
	private int id;

	// The order in which species should be sorted. Based on National Dex order, except families are grouped together and sorted by stage.
	private int order;

	// The chance of this Pokémon being female, in eighths; or -1 for genderless.
	private int gender_rate;

	// The base capture rate; up to 255. The higher the number, the easier the catch.
	private int capture_rate;

	// The happiness when caught by a normal Pokéball; up to 255. The higher the number, the happier the Pokémon.
	private int base_happiness;

	// Whether or not this is a baby Pokémon.
	private boolean is_baby;

	// Whether or not this is a legendary Pokémon.
	private boolean is_legendary;

	// Whether or not this is a mythical Pokémon.
	private boolean is_mythical;

	// Initial hatch counter: one must walk 255 × (hatch_counter + 1) steps before this Pokémon's egg hatches, unless utilizing bonuses like Flame Body's.
	private int hatch_counter;

	// Whether or not this Pokémon has visual gender differences.
	private boolean has_gender_differences;

	// Whether or not this Pokémon has multiple forms and can switch between them.
	private boolean forms_switchable;

	// The rate at which this Pokémon species gains levels.
	private GrowthRate growth_rate;

	// A list of Pokedexes and the indexes reserved within them for this Pokémon species.
	private ArrayList<PokemonSpeciesDexEntry> pokedex_numbers;

	// A list of egg groups this Pokémon species is a member of.
	private ArrayList<EggGroup> egg_groups;

	// The color of this Pokémon for Pokédex search.
	private PokemonColor color;

	// The shape of this Pokémon for Pokédex search.
	private PokemonShape shape;

	// The Pokémon species that evolves into this Pokemon_species.
	private PokemonSpecies evolves_from_species;

	// The evolution chain this Pokémon species is a member of.
	private EvolutionChain evolution_chain;

	// The habitat this Pokémon species can be encountered in.
	private PokemonHabitat habitat;

	// The generation this Pokémon species was introduced in.
	private Generation generation;

	// The name of this resource listed in different languages.
	private ArrayList<Name> names;

	// A list of encounters that can be had with this Pokémon species in pal park.
	private ArrayList<PalParkEncounterArea> pal_park_encounters;

	// A list of flavor text entries for this Pokémon species.
	private ArrayList<FlavorText> flavor_text_entries;

	// Descriptions of different forms Pokémon take on within the Pokémon species.
	private ArrayList<Description> form_descriptions;

	// The genus of this Pokémon species listed in multiple languages.
	private ArrayList<Genus> genera;

	// A list of the Pokémon that exist within this Pokémon species.
	private ArrayList<PokemonSpeciesVariety> varieties;

	public int getId() {
		return id;
	}

	public PokemonSpecies setId(int id) {
		this.id = id;
		return this;
	}

	public int getOrder() {
		return order;
	}

	public PokemonSpecies setOrder(int order) {
		this.order = order;
		return this;
	}

	public int getGenderRate() {
		return gender_rate;
	}

	public PokemonSpecies setGenderRate(int gender_rate) {
		this.gender_rate = gender_rate;
		return this;
	}

	public int getCaptureRate() {
		return capture_rate;
	}

	public PokemonSpecies setCaptureRate(int capture_rate) {
		this.capture_rate = capture_rate;
		return this;
	}

	public int getBaseHappiness() {
		return base_happiness;
	}

	public PokemonSpecies setBaseHappiness(int base_happiness) {
		this.base_happiness = base_happiness;
		return this;
	}

	public boolean getIsBaby() {
		return is_baby;
	}

	public PokemonSpecies setIsBaby(boolean is_baby) {
		this.is_baby = is_baby;
		return this;
	}

	public boolean getIsLegendary() {
		return is_legendary;
	}

	public PokemonSpecies setIsLegendary(boolean is_legendary) {
		this.is_legendary = is_legendary;
		return this;
	}

	public boolean getIsMythical() {
		return is_mythical;
	}

	public PokemonSpecies setIsMythical(boolean is_mythical) {
		this.is_mythical = is_mythical;
		return this;
	}

	public int getHatchCounter() {
		return hatch_counter;
	}

	public PokemonSpecies setHatchCounter(int hatch_counter) {
		this.hatch_counter = hatch_counter;
		return this;
	}

	public boolean getHasGenderDifferences() {
		return has_gender_differences;
	}

	public PokemonSpecies setHasGenderDifferences(boolean has_gender_differences) {
		this.has_gender_differences = has_gender_differences;
		return this;
	}

	public boolean getFormsSwitchable() {
		return forms_switchable;
	}

	public PokemonSpecies setFormsSwitchable(boolean forms_switchable) {
		this.forms_switchable = forms_switchable;
		return this;
	}

	public GrowthRate getGrowthRate() {
		if(!growth_rate.getIsFetched()) {
			growth_rate = growth_rate.get();
		}
		return growth_rate;
	}

	public PokemonSpecies setGrowthRate(GrowthRate growth_rate) {
		this.growth_rate = growth_rate;
		return this;
	}

	public ArrayList<PokemonSpeciesDexEntry> getPokedexNumbers() {
		return pokedex_numbers;
	}

	public PokemonSpecies setPokedexNumbers(ArrayList<PokemonSpeciesDexEntry> pokedex_numbers) {
		this.pokedex_numbers = pokedex_numbers;
		return this;
	}

	public ArrayList<EggGroup> getEggGroups() {
		return egg_groups;
	}

	public PokemonSpecies setEggGroups(ArrayList<EggGroup> egg_groups) {
		this.egg_groups = egg_groups;
		return this;
	}

	public PokemonColor getColor() {
		if(!color.getIsFetched()) {
			color = color.get();
		}
		return color;
	}

	public PokemonSpecies setColor(PokemonColor color) {
		this.color = color;
		return this;
	}

	public PokemonShape getShape() {
		if(!shape.getIsFetched()) {
			shape = shape.get();
		}
		return shape;
	}

	public PokemonSpecies setShape(PokemonShape shape) {
		this.shape = shape;
		return this;
	}

	public PokemonSpecies getEvolvesFromSpecies() {
		if(!evolves_from_species.getIsFetched()) {
			evolves_from_species = evolves_from_species.get();
		}
		return evolves_from_species;
	}

	public PokemonSpecies setEvolvesFromSpecies(PokemonSpecies evolves_from_species) {
		this.evolves_from_species = evolves_from_species;
		return this;
	}

	public EvolutionChain getEvolutionChain() {
		if(!evolution_chain.getIsFetched()) {
			evolution_chain = evolution_chain.get();
		}
		return evolution_chain;
	}

	public PokemonSpecies setEvolutionChain(EvolutionChain evolution_chain) {
		this.evolution_chain = evolution_chain;
		return this;
	}

	public PokemonHabitat getHabitat() {
		if(!habitat.getIsFetched()) {
			habitat = habitat.get();
		}
		return habitat;
	}

	public PokemonSpecies setHabitat(PokemonHabitat habitat) {
		this.habitat = habitat;
		return this;
	}

	public Generation getGeneration() {
		if(!generation.getIsFetched()) {
			generation = generation.get();
		}
		return generation;
	}

	public PokemonSpecies setGeneration(Generation generation) {
		this.generation = generation;
		return this;
	}

	public ArrayList<Name> getNames() {
		return names;
	}

	public PokemonSpecies setNames(ArrayList<Name> names) {
		this.names = names;
		return this;
	}

	public ArrayList<PalParkEncounterArea> getPalParkEncounters() {
		return pal_park_encounters;
	}

	public PokemonSpecies setPalParkEncounters(ArrayList<PalParkEncounterArea> pal_park_encounters) {
		this.pal_park_encounters = pal_park_encounters;
		return this;
	}

	public ArrayList<FlavorText> getFlavorTextEntries() {
		return flavor_text_entries;
	}

	public PokemonSpecies setFlavorTextEntries(ArrayList<FlavorText> flavor_text_entries) {
		this.flavor_text_entries = flavor_text_entries;
		return this;
	}

	public ArrayList<Description> getFormDescriptions() {
		return form_descriptions;
	}

	public PokemonSpecies setFormDescriptions(ArrayList<Description> form_descriptions) {
		this.form_descriptions = form_descriptions;
		return this;
	}

	public ArrayList<Genus> getGenera() {
		return genera;
	}

	public PokemonSpecies setGenera(ArrayList<Genus> genera) {
		this.genera = genera;
		return this;
	}

	public ArrayList<PokemonSpeciesVariety> getVarieties() {
		return varieties;
	}

	public PokemonSpecies setVarieties(ArrayList<PokemonSpeciesVariety> varieties) {
		this.varieties = varieties;
		return this;
	}

	private static PokemonSpecies get(String url) {
		PokemonSpecies obj = new com.google.gson.Gson().fromJson(Information.fromInternet(url), PokemonSpecies.class);
		obj.setIsFetched(true);
		return obj;
	}

	public PokemonSpecies get() {
		return PokemonSpecies.get(this.getUrl());
	}

	public static NamedAPIResourceList getList(int limit, int offset) {
		 return NamedAPIResourceList.getList("pokemon-species", limit, offset);
	}

	public static PokemonSpecies getById(int id) {
		return get("https://pokeapi.co/api/v2/pokemon-species/" + id);
	}

	public static PokemonSpecies getByName(String name) {
		return get("https://pokeapi.co/api/v2/pokemon-species/" + name);
	}
}