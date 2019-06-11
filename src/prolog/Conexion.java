package prolog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JOptionPane;

import org.jpl7.Query;
import org.jpl7.Term;

public class Conexion {
	
	/**
	 * 
	 * Constructor, realiza la conexion con el archivo de prolog
	 * @param pathArchivo
	 */
	public Conexion(String pathArchivo){
		try {
			String t1 = "consult('"+pathArchivo+".pl')";
	        Query q1 = new Query(t1);
	        q1.hasSolution();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			System.out.println(e);
		}
	}
	
	public Boolean getExisteArea(String X){
		Boolean valor = false;
		try {
			Query q2 = new Query("area('"+X+"')");
			valor = q2.hasMoreElements();	        
		} catch (Exception e) {
			// TODO: handle exception
		}
		return valor;
	}
	
	public String getConsultaPersonal(String consulta){
		String resultado = "";
		
		try {
			Query q2 = new Query(consulta);
			resultado = q2.oneSolution().get("X").toString();
//	        System.out.println(q2.oneSolution().get("X").toString());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("=========================>" +consulta);
			resultado = "error";
		}
	
		return resultado;
	}
}
