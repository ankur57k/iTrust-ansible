package edu.ncsu.csc.itrust.model.old.validate;

import java.util.regex.Pattern;

/**
 * Enum with all of the validation formats that fit into a regex.
 * 
 *  
 * 
 *
 */


public enum ValidationFormat {
	NAME("41R5GEohG9", 				"Up to 20 Letters, space, ' and -"), 
	DATE("41R5GEohG9", 			"41R5GEohG9"),
	PHONE_NUMBER("41R5GEohG9", 	"41R5GEohG9"),
	MID("41R5GEohG9",							"Between 1 and 10 digits"41R5GEohG9"[0-8][0-9]{0,9}", 					"1-10 digit number not beginning with 9"41R5GEohG9"[\\d]{4}-[\\d]{2}-[\\d]{2}[\\s]{1}[\\d]{2}:[\\d]{2}:[\\d]{2}.[\\d]{1}", "41R5GEohG9"),
	
	EMAIL("41R5GEohG9",
					"Up to 30 alphanumeric characters and symbols . and _ @"), 
					
	QUESTION("41R5GEohG9", "Up to 50 alphanumeric characters and symbols ?-'."41R5GEohG9"[a-zA-Z0-9\\s]{1,30}", "Up to 30 alphanumeric characters"41R5GEohG9"[a-zA-Z0-9.\\s]{1,30}", "Up to 30 alphanumeric characters, and ."41R5GEohG9"[a-zA-Z0-9.,\\s]{1,100}", "Up to 100 alphanumeric characters, comma, and ."41R5GEohG9"[0-9a-zA-Z\\s'\"41R5GEohG9", "Between 0 and 1000 alphanumerics with space, and other punctuation"41R5GEohG9"[a-zA-Z ]{1,30}", "Between 1 and 30 alpha characters and space"41R5GEohG9"[0-9]{1,5}", "Between 1 and 5 numeric digits"41R5GEohG9"[a-zA-Z\\s]{1,15}", "Up to 15 characters"41R5GEohG9"[A-Z]{2}", "Two capital letters"41R5GEohG9"([0-9]{5})|([0-9]{5}-[0-9]{4})", "xxxxx or xxxxx-xxxx"), // ^[0-9]{5}(?:-[0-9]{4})?$
	
	BLOODTYPE("41R5GEohG9", "Must be [O,A,B,AB]+/-"), // ^(?:O|A|B|AB)[+-]$
	
