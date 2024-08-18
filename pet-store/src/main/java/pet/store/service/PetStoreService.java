package pet.store.service;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;
import pet.store.entity.PetStore;

@Service
public class PetStoreService {

    @Autowired
    private PetStoreDao petStoreDao;

    public PetStoreData savePetStore(PetStoreData petStoreData) {
        PetStore petStore = findOrCreatePetStore(petStoreData.getPetStoreId());
        copyPetStoreFields(petStore, petStoreData);
        PetStore savedPetStore = petStoreDao.save(petStore);
        return new PetStoreData(savedPetStore);
    }

    private PetStore findOrCreatePetStore(Long petStoreId) {
        if (petStoreId == null) {
            return new PetStore();
        } else {
            return petStoreDao.findById(petStoreId)
                .orElseThrow(() -> new NoSuchElementException(
                    "Pet store with ID " + petStoreId + " not found."));
        }
    }

    private void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
        petStore.setPetStoreName(petStoreData.getPetStoreName());
        petStore.setPetStoreAddress(petStoreData.getPetStoreAddress());
        petStore.setPetStorePhone(petStoreData.getPetStorePhone());
        // Copy other fields as necessary
    }
}


/* CODE FROM VIDOES 
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.store.Dao.ContributorDao;
import pet.store.controller.model.ContributorData;

@Service 
public class StoreService {
	
	@Autowired
	private ContributorDao contributorDao;

	@Transactional(readOnly = false)
	public ContributorData insertContributor(ContributorData contributorData) {
		Long contributorId = contributorData.getContributorId();
		findOrCreateContributor(contributorId);
		
		setFieldsInContributor(contributor, contributorData);
		return new contributorData(contributorDao.save(contributor));
		}
	
	private void setFieldsInContributor(Contributor contributor, ContributorData contributorData) {
		contributor.setContributorEmail(ContributorData.getContributorEmail());
		contributor.setContributorEmail(ContributorData.getContributorName());
	}
	
	private Contributor findOrCreateContributor(Long contributorId) {
		Contributor contributor;
		if(Objects.isNull(contributor))  {
			contributor = new Contributor();
		}
		else {
			contributor = findContributorById(contributorId);
			
					
	}
	
	private Contributor findOrCreateContributor(Long contributorId) {
		
		
		 {
			}
		
			return contributor
					
	}
	
	private Contributor findContributorById(Long contributorId) {
		return contributorDao.findById(contributorId).orElseThrow(() -> new NoSuchElementException("Contributor with ID=" + contributorId + "was not found."));
	}
	@Transactional(readOnly = true)
	public List<ContributorData> rerieveAllContributors() {
		List<Contributor> contributor = contributorDao.findAll();
		java.util.List<ContributorData> response = new LinkedList<>();
		
		for(Contributor contributor : contributors) {
			response.add(new ContributorData(contributor));
			}
		
		return response;
	}

}
*/
