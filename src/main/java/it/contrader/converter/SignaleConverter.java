package it.contrader.converter;

import org.springframework.stereotype.Component;


import it.contrader.dto.SignaleDTO;
import it.contrader.model.Signale;

@Component
public class SignaleConverter extends AbstractConverter<Signale,SignaleDTO> {
	
	@Override
	public Signale toEntity(SignaleDTO signaleDTO) {
		Signale signale = null;
		if (signaleDTO != null) {
			signale = new Signale(signaleDTO.getIdSignale(),signaleDTO.getNameSignale(),signaleDTO.getSignaletype(),signaleDTO.getLatSignale(),signaleDTO.getLongSignale());			
		}
		return signale;
	}

	@SuppressWarnings("null")
	@Override
	public SignaleDTO toDTO(Signale signale) {
		SignaleDTO signaleDTO = null;
		if (signale != null) {
			signaleDTO = new SignaleDTO(signale.getIdSignale(),signale.getSignaletype(),signale.getSignalename(),signale.getLatSignale(),signale.getLongSignale());
		
		}
		return signaleDTO;
	}
	
}
