package org.domain.open18.richface.bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.intercept.PostConstruct;


@Name("bean")
public class Bean {

	private String selection;
	private List<String> renderComponents;

	@Create	
	public void init() {
		renderComponents = new ArrayList<String>();
		renderComponents.add("updateButton");
	}

	public void selectComponents(AjaxBehaviorEvent event) {
		renderComponents.add(selection);
	}

	public List<String> getRenderComponents() {
		return renderComponents;
	}

	public String getSelection() {
		return selection;
	}

	public void setSelection(String selection) {
		this.selection = selection;
	}

	public Date getClock1() {
		return new Date();
	}

	public Date getClock2() {
		return new Date();
	}

	public Date getClock3() {
		return new Date();
	}
}
