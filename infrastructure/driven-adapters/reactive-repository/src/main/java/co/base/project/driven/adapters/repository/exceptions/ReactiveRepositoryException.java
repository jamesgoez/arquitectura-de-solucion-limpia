package co.base.project.driven.adapters.repository.exceptions;

import co.base.project.usecase.transversal.enums.ApplicationCodesEnum;
import co.base.project.usecase.transversal.exceptions.UseCaseException;

public class ReactiveRepositoryException extends UseCaseException {
    public ReactiveRepositoryException(ApplicationCodesEnum applicationCodesEnum) {
        super(applicationCodesEnum);
    }
}
