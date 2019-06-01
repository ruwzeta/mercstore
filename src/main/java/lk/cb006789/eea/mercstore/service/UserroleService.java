package lk.cb006789.eea.mercstore.service;


import lk.cb006789.eea.mercstore.models.UserroleModel;
import lk.cb006789.eea.mercstore.repo.UserroleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserroleService {
    private final UserroleRepository userroleRepository;

    public UserroleService(UserroleRepository userroleRepository) {
        this.userroleRepository = userroleRepository;
    }


    public List<UserroleModel> getAllUserroles(){return userroleRepository.findAll();}

    public UserroleModel getUserroleByid(String id ){
        return userroleRepository.findById(id).orElse(null);
    }

}
