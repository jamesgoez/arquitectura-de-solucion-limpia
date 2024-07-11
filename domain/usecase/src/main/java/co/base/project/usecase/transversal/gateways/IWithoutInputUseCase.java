package co.base.project.usecase.transversal.gateways;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface IWithoutInputUseCase<O> {
    Mono<O> execute();
}
