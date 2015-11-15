package obligatorio.grafica.ventanas;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;

import java.awt.Component;
import java.awt.Font;

public class VentanaIngresarMascota {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIngresarMascota window = new VentanaIngresarMascota();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaIngresarMascota() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 218);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel labelTitulo = new JLabel("Nueva mascota");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 34));
		frame.getContentPane().add(labelTitulo, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JButton btnIngresarMascota = new JButton("Ingresar Mascota");
		sl_panel.putConstraint(SpringLayout.EAST, btnIngresarMascota, -20, SpringLayout.EAST, panel);
		btnIngresarMascota.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(btnIngresarMascota);
		
		// C�dula del due�o
		JLabel labelCedulaDue�o = new JLabel("C�dula del due�o");
		sl_panel.putConstraint(SpringLayout.WEST, labelCedulaDue�o, 20, SpringLayout.WEST, panel);
		labelCedulaDue�o.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(labelCedulaDue�o);
			
		JTextField textFieldCedulaDue�o = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldCedulaDue�o, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldCedulaDue�o, 20, SpringLayout.EAST, labelCedulaDue�o);
		sl_panel.putConstraint(SpringLayout.NORTH, labelCedulaDue�o, 3, SpringLayout.NORTH, textFieldCedulaDue�o);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldCedulaDue�o, -20, SpringLayout.EAST, panel);
		panel.add(textFieldCedulaDue�o);
		textFieldCedulaDue�o.setColumns(34);
		
		// Raza
		JLabel labelRaza = new JLabel("Raza");
		sl_panel.putConstraint(SpringLayout.WEST, labelRaza, 20, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, labelRaza, 0, SpringLayout.EAST, labelCedulaDue�o);
		labelRaza.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(labelRaza);
			
		JTextField textFieldRaza = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldRaza, 10, SpringLayout.SOUTH, textFieldCedulaDue�o);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldRaza, 20, SpringLayout.EAST, labelRaza);
		sl_panel.putConstraint(SpringLayout.NORTH, labelRaza, 3, SpringLayout.NORTH, textFieldRaza);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldRaza, -20, SpringLayout.EAST, panel);
		panel.add(textFieldRaza);
		textFieldRaza.setColumns(34);
		
		
		// Apodo
		JLabel labelApodo = new JLabel("Apodo");
		labelApodo.setHorizontalAlignment(SwingConstants.TRAILING);
		sl_panel.putConstraint(SpringLayout.EAST, labelApodo, 0, SpringLayout.EAST, labelCedulaDue�o);
		sl_panel.putConstraint(SpringLayout.WEST, labelApodo, 20, SpringLayout.WEST, panel);
		
		panel.add(labelApodo);
			
		JTextField textFieldApodo = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, textFieldApodo, 20, SpringLayout.EAST, labelApodo);
		sl_panel.putConstraint(SpringLayout.NORTH, btnIngresarMascota, 10, SpringLayout.SOUTH, textFieldApodo);
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldApodo, 10, SpringLayout.SOUTH, textFieldRaza);
		sl_panel.putConstraint(SpringLayout.NORTH, labelApodo, 3, SpringLayout.NORTH, textFieldApodo);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldApodo, -20, SpringLayout.EAST, panel);
		panel.add(textFieldApodo);
		textFieldApodo.setColumns(34);
		
		
	}
	
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

}