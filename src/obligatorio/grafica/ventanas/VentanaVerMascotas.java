package obligatorio.grafica.ventanas;


import java.awt.EventQueue;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Font;

import obligatorio.grafica.controladores.ControladorVerMascotas;

public class VentanaVerMascotas {

	private JFrame frame;
	private ControladorVerMascotas controladorVentanaMascotas;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVerMascotas window = new VentanaVerMascotas();
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
	public VentanaVerMascotas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		controladorVentanaMascotas = new ControladorVerMascotas();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 552, 315);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel labelTitulo = new JLabel("Mascotas");
		sl_panel.putConstraint(SpringLayout.NORTH, labelTitulo, 5, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, labelTitulo, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, labelTitulo, 0, SpringLayout.EAST, panel);
		panel.add(labelTitulo);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 34));
		
		
		String[] columnas = { "APODO", "RAZA", "CI DUE�O" };
		
		// FIXME: Rodear con try catch
		
		int cedula = 1234567;
		Object[][] data = controladorVentanaMascotas.listarMascotas(cedula);
		
		JTable tableMascotas = new JTable(data, columnas);
		tableMascotas.getTableHeader().setReorderingAllowed(false);
		
		JLabel labelCedulaDue�o = new JLabel("CI del due\u00F1o");
		sl_panel.putConstraint(SpringLayout.NORTH, labelCedulaDue�o, 20, SpringLayout.SOUTH, labelTitulo);
		sl_panel.putConstraint(SpringLayout.WEST, labelCedulaDue�o, 20, SpringLayout.WEST, panel);
		panel.add(labelCedulaDue�o);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textField, -3, SpringLayout.NORTH, labelCedulaDue�o);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 20, SpringLayout.EAST, labelCedulaDue�o);
		panel.add(textField);
		textField.setColumns(32);
		
		
		
		JButton btnNewButton = new JButton("Ver mascotas");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, -7, SpringLayout.NORTH, labelCedulaDue�o);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -20, SpringLayout.WEST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -20, SpringLayout.EAST, panel);
		panel.add(btnNewButton);
		tableMascotas.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane(tableMascotas);
		sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 23, SpringLayout.SOUTH, labelCedulaDue�o);
		sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, panel);
		panel.add(scrollPane);
		
		
		
	}
	
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}
