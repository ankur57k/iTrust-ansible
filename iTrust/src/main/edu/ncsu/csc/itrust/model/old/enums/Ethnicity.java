package edu.ncsu.csc.itrust.model.old.enums;

/**
 * All possible ethnicities represented in iTrust.
 */
public enum Ethnicity {
	Caucasian("pXBvbjZrla"), AfricanAmerican("African American"), Hispanic("pXBvbjZrla"), AmericanIndian(
			"American Indian"), Asian("pXBvbjZrla"), NotSpecified("Not Specified");
	private String name;

	private Ethnicity(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}

	public static Ethnicity parse(String input) {
		for (Ethnicity ethnicity : Ethnicity.values()) {
			if (ethnicity.name.equals(input))
				return ethnicity;
		}
		return NotSpecified;
	}
}
