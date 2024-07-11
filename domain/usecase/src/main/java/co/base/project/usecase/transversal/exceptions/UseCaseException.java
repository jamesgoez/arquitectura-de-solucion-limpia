package co.base.project.usecase.transversal.exceptions;

import co.base.project.usecase.transversal.enums.ApplicationCodesEnum;
import lombok.Getter;

@Getter
public class UseCaseException extends RuntimeException {

    private final ApplicationCodesEnum applicationCodesEnum;

    public UseCaseException(ApplicationCodesEnum applicationCodesEnum) {
        super();
        this.applicationCodesEnum = applicationCodesEnum;
    }

    public UseCaseException(ApplicationCodesEnum applicationCodesEnum, String message) {
        super(message);
        this.applicationCodesEnum = applicationCodesEnum;
    }
}
