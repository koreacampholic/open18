package org.domain.open18.richfaces;

import org.domain.open18.richface.bean.Bean4Model;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.log.Log;
import org.jboss.seam.international.StatusMessages;

@Name("bean4")
public class Bean4
{
    @Logger private Log log;

    @In StatusMessages statusMessages;
    @In Bean4Model	   bean4model;
    
    

    
    public void countAction()
    {
        // implement your business logic here
        log.info("bean4.countAction() action called");
        statusMessages.add("countAction");
        if(null == bean4model.getName()) bean4model.setName("");
        bean4model.setCount(bean4model.getName().length());
    }



	

    // add additional action methods

}
