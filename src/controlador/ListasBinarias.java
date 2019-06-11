package controlador;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ListasBinarias implements Serializable  {
	
	private String nombreArchivoNiños;
	private String nombreArchivoRecreacion;
	private String nombreArchivoDescanso;
	private String nombreArchivoGeneral;
	private String nombreArchivoAreas;
	
	public ListasBinarias(){
		
		nombreArchivoNiños = "planAreaNinios";
		nombreArchivoDescanso = "planAreaDescanso";
		nombreArchivoRecreacion = "planAreaRecreacion";
		nombreArchivoGeneral = "planListaGeneral";
		nombreArchivoAreas = "planListaAreas";
	} 
	
	public ArrayList<String> getListaGeneral() throws ClassNotFoundException{
		return leer(nombreArchivoGeneral);
	}
	
	public void setListaGeneral(ArrayList<String> listaGeneral) {
		ecribir(listaGeneral,nombreArchivoGeneral);
	}
	
	public ArrayList<String> getListaAreas() throws ClassNotFoundException{
		return leer(nombreArchivoAreas);
	}
	
	public void setListaAreas(ArrayList<String> listaAreas) {
		ecribir(listaAreas,nombreArchivoAreas);
	}
	
	
	public ArrayList<String> getListaAreaNinios() throws ClassNotFoundException {
		return leer(nombreArchivoNiños);
	}

	public void setListaAreaNinios(ArrayList<String> listaAreaNinios) {
		ecribir(listaAreaNinios,nombreArchivoNiños);
	}

	public ArrayList<String> getListaAreaRecreacion() throws ClassNotFoundException {
		return leer(nombreArchivoRecreacion);
	}

	public void setListaAreaRecreacion(ArrayList<String> listaAreaRecreacion) {
		ecribir(listaAreaRecreacion,nombreArchivoRecreacion);
	}

	public ArrayList<String> getListaAreaDescanso() throws ClassNotFoundException {
		return leer(nombreArchivoDescanso);
	}

	public void setListaAreaDescanso(ArrayList<String> listaAreaDescanso) {
		ecribir(listaAreaDescanso,nombreArchivoDescanso);
	}
	
	private void ecribir(ArrayList<String> lista, String nombreArchivo){
		try {
			ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("archivos/"+nombreArchivo+".dat"));
			escribiendo_fichero.writeObject(lista);
			escribiendo_fichero.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar la información");
		}
	}
	
	private ArrayList<String> leer(String fichero) throws ClassNotFoundException{
		ArrayList<String> lista;
		lista = new ArrayList<String>();
		try {
			ObjectInputStream leer_Fichero;
			leer_Fichero = new ObjectInputStream(new FileInputStream("archivos/"+fichero+".dat"));
			lista = (ArrayList<String>) leer_Fichero.readObject();
			leer_Fichero.close();
			return lista;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<String>();
		}

	}

}
