package lk.cb006789.eea.mercstore.repo;

import lk.cb006789.eea.mercstore.models.ShoppingcartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShoppingcartRepository extends JpaRepository<ShoppingcartModel,String> {
    boolean existsByUseraccByUserid(String id);
}
