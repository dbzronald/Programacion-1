package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

import logical.Partido;
import logical.Liga;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import com.toedter.calendar.JDateChooser;

public class InsertarPartido extends JDialog{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> cbhomeTeam, cbawayTeam, cbLocacion;
	public String HomeTeamName, AwayTeamName;
	public boolean HomeTeamStadistic, AwayTeamStadistic;
	private JDateChooser dateChooser;
	private Date date;
	private SpinnerDateModel spinnerDateModel;
	private JSpinner spnTiempo;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public InsertarPartido() {
		setResizable(false);
		setModal(true);
		dateChooser = new JDateChooser();
		date = new Date();
		spinnerDateModel = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
		setTitle("New game");
		setBounds(100, 100, 471, 171);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblHomeTeam = new JLabel("Home team:");
			lblHomeTeam.setBounds(10, 11, 68, 21);
			contentPanel.add(lblHomeTeam);
		}
		{
			JLabel lblAwayTeam = new JLabel("Away team:");
			lblAwayTeam.setBounds(246, 12, 68, 18);
			contentPanel.add(lblAwayTeam);
		}
		{
			cbhomeTeam = new JComboBox<String>();
			cbhomeTeam.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>"}));
			cbhomeTeam.setBounds(87, 11, 134, 20);
			for (int i = 0; i < Liga.getInstances().getEquipos().size(); i++)
				cbhomeTeam.addItem(""+Liga.getInstances().getEquipos().get(i).getNombre());
			contentPanel.add(cbhomeTeam);
		}
		{
			cbawayTeam = new JComboBox<String>();
			cbawayTeam.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>"}));
			cbawayTeam.setBounds(324, 11, 134, 20);
			for (int i = 0; i < Liga.getInstances().getEquipos().size(); i++)
				cbawayTeam.addItem(""+Liga.getInstances().getEquipos().get(i).getNombre());
			contentPanel.add(cbawayTeam);
		}
		
		cbawayTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbhomeTeam.getSelectedItem().toString().equalsIgnoreCase(cbawayTeam.getSelectedItem().toString())){
					JOptionPane.showMessageDialog(null, "Los campos son iguales!", "Warning!", JOptionPane.WARNING_MESSAGE);
					cbawayTeam.setSelectedIndex(0);
					cbhomeTeam.setSelectedIndex(0);
					}
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(199, 94, 0, -81);
		contentPanel.add(separator);
		
		JLabel lblLocacion = new JLabel("Locacion:");
		lblLocacion.setBounds(10, 43, 68, 21);
		contentPanel.add(lblLocacion);
		
		cbLocacion = new JComboBox<String>();
		cbLocacion.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "Rose Garden", "Quicken Loans Arena", "Oracle Arena ", "Madison Square Garden"}));
		cbLocacion.setBounds(87, 42, 371, 20);
		contentPanel.add(cbLocacion);
	
		
		JLabel lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setBounds(246, 73, 68, 21);
		contentPanel.add(lblTiempo);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 73, 68, 21);
		contentPanel.add(lblFecha);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(87, 73, 134, 20);
		dateChooser.setDate(date);
		contentPanel.add(dateChooser);
		
		spnTiempo = new JSpinner(spinnerDateModel);
		JSpinner.DateEditor de_spnTiempo = new JSpinner.DateEditor(spnTiempo, "hh:mm a");
		de_spnTiempo.getTextField().setEditable(true);
		spnTiempo.setEditor(de_spnTiempo);
		spnTiempo.setBounds(324, 73, 134, 20);
		contentPanel.add(spnTiempo);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			//Se registran los jugadores y ponen en el arraylist.
			JButton btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String dat = new SimpleDateFormat("MMM/dd/yyyy").format(dateChooser.getDate());
					JSpinner.DateEditor de = new JSpinner.DateEditor(spnTiempo, "hh:mm a");
					String homeTeam = cbhomeTeam.getSelectedItem().toString();
					String awayTeam = cbawayTeam.getSelectedItem().toString();
					String loca = cbLocacion.getSelectedItem().toString();
					String tiemp = de.getTextField().getText();
					boolean jugado = false;
					
					Partido partid = new Partido(dat, homeTeam, awayTeam, loca, 0, 0, tiemp, jugado);
					
					if (cbawayTeam.getSelectedIndex() == 0 || cbhomeTeam.getSelectedIndex() == 0 || cbLocacion.getSelectedIndex() == 0 || dateChooser.getDate().toString().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Hay campos que estan vacios!", "Warning!", JOptionPane.WARNING_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Juego registrado!", "", JOptionPane.INFORMATION_MESSAGE);
						Liga.getInstances().InsertarPartido(partid);
				
						Reset_Fields();
						dispose();
					}
				}
			});
			buttonPane.add(btnRegistrar);
			{
				JButton btnCerrar = new JButton("Cerrar");
				btnCerrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
						
					}
				});
				btnCerrar.setActionCommand("Cancel");
				buttonPane.add(btnCerrar);
			}
		}
	}
	
	public void Reset_Fields() {
		cbawayTeam.setSelectedIndex(0);
		cbhomeTeam.setSelectedIndex(0);
		cbLocacion.setSelectedIndex(0);
		dateChooser.setDate(date);
	}
	

}
