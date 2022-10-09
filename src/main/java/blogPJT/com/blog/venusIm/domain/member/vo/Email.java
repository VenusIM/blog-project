package blogPJT.com.blog.venusIm.domain.member.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public final class Email implements Serializable {

    @javax.validation.constraints.Email(message = "이메일 형식이 아닙니다.")
    @NotBlank(message = "필수 값입니다 : Email")
    @Column(unique = true, nullable = false)
    private String email;

    public static Email from(final String email) {
        return new Email(email);
    }

    @JsonValue
    public String email() {
        return email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email());
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Email email = (Email) obj;

        return Objects.equals(email(), email.email());
    }
}