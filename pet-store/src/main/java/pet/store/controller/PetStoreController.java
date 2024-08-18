package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {

    @Autowired
    private PetStoreService petStoreService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetStoreData createPetStore(@RequestBody PetStoreData petStoreData) {
        log.info("Creating pet store: {}", petStoreData);
        return petStoreService.savePetStore(petStoreData);
    }
}

/*CODE FROM VIDEO
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.ContributorData;
import pet.store.service.StoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class StoreController {
  @Autowired	
  private StoreService storeService;
  
  
	@PostMapping("/contributor")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ContributorData insertContributor
	(@RequestBody ContributorData contributorData) {
		log.info("Creating contributor {}", contributorData);
		return storeService.insertContributor(contributorData);
	}
	
	@GetMapping("/contributor")
	public List<ContributorData> retrieveAllContributors() {
		log.info("Retrive all contributors called.");
		return storeService.rerieveAllContributors();
		
	}
}
*/