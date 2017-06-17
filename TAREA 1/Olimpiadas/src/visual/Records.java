package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logical.Delegacion;
import logical.Equipo;




@SuppressWarnings("serial")
public class Records extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreEquipo;
	private JRadioButton rdbtnColectivo;
	private JRadioButton rdbtnIndividual;
	private JSpinner spnMedBronce;
	private JSpinner spnMedPlata;
	private JSpinner spnMedOro;
	//Equipo selectedToModify=null;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Records() {
		//selectedToModify = selected;
		setBounds(100, 100, 450, 264);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 414, 170);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		txtNombreEquipo = new JTextField();
		txtNombreEquipo.setBounds(10, 43, 142, 20);
		panel.add(txtNombreEquipo);
		txtNombreEquipo.setColumns(10);
		{
			JLabel lblNombre = new JLabel("Nombre :");
			lblNombre.setBounds(10, 29, 86, 14);
			panel.add(lblNombre);
		}
		
		JLabel lblMedBronce = new JLabel("Med. Bronce :\r\n");
		lblMedBronce.setBounds(10, 110, 86, 14);
		panel.add(lblMedBronce);
		
		JLabel lblMedPlata = new JLabel("Med. Plata :");
		lblMedPlata.setBounds(171, 110, 86, 14);
		panel.add(lblMedPlata);
		
		JLabel lblMedOro = new JLabel("Med. Oro :");
		lblMedOro.setBounds(328, 110, 67, 14);
		panel.add(lblMedOro);
		
		spnMedBronce = new JSpinner();
		spnMedBronce.setBounds(10, 124, 76, 20);
		panel.add(spnMedBronce);
		
		spnMedPlata = new JSpinner();
		spnMedPlata.setBounds(171, 124, 76, 20);
		panel.add(spnMedPlata);
		
		spnMedOro = new JSpinner();
		spnMedOro.setBounds(328, 123, 76, 22);
		panel.add(spnMedOro);
		
		rdbtnColectivo = new JRadioButton("Colectivo");
		rdbtnColectivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnColectivo.isSelected())
					rdbtnIndividual.setSelected(false);
			}
		});
		rdbtnColectivo.setBounds(181, 42, 109, 23);
		panel.add(rdbtnColectivo);
		
		rdbtnIndividual = new JRadioButton("Individual");
		rdbtnIndividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnIndividual.isSelected())
					rdbtnColectivo.setSelected(false);
			}
		});
		rdbtnIndividual.setBounds(286, 42, 109, 23);
		panel.add(rdbtnIndividual);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//if(selectedToModify == null){
						String nombre = txtNombreEquipo.getText();
						int oro = Integer.valueOf(spnMedOro.getValue().toString());
						int plata = Integer.valueOf(spnMedPlata.getValue().toString());
						int bronce = Integer.valueOf(spnMedBronce.getValue().toString());
						@SuppressWarnings("unused")
						boolean isColectivo=false;
						
						if(rdbtnColectivo.isSelected()){
							isColectivo=true;
							Equipo nuevoEquipo = new Equipo(nombre,oro,plata,bronce);
							Delegacion.getInstance().InsertarEquipo(nuevoEquipo);
							JOptionPane.showMessageDialog(null, "El Equipo se ha registrado!");
							
							clean();
						}
						else if(rdbtnIndividual.isSelected()){
							isColectivo=false;
						Equipo nuevoEquipo = new Equipo(nombre,oro,plata,bronce);
						Delegacion.getInstance().InsertarEquipo(nuevoEquipo);
						JOptionPane.showMessageDialog(null, "El Equipo se ha registrado!");
						clean();
						}
						
					}
						/*else {
							selectedToModify.setNombreTeam(txtNombreEquipo.getText());	
							selectedToModify.setCantMedOro((Integer.valueOf(spnMedOro.getValue().toString())));
							selectedToModify.setCantMedPlata((Integer.valueOf(spnMedPlata.getValue().toString())));
							selectedToModify.setCantMedBronce((Integer.valueOf(spnMedBronce.getValue().toString())));
						}
						dispose();*/
						//loadPublic();
					}
					
					
					/*private void loadPublic() {
						if(selectedToModify!= null){
							txtNombreEquipo.setText(selectedToModify.getNombreTeam());
							spnMedOro.setValue(selectedToModify.getCantMedOro());
							spnMedPlata.setValue(selectedToModify.getCantMedPlata());
							spnMedBronce.setValue(selectedToModify.getCantMedBronce());
						
								rdbtnColectivo.setEnabled(false);
								rdbtnIndividual.setEnabled(false);
								
							}
							txtNombreEquipo.setEditable(false);
						}*/
						
					//}
					
						
				);
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
	 txtNombreEquipo.setText("");
	 rdbtnColectivo.setSelected(false);
	 rdbtnIndividual.setSelected(false);
	 spnMedBronce.setValue(0);
	 spnMedPlata.setValue(0);
	 spnMedOro.setValue(0);
	 
		
	}
}
