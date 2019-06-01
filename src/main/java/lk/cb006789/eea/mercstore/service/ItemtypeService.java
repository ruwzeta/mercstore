package lk.cb006789.eea.mercstore.service;

import lk.cb006789.eea.mercstore.models.ItemtypeModel;
import lk.cb006789.eea.mercstore.repo.ItemtypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemtypeService {
   private final ItemtypeRepository itemtyperepo;

   @Autowired

    public ItemtypeService(ItemtypeRepository itemtyperepo) {
        this.itemtyperepo = itemtyperepo;
    }

    public List<ItemtypeModel>getAlltypes(){ return itemtyperepo.findAll();}

    public ItemtypeModel getItemtypeById(String id){
       return   itemtyperepo.findById(id).orElse(null);
   }

}
