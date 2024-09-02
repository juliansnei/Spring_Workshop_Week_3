package org.riwi.Spring_Workshop_Week_3.controllers.GenericMethods;

public interface ReadByIDControllerMethod <Entity, ID> {

    public Entity readByID(ID id);
}
