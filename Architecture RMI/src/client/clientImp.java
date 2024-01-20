package client;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import common.Animal;
import common.CabinetVeterinaire;
import common.Client;
import common.DossierSuivi;
import common.Espece;

public class clientImp extends UnicastRemoteObject implements Client {
	private Registry registry;
    private CabinetVeterinaire cabinet;
	public clientImp(int host) throws RemoteException {
	    try {	
	    	Registry registry = LocateRegistry.getRegistry(host); //connecet au registre
			CabinetVeterinaire stub = (CabinetVeterinaire) registry.lookup("Cabinet"); //chercher le cabinet dans le registre			
			stub.addClient(this); // pour ajouter les clients dans une liste dans le cabinet 
			cabinet=stub;
	    } catch (RemoteException | NotBoundException e) {
	    	e.printStackTrace();
	    }
	}
	
	public void alertClient(String msg) throws RemoteException{ //affichag alert chez le client
        System.out.println(msg);
   } 
	//deux getters
	public Registry getRegistry() {
		return registry;
	}


	public CabinetVeterinaire getCabinet() {
		return cabinet;
	}
}

