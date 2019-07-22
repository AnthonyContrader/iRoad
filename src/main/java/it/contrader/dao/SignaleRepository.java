package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Signale;
import it.contrader.model.Signale.Signaletype;
@Repository
@Transactional
public interface SignaleRepository extends CrudRepository<Signale, Long>{

	Signale findBySignalenameAndSignaletype(String signalename, Signaletype signaletype);	
}
