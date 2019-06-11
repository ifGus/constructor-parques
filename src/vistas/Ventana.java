package vistas;

//import java.awt.Color;
//import java.awt.Font;
//import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;
import complementos.*;
import controlador.Hilo;
import controlador.ListasBinarias;
import prolog.Conexion;

public class Ventana extends JFrame implements ActionListener {

	private JPanel panelBotones, panelParque, panelNinios, panelDescanso, panelRecreacion, panelConsola;
	private JLabel texto, labelTrabajando;
	private JCheckBox boxNinios, boxDescanso, boxRecreacion;
	private DimensionesPantalla dimPan;
	private JButton btnConstruir, btnSalir, btnProveer;
	private VentanaProveer proveer;
	private JScrollPane scrollPane;
	private JTextArea txtArea, txtNinios, txtDescanso, txtRecreacion;
	private ListasBinarias listaDeposito;
	private Conexion con;
//	public Runnable r;
//	public Thread t;

	public Ventana() {

		dimPan = new DimensionesPantalla();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// this.setResizable(false);
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setSize(dimPan.PenX(61), dimPan.PenY(62));
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setTitle("Inteligencia Artificial");
		JLabel titulo = escribir("Agente Constructor", dimPan.tamanioLetra(20), dimPan.PenX(26), dimPan.PenY(0));
		titulo.setForeground(Color.WHITE);
		this.add(titulo);

		panelParque = new JPanel();
		panelParque.setBackground(Color.gray);
		panelParque.setLayout(new GridLayout(1, 3, 10, 10));
		panelParque.setBounds(dimPan.PenX(1), dimPan.PenY(7), dimPan.PenX(58), dimPan.PenY(40));
		this.add(panelParque);

		panelNinios = new JPanel();
		panelNinios.setBackground(Color.WHITE);
		panelNinios.setBorder(javax.swing.BorderFactory.createTitledBorder("Área de niños"));
		panelNinios.setBounds(dimPan.PenX(2), dimPan.PenY(2.5F), dimPan.PenX(17), dimPan.PenY(35));
		panelNinios.setLayout(new GridLayout(1, 1));
		panelParque.add(new JScrollPane(panelNinios));
		
		txtNinios = new JTextArea("Vacío");
		panelNinios.add(new JScrollPane(txtNinios));

		panelRecreacion = new JPanel();
		panelRecreacion.setBackground(Color.WHITE);
		panelRecreacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Área de recreación"));
		panelRecreacion.setBounds(dimPan.PenX(39), dimPan.PenY(2.5F), dimPan.PenX(17), dimPan.PenY(35));
		panelRecreacion.setLayout(new GridLayout(1, 1));
		panelParque.add(panelRecreacion);
		
		txtRecreacion = new JTextArea("Vacío");
		panelRecreacion.add(new JScrollPane(txtRecreacion));
		
		panelDescanso = new JPanel();
		panelDescanso.setBackground(Color.WHITE);
		panelDescanso.setBorder(javax.swing.BorderFactory.createTitledBorder("Área de descanso"));
		panelDescanso.setBounds(dimPan.PenX(20.5F), dimPan.PenY(2.5F), dimPan.PenX(17), dimPan.PenY(35));
		panelDescanso.setLayout(new GridLayout(1, 1));
		panelParque.add(panelDescanso);
		
		txtDescanso = new JTextArea("Vacío");
		panelDescanso.add(new JScrollPane(txtDescanso));
		
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.gray);
		panelBotones.setLayout(null);
		panelBotones.setBounds(dimPan.PenX(1), dimPan.PenY(48), dimPan.PenX(58), dimPan.PenY(8.5F));
		this.add(panelBotones);

		btnConstruir = new JButton("Construir");
		btnConstruir.setBackground(Color.GREEN);
		btnConstruir.setBounds(dimPan.PenX(50), dimPan.PenY(2F), dimPan.PenX(7), dimPan.PenY(4));
		panelBotones.add(btnConstruir);
		btnConstruir.addActionListener(this);

		btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.RED);
		btnSalir.setBounds(dimPan.PenX(1), dimPan.PenY(2F), dimPan.PenX(7), dimPan.PenY(4));
		panelBotones.add(btnSalir);
		btnSalir.addActionListener(this);

		btnProveer = new JButton("Proveer");
		btnProveer.setBounds(dimPan.PenX(25), dimPan.PenY(2F), dimPan.PenX(7), dimPan.PenY(4));
		panelBotones.add(btnProveer);
		btnProveer.addActionListener(this);

		panelConsola = new JPanel();
		panelConsola.setBounds(dimPan.PenX(62), dimPan.PenY(1), dimPan.PenX(37), dimPan.PenY(90));
		panelConsola.setBorder(javax.swing.BorderFactory.createTitledBorder("Consola"));
		txtArea = new JTextArea("SECUENCIA DE RESULTADOS\n");
		txtArea.setBackground(Color.BLACK);
		txtArea.setEditable(false);
		txtArea.setForeground(Color.GREEN);
		txtArea.setFont(new Font("Arial", 1, dimPan.tamanioLetra(12)));
		panelConsola.setLayout(new GridLayout(1, 1));
		scrollPane = new JScrollPane(txtArea);
		panelConsola.add(scrollPane);
		this.add(panelConsola);
		
		txtNinios.setBackground(Color.GREEN);
		txtNinios.setFont(new Font("Andale mono", 1, dimPan.tamanioLetra(12)));
		
		txtDescanso.setBackground(Color.GREEN);
		txtDescanso.setFont(new Font("Andale mono", 1, dimPan.tamanioLetra(12)));
		
		txtRecreacion.setBackground(Color.GREEN);
		txtRecreacion.setFont(new Font("Andale mono", 1, dimPan.tamanioLetra(12)));
		
		labelTrabajando = new JLabel("En reposo");
		labelTrabajando.setBounds(0, dimPan.PenY(75), dimPan.PenX(60), dimPan.PenY(8));
		labelTrabajando.setHorizontalAlignment(SwingConstants.CENTER);
		labelTrabajando.setFont(new Font("Arial", 1, dimPan.tamanioLetra(25)));
		labelTrabajando.setForeground(Color.YELLOW);
		this.add(labelTrabajando);
	}

	public JLabel escribir(String texto, int tamanio, int x, int y) {
		JLabel letra = new JLabel(texto);
		letra.setFont(new Font("Arial", 0, tamanio));
		letra.setBounds(x, y, dimPan.PenX(50), dimPan.PenY(7));
		// this.add(letra);
		return letra;
	}

	public JLabel escribir(String texto, int x, int y) {
		JLabel letra = new JLabel(texto);
		letra.setFont(new Font("Arial", 0, dimPan.tamanioLetra(15)));
		letra.setBounds(x, y, dimPan.PenX(50), dimPan.PenY(7));
		return letra;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ventana().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			System.exit(0);
		} else if (e.getSource() == btnProveer) {
			proveer = new VentanaProveer(this, true);
			proveer.setVisible(true);
		} else if (e.getSource() == btnConstruir) {
			
			limpiarConola();
			txtNinios.setText("");
			txtDescanso.setText("");
			txtRecreacion.setText("");
			
			con = new Conexion("constructorParque");
			listaDeposito = new ListasBinarias();
			try {
				 Runnable r;
				 Thread t;
				r = new Hilo(scrollPane, txtArea, con, txtNinios, txtDescanso, txtRecreacion);
				t = new Thread(r);
				t.start();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Ocurrio un error al leer el archivo base");
			}
		}
	}
	private void limpiarConola(){
		txtArea.selectAll();
        txtArea.replaceSelection("");
	}
	
}
