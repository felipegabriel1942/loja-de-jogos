package br.com.lojajogos.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class MensagensUtil implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static void mensagemErro(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,mensagem,"");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public static void mensagemSucesso(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,mensagem,"");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
}
