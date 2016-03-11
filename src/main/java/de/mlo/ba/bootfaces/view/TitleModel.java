package de.mlo.ba.bootfaces.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import de.mlo.ba.bootfaces.domain.Title;
import de.mlo.ba.bootfaces.persistence.TitleRepository;

@ManagedBean(name = "titleModel", eager = true)
@RequestScoped
public class TitleModel {

    @ManagedProperty(value = "#{titleRepository}")
    TitleRepository titleRepository;
    
    @ManagedProperty(value = "#{title}")
    private TitleView title;

	    public void setTitle(TitleView title) {
	        this.title = title;
	    }

	    public TitleView getTitle() {
	        return title;
	    }

	    public TitleRepository getTitleRepository() {
	        return titleRepository;
	    }

	    public void setTitleRepository(TitleRepository employeeRepository) {
	        this.titleRepository = employeeRepository;
	    }

	    public String doCreateTitle() {
	        Title created = new Title();
	        setThisTitle(created, this.title);
	        Title newTitle = this.titleRepository.save(created);

	        FacesContext.getCurrentInstance().addMessage("errors",
	            new FacesMessage(FacesMessage.SEVERITY_INFO, "employee created",
	                "The title " + created.getTitle() + " has been created with id: " + newTitle.getId()));

	        Title employee = new Title();
	        setThisTitle(this.title, employee);

	        return "index.xhtml";
	    }

	    public void doFindTitleById() {
	        Title found = titleRepository.findOne(this.title.getId());
	        setThisTitle(this.title, found);
	    }

	    public List<TitleView> findAllTitles() {
	        List<TitleView> employees = new ArrayList<TitleView>();
	        for(Title entity : this.titleRepository.findAll()) {
	            TitleView view = new TitleView();
	            setThisTitle(view, entity);
	            employees.add(view);
	        }
	        return employees;
	    }
	    
	    public List<String> findAllTitleNames() {
	        List<String> titles = new ArrayList<String>();
	        for(Title entity : this.titleRepository.findAll()) {
	            String view = entity.getTitle();
	            titles.add(view);
	        }
	        return titles;
	    }
	    
	    private void setThisTitle(Title employee, Title setTitle) {
	        employee.setId(setTitle.getId());
	        employee.setTitle(setTitle.getTitle());
	        employee.setDegrade(setTitle.isDegrade());;

	    }
}
