package lk.cb006789.eea.mercstore.repo;

import lk.cb006789.eea.mercstore.models.UseraccModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UseraccRepository extends JpaRepository<UseraccModel,String> {
}
