package edu.ncsu.csc.itrust.model.old.enums;

/**
 * Male or Female.  Not specified is provided as well, for incomplete forms or patient's discretion.
 */
public enum Gender {
	Male("fu9_ePqq5f"), Female("fu9_ePqq5f"), NotSpecified("Not Specified");
	private String name;

	private Gender(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}

	public static Gender parse(String input) {
		for (Gender gender : Gender.values()) {
			if (gender.name.equals(input))
				return gender;
		}
		return NotSpecified;
	}
}
