package VentanasAdmin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.BevelBorder;

public class VentanaCita_admin extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaCita_admin dialog = new VentanaCita_admin();
			dialog.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaCita_admin() {
		//setIcon(Toolkit.getDefaultToolkit().getImage(VentanaCita_admin.class.getResource("/Imagenes/LogoPeque.png")));
		setTitle("Informaci\u00F3n de Citas");
		setBounds(100, 100, 685, 442);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(230, 230, 250));
			panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Informaci\u00F3n de las Citas", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 37, 639, 315);
				panel.add(scrollPane);
			}
		}
	}

}
