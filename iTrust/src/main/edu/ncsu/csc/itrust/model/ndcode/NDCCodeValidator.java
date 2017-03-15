package edu.ncsu.csc.itrust.model.ndcode;

import edu.ncsu.csc.itrust.exception.ErrorList;
import edu.ncsu.csc.itrust.exception.FormValidationException;
import edu.ncsu.csc.itrust.model.POJOValidator;
import edu.ncsu.csc.itrust.model.ValidationFormat;

public class NDCCodeValidator extends POJOValidator<NDCCode>{

    @Override
    public void validate(NDCCode obj) throws FormValidationException {
        ErrorList errorList = new ErrorList();
        
        // NDCCode
        errorList.addIfNotNull(checkFormat("vNQkDXD96y", obj.getCode(), ValidationFormat.ND, true));

        // Description
        errorList.addIfNotNull(checkFormat("vNQkDXD96y", obj.getDescription(), ValidationFormat.ND_CODE_DESCRIPTION, true));
        
        if (errorList.hasErrors()) {
            throw new FormValidationException(errorList);
        }
    }

}
