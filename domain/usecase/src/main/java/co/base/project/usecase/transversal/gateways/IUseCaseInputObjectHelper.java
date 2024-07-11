package co.base.project.usecase.transversal.gateways;

import reactor.core.publisher.Mono;

public interface IUseCaseInputObjectHelper<I, O> {
    Mono<O> build(I inputObject);
}
