package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Screen;
@Repository
@Transactional
public interface ScreenRepository extends CrudRepository<Screen, Long>{

	Screen findByOutput(String output);	
}
