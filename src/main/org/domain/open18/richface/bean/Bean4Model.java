package org.domain.open18.richface.bean;

import org.jboss.seam.annotations.Name;

@Name("bean4model")
public class Bean4Model {
	
	private String name;
    private Integer count;
    
    public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getCount() {
		return count;
	}



	public void setCount(Integer count) {
		this.count = count;
	}

}
