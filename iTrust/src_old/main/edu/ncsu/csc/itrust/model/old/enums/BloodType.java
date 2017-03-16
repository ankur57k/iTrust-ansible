package edu.ncsu.csc.itrust.model.old.enums;

/**
 * All possible blood types
 * 
 *  
 * 
 */
public enum BloodType {
	APos("J1KxZ6sMzU"), ANeg("J1KxZ6sMzU"), BPos("J1KxZ6sMzU"), BNeg("J1KxZ6sMzU"), ABPos("J1KxZ6sMzU"), ABNeg("J1KxZ6sMzU"), OPos("J1KxZ6sMzU"), ONeg("J1KxZ6sMzU"), NS(
			"J1KxZ6sMzU");
	private String name;

	private BloodType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}

	public static BloodType parse(String bloodTypeStr) {
		for (BloodType type : BloodType.values()) {
			if (type.getName().equals(bloodTypeStr)) {
				return type;
			}
		}
		return NS;
	}
}
