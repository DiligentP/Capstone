import ce.mnu.capstone.domain.UserAccount;
import ce.mnu.capstone.repository.JpaAccountRepository;
import ce.mnu.capstone.repository.UserAccountRepository;
import ce.mnu.capstone.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class CapstoneConfig {

    @PersistenceContext
    private EntityManager em;

    @Bean
    public UserAccountService AccountService() {return new UserAccountService(userAccountRepository());}

    @Bean
    public UserAccountRepository userAccountRepository() {
        return new JpaAccountRepository(em);
    }
}
