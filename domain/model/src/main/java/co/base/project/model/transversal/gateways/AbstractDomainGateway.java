package co.base.project.model.transversal.gateways;

import reactor.core.publisher.Mono;

public abstract class AbstractDomainGateway<I, O, R, A> {

    public Mono<A> executeDomainBusinessRules(I inputObject) {
        return Mono.justOrEmpty(inputObject)
                .map(this::buildDomainInputObject)
                .map(this::executeBusinessRules)
                .flatMap(this::buildOutputObject);
    }

    protected abstract O buildDomainInputObject(I inputObject);
    protected abstract Mono<R> executeBusinessRules(O domainInputObject);
    protected abstract Mono<A> buildOutputObject(Mono<R> domainOutputObject);

}
