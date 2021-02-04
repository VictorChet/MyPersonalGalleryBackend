package viktor_chetvertukhin.MyPersonalGallery.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import viktor_chetvertukhin.MyPersonalGallery.business.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount getUserAccountById(Long id);

    UserAccount getUserAccountByUsername(String username);
}
