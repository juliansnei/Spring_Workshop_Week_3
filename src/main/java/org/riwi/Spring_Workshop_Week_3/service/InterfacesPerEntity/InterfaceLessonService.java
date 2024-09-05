package org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity;

import org.riwi.Spring_Workshop_Week_3.dtos.Request.LessonRequestDTO;
import org.riwi.Spring_Workshop_Week_3.dtos.Response.LessonResponseDTO;
import org.riwi.Spring_Workshop_Week_3.entities.LessonEntity;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.Disable;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.ReadAll;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.ReadByID;
import org.riwi.Spring_Workshop_Week_3.service.CRUD.Save;

public interface InterfaceLessonService  extends
        Disable<LessonResponseDTO, Long>,
        Save<LessonEntity, LessonRequestDTO>,
        ReadAll<LessonResponseDTO>,
        ReadByID<LessonResponseDTO,Long>
{
}
