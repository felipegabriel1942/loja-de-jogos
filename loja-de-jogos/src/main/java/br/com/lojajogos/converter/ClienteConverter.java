package br.com.lojajogos.converter;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.lojajogos.model.Cliente;
import br.com.lojajogos.service.ClienteService;

@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				ClienteService service = (ClienteService) context.getExternalContext().getApplicationMap()
						.get("clienteService");
				return service.pesquisarClientePorCodigo(Long.parseLong(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na conversão", "Cliente não encontrado"));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return String.valueOf(((Cliente) value).getPkcliente());
		} else {
			return null;
		}
	}

}
