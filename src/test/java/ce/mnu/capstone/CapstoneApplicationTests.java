package ce.mnu.capstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ce.mnu.capstone.repository.UserAccountRepository;

@SpringBootTest
class CapstoneApplicationTests {

    @Autowired
    UserAccountRepository userAccountRepository;

}
