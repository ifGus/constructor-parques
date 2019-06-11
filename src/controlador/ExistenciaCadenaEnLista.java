package controlador;

import java.util.ArrayList;

public class ExistenciaCadenaEnLista {
	
	public ExistenciaCadenaEnLista(){
		
	}
	
	public boolean exite(ArrayList<String> lista, String elemento){
		
		boolean existe = false;
		
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).equalsIgnoreCase(elemento)){
				existe = true;
				break;
			}
		}
		return existe;
	}

}
