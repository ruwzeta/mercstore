package lk.cb006789.eea.mercstore.repo;

import lk.cb006789.eea.mercstore.models.SaleitemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SaleitemRepository extends JpaRepository<SaleitemModel,String> {
}
