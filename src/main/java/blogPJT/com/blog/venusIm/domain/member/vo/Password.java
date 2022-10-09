package blogPJT.com.blog.venusIm.domain.member.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Embeddable
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class Password {

    @NotBlank(message = "password : 필수 값입니다.")
    @Length(min = 10)
    @Column(nullable = false)
    private String password;

    public static Password from(final String password) {
        return new Password(password);
    }

    public static Password encode(final String rawPassword, final PasswordEncoder encoder) {
        validate(rawPassword);
        return new Password(encoder.encode(rawPassword));
    }

    private static void validate(final String password) {
        if(Objects.isNull(password) || password.isBlank()) {
            throw new NullPointerException("password NullPointException");
        }
    }

    @JsonValue
    public String password() {
        return password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(password());
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Password password = (Password) obj;

        return Objects.equals(password(), password.password());
    }
}
