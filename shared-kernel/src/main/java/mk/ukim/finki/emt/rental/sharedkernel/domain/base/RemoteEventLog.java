package mk.ukim.finki.emt.rental.sharedkernel.domain.base;

import mk.ukim.finki.emt.rental.sharedkernel.infra.eventlog.StoredDomainEvent;

import java.util.List;

public interface RemoteEventLog {

    List<StoredDomainEvent> events();

}