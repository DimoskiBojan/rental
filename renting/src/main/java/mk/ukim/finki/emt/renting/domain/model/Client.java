package mk.ukim.finki.emt.renting.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.rental.sharedkernel.domain.geo.Address;
import mk.ukim.finki.emt.rental.sharedkernel.domain.bio.Email;
import mk.ukim.finki.emt.rental.sharedkernel.domain.bio.FullName;
import mk.ukim.finki.emt.rental.sharedkernel.domain.bio.PhoneNumber;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "client")
public class Client extends AbstractEntity<ClientId> {

    @Version
    private Long version;

    @Embedded
    private FullName fullName;

    @Embedded
    private Address address;

    @Embedded
    private Email email;

    @Embedded
    private PhoneNumber phoneNumber;

    private Client() {}

    public Client(@NonNull FullName fullName, @NonNull Address address, @NonNull Email email, PhoneNumber phone) {
        super(DomainObjectId.randomId(ClientId.class));
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phone;
    }

    public Client(ClientId id, @NonNull FullName fullName, @NonNull Address address, @NonNull Email email, PhoneNumber phone) {
        super(id);
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phone;
    }

}
