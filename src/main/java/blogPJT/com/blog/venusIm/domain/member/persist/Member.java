package blogPJT.com.blog.venusIm.domain.member.persist;

import blogPJT.com.blog.venusIm.domain.member.vo.Birth;
import blogPJT.com.blog.venusIm.domain.member.vo.NickName;
import blogPJT.com.blog.venusIm.domain.member.vo.Password;
import blogPJT.com.blog.venusIm.domain.member.vo.RoleType;
import blogPJT.com.blog.venusIm.global.common.BaseDateEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member extends BaseDateEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_idx", nullable = false, updatable = false)
    private Long id;

    @Embedded
    private Password password;

    @Embedded
    private NickName nickName;

    @Embedded
    private Birth birth;

    @Enumerated(value = EnumType.STRING)
    private RoleType roleType;

    private String regDate;

}
