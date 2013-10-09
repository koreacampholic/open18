package org.domain.open18.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import org.domain.open18.entity.TeeSet;

@Name("teeSetList")
public class TeeSetList extends EntityQuery<TeeSet>
{
    public TeeSetList()
    {
        setEjbql("select teeSet from TeeSet teeSet");
    }
}
