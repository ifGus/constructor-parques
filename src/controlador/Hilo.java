package controlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import prolog.Conexion;

public class Hilo implements Runnable {
	private JTextArea txtArea;
	private Conexion con;
	private JScrollPane scrollPane;
	private int lapso;
	private JTextArea txtNinios, txtDescanso, txtRecreacion;
	private ListasBinarias lista;
	private JLabel labelTrabajando;
	private ListasBinarias registros;

	public Hilo(JScrollPane scrollPane, JTextArea txtArea, Conexion con, JTextArea txtNi�os, JTextArea txtDescanso, JTextArea txtRecreacion, JLabel labelTrabajando) {
		this.txtArea = txtArea;
		this.con = con;
		this.txtNinios = txtNi�os;
		this.txtDescanso = txtDescanso;
		this.txtRecreacion = txtRecreacion;
		this.labelTrabajando = labelTrabajando;
		registros = new ListasBinarias();
		lista = new ListasBinarias();
		lapso = 100;
	}
	
	private void construido(String nombrePanel, String elemento){
		elemento +=" => terminado";
		if(nombrePanel.equals("ni�os")){
			txtNinios.append("+ "+elemento + '\n');
		}else if(nombrePanel.equals("descanso")){
			txtDescanso.append("+ "+elemento + '\n');
		}else{
			txtRecreacion.append("+ "+elemento+'\n');
		}
	}

	@Override
	public void run() {

		// TODO Auto-generated method stub

		String area = "";
		// txtArea.append("�?"+ '\n');
		for (int j = 1; j <= 28; j++) {

			if (!area.equalsIgnoreCase(con.getConsultaPersonal("es_del_area(" + j + ",X)"))) {
				area = con.getConsultaPersonal("es_del_area(" + j + ",X)");
				labelTrabajando.setText("Trabajando en: "+area);
				txtArea.append('\n' + "DIRIGIENDOSE AL AREA " + area + "..." + '\n');
				try {
					Thread.sleep(lapso);
				} catch (InterruptedException e) {
				}

				txtArea.append("   En el �rea de " + area + '\n');
				try {
					Thread.sleep(lapso);
				} catch (InterruptedException e) {
				}
			}

			txtArea.append(
					"   Dirigiendose a la sub�rea " + con.getConsultaPersonal("ejecutar(" + j + ",X)") + "..." + '\n');
			try {
				Thread.sleep(lapso);
			} catch (InterruptedException e) {
			}

			txtArea.append("   En la sub�rea " + con.getConsultaPersonal("ejecutar(" + j + ",X)") +  '\n');
			try {
				Thread.sleep(lapso);
			} catch (InterruptedException e) {
			}

			txtArea.append("   Despejando sub�rea " + con.getConsultaPersonal("ejecutar(" + j + ",X)") + "..." + '\n');

			txtArea.append("   Sub�rea " + con.getConsultaPersonal("ejecutar(" + j + ",X)") + " despejada" + '\n');
			try {
				Thread.sleep(lapso);
			} catch (InterruptedException e) {
			}
			

			txtArea.append("   Caminar hacia deposito por " +con.getConsultaPersonal("es_elemento(" + j + ",X)")+ '\n');
			try {
				Thread.sleep(lapso);
			} catch (InterruptedException e) {
			}
			
			try {
				if(new ExistenciaCadenaEnLista().exite(registros.getListaAreaNinios(), con.getConsultaPersonal("es_elemento(" + j + ",X)"))
				|| new ExistenciaCadenaEnLista().exite(registros.getListaAreaRecreacion(), con.getConsultaPersonal("es_elemento(" + j + ",X)"))
				|| new ExistenciaCadenaEnLista().exite(registros.getListaAreaDescanso(), con.getConsultaPersonal("es_elemento(" + j + ",X)"))
				|| new ExistenciaCadenaEnLista().exite(registros.getListaGeneral(), con.getConsultaPersonal("es_elemento(" + j + ",X)"))
				){
					
						txtArea.append("   Llevar " +con.getConsultaPersonal("es_elemento(" + j + ",X)")+ " hacia " +con.getConsultaPersonal("ejecutar(" + j + ",X)")+ '\n');
						try {
							Thread.sleep(lapso);
						} catch (InterruptedException e) {
						}
						
						txtArea.append("   Construyendo " + con.getConsultaPersonal("es_elemento(" + j + ",X)") + " en "
								+ con.getConsultaPersonal("ejecutar(" + j + ",X)") + "..." + '\n');
						try {
							Thread.sleep(lapso);
						} catch (InterruptedException e) {
						}

						txtArea.append("   Elemento " + con.getConsultaPersonal("es_elemento(" + j + ",X)") + " instalado en "
								+ con.getConsultaPersonal("ejecutar(" + j + ",X)") + " correctamente" + '\n'+'\n');
						try {
							Thread.sleep(lapso);
						} catch (InterruptedException e) {
						}
						
						construido(con.getConsultaPersonal("es_del_area("+ j +",X)"), con.getConsultaPersonal("es_elemento("+ j +",X)"));
				}else{
					txtArea.append("     (No existe) No se encontr� el elemento "+con.getConsultaPersonal("es_elemento(" + j + ",X)")+" en el dep�sito!"+'\n'+'\n');
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Inconsistencia de datos!!");
				e.printStackTrace();
			}
			
		}

		txtArea.append('\n' + " TRABAJO TERMINADO");
		labelTrabajando.setText("En reposo");

	}
}
