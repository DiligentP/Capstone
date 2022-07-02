package ce.mnu.capstone.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
public class UserAccount {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userno;  // 유저 번호
    private String userid; // 유저 아이디
    private String userpass; // 유저 패스워드
    private String username; // 유저 이름
    private String userphone; // 유저 폰번호
    private String useremail; // 유저 이메일
    private Long userage; // 유저 나이
    private Date regidate; // 가입일자

    @Builder
    public UserAccount(String userid, String userpass, String username, String userphone, String useremail, Long userage){
        this.userid = userid;
        this.userpass = userpass;
        this.username = username;
        this.userphone = userphone;
        this.useremail = useremail;
        this.userage = userage;
        this.regidate = new Date();
    }
}
