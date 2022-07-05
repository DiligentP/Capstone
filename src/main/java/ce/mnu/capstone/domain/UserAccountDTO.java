package ce.mnu.capstone.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserAccountDTO {

    @ApiModelProperty(example = "유저 번호")
    private Long userno;
    @ApiModelProperty(example = "유저 아이디")
    private String userid;
    @ApiModelProperty(example = "유저 패스워드")
    private String userpass;
    @ApiModelProperty(example = "유저 이름")
    private String username;
    @ApiModelProperty(example = "유저 가입일자")
    private Date regidate;

    @Builder
    public UserAccountDTO(String userid, String userpass, String username){
        this.userid = userid;
        this.userpass = userpass;
        this.username = username;
        this.regidate = new Date();
    }
}
