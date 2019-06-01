package lk.cb006789.eea.mercstore.service;

import lk.cb006789.eea.mercstore.models.ShoppingcartModel;
import lk.cb006789.eea.mercstore.models.ShoppingcartitemModel;
import lk.cb006789.eea.mercstore.repo.ShoppingcartRepository;
import lk.cb006789.eea.mercstore.repo.UseraccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingcartService {
    private final ShoppingcartRepository shoppingcartRepository;
    private final UseraccRepository useraccRepository;

    @Autowired

    public ShoppingcartService(ShoppingcartRepository shoppingcartRepository, UseraccRepository useraccRepository) {
        this.shoppingcartRepository = shoppingcartRepository;
        this.useraccRepository = useraccRepository;
    }
    public boolean saveCart(ShoppingcartModel shoppingcartModel){
        return shoppingcartRepository.save(shoppingcartModel)!=null;
    }
    /*public ShoppingcartModel getCartbyuser(String id){
        if(shoppingcartRepository.existsByUseraccByUserid(id)){


            return ShoppingcartModel ;
        }
    }*/


}
