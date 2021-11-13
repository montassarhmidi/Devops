package tn.esprit.spring.services;



import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {
	private static final Logger l=LogManager.getLogger(EmployeServiceImplTest.class);
	
	@Autowired
	IEmployeService e;

	@Test
	public void testGetNombreEmployeJPQL() {
		Integer i=e.getNombreEmployeJPQL();
    	l.info(i);
    	Employe emp = new Employe();
        emp.setNom("Chouchan");
        emp.setPrenom("Samir");
        emp.setEmail("samirch@esprit.tn");
        e.ajouterEmploye(emp);
        
        l.info("Nbr:"+e.getAllEmployeNamesJPQL());
        assertEquals(i+1, e.getNombreEmployeJPQL());
	}

}
