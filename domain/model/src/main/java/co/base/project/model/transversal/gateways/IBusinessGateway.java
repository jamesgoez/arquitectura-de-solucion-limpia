package co.base.project.model.transversal.gateways;

import reactor.core.publisher.Mono;

public interface IBusinessGateway<I, O> {
    Mono<O> executeBusinessRules(I outputObject);
}
