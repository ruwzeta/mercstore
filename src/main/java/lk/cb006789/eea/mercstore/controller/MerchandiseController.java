package lk.cb006789.eea.mercstore.controller;


import lk.cb006789.eea.mercstore.models.MerchandiseModel;
import lk.cb006789.eea.mercstore.service.MerchandiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MerchandiseController {

    private final MerchandiseService merchandiseService;



    public MerchandiseController(MerchandiseService merchandiseService) {
        this.merchandiseService = merchandiseService;
    }


    @GetMapping("/merchandises")
    public List<MerchandiseModel> getAllMerchandises(){
        return merchandiseService.getAllMerc();
    }




}
