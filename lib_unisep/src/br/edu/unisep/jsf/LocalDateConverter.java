package br.edu.unisep.jsf;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "localDateConverter")
public class LocalDateConverter implements javax.faces.convert.Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		LocalDate data = null;
		try {
			data = LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Erro ao converter LocalDate", "Conteúdo não é uma data válida");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(msg);
		}

		return data;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			LocalDate dateValue = (LocalDate) value;
			return dateValue.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} else {
			return "";
		}
	}
}
