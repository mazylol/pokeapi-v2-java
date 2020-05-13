/* Growth rates are the speed with which Pokémon gain levels through experience. Check out Bulbapedia for greater detail. */

package pokeapi.bittle.models.pokemon;
/*
{
  "id": 1,
  "name": "slow",
  "formula": "\\frac{5x^3}{4}",
  "descriptions": [
    {
      "description": "langsam",
      "language": {
        "name": "de",
        "url": "https://pokeapi.co/api/v2/language/6/"
      }
    }
  ],
  "levels": [
    {
      "level": 100,
      "experience": 1250000
    }
  ],
  "pokemon_species": [
    {
      "name": "growlithe",
      "url": "https://pokeapi.co/api/v2/pokemon-species/58/"
    }
  ]
}
*/

public class GrowthRate extends pokeapi.bittle.models.utility.NamedAPIResource {
	public int getId() {
				return id;
	}

	public GrowthRate setId(int id) {
		this.id = id;
		return this;
	}

	public String getFormula() {
				return formula;
	}

	public GrowthRate setFormula(String formula) {
		this.formula = formula;
		return this;
	}

	public java.util.ArrayList<pokeapi.bittle.models.utility.Description> getDescriptions() {
				return descriptions;
	}

	public GrowthRate setDescriptions(java.util.ArrayList<pokeapi.bittle.models.utility.Description> descriptions) {
		this.descriptions = descriptions;
		return this;
	}

	public java.util.ArrayList<pokeapi.bittle.models.pokemon.GrowthRateExperienceLevel> getLevels() {
				return levels;
	}

	public GrowthRate setLevels(java.util.ArrayList<pokeapi.bittle.models.pokemon.GrowthRateExperienceLevel> levels) {
		this.levels = levels;
		return this;
	}

	public java.util.ArrayList<pokeapi.bittle.models.pokemon.PokemonSpecies> getPokemonSpecies() {
				return pokemon_species;
	}

	public GrowthRate setPokemonSpecies(java.util.ArrayList<pokeapi.bittle.models.pokemon.PokemonSpecies> pokemon_species) {
		this.pokemon_species = pokemon_species;
		return this;
	}

	// The identifier for this resource.
	private int id;

	// The formula used to calculate the rate at which the Pokémon species gains level.
	private String formula;

	// The descriptions of this characteristic listed in different languages.
	private java.util.ArrayList<pokeapi.bittle.models.utility.Description> descriptions;

	// A list of levels and the amount of experienced needed to atain them based on this growth rate.
	private java.util.ArrayList<pokeapi.bittle.models.pokemon.GrowthRateExperienceLevel> levels;

	// A list of Pokémon species that gain levels at this growth rate.
	private java.util.ArrayList<pokeapi.bittle.models.pokemon.PokemonSpecies> pokemon_species;

	private static GrowthRate get(String url) {
		GrowthRate obj = new com.google.gson.Gson().fromJson(pokeapi.bittle.utils.Information.fromInternet(url), GrowthRate.class);
		obj.setIsFetched(true);
		return obj;
	}

	public GrowthRate get() {
		return GrowthRate.get(this.getUrl());
	}

	public static pokeapi.bittle.models.resources.NamedAPIResourceList getList(int limit, int offset) {
		 return pokeapi.bittle.models.resources.NamedAPIResourceList.getList("growth-rate", limit, offset);
	}

	public static GrowthRate getById(int id) {
		return get("https://pokeapi.co/api/v2/growth-rate/" + id);
	}

	public static GrowthRate getByName(String name) {
		return get("https://pokeapi.co/api/v2/growth-rate/" + name);
	}
}