package co.base.project.api.transversal.exceptions;

import co.base.project.usecase.transversal.enums.ApplicationCodesEnum;
import co.base.project.usecase.transversal.exceptions.UseCaseException;

public class EntryPointException extends UseCaseException {

    public EntryPointException(ApplicationCodesEnum applicationCodesEnum) {
        super(applicationCodesEnum);
    }

    public EntryPointException(ApplicationCodesEnum applicationCodesEnum, String message) {
        super(applicationCodesEnum, message);
    }

}
