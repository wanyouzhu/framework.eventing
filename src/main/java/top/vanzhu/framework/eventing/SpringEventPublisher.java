package top.vanzhu.framework.eventing;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SpringEventPublisher implements EventPublisher, ApplicationEventPublisherAware {

    private ApplicationEventPublisher impl;

    @Override
    public void publish(DomainEvent event) {
        impl.publishEvent(event);
    }

    @Override
    public void publish(Collection<DomainEvent> events) {
        events.forEach(x -> impl.publishEvent(x));
    }

    @Override
    public void publish(DomainEvent event, String routingHint) {
        impl.publishEvent(new RoutableExternalDomainEvent(routingHint, event));
    }

    @Override
    public void publish(Collection<DomainEvent> events, String routingHint) {
        events.forEach(x -> impl.publishEvent(new RoutableExternalDomainEvent(routingHint, x)));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.impl = applicationEventPublisher;
    }

}
