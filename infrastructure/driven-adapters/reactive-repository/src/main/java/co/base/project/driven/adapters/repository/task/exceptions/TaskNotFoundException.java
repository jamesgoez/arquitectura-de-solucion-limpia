package co.base.project.driven.adapters.repository.task.exceptions;

import co.base.project.driven.adapters.repository.exceptions.ReactiveRepositoryException;
import co.base.project.usecase.transversal.enums.ApplicationCodesEnum;

public class TaskNotFoundException extends ReactiveRepositoryException {
    public TaskNotFoundException(ApplicationCodesEnum applicationCodesEnum) {
        super(applicationCodesEnum);
    }
}
