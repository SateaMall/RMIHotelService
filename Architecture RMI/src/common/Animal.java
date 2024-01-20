package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Animal extends Remote {
	public String getNom() throws RemoteException;
	public void setNom(String nom) throws RemoteException;
	public String getNom_maitre() throws RemoteException;
	public void setNom_maitre(String nom_maitre) throws RemoteException;
	public String getRace() throws RemoteException;
	public void setRace(String race) throws RemoteException;
	public String returnString()throws RemoteException;
	public DossierSuivi getDossier() throws RemoteException;
	public void setDossier(DossierSuivi dossier)throws RemoteException;
	public Espece getEspece()  throws RemoteException;
	public void setEspece(Espece espece)throws RemoteException;
	
	
}
