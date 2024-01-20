package serveur;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.CabinetVeterinaire;
import common.DossierSuivi;
import common.Espece;

public class MainServer {

	public static void main (String[] args) {
		Server server= new Server(); //lancer le server
		CabinetVeterinaire cabinet= server.getCabinet(); 
		try { 
			Espece Sange= new Espece("Sange", 73);  
			Espece Vache= new Espece("Vache", 44);
			
			
			DossierSuivi DossierT1= new DossierSuiviImp("Dépression");
			DossierSuivi DossierT2= new DossierSuiviImp("Pas intelligent");
			DossierSuivi DossierT3= new DossierSuiviImp("faible");
			
			
			AnimalImp Tom= new AnimalImp("Tom", "Seb",Sange,"Chien_rouge",DossierT1);
			AnimalImp Mo = new AnimalImp("Mo", "Seb",Vache,"Chien_bleu",DossierT2);
			AnimalImp Angela= new AnimalImp("Angela", "Seb",Sange,"Chien_blanc",DossierT3);
			
			cabinet.addPatient(Tom);
			cabinet.addPatient(Mo);
			cabinet.addPatient(Angela);
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
