package mk.ukim.finki.emt.rental.sharedkernel.infra.eventlog;

import mk.ukim.finki.emt.rental.sharedkernel.domain.base.RemoteEventLog;

public interface RemoteEventLogService {

    String source();

    RemoteEventLog currentLog(long lastProcessedId);

}
