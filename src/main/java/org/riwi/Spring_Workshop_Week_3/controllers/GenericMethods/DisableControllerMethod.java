package org.riwi.Spring_Workshop_Week_3.controllers.GenericMethods;


public interface DisableControllerMethod <ID, Entity>{

    public Entity disableController(ID id);

}
