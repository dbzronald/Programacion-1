package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



import javax.swing.JSeparator;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Label;

import logical.Sum;
import logical.Typeline;
import logical.Vehiculo;
import logical.Vendedor;

import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class RegCarro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField modelo;
	private JTextField color;
	private JTextField precio;
	private Vendedor ven;
	private Vehiculo myVehiculo = null;
	private boolean option = true;
	private JComboBox tipo;
	private JComboBox suplidor;
	private Sum sumi = null;
	private JTextField marca;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public RegCarro(Vendedor pven, String titulo, boolean option, Vehiculo vehiculo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\buch\\workspace\\Tarea1\\ico.png"));
		setTitle("REGISTRAR");
		this.option = option;
		myVehiculo = vehiculo;
		this.ven = pven;
		getContentPane().setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBounds(0, 0, 444, 220);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblColor.setForeground(new Color(0, 0, 0));
		lblColor.setBounds(229, 53, 46, 14);
		contentPanel.add(lblColor);
		
		JLabel lblT = new JLabel("Tipo:");
		lblT.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblT.setForeground(new Color(0, 0, 0));
		lblT.setBounds(229, 86, 46, 14);
		contentPanel.add(lblT);
		
		tipo = new JComboBox();
		tipo.setModel(new DefaultComboBoxModel(new String[] {"<Vacio>", "Auto", "Autobus", "Microbus"}));
		tipo.setToolTipText("Auto");
		tipo.setBounds(269, 83, 124, 24);
		contentPanel.add(tipo);
		
		color = new JTextField();
		color.setBounds(269, 48, 124, 24);
		contentPanel.add(color);
		color.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(-18, 209, 459, 14);
		contentPanel.add(separator);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblPrecio.setForeground(new Color(0, 0, 0));
		lblPrecio.setBounds(24, 80, 46, 14);
		contentPanel.add(lblPrecio);
		
		precio = new JTextField();
		precio.setBounds(79, 80, 116, 24);
		contentPanel.add(precio);
		precio.setColumns(10);
		
		JLabel lblSuplidor = new JLabel("Suplidor:");
		lblSuplidor.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblSuplidor.setForeground(new Color(0, 0, 0));
		lblSuplidor.setBounds(24, 118, 53, 14);
		contentPanel.add(lblSuplidor);
		
		suplidor  = new JComboBox();
		suplidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(suplidor.getSelectedIndex()!=0){
					String nombre = suplidor.getSelectedItem().toString();
					Sum sumi = ven.findSum(nombre);
					if(sumi!=null){
						marca.setText(sumi.getMarca().toString());
					}
					
				}
			}
		});
	
		suplidor.setBounds(79, 115, 116, 24);
		contentPanel.add(suplidor);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblMarca.setForeground(Color.BLACK);
		lblMarca.setBounds(229, 117, 46, 14);
		contentPanel.add(lblMarca);
		
		marca = new JTextField();
		marca.setEditable(false);
		marca.setBounds(269, 111, 124, 24);
		contentPanel.add(marca);
		marca.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 181));
		panel.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(240, 240, 240), new Color(255, 255, 255), new Color(105, 105, 105), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 5, true)), "CARRO", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 11, 422, 160);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		modelo = new JTextField();
		modelo.setBounds(73, 37, 116, 24);
		panel.add(modelo);
		modelo.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblModelo.setForeground(new Color(0, 0, 0));
		lblModelo.setBounds(18, 37, 46, 24);
		panel.add(lblModelo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 228, 181));
			buttonPane.setBounds(0, 216, 444, 45);
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setBackground(Color.BLACK);
				okButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
				okButton.setForeground(Color.WHITE);
				okButton.setBounds(89, 5, 88, 28);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(myVehiculo == null){
						if(!modelo.getText().equalsIgnoreCase("")){
							Vehiculo vehiculo = new Vehiculo();
							vehiculo.setModelo(modelo.getText());
							vehiculo.setColor(color.getText());
							vehiculo.setMarca(marca.getText());
							vehiculo.setPrecio(Double.valueOf(precio.getText()));
							vehiculo.setSumi(String.valueOf(suplidor.getSelectedItem()));
							if(tipo.getSelectedItem().toString().equalsIgnoreCase("Auto")){
								vehiculo.setTipo(Typeline.auto);
							}else if(tipo.getSelectedItem().toString().equalsIgnoreCase("Autobus")){
								vehiculo.setTipo(Typeline.autobus);
							}else if(tipo.getSelectedItem().toString().equalsIgnoreCase("Microbus")){
								vehiculo.setTipo(Typeline.microbus);
							}
							ven.registrarVehiculo(vehiculo);
							cleanD();
							JOptionPane.showMessageDialog(null, "Vehiculo registrado", null, JOptionPane.INFORMATION_MESSAGE, null);
						}else {
							JOptionPane.showMessageDialog(null, "Datos incompletos", null, JOptionPane.WARNING_MESSAGE, null);
						}
						}else{
							myVehiculo.setModelo(modelo.getText());
							myVehiculo.setColor(color.getText());
							myVehiculo.setMarca(marca.getText());
							myVehiculo.setPrecio(Double.valueOf(precio.getText()));
							if(tipo.getSelectedItem().toString().equalsIgnoreCase("Auto")){
								myVehiculo.setTipo(Typeline.auto);
							}else if(tipo.getSelectedItem().toString().equalsIgnoreCase("Autobus")){
								myVehiculo.setTipo(Typeline.autobus);
							}else if(tipo.getSelectedItem().toString().equalsIgnoreCase("Microbus")){
								myVehiculo.setTipo(Typeline.microbus);
							}
							
							ven.modificarVehiculos(myVehiculo);
							dispose();
							ListCarros.loadVehiculos();
						}
							
						}
						
					}
				);
				buttonPane.setLayout(null);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(Color.BLACK);
				cancelButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setBounds(266, 5, 88, 28);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadVehiculoModificado();
		loadV();
	}
	private void loadVehiculoModificado(){
		if(!option){
			modelo.setText(myVehiculo.getModelo());
			precio.setText(String.valueOf(myVehiculo.getPrecio()));
			color.setText(myVehiculo.getColor());
			
			if(myVehiculo.getTipo().toString().equalsIgnoreCase("Auto"))
			  tipo.setSelectedIndex(1);
			else if(myVehiculo.getTipo().toString().equalsIgnoreCase("Autobus"))
				  tipo.setSelectedIndex(2);
			else if(myVehiculo.getTipo().toString().equalsIgnoreCase("Microbus"))
				  tipo.setSelectedIndex(3);
			
		}
	}
	private void cleanD() {
		
		modelo.setText("");
		marca.setText("");
		precio.setText("");
		color.setText("");
		tipo.setSelectedIndex(0);
		suplidor.setSelectedIndex(0);

	}
	
	private void loadV(){
		suplidor.removeAll();
		
		for (int i = 0; i < ven.getCantSum(); i++) {
			suplidor.addItem(ven.getListaSum()[i].getNombre());
		}
		suplidor.insertItemAt("<Vacio>", 0);
		suplidor.setSelectedIndex(0);
	}
}


