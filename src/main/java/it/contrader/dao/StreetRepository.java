package it.contrader.dao;

import javax.transaction.Transactional;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Sensor;
import it.contrader.model.Street;
import it.contrader.model.Street.Streettype;

@Repository
@Transactional
public interface StreetRepository extends CrudRepository<Street, Long>{

	Street findByStreetnameAndStreettype(String streetname, Streettype streettype);	
	
	public List<Street> findAllBySensor(Sensor sensor);
}
