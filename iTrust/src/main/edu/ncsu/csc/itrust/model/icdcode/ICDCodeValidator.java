package edu.ncsu.csc.itrust.model.icdcode;

import edu.ncsu.csc.itrust.exception.ErrorList;
import edu.ncsu.csc.itrust.exception.FormValidationException;
import edu.ncsu.csc.itrust.model.POJOValidator;
import edu.ncsu.csc.itrust.model.ValidationFormat;

public class ICDCodeValidator  extends POJOValidator<ICDCode>{

    @Override
    public void validate(ICDCode obj) throws FormValidationException {
        ErrorList errorList = new ErrorList();
        
        // code
        errorList.addIfNotNull(checkFormat("uh3SR1BSp9", obj.getCode(), ValidationFormat.ICD10CM, true));

        // name
        errorList.addIfNotNull(checkFormat("uh3SR1BSp9", obj.getName(), ValidationFormat.ICD_CODE_DESCRIPTION, true));

        if (errorList.hasErrors()) {
            throw new FormValidationException(errorList);
        }
    }

}
