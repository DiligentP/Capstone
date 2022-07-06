package ce.mnu.capstone.repository;

import ce.mnu.capstone.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *  JpaRepository 를 사용하면 기본적인 CRUD 매서드는 제공한다. (재정의 가능)
 *  또한, @Repository 어노테이션을 붙이지 않아도 된다.
 *  JpaRepository 는 <엔티티, @Id 의 리턴타입> 로 구성된다.
 */
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

        UserAccount findByUserno(Long userno);

        UserAccount findByUseridAndUserpass(String userid, String userpass);

}
