package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CabinetVeterinaire extends Remote {
	
	public ArrayList<Animal> getPatients() throws RemoteException;
	public String getNom() throws RemoteException;
	public void setNom(String nom) throws RemoteException;
	public int size() throws RemoteException;
	public String returnString()throws RemoteException;
	public boolean patientExiste(String nom)throws RemoteException;
	public String addPatient(Animal newPatient)throws RemoteException;
	public String addPatient(String nom, String nom_maitre,Espece espece,String race, String etat) throws RemoteException ;
	public String addPatient(String nom, String nom_maitre,String especeNom, int vieMoyenne,String race, String etat) throws RemoteException;
	public void addClient (Client client) throws RemoteException;
	public Animal getPatient(String nom) throws RemoteException ;
}
