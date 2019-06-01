package lk.cb006789.eea.mercstore.repo;

import lk.cb006789.eea.mercstore.models.OfferModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferModel,String> {
}
