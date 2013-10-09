package org.domain.open18.session;

import java.util.Arrays;
import java.util.List;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import org.domain.open18.entity.Hole;

@Name("holeList")
public class HoleList extends EntityQuery<Hole>
{
	private static final String[] RESTRICTIONS = {"lower(hole.name) like concat(lower(#{holeList.hole.name}),'%')",};

	private Hole hole = new Hole();

	@Override
	public String getEjbql() {
		return "select hole from Hole hole";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	public Hole getHole() {
		return hole;
	}

	@Override
	public List<String> getRestrictionExpressionStrings() {
		return Arrays.asList(RESTRICTIONS);
	}

}
