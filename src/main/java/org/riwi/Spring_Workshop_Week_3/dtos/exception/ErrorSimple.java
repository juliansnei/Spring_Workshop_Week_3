package org.riwi.Spring_Workshop_Week_3.dtos.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ErrorSimple {
    private Integer code;
    private String status;
}
