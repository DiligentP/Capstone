package ce.mnu.capstone.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter @NoArgsConstructor @AllArgsConstructor
@Table(name = "user_account")
public class UserAccount {

    @ApiModelProperty(name = "유저 번호")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userno;
    @ApiModelProperty(name = "유저 아이디")
    private String userid;
    @ApiModelProperty(name = "유저 패스워드")
    private String userpass;
    @ApiModelProperty(name = "유저 이름")
    private String username;
    @ApiModelProperty(name = "유저 가입일자")
    private Date regidate;

    @Builder
    public UserAccount(String userid, String userpass, String username){
        this.userid = userid;
        this.userpass = userpass;
        this.username = username;
        this.regidate = new Date();
    }
}
