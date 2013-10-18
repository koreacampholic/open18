package org.domain.open18.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class PhaseTracker implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3289981226232122365L;

	@Override
	public void afterPhase(PhaseEvent event) {
		event.getFacesContext().getExternalContext()
				.log("AFTER " + event.getPhaseId());

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		event.getFacesContext().getExternalContext()
		.log("BEFORE " + event.getPhaseId());

	}

	@Override
	public PhaseId getPhaseId() {
		
		return PhaseId.ANY_PHASE;
	}

}
