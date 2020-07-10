package mk.ukim.finki.emt.rental.cdcatalog.application;

import mk.ukim.finki.emt.rental.cdcatalog.domain.model.Cd;
import mk.ukim.finki.emt.rental.cdcatalog.domain.model.CdId;
import mk.ukim.finki.emt.rental.cdcatalog.domain.repository.CdRepository;
import mk.ukim.finki.emt.rental.cdcatalog.integration.RentItemAddedEvent;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class CdCatalog {
    private final CdRepository cdRepository;

    public CdCatalog(CdRepository cdRepository) {
        this.cdRepository = cdRepository;
    }

    @NonNull
    public List<Cd> findAll() {
        return cdRepository.findAll();
    }

    @NonNull
    public Optional<Cd> findById(@NonNull CdId cdId) {
        Objects.requireNonNull(cdId, "cdId must not be null");
        return cdRepository.findById(cdId);
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void onRentCreatedEvent(RentItemAddedEvent event) {
        Cd cd = cdRepository.findById(event.getCdId()).orElseThrow(RuntimeException::new);
        cd.setUnavailable();
        cdRepository.save(cd);
    }
}
