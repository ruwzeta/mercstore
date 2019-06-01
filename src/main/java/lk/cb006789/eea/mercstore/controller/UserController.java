package lk.cb006789.eea.mercstore.controller;


import lk.cb006789.eea.mercstore.models.UseraccModel;
import lk.cb006789.eea.mercstore.models.UserroleModel;
import lk.cb006789.eea.mercstore.service.UserAccService;
import lk.cb006789.eea.mercstore.service.UserroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserAccService userAccService;
    private final UserroleService userroleService;

    @Autowired

    public UserController(UserAccService userAccService, UserroleService userroleService) {
        this.userAccService = userAccService;
        this.userroleService = userroleService;
    }

    @GetMapping("/users/userrole/{id}")
    public UserroleModel getUserrole(@PathVariable String id){
        return  userroleService.getUserroleByid(id);
    }


    @GetMapping("/users")
    public List<UseraccModel> getUsers(){
        return userAccService.getAllUsers();
    }



}
