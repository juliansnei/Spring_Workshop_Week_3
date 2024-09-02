package org.riwi.Spring_Workshop_Week_3.controllers.GenericMethods;

import org.springframework.http.ResponseEntity;

public interface ReadByIDControllerMethod<Entity,ID> {
    public ResponseEntity<Entity> readById(ID id);
}
