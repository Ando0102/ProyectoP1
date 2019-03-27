package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VentaSecretaria extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableCitas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentaSecretaria dialog = new VentaSecretaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentaSecretaria() {
		setResizable(false);
		setTitle("Secretario/a");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bibir\\git\\ProyectoP1\\ProyectoFinalP1\\src\\Imagenes\\LogoPeque.png"));
		setBounds(100, 100, 938, 662);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelBienvenido = new JPanel();
			panelBienvenido.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panelBienvenido.setBounds(10, 11, 145, 564);
			contentPanel.add(panelBienvenido);
			panelBienvenido.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bibir\\git\\ProyectoP1\\ProyectoFinalP1\\src\\Imagenes\\secretaria.png"));
			lblNewLabel.setBounds(24, 11, 95, 123);
			panelBienvenido.add(lblNewLabel);
			
			JLabel lblBienvenidoa = new JLabel("Bienvenido/a!");
			lblBienvenidoa.setBounds(34, 145, 85, 14);
			panelBienvenido.add(lblBienvenidoa);
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\bibir\\git\\ProyectoP1\\ProyectoFinalP1\\src\\Imagenes\\LogoPeque.png"));
			lblNewLabel_1.setBounds(10, 419, 50, 57);
			panelBienvenido.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Clinica ADA");
			lblNewLabel_2.setBounds(47, 455, 65, 14);
			panelBienvenido.add(lblNewLabel_2);
		}
		{
			JPanel panelCitas = new JPanel();
			panelCitas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panelCitas.setBounds(165, 11, 747, 564);
			contentPanel.add(panelCitas);
			panelCitas.setLayout(null);
			
			JScrollPane scrollPaneCitas = new JScrollPane();
			scrollPaneCitas.setBounds(10, 45, 727, 508);
			panelCitas.add(scrollPaneCitas);
			
			tableCitas = new JTable();
			tableCitas.setCellSelectionEnabled(true);
			tableCitas.setColumnSelectionAllowed(true);
			tableCitas.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Paciente", "Doctor", "Fecha y Hora"
				}
			));
			scrollPaneCitas.setViewportView(tableCitas);
			
			JButton btnNuevaCita = new JButton("Nueva");
			btnNuevaCita.setBounds(214, 11, 89, 23);
			panelCitas.add(btnNuevaCita);
			
			JButton btnModificarCita = new JButton("Modificar");
			btnModificarCita.setBounds(469, 11, 89, 23);
			panelCitas.add(btnModificarCita);
		}
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
