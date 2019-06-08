package vistas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import complementos.DimensionesPantalla;

import javax.swing.*;
public class VentanaProveer extends JDialog implements ActionListener{
	
	private JButton btnCancelar, btnSalvar;
	private DimensionesPantalla dimPan;
	private Ventana textos;
	private JPanel [] paneles;
	
	private ArrayList<String> listaNinios;
	private ArrayList<String> listaRecreacion;
	private ArrayList<String> listaDescanso;
	private ArrayList<String> listaGeneral;
	private ArrayList<String> listaAreas;
	
	private JCheckBox []  checksNinios;
	private JCheckBox []  checksRecreacion;
	private JCheckBox []  checksDescanso;
	private JCheckBox []  checksGeneral;
	private JCheckBox []  checksAreas;
	
	public VentanaProveer(Ventana ventana, boolean llave) {
		
		super(ventana, llave);
		// TODO Auto-generated constructor stub
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Elementos");
		dimPan = new DimensionesPantalla();
		this.setSize(dimPan.PenX(55), dimPan.PenY(40));
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
	
		this.getContentPane().setBackground(new Color(67, 67, 67));	
		
		textos = new Ventana();
		JLabel titulo = textos.escribir("Selecciona los elementos para el agente constructor", dimPan.tamanioLetra(18),dimPan.PenX(2), dimPan.PenY(0.5F));
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Ariel", 3, dimPan.tamanioLetra(20)));
		this.add(titulo, BorderLayout.NORTH);
		
		listaNinios = new ArrayList<String>();
		listaRecreacion = new ArrayList<String>();
		listaDescanso = new ArrayList<String>();
		listaGeneral = new ArrayList<String>();
		listaAreas = new ArrayList<String>();
		
		listaNinios.add("Resbalin");
		listaNinios.add("Columpio");
		listaNinios.add("Pasamanos");
		listaNinios.add("Tobogan");
		listaNinios.add("Carrucel");
		listaNinios.add("Kiosco");
		listaNinios.add("Piscina");
		
		listaRecreacion.add("Cancha polifuncional");
			listaRecreacion.add("Arcos");
			listaRecreacion.add("Tableros");
		listaRecreacion.add("Ciclovia");
		listaRecreacion.add("Fronton");
		listaRecreacion.add("Pista de patinaje");
		listaRecreacion.add("Kiosco");
		
		listaDescanso.add("Jardines");
		listaDescanso.add("Churrasqueras");
		listaDescanso.add("Funetes de agua");
		listaDescanso.add("Snack");
		listaDescanso.add("Mesas de cemento");
		listaDescanso.add("Arboles");
		
		listaGeneral.add("Bancos");
		listaGeneral.add("Iluninacion");
		listaGeneral.add("Baños");

		listaAreas.add("Área de niños");
		listaAreas.add("Área recreativa");
		listaAreas.add("Área de descanso");
		
		checksNinios = new JCheckBox[listaNinios.size()];
		checksRecreacion = new JCheckBox[listaRecreacion.size()];
		checksDescanso = new JCheckBox[listaDescanso.size()];
		checksGeneral = new JCheckBox[listaGeneral.size()];
		checksAreas = new JCheckBox[listaAreas.size()];
		
		
		checksNinios = new JCheckBox [listaNinios.size()];
		for(int i = 0; i < checksNinios.length; i ++) {
			checksNinios[i] = new JCheckBox(listaNinios.get(i));
			checksNinios[i].setSelected(true);
		}
		
		checksRecreacion = new JCheckBox [listaRecreacion.size()];
		for(int i = 0; i < checksRecreacion.length; i ++) {
			checksRecreacion[i] = new JCheckBox(listaRecreacion.get(i));
			checksRecreacion[i].setSelected(true);
		}
		
		checksDescanso = new JCheckBox [listaDescanso.size()];
		for(int i = 0; i < checksDescanso.length; i ++) {
			checksDescanso[i] = new JCheckBox(listaDescanso.get(i));
			checksDescanso[i].setSelected(true);
		}
		
		checksGeneral = new JCheckBox [listaGeneral.size()];
		for(int i = 0; i < checksGeneral.length; i ++) {
			checksGeneral[i] = new JCheckBox(listaGeneral.get(i));
			checksGeneral[i].setSelected(true);
		}
		
		checksAreas = new JCheckBox [listaAreas.size()];
		for(int i = 0; i < checksAreas.length; i ++) {
			checksAreas[i] = new JCheckBox(listaAreas.get(i));
			checksAreas[i].setSelected(true);
		}
		
		paneles = new JPanel [7];
		paneles[0] = new JPanel();
		paneles[0].setBackground(new Color(132, 99, 142));
		paneles[0].setLayout(new GridLayout());
		
		this.add(paneles[0], BorderLayout.CENTER);
		for(int i = 1; i < paneles.length; i ++) {
			paneles[i] = new JPanel();
//			paneles[i].setLayout(new GridLayout(7, 2));
			if((i%2) == 0) {
				paneles[i].setBackground(new Color(10, 186, 181));
			}else paneles[i].setBackground(Color.GRAY);
			
			if(i<=paneles.length-1) {
				paneles[0].add(paneles[i], BorderLayout.CENTER);
			}
		}
		paneles[paneles.length-1].setBackground(new Color(67, 67, 67));
		
		this.add(paneles[paneles.length-1], BorderLayout.SOUTH);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		paneles[paneles.length-1].add(btnCancelar);
		paneles[paneles.length-1].add(new JLabel("                    "));
		paneles[paneles.length-1].add(btnSalvar);
		
		generarCheck();
		
	}
	
//	public void generarCheck() {
	public void generarCheck() {
		paneles[1].add(textos.escribir("Área de niños                     ", 0, 0));
		for (int i = 0; i < checksNinios.length; i++) {
			checksNinios[i].setBackground(Color.GRAY);
			paneles[1].add(checksNinios[i]);
		}
		
		paneles[2].add(textos.escribir("Área de recreación              ", 0, 0));
		for (int i = 0; i < checksRecreacion.length; i++) {
			checksRecreacion[i].setBackground(new Color(10, 186, 181));
			paneles[2].add(checksRecreacion[i]);
		}
		
		paneles[3].add(textos.escribir("Área de descanso                ", 0, 0));
		for (int i = 0; i < checksDescanso.length; i++) {
			checksDescanso[i].setBackground(Color.GRAY);
			paneles[3].add(checksDescanso[i]);
		}
		
		paneles[4].add(textos.escribir("Área de general                   ", 0, 0));
		for (int i = 0; i < checksGeneral.length; i++) {
			checksGeneral[i].setBackground(new Color(10, 186, 181));
			paneles[4].add(checksGeneral[i]);
		}
		
		paneles[5].add(textos.escribir("Áreas                             ", 0, 0));
		for (int i = 0; i < checksAreas.length; i++) {
			checksAreas[i].setBackground(Color.GRAY);
			paneles[5].add(checksAreas[i]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnCancelar) {
			this.dispose();
		}else {
			
			System.out.println();
			System.out.println("AREA DE NIÑOS");
			for (int i = 0; i < checksNinios.length; i++) {
				if(checksNinios[i].isSelected()) {
					System.out.println(checksNinios[i].getText());
				}
			}
			
			System.out.println();
			System.out.println("AREA DE RECREACION");
			for (int i = 0; i < checksRecreacion.length; i++) {
				if(checksRecreacion[i].isSelected()) {
					System.out.println(checksRecreacion[i].getText());
				}
			}
			
			System.out.println();
			System.out.println("AREA DE DESCANSO");
			for (int i = 0; i < checksDescanso.length; i++) {
				if(checksDescanso[i].isSelected()) {
					System.out.println(checksDescanso[i].getText());
				}
			}
			
			System.out.println();
			System.out.println("AREAS GENERALES");
			for (int i = 0; i < checksGeneral.length; i++) {
				if(checksGeneral[i].isSelected()) {
					System.out.println(checksGeneral[i].getText());
				}
			}
			System.out.println();
			System.out.println("AREAS");
			for (int i = 0; i < checksAreas.length; i++) {
				if(checksAreas[i].isSelected()) {
					System.out.println(checksAreas[i].getText());
				}
			}
		}
	}
	
}
