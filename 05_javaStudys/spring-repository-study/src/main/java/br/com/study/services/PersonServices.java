package br.com.study.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.study.model.Person;


@Service
public class PersonServices {

	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	
	public List<Person> findAllPersons() {
		List<Person> persons = new ArrayList<>();
		for(int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	
	public Person create(Person person) {
		logger.info("create one person!");

		return person;
	}
	
	public Person update(Person person) {
		logger.info("update one person!");

		return person;
	}
	
	public void delete(String id) {
		logger.info("delete one person!");

	}
	
	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstname("Primeiro Nome" + i);
		person.setLastname("Segundo Nome" + i);
		person.setAdress("Algum Endereço" + i);
		person.setGender("MaleFemale");
		
		return person;
	}


	public Person findById(String id) {
		logger.info("finding one person!");
		Person person = new Person();
		
		person.setId(counter.incrementAndGet());
		person.setFirstname("Falcão");
		person.setLastname("Quer morrer");
		person.setAdress("City of jampa");
		person.setGender("Masqueta");
		
		return person;
	}
}
