package org.domain.open18.session;

import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;
import org.domain.open18.entity.Course;
import org.domain.open18.entity.Hole;
import org.domain.open18.entity.Tee;

@Name("holeHome")
public class HoleHome extends EntityHome<Hole>
{
	@In(create = true)
	CourseHome courseHome;

	public void setHoleId(Long id) {
		setId(id);
	}

	public Long getHoleId() {
		return (Long) getId();
	}

	@Override
	protected Hole createInstance() {
		Hole hole = new Hole();
		return hole;
	}

	public void wire() {
		getInstance();
		Course course = courseHome.getDefinedInstance();
		if (course != null) {
			getInstance().setCourse(course);
		}
	}

	public boolean isWired() {
		if (getInstance().getCourse() == null)
			return false;
		return true;
	}

	public Hole getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Tee> getTees() {
		return getInstance() == null ? null : new ArrayList<Tee>(getInstance()
				.getTees());
	}
}
