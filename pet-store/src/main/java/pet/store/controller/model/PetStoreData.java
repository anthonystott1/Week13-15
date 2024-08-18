package pet.store.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class PetStoreData {
	private Long petStoreId;
    private String petStoreName;
    private String petStoreAddress;
    private String petStoreCity;
    private String petStoreState;
    private String petStoreZip;
    private String petStorePhone;
    private Set<PetStoreCustomer> customers;
    private Set<PetStoreEmployee> employees;

    // Constructor that takes a PetStore entity and converts it to a DTO
    public PetStoreData(PetStore petStore) {
        petStoreId = petStore.getPetStoreId();
        petStoreName = petStore.getPetStoreName();
        petStoreAddress = petStore.getPetStoreAddress();
        petStoreCity = petStore.getPetStoreCity();
        petStoreState = petStore.getPetStoreState();
        petStoreZip = petStore.getPetStoreZip();
        petStorePhone = petStore.getPetStorePhone();
        this.customers = petStore.getCustomers().stream().map(PetStoreCustomer::new).collect(Collectors.toSet());
        this.employees = petStore.getEmployees().stream()
            .map(PetStoreEmployee::new)
            .collect(Collectors.toSet());
    }

    // Inner class for PetStoreCustomer
    @Data
    @NoArgsConstructor
    public static class PetStoreCustomer {
    	private Long customerId;
        private String customerFirstName;
        private String customerLastName;
        private String customerEmail;

        // Constructor that takes a Customer entity and converts it to a DTO
        public PetStoreCustomer(Customer customer) {
        	customerId = customer.getCustomerId();
        	customerFirstName = customer.getCustomerFirstName();
            customerLastName = customer.getCustomerLastName();
            customerEmail = customer.getCustomerEmail();
        }
    }

    // Inner class for PetStoreEmployee
    @Data
    @NoArgsConstructor
    public static class PetStoreEmployee {
    	private Long employeeId;
        private String employeeFirstName;
        private String employeeLastName;
        private String employeePhone;
        private String employeeJobTitle;
        // Constructor that takes an Employee entity and converts it to a DTO
        public PetStoreEmployee(Employee employee) {
        	employeeId = employee.getEmployeeId();
            employeeFirstName = employee.getEmployeeFirstName();
            employeeLastName = employee.getEmployeeLastName();
            employeePhone = employee.getEmployeePhone();
            employeeJobTitle = employee.getEmployeeJobTitle();
        }
    }
}


/*CODE FROM VIDEOS
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
public class ContributorData {
	  private Long customerId;
	  private String customerFirstName;
	  private String customerLastName;
	  private String customerEmail;
      private Set<PetStoreResponse> petStores = new HashSet<>();
      
      public ContributorData(ContributorData save) {
    	  contributorId = contributor.getContributorId();
    	  contributorName = contributor.getContributorName();
    	  contributorEmail = contributor.getContributorEmail();
    	  
    	  for(PetStore petStore : contributor.getPetStore()) {
    		  petStore.add(new PetStoreResponse(petStore));
    	  }
      }
      
@Data
@NoArgsConstructor
      static class PetStoreResponse {
    	    private Long petStoreId;
    	    private String petStoreName;
    	    private String petStoreAddress;
    	    private String petStoreCity;
    	    private String petStoreState;
    	    private String petStoreZip;
    	    private String petStorePhone;
    	    private Set<String> customers = new HashSet<>();
    	    private Set<Employee> employees;
    	    
    	    PetStoreResponse(PetStore petStore)
    	    petStoreId = petStore.getPetStoreId();
    	    storeName = petStore.getPetStoreName();
    	    address = petStore.getPetStoreAddress();
    	    city = petStore.getPetStoreCity();
    	    state = petStore.getPetStoreState();
    	   zipCode = petStore.getPetStoreZip();
    	   
   }
}
*/
