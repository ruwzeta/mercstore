package lk.cb006789.eea.mercstore.service;


import lk.cb006789.eea.mercstore.models.UseraccModel;
import lk.cb006789.eea.mercstore.repo.UseraccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UserAccService {
    private final UseraccRepository useraccRepository;
    private final UserroleService userroleService;

    @Autowired
    public UserAccService(UseraccRepository useraccRepository, UserroleService userroleService) {
        this.useraccRepository = useraccRepository;
        this.userroleService = userroleService;
    }



    public List<UseraccModel> getAllUsers(){return useraccRepository.findAll();}

    public boolean saveUser (UseraccModel useraccModel){return useraccRepository.save(useraccModel) != null ;}

}
