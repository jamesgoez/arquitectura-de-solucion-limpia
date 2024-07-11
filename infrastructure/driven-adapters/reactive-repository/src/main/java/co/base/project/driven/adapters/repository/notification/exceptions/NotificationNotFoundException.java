package co.base.project.driven.adapters.repository.notification.exceptions;

import co.base.project.driven.adapters.repository.exceptions.ReactiveRepositoryException;
import co.base.project.usecase.transversal.enums.ApplicationCodesEnum;

public class NotificationNotFoundException extends ReactiveRepositoryException {
    public NotificationNotFoundException(ApplicationCodesEnum applicationCodesEnum) {
        super(applicationCodesEnum);
    }
}