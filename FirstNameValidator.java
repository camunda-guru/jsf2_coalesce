package com.ness.qm.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class FirstNameValidator implements Validator {
	private static final String regex="^[A-Za-z\\s]*$";
    private Pattern pattern;
    private Matcher matcher;
    public FirstNameValidator()
    {
    	pattern=Pattern.compile(regex);
    }
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, 
			Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		matcher=pattern.matcher(value.toString());
		if(!matcher.matches())
		{
			FacesMessage msg = 
					new FacesMessage("First Name validation failed.", 
							"Invalid First Name(Should contain "
							+ "only alphabets).");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			
		}
		
	}

}
