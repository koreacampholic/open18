package org.domain.open18.session;

import java.util.Arrays;
import java.util.List;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import org.domain.open18.entity.Course;

@Name("courseList")
public class CourseList extends EntityQuery<Course> {
	private static final String[] RESTRICTIONS = {
			"lower(course.description) like concat(lower(#{courseList.course.description}),'%')",
			"lower(course.designer) like concat(lower(#{courseList.course.designer}),'%')",
			"lower(course.fairways) like concat(lower(#{courseList.course.fairways}),'%')",
			"lower(course.greens) like concat(lower(#{courseList.course.greens}),'%')",
			"lower(course.name) like concat(lower(#{courseList.course.name}),'%')", };

	private Course course = new Course();

	@Override
	public String getEjbql() {
		return "select course from Course course";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	@Override
	public String getOrder() {
		if (super.getOrder() == null) {
			setOrder("name asc");
		}
		return super.getOrder();
	}

	public Course getCourse() {
		return course;
	}
	@Override
	public List<String> getRestrictionExpressionStrings() {
		return Arrays.asList(RESTRICTIONS);
	}

	
}
