package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JSeparator;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;

import logical.Clientes;
import logical.Vehiculo;
import logical.Vendedor;
import logical.Ventas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class RegVenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombre;
	private JTextField apellido;
	private JTextField direccion;
	private JTextField monto;
	private JTextField codigo;
	private JTextField fecha;
	private JFormattedTextField cedula;
	private JFormattedTextField telefono;
	private MaskFormatter cedPatron;
	private MaskFormatter telePatron;
	private Vendedor ven;
	private Clientes myClient = null;
	private Ventas myVenta = null;
	private Vehiculo myVehiculo = null;
	private JComboBox modelos;
	private Vehiculo veh = null;
	private JTextField cColor;
	private JTextField cMarca;
	private JTextField cTipo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public RegVenta(Vendedor pven, Clientes clientes, Ventas venta, Vehiculo vehiculo) {
		setFont(new Font("SansSerif", Font.PLAIN, 12));
		setTitle("REGISTRAR\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\buch\\workspace\\Tarea1\\icon.png"));
		this.ven = pven;
		myClient = clientes;
		myVenta = venta;
		myVehiculo = vehiculo;
		getContentPane().setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 450, 313);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBounds(0, 0, 434, 240);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy");
		
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("CLIENTE:");
			label.setForeground(new Color(0, 0, 128));
			label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
			label.setBounds(174, 1, 70, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Nombre:");
			label.setForeground(new Color(0, 0, 0));
			label.setBounds(13, 21, 56, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Apellido:");
			label.setForeground(new Color(0, 0, 0));
			label.setBounds(13, 46, 56, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Cedula:");
			label.setForeground(new Color(0, 0, 0));
			label.setBounds(213, 27, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Direccion:");
			label.setForeground(new Color(0, 0, 0));
			label.setBounds(213, 52, 86, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Telefono:");
			label.setForeground(new Color(0, 0, 0));
			label.setBounds(213, 77, 64, 14);
			contentPanel.add(label);
		}
		{
			nombre = new JTextField();
			nombre.setColumns(10);
			nombre.setBounds(79, 18, 98, 23);
			contentPanel.add(nombre);
		}
		{
			apellido = new JTextField();
			apellido.setColumns(10);
			apellido.setBounds(79, 43, 98, 23);
			contentPanel.add(apellido);
		}
		{
			direccion = new JTextField();
			direccion.setColumns(10);
			direccion.setBounds(272, 46, 135, 23);
			contentPanel.add(direccion);
		}
		{
			JLabel label = new JLabel("Informacion de la Venta:");
			label.setForeground(new Color(0, 0, 0));
			label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
			label.setBounds(14, 103, 154, 14);
			contentPanel.add(label);
		}
		{
			JSeparator separator = new JSeparator();
			separator.setBounds(-4, 100, 424, 14);
			contentPanel.add(separator);
		}
		{
			JLabel label = new JLabel("Codigo:");
			label.setForeground(new Color(0, 0, 0));
			label.setBounds(269, 144, 46, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("Fecha:");
			label.setForeground(new Color(0, 0, 0));
			label.setBounds(273, 182, 46, 14);
			contentPanel.add(label);
		}
		{
			codigo = new JTextField();
			codigo.setColumns(10);
			codigo.setBounds(312, 140, 86, 23);
			contentPanel.add(codigo);
		}
		{
			fecha = new JTextField();
			fecha.setEditable(false);
			fecha.setColumns(10);
			fecha.setBounds(312, 178, 86, 23);
			contentPanel.add(fecha);
		}
		{
			try {
				cedPatron = new MaskFormatter("###-#######-#");
				telePatron = new MaskFormatter("###-###-####");
			} catch(ParseException e) {
				e.printStackTrace();
			};
			cedula = new JFormattedTextField(cedPatron);
			cedula.setBounds(272, 17, 135, 23);
			contentPanel.add(cedula);
		}
		{
			telefono = new JFormattedTextField(telePatron);
			telefono.setBounds(272, 73, 86, 23);
			contentPanel.add(telefono);
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 181));
		panel.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(240, 240, 240), new Color(255, 255, 255), new Color(0, 0, 0), new Color(160, 160, 160)), new LineBorder(new Color(0, 0, 0), 5)), "CARRO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(4, 118, 246, 121);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JLabel label = new JLabel("Monto:");
			label.setForeground(new Color(0, 0, 0));
			label.setBounds(10, 91, 46, 14);
			panel.add(label);
		}
		{
			JLabel lblModelo_1 = new JLabel("Modelo:");
			lblModelo_1.setForeground(new Color(0, 0, 0));
			lblModelo_1.setBounds(10, 22, 118, 14);
			panel.add(lblModelo_1);
		}
		
		modelos = new JComboBox();
		modelos.setBounds(71, 19, 118, 23);
		panel.add(modelos);
		{
			monto = new JTextField();
			monto.setBounds(52, 87, 64, 23);
			panel.add(monto);
			monto.setEditable(false);
			monto.setColumns(10);
		}
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setForeground(new Color(0, 0, 0));
		lblColor.setBounds(10, 61, 46, 14);
		panel.add(lblColor);
		
		cColor = new JTextField();
		cColor.setEditable(false);
		cColor.setColumns(10);
		cColor.setBounds(52, 57, 64, 23);
		panel.add(cColor);
		
		JLabel lblModelo = new JLabel("Marca:");
		lblModelo.setForeground(new Color(0, 0, 0));
		lblModelo.setBounds(126, 61, 46, 14);
		panel.add(lblModelo);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(new Color(0, 0, 0));
		lblTipo.setBounds(126, 91, 46, 14);
		panel.add(lblTipo);
		
		fecha.setText(format.format(date));
		
		cMarca = new JTextField();
		cMarca.setEditable(false);
		cMarca.setBounds(172, 58, 64, 23);
		panel.add(cMarca);
		cMarca.setColumns(10);
		
		cTipo = new JTextField();
		cTipo.setEditable(false);
		cTipo.setColumns(10);
		cTipo.setBounds(172, 88, 64, 23);
		panel.add(cTipo);
		modelos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modelos.getSelectedIndex()!=0){
					String mod = modelos.getSelectedItem().toString();
					Vehiculo veh = ven.findModelo(mod);
					if(mod != null){
						cMarca.setText(veh.getMarca().toString());
						cColor.setText(veh.getColor().toString());
						monto.setText(String.valueOf(veh.getPrecio()));
						cTipo.setText(veh.getTipo().toString());
						
					}
				}
			}
		});
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 228, 181));
			buttonPane.setBounds(0, 236, 434, 38);
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(new Color(0, 0, 0));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBounds(101, 5, 56, 28);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(!nombre.getText().equalsIgnoreCase("")){
							Clientes cliente = new Clientes();
							cliente.setNombre(nombre.getText());
							cliente.setApellido(apellido.getText());
							cliente.setDireccion(direccion.getText());
							cliente.setCedula(cedula.getText());
							cliente.setTelefono(telefono.getText());
							
							Ventas venta = new Ventas();
							venta.setMonto(Double.valueOf(monto.getText()));
							venta.setFecha(fecha.getText());
							venta.setCodigoVenta(Integer.valueOf(codigo.getText()));
							venta.setClientes(cliente);
							venta.setProducto(cMarca.getText());
							ven.registrarVentas(venta);
							
							cleanD();
							JOptionPane.showMessageDialog(null, "Venta registrado", null, JOptionPane.INFORMATION_MESSAGE, null);
						}else {
							JOptionPane.showMessageDialog(null, "Datos incompletos", null, JOptionPane.WARNING_MESSAGE, null);
						}
						
					}
				});
				buttonPane.setLayout(null);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(new Color(0, 0, 0));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBounds(258, 5, 74, 28);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadMonto();
	}
	private void cleanD(){
		
		nombre.setText("");
		apellido.setText("");
		direccion.setText("");
		cedula.setText("");
		telefono.setText("");
		monto.setText("");
		codigo.setText("");
		fecha.setText("");
		cColor.setText("");
		cMarca.setText("");
		cTipo.setText("");
		
		
	}
	
	private void loadMonto(){
		modelos.removeAll();
		
		for(int i = 0; i < ven.getCantVehiculos(); i++ ){
			modelos.addItem(ven.getListaVehiculos()[i].getModelo());
		}
		modelos.insertItemAt("<Vacio>", 0);
		modelos.setSelectedIndex(0);
	}
}
