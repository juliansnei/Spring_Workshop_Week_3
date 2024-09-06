package org.riwi.Spring_Workshop_Week_3.dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.riwi.Spring_Workshop_Week_3.entities.MediaEntity;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LessonRequestDTO {
    private String name;
    private String date;
    private String duration;
    private List<MediaEntity> mediaEntity;
    private  Long courseId;
}
