package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import common.Animal;
import common.CabinetVeterinaire;
import common.DossierSuivi;
import common.Espece;
import common.Client;

public class CabinetVeterinaireImp extends UnicastRemoteObject implements CabinetVeterinaire{
	private ArrayList <Animal> Patients;
	private String nom;
	private ArrayList<Client> clients;
	
	
	public CabinetVeterinaireImp(String nom) throws RemoteException {
		this.Patients=new  ArrayList<Animal>();
		this.clients=new  ArrayList<Client>();
		this.nom = nom;
	}

	public ArrayList <Animal> getPatients() throws RemoteException {
		return Patients;
	}
	
	public Animal getPatient(String nom) throws RemoteException {
		for (Animal patient: Patients) {
			if (patient.getNom().equals(nom)) {
				return patient;
			}
		}
		return null;
	}

	public String getNom() throws RemoteException{
		return nom;
	}

	public void setNom(String nom) throws RemoteException{
		this.nom = nom;
	}
	
	public int size() throws RemoteException{
		return this.Patients.size();
	}
	public boolean patientExiste(String nom)throws RemoteException{
		
		for(Animal a: Patients) {
			if(a.getNom().equals(nom)) {
				return true;
			}
		} 
		return false;
	}
	
	public String returnString()throws RemoteException{
		String names = "Names of patients:";
		for(Animal a: Patients) {
			names+=","+a.getNom();
		}
		return names;
	}
	
	public String addPatient(Animal newPatient)throws RemoteException{
		this.Patients.add(newPatient);
		if (this.size()>=500){	alertClients(500);}
		else if(this.size()>=200) { alertClients(200); }
		else if(this.size()>=100) { alertClients(100); }
		return newPatient.getNom();
	}
		
	public String addPatient(String nom, String nom_maitre,Espece espece,String race, String etat) throws RemoteException { //la mpricipale 
		DossierSuivi dossier= new DossierSuiviImp(etat);
		Animal newAnimal= new AnimalImp( nom,  nom_maitre, espece, race,  dossier);
		 return addPatient(newAnimal);
	}

	public String addPatient(String nom, String nom_maitre,String especeNom, int vieMoyenne,String race, String etat) throws RemoteException {
		DossierSuivi dossier= new DossierSuiviImp(etat);
		Animal newAnimal= new AnimalImp( nom, nom_maitre, especeNom,  vieMoyenne, race, dossier);
		return addPatient(newAnimal);
}
	
	public void addClient (Client client) throws RemoteException{
		this.clients.add(client);
	}
	
	public void alertClients (int number) throws RemoteException { //
		String message ="Warning! the animals in the cabinet has passed "+number+"animals!";
		for (Client client: clients) {
			client.alertClient(message);
		}
	}
}
