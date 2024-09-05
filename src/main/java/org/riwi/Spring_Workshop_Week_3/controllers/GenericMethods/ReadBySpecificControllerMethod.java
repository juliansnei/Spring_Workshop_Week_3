package org.riwi.Spring_Workshop_Week_3.controllers.GenericMethods;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReadBySpecificControllerMethod <Entity,field>{
    public ResponseEntity<List<Entity>> readBySpecific(field name, field description);
}
