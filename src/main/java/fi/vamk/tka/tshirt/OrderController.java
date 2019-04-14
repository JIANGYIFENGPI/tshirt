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
public class OrderController {
	@Autowired
	private OrderRepository orderRepostitory;
	@RequestMapping(value="/orders",produces={"application/json","application/xml"})
	Iterable<Order> orders(){
		return orderRepostitory.findAll();
	}
	
	@RequestMapping(value="/order/{id}",produces={"application/json","application/xml"})
	public Optional<Order> getOrder(@PathVariable("id") int id){
		return orderRepostitory.findById(id);
	}

	@RequestMapping(value = "/order", method = RequestMethod.GET,produces={"application/json","application/xml"})
	public @ResponseBody Order getOrder(@RequestBody Order item) {
    	return orderRepostitory.save(item);
	} 
	
	@RequestMapping(value = "/order" , method = RequestMethod.POST,produces={"application/json","application/xml"})
    public @ResponseBody Order create(@RequestBody Order item) {
    	return orderRepostitory.save(item);
	} 
	
	
    @RequestMapping(value = "/order" , method = RequestMethod.PUT,produces={"application/json","application/xml"})
    public @ResponseBody Order update(@RequestBody Order item) {
    	return orderRepostitory.save(item);
    }
	
    @RequestMapping(value = "/order" , method = RequestMethod.DELETE)
    public void delete(@RequestBody Order item) {
    	orderRepostitory.delete(item);
    }
	
}
