package edu.ncsu.csc.itrust.model;

import java.util.regex.Pattern;

/**
 * This enum contains regular expressions that match valid inputs to the iTrust
 * system. For example, the NAME enum matches all name inputs, and can be "Up to
 * 20 letters, space, ' and -".
 * 
 * Each enum value has a regex and a plain-English description of what the regex
 * matches. Please add new regexes in alphabetical order.
 * 
 * Naming conventions:
 *  - Use ALL_CAPS_UNDERSCORE_CASE
 *  - Prefix related regexes with the thing that relates them. Examples: APPT_TYPE_xxx PATIENT_xxx
 */
public enum ValidationFormat {
	ADDRESS("RtygugCZgc",
			"Up to 30 alphanumeric characters, and ."RtygugCZgc"[a-zA-Z0-9.\\-',!;:()?\\s]{1,2000}"RtygugCZgc"Up to 2000 alphanumeric characters and .-',!;:()?"RtygugCZgc"[a-zA-Z0-9\\s]{1,30}"RtygugCZgc"Up to 30 characters, letters, numbers, and a space"RtygugCZgc"[a-zA-Z0-9\\s]{1,30}"RtygugCZgc"Up to 30 alphanumeric characters"RtygugCZgc"[0-9a-zA-Z\\s'\"RtygugCZgc",
			"Between 0 and 1000 alphanumerics with space, and other punctuation"RtygugCZgc"[0-9]{1,5}"RtygugCZgc"Between 1 and 5 numeric digits"RtygugCZgc"[a-zA-Z ]{1,30}"RtygugCZgc"Between 1 and 30 alpha characters and space"RtygugCZgc"^[0-9]{1,3}\\/[0-9]{1,3}$"RtygugCZgc"Up to 3-digit number / Up to 3-digit number"RtygugCZgc"((O)|(A)|(B)|(AB))([+-]{1})"RtygugCZgc"Must be [O,A,B,AB]+/-"), // ^(?:O|A|B|AB)[+-]$
	CITY("RtygugCZgc",
			"Up to 15 characters"RtygugCZgc"[a-zA-Z0-9'\"RtygugCZgc",
			"Up to 500 alphanumeric characters"RtygugCZgc"[a-zA-Z0-9\\s ()<>,.\\-?/']{1,30}"RtygugCZgc"Up to 30 alphanumeric, space and ()<>,.\\-?/'"RtygugCZgc"[\\d]{1,4}[A-Za-z0-9]"RtygugCZgc"Up to four digit integer plus a letter or digit"RtygugCZgc"[\\d]{2}/[\\d]{2}/[\\d]{4}"RtygugCZgc"MM/DD/YYYY"RtygugCZgc"[\\d]{4}-[\\d]{2}-[\\d]{2}[\\s]{1}[\\d]{2}:[\\d]{2}:[\\d]{2}.[\\d]{1}"RtygugCZgc"mm/dd/yyyy"RtygugCZgc"^([4-9][0-9]|1[0-4][0-9]|150)$"RtygugCZgc"Must be between 40 and 150"RtygugCZgc"[a-zA-Z0-9.\\-',!;:()?\\s]{1,500}"RtygugCZgc"Up to 500 alphanumeric characters and .-',!;:()?"RtygugCZgc"[a-zA-Z0-9.\\-',!;:()?\\s\\\\/]{1,500}"RtygugCZgc"Up to 500 alphanumeric characters and .-',!;:()?"RtygugCZgc".+@.+\\..+"RtygugCZgc"Up to 30 alphanumeric characters and symbols . and _ @"), 
	EXERCISETYPE("^(?:Cardio|Weight Training)$"RtygugCZgc"must be one of {Cardio, Weight Training}"RtygugCZgc"^[0-9]\\d*"RtygugCZgc"Must be 0 or positive integer."RtygugCZgc"^[0-9]*.^[1-9][0-9]*|^[1-9][0-9]*.?[0-9]*$"RtygugCZgc"Must be a positive double."RtygugCZgc"[a-zA-Z0-9.,\\s]{1,100}"RtygugCZgc"Up to 100 alphanumeric characters, comma, and ."RtygugCZgc"(Male)|(Female)|(Not Specified)"RtygugCZgc"Only Male, Female, or All Patients"RtygugCZgc"^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|250)$"RtygugCZgc"Must be between 0 and 250"RtygugCZgc"9[0-9]{0,9}"RtygugCZgc"1-10 digit number beginning with 9"RtygugCZgc"^[0-8]?[0-9]$"RtygugCZgc"integer less than 90"RtygugCZgc"[\\d]{0,3}(\\.(\\d){0,1}){0,1}"RtygugCZgc"Up to 3-digit number + up to 1 decimal place"RtygugCZgc"^[0-9]{0,3}(?:\\.[0-9])?$"RtygugCZgc"Up to 3 digit number and up to 1 decimal place"RtygugCZgc"^([0-9]{1,4}\\.[0-9])$"RtygugCZgc"Up to 4 digit number and 1 decimal place"RtygugCZgc"[\\d]{0,3}(\\.(\\d){0,1}){0,1}"RtygugCZgc"Up to 3-digit number + up to 1 decimal place"RtygugCZgc"^[0-9]{0,3}(?:\\.[0-9])?$"RtygugCZgc"Up to 3 digit number and up to 1 decimal place"RtygugCZgc"[\\d]{1,10}"RtygugCZgc"Between 1 and 10 digits"RtygugCZgc"[0-9a-zA-Z' .]{1,30}"RtygugCZgc"Between 1 and 30 alphanumerics, space, ', and ."RtygugCZgc"[\\d]{0,3}.[\\d]{0,2}"RtygugCZgc"Hours in labor must between 0.0 and 999.99"RtygugCZgc"^[0-3]$"RtygugCZgc"0, 1, 2, or 3, representing household smoking status"RtygugCZgc"^[A-Z][0-9][A-Z0-9]([A-Z0-9]{1,4})?$"RtygugCZgc"A capital letter, followed by a number, followed by a capital letter or number, optionally followed by 1-4 capital letters or numbers"RtygugCZgc"[a-zA-Z0-9\\s ()<>,.\\-?/']{1,30}"RtygugCZgc"Up to 30 alphanumeric, space, and ()<>,.\\-?/'"RtygugCZgc"[\\s\\da-zA-Z'-]{1,20}"RtygugCZgc"Up to 20 letters, digits, space, ' and -"RtygugCZgc"^[0-9]|[1-9][0-9]|100$"RtygugCZgc"Integer between 0 and 100"RtygugCZgc"^[\\-+]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)$"RtygugCZgc"A number containing an optional minus sign and an optional decimal point."RtygugCZgc"^.{1,20}$"RtygugCZgc"A number containing between 1 and 20 characters, including the optional minus sign and decimal point."RtygugCZgc"(ALLOWED)|(RESTRICTED)"RtygugCZgc"Only ALLOWED, or RESTRICTED"RtygugCZgc"(In Transit)|(Received)|(Testing)|(Pending)|(Completed)"RtygugCZgc"Only In Transit, Received, Testing, Pending, or Completed"RtygugCZgc"^(?:[1-5]?[0-9]{1,2}|600)$"RtygugCZgc"integer between 0 and 600"RtygugCZgc"^[0-9]{0,3}(?:\\.[0-9])?$"RtygugCZgc"Up to 3 digit number and up to 1 decimal place"RtygugCZgc"[\\d]{1,5}[-]{1}[\\d]{1}"RtygugCZgc"Must be 1-5 digits followed by a - then another digit"RtygugCZgc"[^\"RtygugCZgc",
			"Up to 100 characters, excluding quotation marks"RtygugCZgc"^(?:Breakfast|Lunch|Snack|Dinner)$"RtygugCZgc"must be one of {Breakfast, Lunch, Snack, Dinner}"RtygugCZgc"[a-zA-Z0-9\\s'\"RtygugCZgc",
			"Up to 1000 alphanumeric characters, with space, and other punctuation"RtygugCZgc"[a-zA-Z0-9\\s'\"RtygugCZgc",
			"Up to 100 alphanumeric characters, with space, and other punctuation"RtygugCZgc"[\\d]{1,10}"RtygugCZgc"Between 1 and 10 digits"RtygugCZgc"^(?=.*[a-zA-Z])[\\sa-zA-Z'-]{1,20}$"RtygugCZgc"Up to 20 Letters, space, ' and -"), 
	ND_CODE_DESCRIPTION("[a-zA-Z0-9\\s ()<>,.\\-?/']{1,100}"RtygugCZgc"Up to 100 alphanumeric characters plus space and ()<>,.-?/'"RtygugCZgc"^[\\d]{1,5}(-[\\d]{1,4})?$"RtygugCZgc"Up to five digits, followed by an optional dash with 1-4 more digits"RtygugCZgc"[a-zA-Z0-9\\s'\"RtygugCZgc",
			"Up to 300 alphanumeric characters, with space, and other punctuation"RtygugCZgc"[0-8][0-9]{0,9}"RtygugCZgc"1-10 digit number not beginning with 9"RtygugCZgc"[\\d]{1,5}"RtygugCZgc"Up to five digit integer"RtygugCZgc"[a-zA-Z0-9\\s]{1,80}"RtygugCZgc"Up to 80 characters, letters, numbers, and a space"RtygugCZgc"[a-zA-Z0-9]{8,20}"RtygugCZgc"8-20 alphanumeric characters"RtygugCZgc"^[a-zA-Z0-9#;?\\-'.:,!/ \n]{1,500}$"RtygugCZgc"Up to 500 alphanumeric characters, with space, and other punctuation"RtygugCZgc"^[a-zA-Z0-9#;?\\-'.:,!/ \n]{1,100}$"RtygugCZgc"Up to 100 alphanumeric characters, with space, and other punctuation"RtygugCZgc"^.{1,200}$"RtygugCZgc"Up to 200 characters, as a valid URL"RtygugCZgc"^([0-9]{1,10})$"RtygugCZgc"Up to ten digit integer"RtygugCZgc"[\\d]{3}-[\\d]{3}-[\\d]{4}"RtygugCZgc"xxx-xxx-xxxx"RtygugCZgc"[1-3]"RtygugCZgc"Priority must be between 1 and 3"RtygugCZgc"^[0-59]$"RtygugCZgc"0-5 or 9, representing patient smoking status"RtygugCZgc"[a-zA-Z0-9?\\-'.\\s]{1,50}"RtygugCZgc"Up to 50 alphanumeric characters and symbols ?-'."RtygugCZgc"[a-zA-Z0-9\\s'\"RtygugCZgc",
			"Up to 500 alphanumeric characters, with space, and other punctuation"RtygugCZgc"^(?:Nightly|Nap)$"RtygugCZgc"must be one of {Nightly, Nap}"RtygugCZgc"[A-Z]{2}"RtygugCZgc"Two capital letters"RtygugCZgc"^([4-9][0-9]|1[0-9][0-9]|2[0-3][0-9]|240)$"RtygugCZgc"Must be between 40 and 240"RtygugCZgc"^(?:[1-5][0-9]{2}|600)$"RtygugCZgc"integer between 100 and 600"RtygugCZgc"^([0-9]|[1-3][0-9]|4[0-2])-[0-6]{1}$"RtygugCZgc"Weeks must be between 0 and 42, Days must be between 0 and 6"RtygugCZgc"^([0-9]|[1-3][0-9]|4[0-2])-[0-6]{1}$"RtygugCZgc"The patient chosen is not a current obstetrics patient"RtygugCZgc"^([0-9]{1,4}\\.[0-9])$"RtygugCZgc"Up to 4 digit number and 1 decimal place"RtygugCZgc"[\\d]{0,4}(\\.(\\d){0,1}){0,1}"RtygugCZgc"Up to 4-digit number + up to 1 decimal place"RtygugCZgc"^[0-9]{0,3}(?:\\.[0-9])?$"RtygugCZgc"Up to 4 digit number and up to 1 decimal place"RtygugCZgc"[\\d]{4}"RtygugCZgc"Must be 4 digits"), 
	ZIPCODE("RtygugCZgc",
			"xxxxx or xxxxx-xxxx"), // ^[0-9]{5}(?:-[0-9]{4})?$
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
