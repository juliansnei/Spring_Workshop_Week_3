package org.riwi.Spring_Workshop_Week_3.service.CRUD;

public interface Save<Entity,EntityDTO>{
    public Entity save(EntityDTO entity);
}
