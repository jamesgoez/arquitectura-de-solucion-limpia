package co.base.project.usecase.task.save.exceptions;

import co.base.project.usecase.transversal.enums.ApplicationCodesEnum;
import co.base.project.usecase.transversal.exceptions.UseCaseException;

public class InvalidDayOfProofException extends UseCaseException {
    public InvalidDayOfProofException(ApplicationCodesEnum applicationCodesEnum) {
        super(applicationCodesEnum);
    }
}
