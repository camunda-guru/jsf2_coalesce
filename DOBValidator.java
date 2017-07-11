package com.ness.qm.validators;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class DOBValidator implements Validator{

	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		Date date =new Date();
		Date givenDate=(Date) value;
		Calendar currentCal=Calendar.getInstance();
		Calendar dobCal=Calendar.getInstance();
		dobCal.setTime(givenDate);
		long millisecs = currentCal.getTimeInMillis()-dobCal.getTimeInMillis();
		int year = (int) (millisecs/( 365 * 24 * 60 * 60 * 1000));
		if(year<21)
		{
			FacesMessage msg = 
					new FacesMessage("Date validation failed.", 
							"Invalid date(Should have minimum 21 years ).");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
		}
	}

}
