package org.cmrc.basedatos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Icoche extends JFrame {
	private static final long serialVersionUID = 7099199980543617818L;
	
	static JLabel lmatricula = new JLabel("Matrícula: ");
	static JLabel lmarca = new JLabel("Marca: ");
	static JLabel lmodelo = new JLabel("Modelo: ");
	static JLabel lcolor = new JLabel("Color: ");
	static JLabel lanio = new JLabel("Año: ");
	static JLabel lprecio = new JLabel("Precio: ");
	static JTextField txtmatricula = new JTextField();
	static JTextField txtmarca = new JTextField();
	static JTextField txtmodelo = new JTextField();
	static JTextField txtcolor = new JTextField();
	static JTextField txtanio = new JTextField();
	static JTextField txtprecio = new JTextField();
	public static JFrame frame;
	public static Icoche fcoche;
	public static JPanel panel1;
	public static JButton btnsiguiente = new JButton("Siguiente");
	public static JButton btnUltimo, btnPrimero;
	public static JButton btnAnterior = new JButton("Anterior");
	static JTextField labelResultado;

	public Icoche() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 459);
		setTitle("Coches");
		panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(100, 100));
		panel1.setLayout(null);
		lmatricula.setBounds(1, 1, 201, 51);
		panel1.add(lmatricula);
		txtmatricula.setBounds(202, 1, 201, 51);
		panel1.add(txtmatricula);
		lmarca.setBounds(1, 52, 201, 51);
		panel1.add(lmarca);
		txtmarca.setBounds(202, 52, 201, 51);
		panel1.add(txtmarca);
		lmodelo.setBounds(1, 103, 201, 51);
		panel1.add(lmodelo);
		txtmodelo.setBounds(202, 103, 201, 51);
		panel1.add(txtmodelo);
		lcolor.setBounds(1, 154, 201, 51);
		panel1.add(lcolor);
		txtcolor.setBounds(202, 154, 201, 51);
		panel1.add(txtcolor);
		lanio.setBounds(1, 205, 201, 51);
		panel1.add(lanio);
		txtanio.setBounds(202, 205, 201, 51);
		panel1.add(txtanio);
		lprecio.setBounds(1, 256, 201, 51);
		panel1.add(lprecio);
		txtprecio.setBounds(202, 256, 201, 51);
		panel1.add(txtprecio);
		btnsiguiente.setBounds(288, 307, 88, 51);
		btnsiguiente.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1.add(btnsiguiente);
		panel1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel1.setLayout(null);
		setContentPane(panel1);
		btnAnterior.setBounds(202, 307, 88, 51);
		btnAnterior.setHorizontalAlignment(SwingConstants.RIGHT);
		panel1.add(btnAnterior);

		btnPrimero = new JButton("Primero");
		btnPrimero.setHorizontalAlignment(SwingConstants.RIGHT);
		btnPrimero.setBounds(105, 307, 98, 51);
		panel1.add(btnPrimero);

		btnUltimo = new JButton("Ultimo");
		btnUltimo.setHorizontalAlignment(SwingConstants.RIGHT);
		btnUltimo.setBounds(375, 307, 96, 51);
		panel1.add(btnUltimo);

		labelResultado = new JTextField();
		labelResultado.setEditable(false);
		labelResultado.setBounds(1, 378, 289, 20);
		panel1.add(labelResultado);
		labelResultado.setColumns(10);
		PulsarBoton Boton = new PulsarBoton();
		btnsiguiente.addActionListener(Boton);
		btnAnterior.addActionListener(Boton);
		btnUltimo.addActionListener(Boton);
		btnPrimero.addActionListener(Boton);

	}
}
