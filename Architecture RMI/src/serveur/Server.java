package serveur;
import java.rmi.AlreadyBoundException ;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Animal;
import common.CabinetVeterinaire;
import common.DossierSuivi;
import common.Espece;

public class Server {
	private Registry registry;
	private CabinetVeterinaire cabinet;
	

public Server() {
	try {
		System.setProperty("java.rmi.server.codebase","file:/home/e20200007833/Bureau/L2/JAVA/TD1/dm/Archi-TP1/codeBase");
		registry = LocateRegistry.createRegistry(1099); // créer registre
		cabinet= new CabinetVeterinaireImp("Cabinet");  // créer cabinet
		if(registry==null) { // afficher un message d'erruer si le registre n'pas était créer 
			System.err.println("Registry not found");
		}
		else {
			registry.bind("Cabinet",cabinet); // on met le cabinet dans le registre 
			System.err.println("Server is working!");
		}
	} catch (RemoteException | AlreadyBoundException e) {
		e.printStackTrace();
	}
	
	}
// deux methodes getters
		public CabinetVeterinaire getCabinet() {
			return cabinet;
		}	

		public Registry getRegistry() {
			return registry;
		}
	}
