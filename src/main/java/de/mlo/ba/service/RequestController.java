package de.mlo.ba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.mlo.ba.domain.Req;
import de.mlo.ba.persistence.ReqRepository;

public class RequestController {

	@Autowired
	private ReqRepository requestRepository;
	
	@RequestMapping("/service/reqs")
    public @ResponseBody
    List<Req> getAllReqs() {
        return this.requestRepository.findAll();
    }
    
    @RequestMapping(value="/service/req/{id}", method=RequestMethod.GET)
    public @ResponseBody Req getRequestById(@PathVariable Long id) {
        return this.requestRepository.findOne(id);
    }
}
