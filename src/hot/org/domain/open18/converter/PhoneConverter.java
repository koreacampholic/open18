package org.domain.open18.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.faces.Converter;
import org.jboss.seam.annotations.intercept.BypassInterceptors;


@Name("org.open18.PhoneConverter")
@Converter
@BypassInterceptors
@Scope(ScopeType.CONVERSATION)
public class PhoneConverter implements javax.faces.convert.Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if(context==null || component==null){
			throw new NullPointerException();
		}
		if(value==null || "".equals(value)){
			return null;
		}
		String digits = value.replaceAll("[^0-9]", "");
		if(digits.length() == 1){
			// country code not supported
			digits = digits.substring(1);
		}
		if(digits.length()!=10){
			throw new ConverterException(
					new FacesMessage(FacesMessage.SEVERITY_WARN
				    ,"Invalid phone number: " + value
				    ,"Invalid number of digits in phone number."));
		}
		return digits;
	}
	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value == null) {
			return "";
		}
		
		return (String) value;
	}

}
