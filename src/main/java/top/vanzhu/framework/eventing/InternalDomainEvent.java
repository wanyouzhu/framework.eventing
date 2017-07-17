package top.vanzhu.framework.eventing;

public interface InternalDomainEvent extends DomainEvent {

    @Override
    default String eventName() {
        return getClass().getSimpleName();
    }

}
