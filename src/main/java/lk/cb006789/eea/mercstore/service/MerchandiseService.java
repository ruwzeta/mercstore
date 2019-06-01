package lk.cb006789.eea.mercstore.service;

import lk.cb006789.eea.mercstore.models.MerchandiseModel;
import lk.cb006789.eea.mercstore.repo.MerchandiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchandiseService {
    private final MerchandiseRepository merchandiseRepository;

    @Autowired
    public MerchandiseService(MerchandiseRepository merchandiseRepository) {
        this.merchandiseRepository = merchandiseRepository;
    }

    public List<MerchandiseModel> getAllMerc(){return merchandiseRepository.findAll();};

    public boolean saveMerc(MerchandiseModel merchandiseModel){ return merchandiseRepository.save(merchandiseModel)!=null;}

    /*public MerchandiseModel getMerc(String Id){
        return  merchandiseRepository.findById(Id).orElse(null) ;
    }*/


    public boolean addMerchandise(MerchandiseModel merchandiseModel){
        if (merchandiseRepository.existsByMerchandisename(merchandiseModel.getMerchandisename())){
            return false;
        }else{
            return saveMerc(merchandiseModel);
        }
    }
    public boolean deleteMerchandise(MerchandiseModel merchandiseModel){
        if (merchandiseModel.getMerchandiseitemsByMercandiseid().size() <=0 ){
            merchandiseRepository.delete(merchandiseModel);
            return true;
        }
        else{
            return false;
        }

    }

    public MerchandiseModel getMerchandiseById(String Id){return merchandiseRepository.findById(Id).orElse(null);}
}
