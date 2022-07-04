package ce.mnu.capstone.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserAccount {

    private Long userno;  // 유저 번호
    private String userid; // 유저 아이디
    private String userpass; // 유저 패스워드
    private String username; // 유저 이름
    private Date regidate; // 가입일자

    @Builder
    public UserAccount(String userid, String userpass, String username){
        this.userid = userid;
        this.userpass = userpass;
        this.username = username;
        this.regidate = new Date();
    }
}
