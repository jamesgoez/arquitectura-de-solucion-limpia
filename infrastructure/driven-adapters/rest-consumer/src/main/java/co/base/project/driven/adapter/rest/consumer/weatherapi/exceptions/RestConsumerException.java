package co.base.project.driven.adapter.rest.consumer.weatherapi.exceptions;

import co.base.project.usecase.transversal.enums.ApplicationCodesEnum;
import co.base.project.usecase.transversal.exceptions.UseCaseException;

public class RestConsumerException extends UseCaseException {
    public RestConsumerException(ApplicationCodesEnum applicationCodesEnum, String message) {
        super(applicationCodesEnum, message);
    }
}