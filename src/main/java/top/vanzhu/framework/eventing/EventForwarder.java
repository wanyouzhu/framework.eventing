package top.vanzhu.framework.eventing;

public interface EventForwarder {

    void forward(DomainEvent event);

    void forward(DomainEvent event, String routingHint);

}
