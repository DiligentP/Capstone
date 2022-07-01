package ce.mnu.capstone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ce.mnu.capstone.repository.UserAccountRepository;
import ce.mnu.capstone.repository.UserAccount;

@SpringBootTest
class CapstoneApplicationTests {

    @Autowired
    UserAccountRepository userAccountRepository;

}
