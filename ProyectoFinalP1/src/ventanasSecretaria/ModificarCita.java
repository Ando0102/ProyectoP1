package ventanasSecretaria;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class ModificarCita extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtBusquedaPersona;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ModificarCita dialog = new ModificarCita();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModificarCita() {
		setTitle("Modificar Cita");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarCita.class.getResource("/Imagenes/LogoPeque.png")));
		setBounds(100, 100, 839, 444);
		setModal(true);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Listado de Citas:", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(230, 230, 250));
		panel.setBounds(10, 11, 662, 393);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 642, 320);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre Completo", "Doctor", "Fecha", "Hora"
			}
		));
		JTableHeader header = table.getTableHeader();
	    header.setBackground(new Color(230, 230, 250));
	    table.setDefaultEditor(Object.class, null);
	    table.setCellSelectionEnabled(true);
		table.setBackground(SystemColor.inactiveCaptionBorder);
		scrollPane.setViewportView(table);
		
		JLabel lblBusquedaDePersona = new JLabel("Busqueda de Persona:");
		lblBusquedaDePersona.setBounds(10, 11, 152, 14);
		panel.add(lblBusquedaDePersona);
		
		txtBusquedaPersona = new JTextField();
		txtBusquedaPersona.setBounds(10, 32, 225, 20);
		panel.add(txtBusquedaPersona);
		txtBusquedaPersona.setColumns(10);
		
		JButton btnBusquedaPersona = new JButton("");
		btnBusquedaPersona.setBackground(new Color(230, 230, 250));
		btnBusquedaPersona.setBorder(null);
		btnBusquedaPersona.setBorderPainted(false);
		btnBusquedaPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBusquedaPersona.setIcon(new ImageIcon(ModificarCita.class.getResource("/Imagenes/preview_search_find_locate_1551.png")));
		btnBusquedaPersona.setBounds(245, 32, 32, 32);
		panel.add(btnBusquedaPersona);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(682, 11, 141, 393);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		{
			JButton cancelButton = new JButton("Salir");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int resp = JOptionPane.showOptionDialog(null, "Estas seguro que deseas salir?", "Advertencia!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[] { "Si", "No" }, null); 
					if(resp == 0){
					dispose();
					} else{
						repaint();
					}
					
				}
			});
			cancelButton.setBounds(10, 305, 121, 53);
			panel_1.add(cancelButton);
			cancelButton.setBackground(UIManager.getColor("Button.highlight"));
			cancelButton.setIcon(new ImageIcon(ModificarCita.class.getResource("/Imagenes/cancelar2.png")));
			cancelButton.setActionCommand("Cancel");
		}
		
		JButton btnBorrarCita = new JButton("Cancelar");
		btnBorrarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UIManager UI=new UIManager(); 
				UIManager.put("OptionPane.background", SystemColor.inactiveCaptionBorder); 
				UIManager.put("Panel.background", SystemColor.inactiveCaptionBorder); 
				int resp = JOptionPane.showOptionDialog(null, "Estas seguro?", "Advertencia!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[] { "Si", "No" }, null);   // null para YES, NO y CANCEL			   
				
			}
		});
		btnBorrarCita.setIcon(new ImageIcon(ModificarCita.class.getResource("/Imagenes/recycle_recyclebin_full_delete_trash_1772.png")));
		btnBorrarCita.setBackground(UIManager.getColor("Button.highlight"));
		btnBorrarCita.setBounds(10, 230, 121, 53);
		panel_1.add(btnBorrarCita);
		
		JButton btnModificarCita = new JButton("Editar");
		btnModificarCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevaCita citas = new NuevaCita();
				citas.setModal(true);
				citas.setLocationRelativeTo(null);
				citas.visualizarCampos(false);
			}
		});
		btnModificarCita.setBackground(UIManager.getColor("Button.highlight"));
		btnModificarCita.setIcon(new ImageIcon(ModificarCita.class.getResource("/Imagenes/edit_icon-icons.com_52382.png")));
		btnModificarCita.setBounds(10, 155, 121, 53);
		panel_1.add(btnModificarCita);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ModificarCita.class.getResource("/Imagenes/lists_list_6082.png")));
		lblNewLabel.setBounds(10, 21, 99, 112);
		panel_1.add(lblNewLabel);
	}
}
