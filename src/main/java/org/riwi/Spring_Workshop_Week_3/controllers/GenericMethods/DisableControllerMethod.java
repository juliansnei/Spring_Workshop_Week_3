package org.riwi.Spring_Workshop_Week_3.controllers.GenericMethods;


public interface DisableControllerMethod <Entity, ID>{
    public Entity update(ID id, Entity entity);
}
