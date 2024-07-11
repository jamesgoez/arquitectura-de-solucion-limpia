package co.base.project.api.transversal.exceptions;

import co.base.project.usecase.transversal.enums.ApplicationCodesEnum;

public class RequestException extends EntryPointException {
    public RequestException(ApplicationCodesEnum applicationCodesEnum) {
        super(applicationCodesEnum);
    }
}
