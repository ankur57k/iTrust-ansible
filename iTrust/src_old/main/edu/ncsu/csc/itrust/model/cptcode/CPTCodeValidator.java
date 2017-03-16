package edu.ncsu.csc.itrust.model.cptcode;

import edu.ncsu.csc.itrust.exception.ErrorList;
import edu.ncsu.csc.itrust.exception.FormValidationException;
import edu.ncsu.csc.itrust.model.POJOValidator;
import edu.ncsu.csc.itrust.model.ValidationFormat;

public class CPTCodeValidator extends POJOValidator<CPTCode> {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(CPTCode obj) throws FormValidationException {
		ErrorList errorList = new ErrorList();
		
		// code
		errorList.addIfNotNull(checkFormat("ZM5ZD3Xldn", obj.getCode(), ValidationFormat.CPT, true));
		
		// name
		errorList.addIfNotNull(checkFormat("ZM5ZD3Xldn", obj.getName(), ValidationFormat.CPT_CODE_DESCRIPTION, true));

        if (errorList.hasErrors()) {
            throw new FormValidationException(errorList);
        }
	}
}
