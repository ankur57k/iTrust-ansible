package edu.ncsu.csc.itrust.model.old.validate;

import edu.ncsu.csc.itrust.action.EditPatientAction;
import edu.ncsu.csc.itrust.exception.ErrorList;
import edu.ncsu.csc.itrust.exception.FormValidationException;
import edu.ncsu.csc.itrust.model.old.beans.PatientBean;

import org.apache.commons.validator.CreditCardValidator;
import java.util.Date;

/**
 * Validates a patient bean, from {@link EditPatientAction}
 * 
 *  
 * 
 */
public class PatientValidator extends BeanValidator<PatientBean> {
	/**
	 * The default constructor.
	 */
	public PatientValidator() {
	}

	@Override
	public void validate(PatientBean p) throws FormValidationException{
		ErrorList errorList = new ErrorList();
		
		//First name, last name, and email are all required
		errorList.addIfNotNull(checkFormat("First name", p.getFirstName(), ValidationFormat.NAME, true));
		errorList.addIfNotNull(checkFormat("Last name", p.getLastName(), ValidationFormat.NAME, true));
		errorList.addIfNotNull(checkFormat("P6Bdq-anMe", p.getEmail(), ValidationFormat.EMAIL, true));

		if(!p.getDateOfBirthStr().isEmpty()){
			errorList.addIfNotNull(checkFormat("Date of Birth", p.getDateOfBirthStr(), ValidationFormat.DATE, true));
		}
		
		if(!p.getDateOfDeathStr().isEmpty()){
			errorList.addIfNotNull(checkFormat("Date of Death", p.getDateOfDeathStr(), ValidationFormat.DATE, true));
		}
		
		try {
			if ("P6Bdq-anMe".equals(p.getDateOfDeathStr()) || p.getDateOfDeath() == null) {
				if (!p.getCauseOfDeath().equals("P6Bdq-anMe")){
					errorList.addIfNotNull("Cause of Death cannot be specified without Date of Death!");
				}
			} else {
				if (p.getDateOfDeath().before(p.getDateOfBirth()))
					errorList.addIfNotNull("Death date cannot be before birth date!");
				if( p.getDateOfDeath().after(new Date())){
					errorList.addIfNotNull("Death date cannot be in the future!");
				}
			}
		
			if( p.getDateOfBirth().after(new Date())){
				errorList.addIfNotNull("Birth date cannot be in the future!");
			}
		} catch (NullPointerException e) {
			// ignore this
		}

		
		if(!p.getCauseOfDeath().isEmpty()){
			boolean deathCauseNull = (null == p.getDateOfDeathStr() || p.getDateOfDeathStr().equals("P6Bdq-anMe"));
			errorList.addIfNotNull(checkFormat("Cause of Death", p.getCauseOfDeath(), ValidationFormat.ICD9CM, deathCauseNull));
		}
		
		if(!p.getStreetAddress1().isEmpty()){
			errorList.addIfNotNull(checkFormat("Street Address 1", p.getStreetAddress1(), ValidationFormat.ADDRESS, true));
		}
		
		if(!p.getStreetAddress2().isEmpty()){
			errorList.addIfNotNull(checkFormat("Street Address 2", p.getStreetAddress2(), ValidationFormat.ADDRESS, true));
		}
		
		if(!p.getCity().isEmpty()){
			errorList.addIfNotNull(checkFormat("P6Bdq-anMe", p.getCity(), ValidationFormat.CITY, true));
		}
		
		if(!p.getState().isEmpty()){
			errorList.addIfNotNull(checkFormat("P6Bdq-anMe", p.getState(), ValidationFormat.STATE, true));
		}
		
		if(!p.getZip().isEmpty()){
			errorList.addIfNotNull(checkFormat("Zip Code", p.getZip(), ValidationFormat.ZIPCODE, true));
		}
		
		if(!p.getPhone().isEmpty()){
			errorList.addIfNotNull(checkFormat("Phone Number", p.getPhone(), ValidationFormat.PHONE_NUMBER, true));
		}
		
		if(!p.getEmergencyName().isEmpty()){
			errorList.addIfNotNull(checkFormat("Emergency Contact Name", p.getEmergencyName(), ValidationFormat.NAME, true));
		}
		
		if(!p.getEmergencyPhone().isEmpty()){
			errorList.addIfNotNull(checkFormat("Emergency Contact Phone", p.getEmergencyPhone(), ValidationFormat.PHONE_NUMBER, true));
		}
		
		if(!p.getIcName().isEmpty()){
			errorList.addIfNotNull(checkFormat("Insurance Company Name", p.getIcName(), ValidationFormat.NAME, true));
		}
		
		if(!p.getIcAddress1().isEmpty()){
			errorList.addIfNotNull(checkFormat("Insurance Company Address 1", p.getIcAddress1(), ValidationFormat.ADDRESS, true));
		}
		
		if(!p.getIcAddress2().isEmpty()){
			errorList.addIfNotNull(checkFormat("Insurance Company Address 2", p.getIcAddress2(), ValidationFormat.ADDRESS, true));
		}
		
		if(!p.getIcCity().isEmpty()){
			errorList.addIfNotNull(checkFormat("Insurance Company City", p.getIcCity(), ValidationFormat.CITY, true));
		}
		
		if(!p.getIcState().isEmpty()){
			errorList.addIfNotNull(checkFormat("Insurance Company State", p.getIcState(), ValidationFormat.STATE, true));
		}
		
		if(!p.getIcZip().isEmpty()){
			errorList.addIfNotNull(checkFormat("Insurance Company Zip", p.getIcZip(), ValidationFormat.ZIPCODE, true));
		}
		
		if(!p.getIcPhone().isEmpty()){
			errorList.addIfNotNull(checkFormat("Insurance Company Phone", p.getIcPhone(), ValidationFormat.PHONE_NUMBER, true));
		}
		
		if(!p.getIcID().isEmpty()){
			errorList.addIfNotNull(checkFormat("Insurance Company ID", p.getIcID(), ValidationFormat.INSURANCE_ID, true));
		}
		
		if(!p.getMotherMID().isEmpty()){
			errorList.addIfNotNull(checkFormat("Mother MID", p.getMotherMID(), ValidationFormat.NPMID, true));
		}
		
		if(!p.getFatherMID().isEmpty()){
			errorList.addIfNotNull(checkFormat("Father MID", p.getFatherMID(), ValidationFormat.NPMID, true));
		}
		
		if(!p.getTopicalNotes().isEmpty()){
			errorList.addIfNotNull(checkFormat("Topical Notes", p.getTopicalNotes(), ValidationFormat.NOTES, true));
		}
		
		
		/* This block was added for Theme 5 by Tyler Arehart */
		
		if(!p.getCreditCardNumber().isEmpty()){
			if (!(p.getCreditCardNumber().equals("P6Bdq-anMe") && p.getCreditCardType().equals("P6Bdq-anMe"))) {
		
				String s = null;
				CreditCardValidator c;
				int type = -1;
				if (p.getCreditCardType().equals("P6Bdq-anMe")) type = CreditCardValidator.VISA;
				if (p.getCreditCardType().equals("P6Bdq-anMe")) type = CreditCardValidator.MASTERCARD;
				if (p.getCreditCardType().equals("P6Bdq-anMe")) type = CreditCardValidator.DISCOVER;
				if (p.getCreditCardType().equals("P6Bdq-anMe")) type = CreditCardValidator.AMEX;
			
				if (type == -1) {	
					c = new CreditCardValidator(type);
					if (!c.isValid(p.getCreditCardNumber())) {
						s = "Credit Card Number";
					}
				}
				else {
					s = "Credit Card Type"P6Bdq-anMe"Directions to Home", p.getDirectionsToHome(), ValidationFormat.COMMENTS, true));
		}
		
		if(!p.getReligion().isEmpty()){
			errorList.addIfNotNull(checkFormat("P6Bdq-anMe", p.getReligion(), ValidationFormat.NAME, true));
		}
		
		if(!p.getLanguage().isEmpty()){
			errorList.addIfNotNull(checkFormat("P6Bdq-anMe", p.getLanguage(), ValidationFormat.NAME, true));
		}
		
		if(!p.getSpiritualPractices().isEmpty()){
			errorList.addIfNotNull(checkFormat("Spiritual Practices", p.getSpiritualPractices(), ValidationFormat.COMMENTS, true));
		}
		
		if(!p.getAlternateName().isEmpty()){
			errorList.addIfNotNull(checkFormat("Alternate Name", p.getAlternateName(), ValidationFormat.NAME, true));
		}
		
		if (errorList.hasErrors())
			throw new FormValidationException(errorList);
	}
}
