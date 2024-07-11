package co.base.project.api.transversal.exceptions;

import co.base.project.usecase.transversal.enums.ApplicationCodesEnum;

public class RequestNoBodyException extends EntryPointException {
    public RequestNoBodyException(ApplicationCodesEnum applicationCodesEnum) {
        super(applicationCodesEnum);
    }
}
