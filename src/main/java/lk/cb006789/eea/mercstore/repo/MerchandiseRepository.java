package lk.cb006789.eea.mercstore.repo;

import lk.cb006789.eea.mercstore.models.MerchandiseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchandiseRepository extends JpaRepository<MerchandiseModel,String> {
    boolean existsByMerchandisename(String name);

}
