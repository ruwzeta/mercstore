package lk.cb006789.eea.mercstore.repo;

import lk.cb006789.eea.mercstore.models.UserroleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserroleRepository extends JpaRepository<UserroleModel,String> {
}
