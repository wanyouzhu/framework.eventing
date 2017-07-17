package top.vanzhu.framework.eventing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExternalDomainEventForwarder {

    private List<EventForwarder> forwarders;

    @Autowired
    public ExternalDomainEventForwarder(List<EventForwarder> forwarders) {
        this.forwarders = forwarders;
    }

    @EventHandler
    public void forwardExternalEvent(ExternalDomainEvent event) {
        forwarders.forEach(x -> x.forward(event));
    }

    @EventHandler
    public void forwardRoutableExternalEvent(RoutableExternalDomainEvent event) {
        forwarders.forEach(x -> x.forward(event.event(), event.getRoutingHint()));
    }

}
