package PanelesDoctor;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class pnlCitasTodas extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public pnlCitasTodas() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Lista de citas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(26, 11, 750, 330);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnRealizarConsulta = new JButton("Realizar Consulta");
		btnRealizarConsulta.setEnabled(false);
		btnRealizarConsulta.setBounds(604, 352, 172, 44);
		add(btnRealizarConsulta);

	}
}
