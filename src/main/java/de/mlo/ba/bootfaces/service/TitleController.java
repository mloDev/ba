package de.mlo.ba.bootfaces.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.mlo.ba.bootfaces.domain.Title;
import de.mlo.ba.bootfaces.persistence.TitleRepository;

public class TitleController {

	@Autowired
	private TitleRepository titleRepository;
	
	@RequestMapping("/service/titles")
    public @ResponseBody
    List<Title> getAllTitles() {
        return this.titleRepository.findAll();
    }
    
    @RequestMapping(value="/service/title/{id}", method=RequestMethod.GET)
    public @ResponseBody Title getTitleById(@PathVariable Long id) {
        return this.titleRepository.findOne(id);
    }
}
