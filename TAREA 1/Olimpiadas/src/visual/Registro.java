package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logical.Delegacion;
import logical.Deportista;
import logical.Equipo;

@SuppressWarnings("serial")
public class Registro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreDep;
	private JTextField txtEstatura;
	private JTextField txtPeso;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private JComboBox<String> cbEquipos;
	

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Registro() {
		setBounds(100, 100, 366, 313);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 333, 139);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNombre = new JLabel("Nombre :");
				lblNombre.setBounds(10, 28, 112, 14);
				panel.add(lblNombre);
			}
			{
				txtNombreDep = new JTextField();
				txtNombreDep.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				txtNombreDep.setBounds(10, 48, 182, 20);
				panel.add(txtNombreDep);
				txtNombreDep.setColumns(10);
			}
			
			txtEstatura = new JTextField();
			txtEstatura.setBounds(10, 98, 86, 20);
			panel.add(txtEstatura);
			txtEstatura.setColumns(10);
			
			JLabel lblEstatura = new JLabel("Estatura :");
			lblEstatura.setBounds(10, 79, 86, 14);
			panel.add(lblEstatura);
			
			txtPeso = new JTextField();
			txtPeso.setBounds(106, 98, 86, 20);
			panel.add(txtPeso);
			txtPeso.setColumns(10);
			
			JLabel lblPeso = new JLabel("Peso :");
			lblPeso.setBounds(106, 79, 46, 14);
			panel.add(lblPeso);
			
			JLabel lblSexo = new JLabel("Sexo :");
			lblSexo.setBounds(222, 48, 46, 14);
			panel.add(lblSexo);
			
			rdbtnMasculino = new JRadioButton("Masculino");
			rdbtnMasculino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnMasculino.isSelected())
						rdbtnFemenino.setSelected(false);
					
				}
			});
			rdbtnMasculino.setBounds(222, 70, 94, 23);
			panel.add(rdbtnMasculino);
			
			rdbtnFemenino = new JRadioButton("Femenino");
			rdbtnFemenino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(rdbtnFemenino.isSelected())
						rdbtnMasculino.setSelected(false);
				}
			});
			rdbtnFemenino.setBounds(222, 97, 94, 23);
			panel.add(rdbtnFemenino);
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 161, 333, 2);
		contentPanel.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 169, 333, 61);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblEquipos = new JLabel("Equipos :");
		lblEquipos.setBounds(10, 25, 82, 14);
		panel.add(lblEquipos);
		
		cbEquipos = new JComboBox();
		for (Equipo aux : Delegacion.getInstance().getMiEquipo()) {
			cbEquipos.addItem("<Seleccione>");
			cbEquipos.addItem(aux.getNombreTeam());
		
		}
		
		cbEquipos.setBounds(132, 22, 191, 20);
		panel.add(cbEquipos);

		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nombre = txtNombreDep.getText();
						//Double peso = new Double(txtPeso.toString());
						//Double estatura = new Double(txtEstatura.toString());
						@SuppressWarnings("unused")
						boolean SexoMasc=false;
						
						if(rdbtnMasculino.isSelected()){
							SexoMasc=true;
							//Deportista nuevoDep = new Deportista(nombre,peso,estatura);
							//Delegacion.getInstance().InsertarDeportista(nuevoDep);
							JOptionPane.showMessageDialog(null, "El Deportista se ha registrado!");
							clean();
						}
						else if(rdbtnFemenino.isSelected()){
							SexoMasc=false;
						//Deportista nuevoDep = new Deportista(nombre,peso,estatura);
						//Delegacion.getInstance().InsertarDeportista(nuevoDep);
						JOptionPane.showMessageDialog(null, "El Deportista se ha registrado!");
						clean();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void clean(){
		txtNombreDep.setText("");
		txtEstatura.setText("");
		txtPeso.setText("");
		rdbtnMasculino.setSelected(false);
		rdbtnFemenino.setSelected(false);
		cbEquipos.setSelectedIndex(0);
		
	}
}
