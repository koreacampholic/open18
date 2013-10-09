package org.domain.open18.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import org.domain.open18.entity.Tee;

@Name("teeList")
public class TeeList extends EntityQuery<Tee>
{
    public TeeList()
    {
        setEjbql("select tee from Tee tee");
    }
}
