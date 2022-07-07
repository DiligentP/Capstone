package ce.mnu.capstone.service;

import ce.mnu.capstone.domain.UserFocus;

public interface UserFocusService {

    UserFocus modifyUserFocus(UserFocus userFocus);

    UserFocus getUserFocus(Long userno);
}
