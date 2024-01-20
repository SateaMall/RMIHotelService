package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.DossierSuivi;

public class DossierSuiviImp extends UnicastRemoteObject implements DossierSuivi {
	private String texte;
	public DossierSuiviImp(String texte) throws RemoteException {
		super();
		this.texte=texte;
	}
	public String getTexte() throws RemoteException{
		return texte;
	}
	public void setTexte(String texte)throws RemoteException {
		this.texte = texte;
	}
	@Override
	public String returnString() throws RemoteException{ //Pour tester
		return "DossierSuiviImp [texte=" + texte + "]";
	}
	
	
}
