package ce.mnu.capstone.repository;

import ce.mnu.capstone.domain.UserAccount;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class    JpaAccountRepository implements UserAccountRepository{

    private final EntityManager em;

    public JpaAccountRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public UserAccount save(UserAccount user) {
        em.persist(user);
        return user;
    }

    @Override
    public Optional<UserAccount> findById(Long id) {
        UserAccount user = em.find(UserAccount.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<UserAccount> findByName(String name) {
        List<UserAccount> result = em.createQuery("select u from UserAccount u where u.username = :name",UserAccount.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<UserAccount> findAll() {
        return em.createQuery("select u from UserAccount u", UserAccount.class)
                .getResultList();
    }


}
