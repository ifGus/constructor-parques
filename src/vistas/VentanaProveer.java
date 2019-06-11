package vistas;
import java.awt.BorderLayout;
import controlador.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import controlador.*;

import complementos.DimensionesPantalla;

import javax.swing.*;
public class VentanaProveer extends JDialog implements ActionListener{
	
	private JButton btnCancelar, btnSalvar;
	private DimensionesPantalla dimPan;
	private Ventana textos;
	private JPanel [] paneles;
	
	private ListasPlan listas;
	private ListasBinarias registro;
	
	private JCheckBox []  checksNinios;
	private JCheckBox []  checksRecreacion;
	private JCheckBox []  checksDescanso;
	private JCheckBox []  checksGeneral;
	private JCheckBox []  checksAreas;
	
	public VentanaProveer(Ventana ventana, boolean llave) throws ClassNotFoundException {
		
		super(ventana, llave);
		
		this.setTitle("Elementos");
		dimPan = new DimensionesPantalla();
		this.setSize(dimPan.PenX(50), dimPan.PenY(40));
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
	
//		this.getContentPane().setBackground(new Color(67, 67, 67));	
		
		textos = new Ventana();
		JLabel titulo = textos.escribir("DISPONIBILIDAD EN EL DEPÓSITO", dimPan.tamanioLetra(18),dimPan.PenX(2), dimPan.PenY(0.5F));
		titulo.setForeground(Color.DARK_GRAY);
		titulo.setFont(new Font("Ariel", 3, dimPan.tamanioLetra(20)));
		this.add(titulo, BorderLayout.NORTH);
		
		listas = new ListasPlan();
		registro = new ListasBinarias();
		
		checksNinios = new JCheckBox[listas.getListaNinios().size()];
		checksRecreacion = new JCheckBox[listas.getListaRecreacion().size()];
		checksDescanso = new JCheckBox[listas.getListaDescanso().size()];
		checksGeneral = new JCheckBox[listas.getListaGeneral().size()];
		checksAreas = new JCheckBox[listas.getListaAreas().size()];
		
		for(int i = 0; i < checksNinios.length; i ++) {
			checksNinios[i] = new JCheckBox(listas.getListaNinios().get(i));
			if(new ExistenciaCadenaEnLista().exite(registro.getListaAreaNinios(), checksNinios[i].getText())){
				checksNinios[i].setSelected(true);
			}
		}

		for(int i = 0; i < checksRecreacion.length; i ++) {
			checksRecreacion[i] = new JCheckBox(listas.getListaRecreacion().get(i));
			if(new ExistenciaCadenaEnLista().exite(registro.getListaAreaRecreacion(), checksRecreacion[i].getText())){
				checksRecreacion[i].setSelected(true);
			}
		}

		for(int i = 0; i < checksDescanso.length; i ++) {
			checksDescanso[i] = new JCheckBox(listas.getListaDescanso().get(i));
			if(new ExistenciaCadenaEnLista().exite(registro.getListaAreaDescanso(), checksDescanso[i].getText())){
				checksDescanso[i].setSelected(true);
			}
		}

		for(int i = 0; i < checksGeneral.length; i ++) {
			checksGeneral[i] = new JCheckBox(listas.getListaGeneral().get(i));
			if(new ExistenciaCadenaEnLista().exite(registro.getListaGeneral(), checksGeneral[i].getText())){
				checksGeneral[i].setSelected(true);
			}
			
		}

		for(int i = 0; i < checksAreas.length; i ++) {
			checksAreas[i] = new JCheckBox(listas.getListaAreas().get(i));
			checksAreas[i].setSelected(true);
		}
		
		paneles = new JPanel [7];
		paneles[0] = new JPanel();
		paneles[0].setLayout(new GridLayout(1,4)); // Pancel 0 es el fondo para el resto de lo spaneles
		
		this.add(paneles[0], BorderLayout.CENTER);
		for(int i = 1; i < paneles.length; i ++) {
			paneles[i] = new JPanel();
//			if((i%2) == 0) {
//				paneles[i].setBackground(new Color(10, 186, 181));
//				paneles[i].setBackground(Color.DARK_GRAY);
				switch (i) {
				case 1:
					paneles[i].setBorder(javax.swing.BorderFactory.createTitledBorder("Niños"));
					break;
				case 2:
					paneles[i].setBorder(javax.swing.BorderFactory.createTitledBorder("Recreación"));
					break;
				case 3:
					paneles[i].setBorder(javax.swing.BorderFactory.createTitledBorder("Descanso"));
					break;
				case 4:
					paneles[i].setBorder(javax.swing.BorderFactory.createTitledBorder("General"));
					break;
				case 5:
					paneles[i].setBorder(javax.swing.BorderFactory.createTitledBorder("Áreas"));
					break;
				default:
					break;
				}

			if(i<=paneles.length-3) {
				paneles[0].add(paneles[i], BorderLayout.CENTER);
			}
		}
//		paneles[paneles.length-1].setBackground(new Color(67, 67, 67));
		
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
	
	public void generarCheck() {
		for (int i = 0; i < checksNinios.length; i++) {
			paneles[1].add(checksNinios[i]);
		}
		
		for (int i = 0; i < checksRecreacion.length; i++) {
			paneles[2].add(checksRecreacion[i]);
		}
		
		for (int i = 0; i < checksDescanso.length; i++) {
			paneles[3].add(checksDescanso[i]);
		}
		
		for (int i = 0; i < checksGeneral.length; i++) {
			paneles[4].add(checksGeneral[i]);
		}
		
//		for (int i = 0; i < checksAreas.length; i++) {
//			paneles[5].add(checksAreas[i]);
//		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnCancelar) {
			this.dispose();
		}else {
			registro.setListaAreaDescanso(seleccionados(checksDescanso));
			registro.setListaAreaNinios(seleccionados(checksNinios));
			registro.setListaAreaRecreacion(seleccionados(checksRecreacion));
			registro.setListaAreas(seleccionados(checksAreas));
			registro.setListaGeneral(seleccionados(checksGeneral));

			this.dispose();
		}
	}
	
	private ArrayList<String> seleccionados( JCheckBox [] seleccionados){
		ArrayList<String> lista = new ArrayList<>();
		for (int i = 0; i < seleccionados.length; i++) {
//			System.out.println("Los elementos seleccionados son: "+seleccionados[i].getText());
			if(seleccionados[i].isSelected()){
				lista.add(seleccionados[i].getText());
			}
		}
		return lista;
	}
	
}
