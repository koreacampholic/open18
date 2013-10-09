package org.domain.open18.session;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.log.Log;
import org.jboss.seam.international.StatusMessages;

@Name("registerAction")
public class RegisterAction
{
    @Logger private Log log;

    @In StatusMessages statusMessages;

    public void register()
    {
        // implement your business logic here
        log.info("registerAction.register() action called");
        statusMessages.add("register");
    }

    // add additional action methods

}
