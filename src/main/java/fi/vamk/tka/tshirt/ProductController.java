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
public class ProductController {
	@Autowired
	private ProductRepository productRepostitory;
	@RequestMapping(value="/products",produces={"application/json","application/xml"})
	Iterable<Product> products(){
		return productRepostitory.findAll();
	}
	
	@RequestMapping(value="/products/{id}",produces={"application/json","application/xml"})
	public Optional<Product> getproduct(@PathVariable("id") int id){
		return productRepostitory.findById(id);
	}
	
    @RequestMapping(value = "/products" , method = RequestMethod.POST,produces={"application/json","application/xml"})
    public @ResponseBody Product create(@RequestBody Product item) {
    	return productRepostitory.save(item);
    } 
	
    @RequestMapping(value = "/products" , method = RequestMethod.PUT,produces={"application/json","application/xml"})
    public @ResponseBody Product update(@RequestBody Product item) {
    	return productRepostitory.save(item);
    }
	
    @RequestMapping(value = "/products" , method = RequestMethod.DELETE)
    public void delete(@RequestBody Product item) {
    	productRepostitory.delete(item);
    }
	
}
