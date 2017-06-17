package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

import javax.swing.JTextField;

import java.io.Serializable;

import com.toedter.calendar.JDateChooser;

import logical.Equipo;
import logical.Jugador;
import logical.Lesion;
import logical.Liga;

public class InsertarLesion extends JDialog implements Serializable{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> cbEquipo, cbJugador, cbTipo;
	private JTextField txtRegreso;
	private JDateChooser dateChooser;
	private JLabel lblTipo,lblFechaini,lblFechafin,lblEquipo;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public InsertarLesion() {
		
		setModal(true);
		setTitle("Insertar Lesion");
		setBounds(100, 100, 496, 218);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion de Lesion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 461, 225);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 54, 48, 14);
		panel.add(lblTipo);
		
		cbTipo = new JComboBox();
		cbTipo.setEnabled(false);
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"<Select Lesion>", "Tobillo", "Muneca", "Rodilla", "Hombro", "Espalda"}));
		cbTipo.setBounds(58, 51, 400, 20);
		panel.add(cbTipo);
		
		lblFechaini = new JLabel("Fecha:");
		lblFechaini.setBounds(10, 99, 48, 14);
		panel.add(lblFechaini);
		
		lblFechafin = new JLabel("Retorno:");
		lblFechafin.setBounds(236, 99, 96, 14);
		panel.add(lblFechafin);
		
		lblEquipo = new JLabel("Equipo:");
		lblEquipo.setBounds(10, 29, 48, 14);
		panel.add(lblEquipo);
		
		cbEquipo = new JComboBox();
		
		cbEquipo.setModel(new DefaultComboBoxModel(new String[] {"<Select Equipo>"}));
		cbEquipo.setBounds(58, 26, 127, 20);
		for (Equipo aux : Liga.getInstances().getEquipos())
			cbEquipo.addItem(aux.getNombre());
		panel.add(cbEquipo);
		
		cbEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbJugador.setModel(new DefaultComboBoxModel(new String[] {"<Select Jugador>"}));
				cbJugador.setEnabled(true);
				
				for (Equipo aux : Liga.getInstances().getEquipos()){
					for (Jugador aux2 : aux.getJugadores()){
						
						cbJugador.setEnabled(true);
						if (cbEquipo.getSelectedItem().toString().equalsIgnoreCase(aux.getNombre())){
							cbJugador.addItem(aux2.getNombre()+" "+aux2.getApellido());
						}
					}
				}
				if (cbEquipo.getSelectedIndex()==0)
					cbJugador.setEnabled(false);
			}
			
		});
		
		JLabel lblJugador = new JLabel("Jugador:");
		lblJugador.setBounds(238, 29, 68, 14);
		panel.add(lblJugador);
		
		cbJugador = new JComboBox();
		cbJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(cbEquipo.getSelectedIndex()!=0)
					cbJugador.setEnabled(true);
					
				if(cbJugador.getSelectedIndex()!=0)
					cbTipo.setEnabled(true);
				
				if(cbJugador.getSelectedIndex()==0)
					cbTipo.setEnabled(false);
				
			}
		});
		cbJugador.setEnabled(false);
		cbJugador.setModel(new DefaultComboBoxModel(new String[] {"<Select jugador>"}));
		cbJugador.setBounds(301, 26, 157, 20);
		panel.add(cbJugador);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(442, 182, -433, -83);
		
		txtRegreso = new JTextField();
		txtRegreso.setBounds(301, 96, 157, 20);
		panel.add(txtRegreso);
		txtRegreso.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(58, 96, 127, 20);
		panel.add(dateChooser);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 247, 478, 2);
		contentPanel.add(separator);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Insertar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//Insertar la lesion.
						//if (cbJugador.getSelectedIndex() != 0 && cbEquipo.getSelectedIndex() != 0 && cbTipo.getSelectedIndex() != 0  && dateChooser.getDate().toString().isEmpty()) {
							Lesion inj = new Lesion(cbJugador.getSelectedItem().toString(), cbEquipo.getSelectedItem().toString(), cbTipo.getSelectedItem().toString(), dateChooser.getDate().toString(), txtRegreso.getText());
							JOptionPane.showMessageDialog(null, "Lesion Registrada " + cbJugador.getSelectedItem().toString(), null, JOptionPane.INFORMATION_MESSAGE);
							Liga.getInstances().getEquipos().get(cbEquipo.getSelectedIndex()).getJugadores().get(cbJugador.getSelectedIndex()).InsertarLesion(inj);
							clean();
							
					}
					});
				
				

				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cerrar");
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
	
	public JComboBox<String> getComboBox_Team() {
		return cbEquipo;
	}
	
	public JComboBox<String> getComboBox_Player() {
		return cbJugador;
	}
	
	//Limpiar los campos llenados
	private void clean() {

		cbEquipo.setSelectedIndex(0);
		cbJugador.setSelectedIndex(0);
		cbTipo.setSelectedIndex(0);
		txtRegreso.setText("");
		dateChooser.setDate(null);
	}

	
	
}
