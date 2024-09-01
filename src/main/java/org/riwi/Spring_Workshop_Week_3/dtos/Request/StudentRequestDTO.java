package org.riwi.Spring_Workshop_Week_3.dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {
    private String name;
    private String email;
}
