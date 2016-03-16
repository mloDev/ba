package de.mlo.ba.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import de.mlo.ba.domain.Req;
import de.mlo.ba.persistence.ReqRepository;
import de.mlo.ba.persistence.StudentRepository;
import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "reqModel", eager = true)
@RequestScoped
public class RequestModel {
	
	@ManagedProperty(value = "#{reqRepository}")
	@Setter
	@Getter
	ReqRepository reqRepository;
	
	private StudentRepository stRepository;
	
	@ManagedProperty(value = "#{req}")
	@Setter
	@Getter
	private RequestView request;
	
	public String doCreateRequest() {
		Req created = new Req();
		created.setId(this.request.getId());
		created.setName(this.request.getName());
		created.setStudent(stRepository.findOne(this.request.getStudent().getId()));
		
		Req newRequest = this.reqRepository.save(created);
		
        FacesContext.getCurrentInstance().addMessage("errors",
	            new FacesMessage(FacesMessage.SEVERITY_INFO, "Request created",
	                "The Request " + created.getName() + " has been created for Student: "));

	        Req request = new Req();
	        setThisRequest(this.request, request);

	        return "index.xhtml";
	}
	
    public void doFindReqById() {
        Req found = reqRepository.findOne(this.request.getId());
        setThisRequest(this.request, found);
    }
    
    public List<RequestView> findAllReqs() {
        List<RequestView> requests = new ArrayList<RequestView>();
        for(Req entity : this.reqRepository.findAll()) {
            RequestView view = new RequestView();
            setThisRequest(view, entity);
            requests.add(view);
        }
        return requests;
    }
	
	public void setThisRequest(Req request, Req setRequest) {
		request.setId(setRequest.getId());
		request.setName(setRequest.getName());
		request.setStudent(setRequest.getStudent());
		
	}
	
	

}
