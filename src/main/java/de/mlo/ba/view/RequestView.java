package de.mlo.ba.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import de.mlo.ba.domain.Req;

@ManagedBean(name = "req", eager = true)
@RequestScoped
public class RequestView extends Req {

	public RequestView() {};
	
}
