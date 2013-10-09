package org.domain.open18.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import org.domain.open18.entity.Golfer;

@Name("golferHome")
public class GolferHome extends EntityHome<Golfer>
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1302953155841399559L;
	
	
	@RequestParameter Long golferId;

    @Override
    public Object getId()
    {
        if (golferId == null)
        {
            return super.getId();
        }
        else
        {
            return golferId;
        }
    }

    @Override @Begin
    public void create() {
        super.create();
    }

}
