package obligatorio.grafica.ventanas;


import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;

import java.awt.Font;
import obligatorio.grafica.controladores.ControladorVerDue�os;

public class VentanaVerDue�os {

	private JFrame frame;
	private ControladorVerDue�os controladorVentanaDue�os;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaVerDue�os window = new VentanaVerDue�os();
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
	public VentanaVerDue�os() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		controladorVentanaDue�os = new ControladorVerDue�os();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 218);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel labelTitulo = new JLabel("Due\u00F1os");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 34));
		frame.getContentPane().add(labelTitulo, BorderLayout.NORTH);
		
		
		String[] columnas = { "CI", "NOMBRE", "APELLIDO" };
		
		// FIXME: Rodear con try catch
		
		Object[][] data = controladorVentanaDue�os.listarDue�os();
		
		JTable tableDue�os = new JTable(data, columnas);
		tableDue�os.getTableHeader().setReorderingAllowed(false);
		tableDue�os.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(tableDue�os);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
	}
	
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}
