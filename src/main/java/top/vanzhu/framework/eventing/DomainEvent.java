package top.vanzhu.framework.eventing;

import java.util.UUID;

public interface DomainEvent {

    default String eventId() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    String eventName();

    Object eventPayload();

}
