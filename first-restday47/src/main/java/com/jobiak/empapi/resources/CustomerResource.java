package com.jobiak.empapi.resources;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jobiak.empapi.model.Customer;
import com.jobiak.empapi.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

	@Autowired
	CustomerService service;
	
	@CrossOrigin(origins= {"*"},maxAge=4800,allowCredentials="false")
	@GetMapping(value="/display",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer>showAll(){
		return service.getAll();
	}
	
	@CrossOrigin(origins= {"*"},maxAge=4800,allowCredentials="false")
	@GetMapping(value="/customer",produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer showCatalog()
	{
		Customer customer=new Customer();
		customer.setCusid(111L);
		customer.setName("Mouli");
		customer.setBalance(89000);
		
	return customer;
	}
	
	
	@GetMapping("/intro")
	public String introduction() {
		return new String("The API for customer relationships");
	}
	
	/*
	 * @GetMapping("/search/{modelId}/brand/{brand}") public String
	 * searchModel(@PathVariable(value="modelId")String
	 * modelId,@PathVariable(value="brand")String brand) { return new
	 * String(modelId+brand+"currently not available for your location"); }
	 */
	@CrossOrigin(origins= {"*"},maxAge=4800,allowCredentials="false")
	@PostMapping(value="/create",consumes =MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Customer addCustomer(@RequestBody Customer customer) {
		
		//System.out.println(mobile);
		//repo.save(mobile);
		Customer ref= service.addCustomer(customer);
		return ref;
	}
	@CrossOrigin(origins= {"*"},maxAge=4800,allowCredentials="false")
	@PutMapping(value="/modify",consumes =MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	     public Customer modifyProduct(@RequestBody Customer customer) {
		Customer ref=service.modifyCustomer(customer);
		return ref;
	}
	@CrossOrigin(origins= {"*"},maxAge=4800,allowCredentials="false")
	@DeleteMapping(value="/remove/{mid}")
	public void removeCustomer(@PathVariable(value="mid")Long cusid) {
		service.removeCustomer(cusid);
	}
}