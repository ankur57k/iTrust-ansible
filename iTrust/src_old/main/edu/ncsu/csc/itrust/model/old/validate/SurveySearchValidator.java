package edu.ncsu.csc.itrust.model.old.validate;

import edu.ncsu.csc.itrust.exception.ErrorList;
import edu.ncsu.csc.itrust.exception.FormValidationException;
import edu.ncsu.csc.itrust.model.old.beans.SurveyResultBean;

/**
 * Validator for zip code that is entered when a user searches for HCP survey results.
 */
public class SurveySearchValidator extends BeanValidator<SurveyResultBean>{

	/**
	 * Performs the act of validating the bean in question, which varies depending on the
	 * type of validator.  If the validation does not succeed, a {@link FormValidationException} is thrown.
	 * 
	 * @param p A bean of the type to be validated.
	 */
	@Override
	public void validate(SurveyResultBean bean) throws FormValidationException {
		ErrorList errorList = new ErrorList();
		errorList.addIfNotNull(checkFormat("Zip Code", bean.getHCPzip(), ValidationFormat.ZIPCODE, true));
		
		if (errorList.hasErrors())
			throw new FormValidationException(errorList);
	}

}
