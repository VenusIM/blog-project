package blogPJT.com.blog.venusIm.domain.member.persist;

import blogPJT.com.blog.venusIm.domain.member.vo.*;
import blogPJT.com.blog.venusIm.global.common.BaseDateEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_IDX", nullable = false, updatable = false)
    private Long id;

    @Embedded
    private Email email;

    @Embedded
    private Password password;

    @Embedded
    private NickName nickName;

    private LocalDate birth;

    @Enumerated(value = EnumType.STRING)
    private RoleType roleType;

    private Boolean isActivate;

    @Builder
    private Member(Long id, Email email, Password password, NickName nickName, LocalDate birth, RoleType roleType) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickName = nickName;
        this.birth = birth;
        this.roleType = roleType;
        this.isActivate = true;
    }

    public Member encode(final PasswordEncoder encoder) {
        password = Password.encode(password.password(), encoder);
        return this;
    }

    public Member update(final Member member, final PasswordEncoder encoder) {
        this.password = Password.encode(member.getPassword().password(), encoder);
        this.nickName = member.getNickName();
        return this;
    }

    public void delete() {
        isActivate = false;
        deleteDate();
    }



}
