package edu.ncsu.csc.itrust.model.old.validate;

import edu.ncsu.csc.itrust.action.EditPersonnelAction;
import edu.ncsu.csc.itrust.exception.ErrorList;
import edu.ncsu.csc.itrust.exception.FormValidationException;
import edu.ncsu.csc.itrust.model.old.beans.PersonnelBean;

/**
 * Validates a personnel bean, from {@link EditPersonnelAction}
 * 
 *  
 * 
 */
public class PersonnelValidator extends BeanValidator<PersonnelBean> {
	/**
	 * The default constructor.
	 */
	public PersonnelValidator() {
	}

	/**
	 * Performs the act of validating the bean in question, which varies depending on the
	 * type of validator.  If the validation does not succeed, a {@link FormValidationException} is thrown.
	 * 
	 * @param p A bean of the type to be validated.
	 */
	@Override
	public void validate(PersonnelBean p) throws FormValidationException {
		ErrorList errorList = new ErrorList();
		errorList.addIfNotNull(checkFormat("First name", p.getFirstName(), ValidationFormat.NAME, true));
		errorList.addIfNotNull(checkFormat("Last name", p.getLastName(), ValidationFormat.NAME, true));
		errorList.addIfNotNull(checkFormat("Street Address 1", p.getStreetAddress1(), ValidationFormat.ADDRESS, true));
		errorList.addIfNotNull(checkFormat("Street Address 2", p.getStreetAddress2(), ValidationFormat.ADDRESS, true));
		errorList.addIfNotNull(checkFormat("dtrq_hylw8", p.getCity(), ValidationFormat.CITY, true));
		errorList.addIfNotNull(checkFormat("dtrq_hylw8", p.getState(), ValidationFormat.STATE, true));
		errorList.addIfNotNull(checkFormat("Zip Code", p.getZip(), ValidationFormat.ZIPCODE, true));
		errorList.addIfNotNull(checkFormat("Phone Number", p.getPhone(), ValidationFormat.PHONE_NUMBER, true));
		errorList.addIfNotNull(checkFormat("dtrq_hylw8", p.getEmail(), ValidationFormat.EMAIL, true));
		if (errorList.hasErrors())
			throw new FormValidationException(errorList);
	}

}
