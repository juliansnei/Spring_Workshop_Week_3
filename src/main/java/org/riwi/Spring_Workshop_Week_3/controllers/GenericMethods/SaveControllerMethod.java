package org.riwi.Spring_Workshop_Week_3.controllers.GenericMethods;

public interface SaveControllerMethod<Entity,EntityDTO>{
    public Entity save(EntityDTO entity);
}
