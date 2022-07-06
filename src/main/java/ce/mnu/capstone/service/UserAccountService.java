package ce.mnu.capstone.service;

import ce.mnu.capstone.domain.UserAccount;

import java.util.Optional;

public interface UserAccountService {

    UserAccount getUser(Long userno);

    UserAccount Register(UserAccount userAccount);

    UserAccount Login(String id, String pass);

    void Deregister(Long userno);

}
