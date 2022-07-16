package blogPJT.com.blog.venusIm.domain.member.entity;

import blogPJT.com.blog.venusIm.domain.member.entity.vo.Birth;
import blogPJT.com.blog.venusIm.domain.member.entity.vo.NickName;
import blogPJT.com.blog.venusIm.domain.member.entity.vo.Password;
import blogPJT.com.blog.venusIm.domain.member.entity.vo.RoleType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

    @Id
    @Column(name = "member_idx")
    private Long id;

    @Embedded
    private Password password;

    @Embedded
    private NickName nickName;

    @Embedded
    private Birth birth;

    @Embedded
    private RoleType roleType;

    private String regDate;

}
