package co.base.project.usecase.notification.get.exceptions;

import co.base.project.usecase.transversal.enums.ApplicationCodesEnum;
import co.base.project.usecase.transversal.exceptions.UseCaseException;

public class NotificationNoFoundException extends UseCaseException {
    public NotificationNoFoundException(ApplicationCodesEnum applicationCodesEnum) {
        super(applicationCodesEnum);
    }
}
