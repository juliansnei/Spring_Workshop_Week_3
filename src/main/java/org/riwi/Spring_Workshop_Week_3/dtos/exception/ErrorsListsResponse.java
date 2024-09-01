package org.riwi.Spring_Workshop_Week_3.dtos.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class ErrorsListsResponse extends ErrorSimple{
    private List<String> errors;
}
