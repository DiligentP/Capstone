package ce.mnu.capstone.service;

import ce.mnu.capstone.domain.UserFocus;

import java.util.ArrayList;
import java.util.List;

public interface UserFocusService {

    UserFocus modifyUserFocus(UserFocus userFocus);

    ArrayList<UserFocus> getUserFocus(Long userno);

    UserFocus getUserFocusAndDate(Long userno, String all_date);

    ArrayList<UserFocus> getUserFocusStanMonth(Long userno, String ym_date);
}
