package controlador;

import java.util.ArrayList;

public class ListasPlan {
	
	private ArrayList<String> listaDescanso;
	private ArrayList<String> listaNinios;
	private ArrayList<String> listaRecreacion;
	private ArrayList<String> listaGeneral;
	private ArrayList<String> listaAreas;
	
	public ListasPlan() {
		
		this.listaDescanso = new ArrayList<>();
		this.listaNinios = new ArrayList<>();
		this.listaRecreacion = new ArrayList<>();
		this.listaGeneral = new ArrayList<>();
		this.listaAreas = new ArrayList<>();
		
		listaDescanso.add("Jardines");
		listaDescanso.add("Churrasqueras");
		listaDescanso.add("Fuente de agua");
		listaDescanso.add("Snack");
		listaDescanso.add("Mesas de cemento");
		listaDescanso.add("Arboles");
		
		listaNinios.add("Resbalin");
		listaNinios.add("Columpio");
		listaNinios.add("Pasamanos");
		listaNinios.add("Tobogan");
		listaNinios.add("Carrucel");
		listaNinios.add("Kiosco");
		listaNinios.add("Piscina");
		listaNinios.add("Sube y baja");
		
		listaRecreacion.add("Cancha polifuncional");
//			listaRecreacion.add("Arcos");
//			listaRecreacion.add("Tableros");
		listaRecreacion.add("Ciclovia");
		listaRecreacion.add("Fronton");
		listaRecreacion.add("Pista de patinaje");
		listaRecreacion.add("Kiosco");
		
		listaGeneral.add("Banca");
		listaGeneral.add("Iluminacion");
		listaGeneral.add("Baño");

		listaAreas.add("Niños");
		listaAreas.add("Recreacion");
		listaAreas.add("Descanso");
	}

	public ArrayList<String> getListaDescanso() {
		return listaDescanso;
	}

	public void setListaDescanso(ArrayList<String> listaDescanso) {
		this.listaDescanso = listaDescanso;
	}

	public ArrayList<String> getListaNinios() {
		return listaNinios;
	}

	public void setListaNinios(ArrayList<String> listaNinios) {
		this.listaNinios = listaNinios;
	}

	public ArrayList<String> getListaRecreacion() {
		return listaRecreacion;
	}

	public void setListaRecreacion(ArrayList<String> listaRecreacion) {
		this.listaRecreacion = listaRecreacion;
	}

	public ArrayList<String> getListaGeneral() {
		return listaGeneral;
	}

	public void setListaGeneral(ArrayList<String> listaGeneral) {
		this.listaGeneral = listaGeneral;
	}

	public ArrayList<String> getListaAreas() {
		return listaAreas;
	}

	public void setListaAreas(ArrayList<String> listaAreas) {
		this.listaAreas = listaAreas;
	}

}
