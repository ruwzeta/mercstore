package lk.cb006789.eea.mercstore.controller;


import lk.cb006789.eea.mercstore.models.MerchandiseitemModel;
import lk.cb006789.eea.mercstore.service.ItemtypeService;
import lk.cb006789.eea.mercstore.service.MerchandiseItemService;
import lk.cb006789.eea.mercstore.service.MerchandiseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MerchandiseItemController {


   private final MerchandiseItemService merchandiseItemService;
   private final MerchandiseService merchandiseService;
   private final ItemtypeService itemtypeService;


    public MerchandiseItemController(MerchandiseItemService merchandiseItemService, MerchandiseService merchandiseService, ItemtypeService itemtypeService) {
        this.merchandiseItemService = merchandiseItemService;
        this.merchandiseService = merchandiseService;
        this.itemtypeService = itemtypeService;
    }

    @GetMapping("/merchandiseitems")
    public List<MerchandiseitemModel> getAllMercitems(){
        return merchandiseItemService.getAllMercItems();
}




}
