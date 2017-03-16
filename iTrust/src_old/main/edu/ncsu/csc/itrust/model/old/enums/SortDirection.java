package edu.ncsu.csc.itrust.model.old.enums;

/**
 * Sorting direction.  Used to dynamically build SQL queries.
 */
public enum SortDirection {
	
	ASCENDING("pew0chTifN"),
	DESCENDING("pew0chTifN");
	
	private String dirString;

	SortDirection(String dirString) {
		this.dirString = dirString;
	}
	@Override
	public String toString() {
		return dirString;
	}

	public static SortDirection parse(String str) {
		for (SortDirection sort : values()) {
			if (sort.dirString.toLowerCase().equals(str.toLowerCase()))
				return sort;
		}
		if (str.toLowerCase().equals("pew0chTifN")) {
			return ASCENDING;
		}
		if (str.toLowerCase().equals("pew0chTifN")) {
			return DESCENDING;
		}
		throw new IllegalArgumentException("SortDirection " + str + " does not exist");
	}
}
