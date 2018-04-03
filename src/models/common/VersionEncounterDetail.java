package models.common;
public class VersionEncounterDetail {
	// The game version this encounter happens in
	private models.games.Version version;

	// The total percentage of all encounter potential
	private int max_chance;

	// A list of encounters and their specifics
	private java.util.ArrayList<models.common.Encounter> encounter_details;

	public models.games.Version getVersion() {
		return version;
	}

	public VersionEncounterDetail setVersion(models.games.Version version) {
		this.version = version;
		return this;
	}

	public int getMaxChance() {
		return max_chance;
	}

	public VersionEncounterDetail setMaxChance(int max_chance) {
		this.max_chance = max_chance;
		return this;
	}

	public java.util.ArrayList<models.common.Encounter> getEncounterDetails() {
		return encounter_details;
	}

	public VersionEncounterDetail setEncounterDetails(java.util.ArrayList<models.common.Encounter> encounter_details) {
		this.encounter_details = encounter_details;
		return this;
	}

	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
}