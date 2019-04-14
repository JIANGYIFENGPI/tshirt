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
public class OrdelineController {
	@Autowired
	private OrderlineRepository orderlineRepostitory;
	@RequestMapping(value="/orderlines",produces={"application/json","application/xml"})
	Iterable<Orderline> orderlines(){
		return orderlineRepostitory.findAll();
	}
	
	@RequestMapping(value="/orderline/{id}",produces={"application/json","application/xml"})
	public Optional<Orderline> getOrderline(@PathVariable("id") int id){
		return orderlineRepostitory.findById(id);
	}
	
    @RequestMapping(value = "/orderline" , method = RequestMethod.POST,produces={"application/json","application/xml"})
    public @ResponseBody Orderline create(@RequestBody Orderline item) {
    	return orderlineRepostitory.save(item);
    } 
	
    @RequestMapping(value = "/orderline" , method = RequestMethod.PUT,produces={"application/json","application/xml"})
    public @ResponseBody Orderline update(@RequestBody Orderline item) {
    	return orderlineRepostitory.save(item);
    }
	
    @RequestMapping(value = "/orderline" , method = RequestMethod.DELETE)
    public void delete(@RequestBody Orderline item) {
    	orderlineRepostitory.delete(item);
    }
	
}
