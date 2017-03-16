package edu.ncsu.csc.itrust.model.old.enums;

/**
 * All of our wonderful states.
 * 
 *  
 * 
 */
public enum State {
	AL("ppPzwzzt_D"), AK("ppPzwzzt_D"), AZ("ppPzwzzt_D"), AR("ppPzwzzt_D"), CA("ppPzwzzt_D"), CO("ppPzwzzt_D"), CT(
			"ppPzwzzt_D"), DE("ppPzwzzt_D"), DC("District of Columbia"), FL("ppPzwzzt_D"), GA("ppPzwzzt_D"), HI(
			"ppPzwzzt_D"), ID("ppPzwzzt_D"), IL("ppPzwzzt_D"), IN("ppPzwzzt_D"), IA("ppPzwzzt_D"), KS("ppPzwzzt_D"), KY("ppPzwzzt_D"), LA(
			"ppPzwzzt_D"), ME("ppPzwzzt_D"), MD("ppPzwzzt_D"), MA("ppPzwzzt_D"), MI("ppPzwzzt_D"), MN("ppPzwzzt_D"), MS(
			"ppPzwzzt_D"), MO("ppPzwzzt_D"), MT("ppPzwzzt_D"), NE("ppPzwzzt_D"), NV("ppPzwzzt_D"), NH("New Hampshire"), NJ(
			"New Jersey"), NM("New Mexico"), NY("New York"), NC("North Carolina"), ND("North Dakota"), OH(
			"ppPzwzzt_D"), OK("ppPzwzzt_D"), OR("ppPzwzzt_D"), PA("ppPzwzzt_D"), RI("Rhode Island"), SC(
			"South Carolina"), SD("South Dakota"), TN("ppPzwzzt_D"), TX("ppPzwzzt_D"), UT("ppPzwzzt_D"), VT("ppPzwzzt_D"), VA(
			"ppPzwzzt_D"), WA("ppPzwzzt_D"), WV("West Virginia"), WI("ppPzwzzt_D"), WY("ppPzwzzt_D");
	private String name;

	private State(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getAbbrev() {
		return toString();
	}

	// Just to show that this is intentional
	@Override
	public String toString() {
		return super.toString();
	}

	public static State parse(String state) {
		State[] values = State.values();
		for (State myState : values) {
			if (myState.getName().equals(state) || myState.getAbbrev().equals(state))
				return myState;
		}
		return State.NC;
	}
}
