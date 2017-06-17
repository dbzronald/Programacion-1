package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;

import logical.ComplejoLacteo;
import logical.QuesoCilindrico;
import logical.QuesoEsferico;
import logical.QuesoHueco;
import logical.Quesos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class RegQuesos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField radio;
	private JTextField longitud;
	private JTextField radioInter;
	private JTextField precioU;
	private JTextField precioB;
	private JPanel panelMedidas;
	@SuppressWarnings("unused")
	private Quesos miQueso = null;
	private JTextField id;
	private JRadioButton rdbtnQuesoEsferico;
	private JRadioButton rdbtnQuesoCilindrico;
	private JRadioButton rdbtnQuesoHueco;
	private int Id = ComplejoLacteo.getInstance().getID();

	/**
	 * Launch the application.
	 * @param Complejo 
	 */

	/**
	 * Create the dialog.
	 */
	public RegQuesos(Quesos queso) {
		this.miQueso = queso;
		setBounds(100, 100, 465, 323);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panelMedidas = new JPanel();
		panelMedidas.setBackground(new Color(255, 255, 255));
		panelMedidas.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Medidas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelMedidas.setBounds(6, 11, 192, 117);
		contentPanel.add(panelMedidas);
		panelMedidas.setLayout(null);
		{
			JLabel lblRadio = new JLabel("Radio:");
			lblRadio.setBounds(12, 24, 36, 16);
			panelMedidas.add(lblRadio);
		}
		
		JLabel lblRadioExterior = new JLabel("Radio Interior:");
		lblRadioExterior.setBounds(12, 83, 98, 16);
		panelMedidas.add(lblRadioExterior);
		
		radio = new JTextField();
		radio.setBounds(110, 18, 45, 28);
		panelMedidas.add(radio);
		radio.setColumns(10);
		
		longitud = new JTextField();
		longitud.setBounds(110, 48, 45, 28);
		panelMedidas.add(longitud);
		longitud.setColumns(10);
		
		radioInter = new JTextField();
		radioInter.setBounds(110, 77, 45, 28);
		panelMedidas.add(radioInter);
		radioInter.setColumns(10);
		
		JLabel lblLongitud = new JLabel("Longitud:");
		lblLongitud.setBounds(12, 52, 55, 16);
		panelMedidas.add(lblLongitud);
		
		JPanel panelCostos = new JPanel();
		panelCostos.setBackground(new Color(255, 255, 255));
		panelCostos.setLayout(null);
		panelCostos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Costos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelCostos.setBounds(235, 11, 192, 117);
		contentPanel.add(panelCostos);
		
		JLabel lblCostoUnitario = new JLabel("Costo Unitario:");
		lblCostoUnitario.setBounds(12, 24, 86, 16);
		panelCostos.add(lblCostoUnitario);
		
		precioU = new JTextField();
		precioU.setColumns(10);
		precioU.setBounds(110, 18, 45, 28);
		panelCostos.add(precioU);
		
		precioB = new JTextField();
		precioB.setColumns(10);
		precioB.setBounds(110, 48, 45, 28);
		panelCostos.add(precioB);
		
		JLabel lblCostoBase = new JLabel("Costo Base:");
		lblCostoBase.setBounds(12, 52, 86, 16);
		panelCostos.add(lblCostoBase);
		
		id = new JTextField();
		id.setEditable(false);
		id.setVisible(false);
		id.setColumns(10);
		id.setBounds(110, 80, 45, 28);
		panelCostos.add(id);
		radio.setEditable(false);
		radioInter.setEditable(false);
		longitud.setEditable(false);
		
		id.setText(String.valueOf(Id));
		
	 rdbtnQuesoEsferico = new JRadioButton("Queso Esferico");
	 rdbtnQuesoEsferico.setBackground(Color.WHITE);
		rdbtnQuesoEsferico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnQuesoEsferico.isSelected()){
					rdbtnQuesoCilindrico.setSelected(false);
				rdbtnQuesoHueco.setSelected(false);
				radio.setEditable(true);
				radioInter.setEditable(false);
				longitud.setEditable(false);
			}
			}
		});
		rdbtnQuesoEsferico.setBounds(20, 155, 130, 23);
		contentPanel.add(rdbtnQuesoEsferico);
		
		rdbtnQuesoCilindrico = new JRadioButton("Queso Cilindrico");
		rdbtnQuesoCilindrico.setBackground(Color.WHITE);
		rdbtnQuesoCilindrico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnQuesoCilindrico.isSelected()){
					rdbtnQuesoEsferico.setSelected(false);
				radio.setEditable(true);
				rdbtnQuesoHueco.setSelected(false);
				longitud.setEditable(true);
			}
			}
		});
		rdbtnQuesoCilindrico.setBounds(163, 155, 130, 23);
		contentPanel.add(rdbtnQuesoCilindrico);
		
		rdbtnQuesoHueco = new JRadioButton("Queso Hueco");
		rdbtnQuesoHueco.setBackground(Color.WHITE);
		rdbtnQuesoHueco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnQuesoHueco.isSelected()){
					rdbtnQuesoEsferico.setSelected(false);
				rdbtnQuesoCilindrico.setSelected(false);
				radioInter.setEditable(true);
				longitud.setEditable(true);
				radio.setEditable(true);
			}
			}
		});
		rdbtnQuesoHueco.setBounds(295, 155, 132, 23);
		contentPanel.add(rdbtnQuesoHueco);
		
		JPanel panelNota = new JPanel();
		panelNota.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelNota.setBounds(16, 199, 411, 41);
		contentPanel.add(panelNota);
		panelNota.setLayout(null);
		
		JLabel lblnotaSeleccionar = new JLabel("*Nota : Seleccionar primero que tipo de queso es el que desea.");
		lblnotaSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnotaSeleccionar.setBounds(10, 0, 384, 41);
		panelNota.add(lblnotaSeleccionar);
		
		{
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLocation(-12, 186);
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {		
						if(rdbtnQuesoCilindrico.isSelected()){

									Quesos queso = new QuesoCilindrico(Integer.valueOf(precioB.getText()),Integer.valueOf(precioU.getText()),Float.valueOf(radio.getText()),Id,Float.valueOf(longitud.getText()));
									ComplejoLacteo.getInstance().addInventario(queso);
									JOptionPane.showMessageDialog(null, "El Queso se ha registrado!");
									
									clean();
						}
						else if(rdbtnQuesoHueco.isSelected()){
									
									if(Float.valueOf(radio.getText())>Float.valueOf(radioInter.getText())){
										JOptionPane.showMessageDialog(null, "No pueden tener esos radios!");
									}
									else{
										Quesos queso = new QuesoHueco(Integer.valueOf(precioB.getText()),Integer.valueOf(precioU.getText()),Float.valueOf(radio.getText()),Float.valueOf(radioInter.getText()),Id,Float.valueOf(longitud.getText()));
										ComplejoLacteo.getInstance().addInventario(queso);
										JOptionPane.showMessageDialog(null, "El Queso se ha registrado!");
										
										clean();
									}	
								}
						else if(rdbtnQuesoEsferico.isSelected()){
									Quesos queso = new QuesoEsferico(Integer.valueOf(precioB.getText()),Integer.valueOf(precioU.getText()),Float.valueOf(radio.getText()),Id);
									ComplejoLacteo.getInstance().addInventario(queso);
									JOptionPane.showMessageDialog(null, "El Queso se ha registrado!");
									
									clean();
							}
						}
					}					
			);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						ComplejoLacteo.getInstance().setID(Id);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void clean(){
		
		precioB.setText("");
		precioU.setText("");
		radio.setText("");
		radioInter.setText("");
		longitud.setText("");
		id.setText(String.valueOf(Id));
		
	}
}
