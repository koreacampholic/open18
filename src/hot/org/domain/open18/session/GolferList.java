package org.domain.open18.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import org.domain.open18.entity.Golfer;

@Name("golferList")
public class GolferList extends EntityQuery<Golfer>
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2350005927407951124L;

	public GolferList()
    {
        setEjbql("select golfer from Golfer golfer");
    }
}
