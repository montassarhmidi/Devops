package tn.esprit.spring.services;

import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
 
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {

	@Autowired
	IEntrepriseService us;
	
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImplTest.class);
	
	@Test
	public void ajouterentreprise(){
	
	Entreprise e = new Entreprise();
    e.setName("Esprit");
    e.setRaisonSocial("Ecole Superieur");
   
     us.ajouterEntreprise(e);
     l.info("Entreprise "+ e + "ajouter !!");
	}
	
	@Test
	public void deleteEntrepriseById() {
		try {	
			us.deleteEntrepriseById(1);
			
			l.info("Entreprise "+ 1 +" supprimer !!");
			}
			catch (Exception e) { l.error("Erreur dans deleteEmployeById() : " + e); }
			}
	
	@Test
	public void ajouterDepartement() throws ParseException {
		try {	
		Departement u1=new Departement("Bloc H");
		
us.ajouterDepartement(u1);
l.info("Departement "+ u1 + "ajouter !!");
		}
		catch (Exception e) { l.error("Erreur dans ajouterDepartement() : " + e); }
		
	}
	
	@Test
	public void deleteDepartementById() {
		try {	
			us.deleteDepartementById(4);
			
			l.info("Departement "+ 4 +" supprimer !!");
			}
			catch (Exception e) { l.error("Erreur dans deleteDepartementById() : " + e); }
			}
	

@Test
public void getEntrepriseById() {
	try {	
		us.getEntrepriseById(4);
		
		l.info("Entreprise ");
		}
		catch (Exception e) { l.error("Erreur dans getEntrepriseById() : " + e); }
		}



@Test
public void getAllDepartementsNamesByEntreprise() {
	try {	
		us.getAllDepartementsNamesByEntreprise(4);
		
		l.info("Departement ");
		}
		catch (Exception e) { l.error("Erreur dans getAllDepartementsNamesByEntreprise() : " + e); }
		}

@Test
public void affecterDepartementAEntreprise() {
	try {	
		us.affecterDepartementAEntreprise(4,4);
		
		l.info("Departement " + 4 +"affecter a entreprise" +4);
		}
		catch (Exception e) { l.error("Erreur dans getAllDepartementsNamesByEntreprise() : " + e); }
		}

}

