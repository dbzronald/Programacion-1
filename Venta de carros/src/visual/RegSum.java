package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;

import javax.swing.border.TitledBorder;

import logical.Sum;
import logical.Typeline;
import logical.Vehiculo;
import logical.Vendedor;

import java.awt.Toolkit;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;

public class RegSum extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField marca;
	private JTextField pais;
	private JTextField codigo;
	private JTextField apellido;
	private JTextField nombre;
	private Vendedor ven;
	private Sum mySum = null;
	private boolean option = true;
	private static int cant;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public RegSum(Vendedor pven, Sum sumi, boolean option) {
		setTitle("REGISTRAR");
		this.ven = pven;
		mySum = sumi;
		this.option = option;
		getContentPane().setBackground(new Color(0, 0, 128));
		setTitle("Registar");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBounds(0, 0, 434, 228);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel("Marca:");
		label.setBackground(new Color(0, 0, 0));
		label.setForeground(new Color(0, 0, 0));
		label.setBounds(260, 98, 46, 24);
		contentPanel.add(label);
		
		marca = new JTextField();
		marca.setColumns(10);
		marca.setBounds(312, 95, 86, 24);
		contentPanel.add(marca);
		
		pais = new JTextField();
		pais.setColumns(10);
		pais.setBounds(312, 68, 86, 24);
		contentPanel.add(pais);
		
		JLabel label_1 = new JLabel("Pais:");
		label_1.setBackground(new Color(0, 0, 0));
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setBounds(260, 68, 46, 14);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Codigo");
		label_2.setBackground(new Color(0, 0, 0));
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setBounds(260, 43, 46, 14);
		contentPanel.add(label_2);
		
		codigo = new JTextField();
		codigo.setColumns(10);
		codigo.setBounds(312, 40, 86, 24);
		contentPanel.add(codigo);
		
		JLabel label_4 = new JLabel("Nombre:");
		label_4.setBackground(new Color(0, 0, 0));
		label_4.setForeground(new Color(0, 0, 0));
		label_4.setBounds(24, 40, 125, 24);
		contentPanel.add(label_4);
		
		apellido = new JTextField();
		apellido.setColumns(10);
		apellido.setBounds(79, 71, 93, 24);
		contentPanel.add(apellido);
		
		nombre = new JTextField();
		nombre.setColumns(10);
		nombre.setBounds(79, 40, 93, 24);
		contentPanel.add(nombre);
		
		JLabel label_5 = new JLabel("Apellido:");
		label_5.setBackground(new Color(0, 0, 0));
		label_5.setForeground(new Color(0, 0, 0));
		label_5.setBounds(24, 71, 98, 24);
		contentPanel.add(label_5);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 181));
		panel.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(240, 240, 240), new Color(255, 255, 255), new Color(105, 105, 105), new Color(0, 0, 0)), new LineBorder(new Color(0, 0, 0), 5)), "SUMINISTRADOR", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 6, 422, 173);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(-6, 203, 452, 14);
		contentPanel.add(separator);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 228, 181));
			buttonPane.setBounds(0, 228, 434, 33);
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setBackground(new Color(0, 0, 0));
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setBounds(83, 0, 100, 28);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(mySum == null){
						if(!nombre.getText().equalsIgnoreCase("")){
							
							Sum sumi = new Sum();
							sumi.setNombre(nombre.getText());
							sumi.setApellido(apellido.getText());
							sumi.setCodigo(codigo.getText());
							sumi.setMarca(marca.getText());
							sumi.setPais(pais.getText());
													
							ven.registrarSum(sumi);
							cant=cant+1;
							cleanD();
							JOptionPane.showMessageDialog(null, "Suministrador registrado", null, JOptionPane.INFORMATION_MESSAGE, null);
							
						} else {
							JOptionPane.showMessageDialog(null, "Datos incompletos", null, JOptionPane.WARNING_MESSAGE, null);
						}
					}else{
						
						mySum.setCodigo(codigo.getText());
						mySum.setNombre(nombre.getText());
						mySum.setApellido(apellido.getText());
						mySum.setPais(pais.getText());
						mySum.setMarca(marca.getText());
						
						
						ven.modificarSum(mySum);
						dispose();
						ListaSum.loadSum();
						
					}
				
					}
				});
				buttonPane.setLayout(null);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(new Color(0, 0, 0));
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setBounds(266, 0, 85, 28);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		loadSumModificado();
		
	}
	private void cleanD() {
		nombre.setText("");
		marca.setText("");
		codigo.setText("");
		pais.setText("");
		apellido.setText("");
		
	}
	
	private void loadSumModificado(){
		if(!option){
			codigo.setText(String.valueOf(mySum.getCodigo()));
			nombre.setText(mySum.getNombre());
			apellido.setText(mySum.getApellido());
			pais.setText(mySum.getPais());
			marca.setText(mySum.getMarca());
		}
	}
	public static int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
}
