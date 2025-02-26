package co.base.project.usecase.transversal.gateways;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface  IUseCase<I, O> {
    Mono<O> execute(Mono<I> inputUseCaseObject);
}
