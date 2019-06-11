package controlador;

import prolog.Conexion;
import vistas.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conexion c = new Conexion("constructorParque");
//		for (int i = 0; i < c.getConsultaPersonal(""); i++) {
//			
//		}
//		System.out.println("El valor es: "+c.getConsultaPersonal("vecino_de(X,descanso)"));
		Ventana  v = new Ventana();
		v.setVisible(true);
	}
}
