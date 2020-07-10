package mk.ukim.finki.emt.rental.sharedkernel.domain.bio;

import lombok.Getter;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.rental.sharedkernel.domain.exceptions.InvalidEmailException;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class Email implements ValueObject {
    private final String email;

    public Email() {
        this.email = "";
    }

    public Email(String email) {
        if (email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")) {
            throw new InvalidEmailException();
        }
        this.email = email;
    }

    public Email change(String value) {
        return new Email(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return email;
    }
}
