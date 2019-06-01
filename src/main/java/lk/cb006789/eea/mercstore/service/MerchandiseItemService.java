package lk.cb006789.eea.mercstore.service;


import lk.cb006789.eea.mercstore.models.MerchandiseitemModel;
import lk.cb006789.eea.mercstore.repo.ItemtypeRepository;
import lk.cb006789.eea.mercstore.repo.MerchandiseRepository;
import lk.cb006789.eea.mercstore.repo.MerchandiseitemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchandiseItemService {
   private final MerchandiseRepository merchandiseRepo;
   private final MerchandiseitemRepository merchandiseitemRepo;
   private final ItemtypeRepository itemtypeRepo;

    @Autowired
    public MerchandiseItemService(MerchandiseRepository merchandiseRepo, MerchandiseitemRepository merchandiseitemRepo, ItemtypeRepository itemtypeRepo) {
        this.merchandiseRepo = merchandiseRepo;
        this.merchandiseitemRepo = merchandiseitemRepo;
        this.itemtypeRepo = itemtypeRepo;
    }


    public List<MerchandiseitemModel> getAllMercItems(){
        return merchandiseitemRepo.findAll();
    }



}
