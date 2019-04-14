package fi.vamk.tka.tshirt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepostitory;
	@RequestMapping(value="/customers",produces={"application/json","application/xml"})
	Iterable<Customer> customers(){
		return customerRepostitory.findAll();
	}
	
	@RequestMapping(value="/customer/{id}",produces={"application/json","application/xml"})
	public Optional<Customer> getCustomer(@PathVariable("id") int id){
		return customerRepostitory.findById(id);
	}
	
    @RequestMapping(value = "/customer" , method = RequestMethod.POST,produces={"application/json","application/xml"})
    public @ResponseBody Customer create(@RequestBody Customer item) {
    	return customerRepostitory.save(item);
    } 
	
    @RequestMapping(value = "/customer" , method = RequestMethod.PUT,produces={"application/json","application/xml"})
    public @ResponseBody Customer update(@RequestBody Customer item) {
    	return customerRepostitory.save(item);
    }
	
    @RequestMapping(value = "/customer" , method = RequestMethod.DELETE)
    public void delete(@RequestBody Customer item) {
    	customerRepostitory.delete(item);
    }
	
}
