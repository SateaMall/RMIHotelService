package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.Animal;
import common.DossierSuivi;
import common.Espece;

public class AnimalImp extends UnicastRemoteObject implements Animal {

private String nom;
private String nom_maitre;
private Espece espece;
private String race;
private DossierSuivi dossier;

public AnimalImp(String nom, String nom_maitre,Espece espece,String race, DossierSuivi dossier) throws RemoteException {
	super();
	this.nom=nom;
	this.nom_maitre=nom_maitre;
	this.espece=espece;
	this.race=race;
	this.dossier= dossier;
}

public AnimalImp(String nom, String nom_maitre,String especeNom, int vieMoyenne,String race, DossierSuivi dossier) throws RemoteException {
	super();
	this.nom=nom;
	this.nom_maitre=nom_maitre;
	
	Espece espece = new Espece (especeNom,vieMoyenne);
	this.espece=espece;
	this.race=race;
	this.dossier= dossier;
}


public DossierSuivi getDossier() throws RemoteException{
	return dossier;
}

public void setDossier(DossierSuivi dossier)throws RemoteException {
	this.dossier = dossier;
}

public String getNom()  throws RemoteException{
	return nom;
}
public void setNom(String nom) throws RemoteException {
	this.nom = nom;
}
public String getNom_maitre()  throws RemoteException{
	return nom_maitre;
}
public void setNom_maitre(String nom_maitre)  throws RemoteException{
	this.nom_maitre = nom_maitre;
}
public Espece getEspece()  throws RemoteException{
	return espece;
}
public void setEspece(Espece espece)  throws RemoteException{
	this.espece = espece;
}
public String getRace()  throws RemoteException{
	return race;
}
public void setRace(String race)  throws RemoteException{
	this.race = race;
}
@Override
public String returnString() throws RemoteException {
	return "Animal [nom=" + nom + ", nom_maitre=" + nom_maitre + ", espece=" + espece + ", race=" + race + "/n" +this.dossier.returnString()+"]";
}

}
