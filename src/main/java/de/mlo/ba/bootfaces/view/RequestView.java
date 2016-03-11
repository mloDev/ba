package de.mlo.ba.bootfaces.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import de.mlo.ba.bootfaces.domain.Req;

@ManagedBean(name = "req", eager = true)
@RequestScoped
public class RequestView extends Req {

	public RequestView() {};
	
}
