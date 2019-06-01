package lk.cb006789.eea.mercstore.controller;

import lk.cb006789.eea.mercstore.models.ItemtypeModel;
import lk.cb006789.eea.mercstore.service.ItemtypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemtypeController {

    private final ItemtypeService itemtypeService;

    public ItemtypeController(ItemtypeService itemtypeService) {
        this.itemtypeService = itemtypeService;
    }


    @GetMapping("/itemtypes")
    public List<ItemtypeModel> getAllitemtypes(){
        return itemtypeService.getAlltypes();
    }
}
