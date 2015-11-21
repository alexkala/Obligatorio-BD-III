package obligatorio.grafica.ventanas;


import java.awt.EventQueue;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import obligatorio.grafica.controladores.ControladorVerMascotas;
import obligatorio.logica.exceptions.Due�oException;

public class VentanaVerMascotas {

	private JFrame frame;
	private Object[][] data;
	private ControladorVerMascotas controlador;
	private JTextField textFieldCedulaDue�o;
	private SpringLayout sl_panel;
	private JPanel panel;
	private JLabel labelCedulaDue�o;

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
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 552, 315);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel labelTitulo = new JLabel("Mascotas");
		sl_panel.putConstraint(SpringLayout.NORTH, labelTitulo, 5, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, labelTitulo, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, labelTitulo, 0, SpringLayout.EAST, panel);
		panel.add(labelTitulo);
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 34));
		
		
		
		
		labelCedulaDue�o = new JLabel("CI del due\u00F1o");
		sl_panel.putConstraint(SpringLayout.NORTH, labelCedulaDue�o, 20, SpringLayout.SOUTH, labelTitulo);
		sl_panel.putConstraint(SpringLayout.WEST, labelCedulaDue�o, 20, SpringLayout.WEST, panel);
		panel.add(labelCedulaDue�o);
		
		textFieldCedulaDue�o = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, textFieldCedulaDue�o, -3, SpringLayout.NORTH, labelCedulaDue�o);
		sl_panel.putConstraint(SpringLayout.WEST, textFieldCedulaDue�o, 20, SpringLayout.EAST, labelCedulaDue�o);
		panel.add(textFieldCedulaDue�o);
		textFieldCedulaDue�o.setColumns(32);
		
		
		
		
		
		JButton btnVerMascotas = new JButton("Ver mascotas");
		sl_panel.putConstraint(SpringLayout.NORTH, btnVerMascotas, -7, SpringLayout.NORTH, labelCedulaDue�o);
		sl_panel.putConstraint(SpringLayout.EAST, textFieldCedulaDue�o, -20, SpringLayout.WEST, btnVerMascotas);
		sl_panel.putConstraint(SpringLayout.EAST, btnVerMascotas, -20, SpringLayout.EAST, panel);
		panel.add(btnVerMascotas);
		
		controlador = new ControladorVerMascotas();
		
		btnVerMascotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] columnas = { "APODO", "RAZA", "CI DUE�O" };
				String strCedula = textFieldCedulaDue�o.getText().trim();

				// Verifica que la cedula no est� vac�a
				if (!strCedula.isEmpty()) {

					// Verifica que la CI del due�o sea solo n�meros
					int cedula = -1;
					try {
						cedula = Integer.parseInt(strCedula);						
					} catch (NumberFormatException e1){
						JOptionPane.showMessageDialog(frame, "Formato inv�lido de c�dula.", "", JOptionPane.ERROR_MESSAGE);
					}

					// CI v�lida
					if (cedula != -1) {

						// Crea la tabla con las mascotas del due�o
						try {
							data = controlador.listarMascotas(cedula);
							
							JTable tableMascotas = new JTable(data, columnas);
							tableMascotas.setEnabled(false);

							JScrollPane scrollPane = new JScrollPane(tableMascotas);
							tableMascotas.getTableHeader().setReorderingAllowed(false);

							sl_panel.putConstraint(SpringLayout.NORTH, scrollPane, 23, SpringLayout.SOUTH, labelCedulaDue�o);
							sl_panel.putConstraint(SpringLayout.WEST, scrollPane, 0, SpringLayout.WEST, panel);
							sl_panel.putConstraint(SpringLayout.EAST, scrollPane, 0, SpringLayout.EAST, panel);
							panel.add(scrollPane);

							textFieldCedulaDue�o.setText("");

						} catch (SQLException | Due�oException | IOException e1) {
							// Muestra el error
							JOptionPane.showMessageDialog(frame, e1.getMessage());
						}
					}

				} else {
					JOptionPane.showMessageDialog(frame, "Ingresa la CI del due�o.", "Campo obligatorio", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		
		
		
		
	}
	
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}
