package ce.mnu.capstone.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserRankDTO {
    private Long userno;
    private String userid;
    private String username;
    private Long focustime;
}
