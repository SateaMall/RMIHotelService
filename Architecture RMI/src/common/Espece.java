package common;

import java.io.Serializable;
// Des copies : on fait pas d'interface et on n'envoie que un objet serializ√© 
// RÈfÈrence distante : On envoie un r√ÈfÈrence de l'objet dans le registe et on fait comme d hab
public class Espece implements Serializable  { // √ßa nous permet de envoyer l'objet en s√Èrialisant cet objet (Mais vu qu'on veux pas le modifier et juste le lire en tant que copie on fait pas d'interface )
	private String name;
	private int vieMoyenne;
	
	public Espece(String name, int vieMoyenne) {
		this.name=name;
		this.vieMoyenne=vieMoyenne;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVieMoyenne() {
		return vieMoyenne;
	}
	public void setVieMoyenne(int vieMoyenne) {
		this.vieMoyenne = vieMoyenne;
	}
	@Override
	public String toString() {
		return "Espece [name=" + name + ", vieMoyenne=" + vieMoyenne + "]";
	}
	
	
}
