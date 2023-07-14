package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorCiudades;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class VistaCiudades extends JFrame {

	private JPanel contentPane;
	private JTextField codigoPostal;
	private JTextField ciudad;
	private JLabel Ciudad;
	private JLabel lblCodigoPostal;

	private ControladorCiudades controlador = new ControladorCiudades();
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCiudades frame = new VistaCiudades();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaCiudades() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton Aceptar = new JButton("ACEPTAR");
		Aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // si no existe el registro dejo insertar
															// en caso contrario saco un mensaje

				if (controlador.existeEnBaseDeDatos(ciudad.getText())) {
					//
					controlador.modificarEnBaseDatos(ciudad.getText(), Integer.parseInt(codigoPostal.getText()));

					// JOptionPane.showMessageDialog(null," error, esta ciudad ya existe en el
					// registro");
				} else {

					controlador.guardarEnBaseDatos(ciudad.getText(), Integer.parseInt(codigoPostal.getText()));

				}

			}
		});
		Aceptar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		Aceptar.setBounds(410, 71, 89, 90);
		contentPane.add(Aceptar);

		codigoPostal = new JTextField();
		codigoPostal.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		codigoPostal.setBounds(179, 71, 180, 90);
		contentPane.add(codigoPostal);
		codigoPostal.setColumns(10);

		ciudad = new JTextField();
		ciudad.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		ciudad.setBounds(30, 71, 86, 90);
		contentPane.add(ciudad);
		ciudad.setColumns(10);

		Ciudad = new JLabel(" Ciudad");
		Ciudad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		Ciudad.setBounds(30, 30, 86, 30);
		contentPane.add(Ciudad);

		lblCodigoPostal = new JLabel("  Codigo Postal");
		lblCodigoPostal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblCodigoPostal.setBounds(179, 30, 180, 30);
		contentPane.add(lblCodigoPostal);

		JButton listar = new JButton("listar");
		listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, controlador.listarBaseDeDatos());
			}
		});
		listar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		listar.setBounds(410, 184, 89, 80);
		
		contentPane.add(listar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!controlador.existeEnBaseDeDatos(ciudad.getText())) {

					JOptionPane.showMessageDialog(null, " error, esta ciudad NO existe en el registro");
				} else {

					controlador.eliminarDeBaseDatos(ciudad.getText());
				}

			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnEliminar.setBounds(410, 293, 89, 74);
		contentPane.add(btnEliminar);
	}
}
