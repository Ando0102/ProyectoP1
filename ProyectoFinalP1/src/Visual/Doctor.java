package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Doctor extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Doctor dialog = new Doctor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Doctor() {
		setTitle("Doctor/a");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bibir\\git\\ProyectoP1\\ProyectoFinalP1\\src\\Imagenes\\LogoPeque.png"));
		setBounds(100, 100, 834, 554);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelBienvenido = new JPanel();
		panelBienvenido.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelBienvenido.setBounds(10, 11, 142, 456);
		contentPanel.add(panelBienvenido);
		panelBienvenido.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bibir\\git\\ProyectoP1\\ProyectoFinalP1\\src\\Imagenes\\doctor.png"));
		lblNewLabel.setBounds(30, 0, 88, 165);
		panelBienvenido.add(lblNewLabel);
		
		JLabel lblBienvenidoa = new JLabel("Bienvenido/a!");
		lblBienvenidoa.setBounds(30, 149, 76, 14);
		panelBienvenido.add(lblBienvenidoa);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\bibir\\git\\ProyectoP1\\ProyectoFinalP1\\src\\Imagenes\\LogoPeque.png"));
		lblNewLabel_1.setBounds(10, 309, 49, 56);
		panelBienvenido.add(lblNewLabel_1);
		
		JLabel lblClinicaAda = new JLabel("Clinica ADA");
		lblClinicaAda.setBounds(50, 342, 82, 14);
		panelBienvenido.add(lblClinicaAda);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCerrar = new JButton("Cerrar");
				btnCerrar.setActionCommand("OK");
				buttonPane.add(btnCerrar);
				getRootPane().setDefaultButton(btnCerrar);
			}
		}
	}
}
