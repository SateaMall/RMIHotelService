package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DossierSuivi extends Remote{
	public String getTexte()throws RemoteException;
	public void setTexte(String texte)throws RemoteException;
	public String returnString()throws RemoteException;
}
