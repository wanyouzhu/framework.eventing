package top.vanzhu.framework.eventing;

import org.springframework.util.Assert;

public class RoutableExternalDomainEvent {

    private final String routingHint;
    private final DomainEvent event;

    public RoutableExternalDomainEvent(String routingHint, DomainEvent event) {
        Assert.hasText(routingHint, "The routing-hint  of a routable-domain-event can not be blank.");
        Assert.notNull(event, "The wrapped event of a routable-domain-event can not be null.");
        this.routingHint = routingHint;
        this.event = event;
    }

    public String getRoutingHint() {
        return routingHint;
    }

    public DomainEvent event() {
        return event;
    }

}
