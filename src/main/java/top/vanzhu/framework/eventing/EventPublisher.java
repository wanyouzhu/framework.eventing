package top.vanzhu.framework.eventing;

import java.util.Collection;

public interface EventPublisher {

    void publish(DomainEvent event);

    void publish(Collection<DomainEvent> events);

    void publish(DomainEvent event, String routingHint);

    void publish(Collection<DomainEvent> events, String routingHint);

}
