package org.riwi.Spring_Workshop_Week_3.service.CRUD;

import java.util.List;

public interface ReadBySpecific <Entity,field>{
    public List<Entity> readBySpecific(field name, field description);
}
