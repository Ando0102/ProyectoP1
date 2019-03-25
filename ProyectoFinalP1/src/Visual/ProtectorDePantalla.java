package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ProtectorDePantalla extends JFrame {

	private JPanel contentPane;
	private Dimension tamaño;

	public ProtectorDePantalla() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProtectorDePantalla.class.getResource("/Imagenes/LogoPeque.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		tamaño = super.getToolkit().getScreenSize();
		super.setSize(tamaño.width, tamaño.height);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BIENVENIDO/A A LA CLINICA BDA ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(506, 11, 366, 138);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ProtectorDePantalla.class.getResource("/Imagenes/LogoMuyGrande.png")));
		lblNewLabel_1.setBounds(10, 11, 366, 541);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("                           \"El mejor m\u00E9dico es el que conoce la inutilidad de la mayor parte de las medicinas.\"\r\n  - Benjamin Franklin");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(188, 495, 961, 138);
		panel.add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ProtectorDePantalla.class.getResource("/Imagenes/LogoMuyGrande.png")));
		label.setBounds(1074, 11, 256, 541);
		panel.add(label);
	}
}
