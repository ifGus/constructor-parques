package vistas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import complementos.*;
public class Ventana extends JFrame implements ActionListener{
	private JPanel panelBotones, panelParque, panelNinios, panelDescanso, panelRecreacion;
	private JLabel texto;
	private JCheckBox boxNinios, boxDescanso, boxRecreacion;
	private DimensionesPantalla dimPan;
	private JButton btnConstruir, btnSalir, btnProveer;
	
	Ventana(){
		
		dimPan = new DimensionesPantalla();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(dimPan.PenX(61), dimPan.PenY(62));
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setTitle("Inteligencia Artificial");
		escribir("Agente Constructor", dimPan.tamanioLetra(20), dimPan.PenX(26), dimPan.PenY(0));
		
		panelParque = new JPanel();
		panelParque.setBackground(Color.gray);
		panelParque.setLayout(null);
		panelParque.setBounds(dimPan.PenX(1), dimPan.PenY(7), dimPan.PenX(59), dimPan.PenY(40));
		this.add(panelParque);
		
		panelNinios = new JPanel();
		panelNinios.setBackground(Color.WHITE);
		panelNinios.setLayout(null);
		panelNinios.setBounds(dimPan.PenX(2), dimPan.PenY(2.5F), dimPan.PenX(17), dimPan.PenY(35));
		panelParque.add(panelNinios);
		
		panelDescanso = new JPanel();
		panelDescanso.setBackground(Color.WHITE);
		panelDescanso.setLayout(null);
		panelDescanso.setBounds(dimPan.PenX(20.5F), dimPan.PenY(2.5F), dimPan.PenX(17), dimPan.PenY(35));
		panelParque.add(panelDescanso);
		
		panelRecreacion = new JPanel();
		panelRecreacion.setBackground(Color.WHITE);
		panelRecreacion.setLayout(null);
		panelRecreacion.setBounds(dimPan.PenX(39), dimPan.PenY(2.5F), dimPan.PenX(17), dimPan.PenY(35));
		panelParque.add(panelRecreacion);
		
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.gray);
		panelBotones.setLayout(null);
		panelBotones.setBounds(dimPan.PenX(1), dimPan.PenY(48), dimPan.PenX(59), dimPan.PenY(8.5F));
		this.add(panelBotones);
		
		btnConstruir = new JButton("Contruir");
		btnConstruir.setBackground(Color.GREEN);
		btnConstruir.setBounds(dimPan.PenX(50), dimPan.PenY(2F), dimPan.PenX(7), dimPan.PenY(4));
		panelBotones.add(btnConstruir);
		btnConstruir.addActionListener(this);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.RED);
		btnSalir.setBounds(dimPan.PenX(1), dimPan.PenY(2F), dimPan.PenX(7), dimPan.PenY(4));
		panelBotones.add(btnSalir);
		btnSalir.addActionListener(this);
		
		btnProveer = new JButton("Opciones");
//		btnProveer.setBackground(C);
		btnProveer.setBounds(dimPan.PenX(25), dimPan.PenY(2F), dimPan.PenX(7), dimPan.PenY(4));
		panelBotones.add(btnProveer);
		btnProveer.addActionListener(this);

	}
	
	private JLabel escribir(String texto, int tamanio, int x, int y){
		JLabel letra = new JLabel(texto);
		letra.setFont(new Font("Arial",0,tamanio));
		letra.setBounds(x, y, dimPan.PenX(50), dimPan.PenY(7));
		this.add(letra);
		return letra;
	}
	
	private JLabel escribir(String texto, int x, int y){
		JLabel letra = new JLabel(texto);
		letra.setFont(new Font("Arial",0,dimPan.tamanioLetra(15)));
		letra.setBounds(x, y, dimPan.PenX(50), dimPan.PenY(7));
		this.add(letra);
		return letra;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ventana().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnSalir){
			System.exit(0);
		}else if(e.getSource()==btnConstruir){
			System.out.println("Construyendo...");
		}
		
	}
}
