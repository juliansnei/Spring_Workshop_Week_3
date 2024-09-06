package org.riwi.Spring_Workshop_Week_3.dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.riwi.Spring_Workshop_Week_3.Enum.MediaType;

@Getter
@Setter
@Builder
public class MediaEntityDTO {
    @NotBlank
    private String title;
    @NotNull
    private MediaType mediaType;
    private Long courseId;
}
