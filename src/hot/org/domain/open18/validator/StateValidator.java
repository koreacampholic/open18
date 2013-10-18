package org.domain.open18.validator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;

import org.domain.open18.lookup.StateLookup;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.faces.Validator;
import org.jboss.seam.annotations.intercept.BypassInterceptors;

@Name("org.open18.StateValidator")
@Validator
@BypassInterceptors
@Scope(ScopeType.CONVERSATION)
public class StateValidator implements javax.faces.validator.Validator{

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		if (context == null || component == null) {
			throw new NullPointerException();
		}

		if (value == null || "".equals(value)) {
			return;
		}

		if (!(value instanceof String)) {
			throw new ValidatorException(
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Expecting a string value for state",
					"Expecting a string value for state")
			);
		}

		for (String abbr : StateLookup.abbreviations) {
			if (abbr.equals(value)) {
				return;
			}
		}

		throw new ValidatorException(
			new FacesMessage(FacesMessage.SEVERITY_ERROR,
				"Invalid state: " + value,
				"Invalid state: " + value)
		);
		
	}

}
