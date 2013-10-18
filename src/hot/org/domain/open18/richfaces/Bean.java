package org.domain.open18.richfaces;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.intercept.PostConstruct;


@Name("bean")
@Scope(ScopeType.CONVERSATION)
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

	public String getClock1() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		return format.format(new Date());
	}

	public String getClock2() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		return format.format(new Date());
	}

	public String getClock3() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		return format.format(new Date());
	}

	
	
	
}
