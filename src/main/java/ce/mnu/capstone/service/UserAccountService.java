package ce.mnu.capstone.service;

import ce.mnu.capstone.repository.UserAccountRepository;

import javax.transaction.Transactional;

@Transactional
public class UserAccountService {

    private UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }
}
