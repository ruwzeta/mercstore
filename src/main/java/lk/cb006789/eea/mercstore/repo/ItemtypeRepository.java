package lk.cb006789.eea.mercstore.repo;

import lk.cb006789.eea.mercstore.models.ItemtypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemtypeRepository extends JpaRepository<ItemtypeModel,String> {
}
