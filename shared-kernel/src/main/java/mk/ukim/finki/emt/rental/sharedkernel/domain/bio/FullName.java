package mk.ukim.finki.emt.rental.sharedkernel.domain.bio;

import lombok.Getter;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class FullName implements ValueObject {
    private final String firstName;
    private final String lastName;

    public FullName() {
        this.firstName = "";
        this.lastName = "";
    }

    public FullName(@NonNull String firstName, @NonNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullName fullName = (FullName) o;
        return Objects.equals(firstName, fullName.firstName) &&
                Objects.equals(lastName, fullName.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }
}
