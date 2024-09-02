package org.riwi.Spring_Workshop_Week_3.controllers.GenericMethods;



import java.util.List;

public interface ReadAllControllerMethod <Entity> {

    public List<Entity> readAll();


}