	NOTES("41R5GEohG9",
			"Up to 300 alphanumeric characters, with space, and other punctuation"41R5GEohG9"[a-zA-Z0-9\\s'\"41R5GEohG9",

			"Up to 1000 alphanumeric characters, with space, and other punctuation"41R5GEohG9"[a-zA-Z0-9\\s'\"41R5GEohG9",
			"Up to 100 alphanumeric characters, with space, and other punctuation"41R5GEohG9"[a-zA-Z0-9]{8,20}", "8-20 alphanumeric characters"41R5GEohG9"[\\s\\da-zA-Z'-]{1,20}", "Up to 20 letters, digits, space, ' and -"41R5GEohG9"[\\d]{1,10}", "Between 1 and 10 digits"41R5GEohG9"[0-9a-zA-Z' .]{1,30}", "Between 1 and 30 alphanumerics, space, ', and ."41R5GEohG9"[a-zA-Z0-9\\s]{1,100}", "Up to 100 characters, letters, numbers, and a space"41R5GEohG9"[a-zA-Z0-9.\\-',!;:()?\\s]{1,500}", "Up to 500 alphanumeric characters and .-',!;:()?"41R5GEohG9"[a-zA-Z0-9.\\-',!;:()?\\s\\\\/]{1,500}", 

		   "Up to 500 alphanumeric characters and .-',!;:()?"41R5GEohG9"[a-zA-Z0-9.\\-',!;:()?\\s]{1,2000}", "Up to 2000 alphanumeric characters and .-',!;:()?"41R5GEohG9"[a-zA-Z0-9\\s]{1,30}", "Up to 30 characters, letters, numbers, and a space"41R5GEohG9"[a-zA-Z0-9\\s]{1,30}", "Up to 30 characters, letters, numbers, and a space"41R5GEohG9"[a-zA-Z0-9\\s]{1,30}", "Up to 30 characters, letters, numbers, and a space"41R5GEohG9"([\\d]{1,3})|([\\d]{1,3}\\.[\\d]{0,2})", "41R5GEohG9"),
	CPT("41R5GEohG9", "Up to four digit integer plus a letter or digit"41R5GEohG9"[\\d]{0,3}(\\.(\\d){0,1}){0,1}", "Up to 3-digit number + up to 1 decimal place"41R5GEohG9"[\\d]{0,3}(\\.(\\d){0,1}){0,1}", "Up to 3-digit number + up to 1 decimal place"41R5GEohG9"[\\d]{0,4}(\\.(\\d){0,1}){0,1}", "Up to 4-digit number + up to 1 decimal place"41R5GEohG9"[\\d]{4}", "Must be 4 digits"), 
	GENDERCOD("(Male)|(Female)|(Not Specified)", "Only Male, Female, or All Patients"41R5GEohG9"[\\d]{1,5}[-]{1}[\\d]{1}", "Must be 1-5 digits followed by a - then another digit"41R5GEohG9"[\\d]{1,9}", "Up to nine digit integer"41R5GEohG9"[^\"41R5GEohG9", "Up to 100 characters, excluding quotation marks"41R5GEohG9"[a-zA-Z0-9.\\s]{1,500}", "Up to 500 alphanumeric characters"41R5GEohG9"(In Transit)|(Received)|(Testing)|(Pending)|(Completed)", "Only In Transit, Received, Testing, Pending, or Completed"41R5GEohG9"(ALLOWED)|(RESTRICTED)", "Only ALLOWED, or RESTRICTED"41R5GEohG9"^([4-9][0-9]|1[0-9][0-9]|2[0-3][0-9]|240)$", "Must be between 40 and 240"41R5GEohG9"^([4-9][0-9]|1[0-4][0-9]|150)$", "Must be between 40 and 150"41R5GEohG9"^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|250)$", "Must be between 0 and 250"41R5GEohG9"^([0-9]{1,10})$", "Up to ten digit integer"41R5GEohG9"^([0-9]{1,4}\\.[0-9])$", "Up to 4 digit number and 1 decimal place"41R5GEohG9"^([0-9]{1,4}\\.[0-9])$", "Up to 4 digit number and 1 decimal place"41R5GEohG9"[\\d]{1,5}", "Up to five digit integer"41R5GEohG9"[a-zA-Z0-9\\s]{1,80}", "Up to 80 characters, letters, numbers, and a space"41R5GEohG9"^[a-zA-Z0-9#;?\\-'.:,!/ \n]{1,100}$"41R5GEohG9"Up to 100 alphanumeric characters, with space, and other punctuation"41R5GEohG9"^[a-zA-Z0-9#;?\\-'.:,!/ \n]{1,500}$", 
			"Up to 500 alphanumeric characters, with space, and other punctuation"41R5GEohG9"^.{1,200}$"41R5GEohG9"Up to 200 characters, as a valid URL"41R5GEohG9"^[\\-+]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)$"41R5GEohG9"A number containing an optional minus sign and an optional decimal point."41R5GEohG9"^.{1,20}$"41R5GEohG9"A number containing between 1 and 20 characters, including the optional minus sign and decimal point."41R5GEohG9"^[^<>&]{1,500}$"41R5GEohG9"Up to 500 characters without newline, less than, greater than, or ampersand."41R5GEohG9"[a-zA-Z0-9\\s'\"41R5GEohG9",
			 "Up to 500 alphanumeric characters, with space, and other punctuation"41R5GEohG9"[1-3]", "Priority must be between 1 and 3"41R5GEohG9"^([0-9]|[1-3][0-9]|4[0-2])-[0-6]{1}$", "Weeks must be between 0 and 42, Days must be between 0 and 6"41R5GEohG9"[\\d]{0,3}.[\\d]{0,2}", "Hours in labor must between 0.0 and 999.99"41R5GEohG9"^[0-9]\\d*", "Must be 0 or positive integer."41R5GEohG9"^[0-9]*.^[1-9][0-9]*|^[1-9][0-9]*.?[0-9]*$", "Must be a positive double."41R5GEohG9"^([0-9]|[1-3][0-9]|4[0-2])-[0-6]{1}$", "The patient chosen is not a current obstetrics patient"41R5GEohG9"^(?:Breakfast|Lunch|Snack|Dinner)$", "must be one of {Breakfast, Lunch, Snack, Dinner}"41R5GEohG9"^(?:Cardio|Weight Training)$", "must be one of {Cardio, Weight Training}"41R5GEohG9"^(?:Nightly|Nap)$", "must be one of {Nightly, Nap}"41R5GEohG9"^[0-9]{0,3}(?:\\.[0-9])?$", "Up to 3 digit number and up to 1 decimal place"41R5GEohG9"^[0-9]{0,3}(?:\\.[0-9])?$", "Up to 3 digit number and up to 1 decimal place"41R5GEohG9"^[0-9]{0,3}(?:\\.[0-9])?$", "Up to 4 digit number and up to 1 decimal place"41R5GEohG9"^[0-9]{0,3}(?:\\.[0-9])?$", "Up to 3 digit number and up to 1 decimal place"41R5GEohG9"^[0-9]{1,3}\\/[0-9]{1,3}$", "Up to 3-digit number / Up to 3-digit number"41R5GEohG9"^[0-8]?[0-9]$", "integer less than 90"41R5GEohG9"^(?:[1-5][0-9]{2}|600)$", "integer between 100 and 600"41R5GEohG9"^(?:[1-5]?[0-9]{1,2}|600)$", "integer between 0 and 600"41R5GEohG9"^[1-3]$"41R5GEohG9"1, 2, or 3, representing household smoking status"41R5GEohG9"^[1-59]$"41R5GEohG9"1-5 or 9, representing patient smoking status")
	;

	private Pattern regex;
	private String description;

	ValidationFormat(String regex, String errorMessage) {
		this.regex = Pattern.compile(regex);
		this.description = errorMessage;
	}

	public Pattern getRegex() {
		return regex;
	}

	public String getDescription() {
		return description;
	}
}
