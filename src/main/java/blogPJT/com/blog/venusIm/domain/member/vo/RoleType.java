package blogPJT.com.blog.venusIm.domain.member.entity.vo;

import javax.persistence.Embeddable;

@Embeddable
public enum RoleType {
    ADMIN,      // 관리자
    STUDENT,    // 학생
    SPARE,      // 예비
    CURRENT     // 취업
}
