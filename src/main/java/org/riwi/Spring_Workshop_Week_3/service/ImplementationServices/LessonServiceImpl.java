package org.riwi.Spring_Workshop_Week_3.service.ImplementationServices;

import org.riwi.Spring_Workshop_Week_3.dtos.Request.LessonRequestDTO;
import org.riwi.Spring_Workshop_Week_3.dtos.Request.MediaEntityDTO;
import org.riwi.Spring_Workshop_Week_3.dtos.Response.LessonResponseDTO;
import org.riwi.Spring_Workshop_Week_3.entities.LessonEntity;
import org.riwi.Spring_Workshop_Week_3.entities.MediaEntity;
import org.riwi.Spring_Workshop_Week_3.repository.Interfaces.LessonRepository;
import org.riwi.Spring_Workshop_Week_3.service.InterfacesPerEntity.InterfaceLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements InterfaceLessonService {
    @Autowired
    private LessonRepository interfaceLesson;

    @Override
    public LessonResponseDTO update(Long id, LessonResponseDTO lessonResponseDTO) {
        return null;
    }

    @Override
    public List<LessonResponseDTO> readAll() {
        return null;
    }

    @Override
    public LessonResponseDTO readById(Long id) {
        return null;
    }


    @Override
    public LessonEntity save(LessonRequestDTO entity) {
    LessonEntity lessonEntity = LessonEntity.builder()
            .name(entity.getName())
            .duration(entity.getDuration())
            .date(entity.getDate())
            .build();

        List<MediaEntity> mediaEntities = entity.getMediaEntity().stream()
                .map(mediaEntityDTO -> MediaEntity.builder()
                        .mediaType(mediaEntityDTO.getMediaType())
                        .title(mediaEntityDTO.getTitle())
                        .build())
                .collect(Collectors.toList());
        lessonEntity.setMediaEntities(mediaEntities);
        
        lessonEntity = interfaceLesson.save(lessonEntity);

        return lessonEntity;
    }
}
