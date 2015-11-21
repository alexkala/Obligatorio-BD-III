package obligatorio.grafica.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import obligatorio.exceptions.LogicaException;
import obligatorio.grafica.controladores.ControladorVerDue�os;

public class VentanaVerDue�os {

	private JFrame frame;
	private Object[][] data;

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

		ControladorVerDue�os controlador = new ControladorVerDue�os();
		// Intenta obtener los datos
		// Si puede abre la ventana, si no muestra error
		try {
			data = controlador.listarDue�os();
			initialize();

		} catch (LogicaException e) {
			JOptionPane.showMessageDialog(frame,
					"No se pudo establecer la conexi�n.");
		}

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

		JLabel labelTitulo = new JLabel("Due\u00F1os");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 34));
		frame.getContentPane().add(labelTitulo, BorderLayout.NORTH);

		String[] columnas = { "CI", "NOMBRE", "APELLIDO" };

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
