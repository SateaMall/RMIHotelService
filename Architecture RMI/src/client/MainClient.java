package client;

import java.rmi.RemoteException;
import common.Animal;
import common.CabinetVeterinaire;

public class MainClient {

	public static void main(String[] args) {
		//String host = (args.length < 1)? null : args[0];    
		try {
			clientImp client= new clientImp(1099); //lancer le client
			CabinetVeterinaire cabinet= client.getCabinet();
			
			Animal Tom=cabinet.getPatient("Tom"); //vérifier l'existance de Tom(un patient)
			
			System.out.println("Server response: Informations about"+Tom.getNom()+":"+ Tom.returnString());
			System.out.println("Server response:  Information about his Species: "+Tom.getEspece()); //test
			
			//traitement de Tom
			Tom.getDossier().setTexte("Guéri");
			System.out.println("The patient Tom has been treated!");
			
			System.out.println("Server response:  Information about Tom after treatement: "+Tom.returnString());
			
			System.out.println("------------ Deuxième partie -----------");

			System.out.println("Server response: Informations about the cabinet: "+cabinet.returnString());
			System.out.println("Est ce que le patient Mo existe?: "+ cabinet.patientExiste("Mo"));
			System.out.println("Est ce que le patient Jean existe?: "+cabinet.patientExiste("Jean"));
		
		
			String nomChat= cabinet.addPatient( "Miao", "Gabi", "Chat", 87, "vert",  "Tousse"); // retourn le nom 
			System.out.println("Est ce que le patient "+ nomChat +"(ajouté par le client) existe?: "+cabinet.patientExiste(nomChat)); 
			System.out.println("Est ce que le patient "+ "Sev (il n'existe pas) " +"existe?: "+cabinet.patientExiste("Sev")); 
		
			System.out.println("------------ Troisième partie -----------");
			Dog Huski = new Dog("dog", 25, "Huski");
			String dog1= cabinet.addPatient( "Jacque", "Roger",Huski ,"Huski",  "malade");
			System.out.println("Est ce que le patient "+ dog1 +"(ajouté par le client) existe? (codeBase) : "+cabinet.patientExiste(dog1));
		
	}
		catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
