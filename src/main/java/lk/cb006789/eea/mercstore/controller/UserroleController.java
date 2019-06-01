package lk.cb006789.eea.mercstore.controller;


import lk.cb006789.eea.mercstore.models.UserroleModel;
import lk.cb006789.eea.mercstore.service.UserroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserroleController {

    private final UserroleService userroleService;

    @Autowired
    public UserroleController(UserroleService userroleService) {
        this.userroleService = userroleService;
    }

    @GetMapping("/userroles")
    public List<UserroleModel> getUserroles(){ return userroleService.getAllUserroles();}

}
