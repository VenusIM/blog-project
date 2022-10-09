package blogPJT.com.blog.venusIm.domain.member.persist;

import blogPJT.com.blog.venusIm.domain.member.util.TestPasswordEncoder;
import blogPJT.com.blog.venusIm.domain.member.vo.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

public class MemberTest {

    public static final Email TEST_EMAIL = Email.from("yim3370@gmail.com");
    public static final Password TEST_PASSWORD = Password.from("123456789");
    public static final NickName TEST_NICKNAME = NickName.from("venus");
    public static final LocalDate TEST_BIRTH = LocalDate.of(1999, 2, 5);

    private static Member toEntity() {
        return Member.builder()
                .id(1L)
                .email(TEST_EMAIL)
                .password(TEST_PASSWORD)
                .nickName(TEST_NICKNAME)
                .birth(TEST_BIRTH)
                .roleType(RoleType.ADMIN)
                .build();
    }

    @Test
    @DisplayName("Builder Test.")
    void builderTest() {
        Member.builder()
                .password(Password.from("12345678910"))
                .nickName(NickName.from("venusIm"))
                .roleType(RoleType.ADMIN)
                .build();
    }

    @Test
    @DisplayName("Password encoding Test")
    void encodingTest() {
        final PasswordEncoder passwordEncoder = TestPasswordEncoder.init();

        Member member = toEntity().encode(passwordEncoder);

        assertAll(
                () -> assertThat(member.getPassword()).isNotEqualTo(TEST_PASSWORD),
                () -> assertThat(passwordEncoder.matches(TEST_PASSWORD.password(),
                        member.getPassword().password())).isTrue()
        );
    }
}
