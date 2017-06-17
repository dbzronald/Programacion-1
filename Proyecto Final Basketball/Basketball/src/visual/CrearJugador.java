package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import logical.Equipo;
import logical.Jugador;
import logical.Liga;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class CrearJugador extends JDialog  implements Serializable
{	
	private static final long serialVersionUID = 1L;	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre, txtApellido, txtEdad;
	private DefaultTableModel tableModel;
	private JButton btnModify,btnDelete, btnInsert;
	private JButton btnBorrar;
	private JSpinner spnPies, spnNumero, spnAltura;
	@SuppressWarnings("rawtypes")
	private JComboBox cbPosicion;
	@SuppressWarnings("rawtypes")
	private JComboBox cbEquipo, cbLesion;
	private JSpinner spnPeso;
	private Object[] row;
	private JLabel lblNombre, lblNacimiento, lblEdad, lblPeso, lblPosicion, lblHeight, lblApellido, lblNo, lblLesion;
	private JLabel lblAltura;
	private JTable tableJugadores;
	private JDateChooser dateChooser;
	
	int year;
	String aux;
	InsertarLesion injury;
	
	ArrayList<Jugador> listPlayers;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CrearJugador() throws ClassNotFoundException, IOException 
	{
		setResizable(false);
		
		setModal(true);
		injury = new InsertarLesion();
		new JCalendar();
		listPlayers = new ArrayList<>();	
		setTitle("Crear Jugador");
		setBounds(100, 100, 700, 573);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		btnDelete = new JButton("Delete");
		
		
		btnDelete.setBounds(304, 507, 75, 23);
		btnBorrar = new JButton("Borrar");
		btnBorrar.setEnabled(false);
		btnBorrar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//Elimina un jugador.
				int answer = JOptionPane.showConfirmDialog(null, "Desea eliminar este jugador?",null,JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION)
				{
					Delete_Player();
					Load_Player();
					
				}
			}
		});
		btnBorrar.setBounds(346, 507, 75, 23);
		contentPanel.add(btnBorrar);
		btnModify = new JButton("Modify");
		btnModify.setEnabled(false);
		btnModify.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				Modify_Player();
				btnModify.setEnabled(false);
				tableJugadores.setEnabled(false);
				btnDelete.setEnabled(false); 
			}
		});
		btnModify.setBounds(431, 507, 74, 23);
		contentPanel.add(btnModify);
		btnInsert = new JButton("Insert");
		btnInsert.setEnabled(false);
		btnInsert.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Se inserta el jugador.
				String Born = new SimpleDateFormat("MMM/dd/yyyy").format(dateChooser.getDate());
				aux = ""+Born.charAt(7)+Born.charAt(8)+Born.charAt(9)+Born.charAt(10);
				year = Integer.parseInt(aux);
				boolean inj = false;
				if (cbLesion.getSelectedIndex() == 0)
				{
					inj = false;
				}
				else
				{
					inj = true;
				}
				Jugador pla = new Jugador(txtNombre.getText(), txtApellido.getText(), 2016-year, (int) spnPeso.getValue(), (int)spnAltura.getValue(), (int)spnPies.getValue(), (int)spnNumero.getValue(),cbPosicion.getSelectedItem().toString(),Born, inj, cbEquipo.getSelectedItem().toString());
			
				//Revisa si los campos estan vacios.
				if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || cbPosicion.getSelectedIndex() == 0 || cbEquipo.getSelectedIndex() == 0) 
				{
					JOptionPane.showMessageDialog(null, "Campos vacios!", "Warning!", JOptionPane.WARNING_MESSAGE);
					return;
				}
				for (Equipo aux : Liga.getInstances().getEquipos()) {
					for (Jugador aux2 : aux.getJugadores()) {
						if ((txtNombre.getText().equalsIgnoreCase(aux2.getNombre()) && (txtApellido.getText().equalsIgnoreCase(aux2.getApellido())))) {
							JOptionPane.showMessageDialog(null, "El jugador ya existe!", "Warning!", JOptionPane.WARNING_MESSAGE);
							cleanField();
							return;
						}
					}
				}
				for (Equipo aux : Liga.getInstances().getEquipos()) {
					if (cbEquipo.getSelectedItem().toString().equalsIgnoreCase(aux.getNombre())) {
						aux.InsertarJugador(pla);
						JOptionPane.showMessageDialog(null, "Jugador insertado!", null, JOptionPane.INFORMATION_MESSAGE);
						btnModify.setEnabled(false);
						tableJugadores.setEnabled(true);
						btnDelete.setEnabled(false);
						cbEquipo.setEnabled(true);
						
						if (inj) {
							injury.getComboBox_Team().setSelectedItem(cbEquipo.getSelectedItem().toString());
							injury.getComboBox_Team().setEnabled(false);
							injury.getComboBox_Player().setSelectedItem(txtNombre.getText()+" "+txtApellido.getText());
							injury.getComboBox_Player().setEnabled(false);
							injury.setVisible(true);
						}
						
						cleanField();
						Load_Player();
						
					}
				}
				
				
			}
		});
		btnInsert.setBounds(515, 507, 74, 23);
		contentPanel.add(btnInsert);
		{
			JButton btnClose = new JButton("Close");
			btnClose.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0)
				{
					dispose();
				}
			});
			btnClose.setBounds(599, 507, 75, 23);
			contentPanel.add(btnClose);
			btnClose.setActionCommand("Cancel");
		}
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(14, 11, 660, 178);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			lblNombre = new JLabel("Nombre:");
			lblNombre.setEnabled(false);
			lblNombre.setBounds(20, 65, 69, 27);
			panel.add(lblNombre);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setEnabled(false);
			txtNombre.setToolTipText("Escriba el nombre...");
			txtNombre.setBounds(99, 68, 181, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			lblApellido = new JLabel("Apellido:");
			lblApellido.setEnabled(false);
			lblApellido.setBounds(359, 65, 100, 27);
			panel.add(lblApellido);
		}
		{
			txtApellido = new JTextField();
			txtApellido.setEnabled(false);
			txtApellido.setToolTipText("Escriba el apellido...");
			txtApellido.setBounds(469, 68, 181, 20);
			panel.add(txtApellido);
			txtApellido.setColumns(10);
		}
		cbEquipo = new JComboBox();
		cbEquipo.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar Equipo>"}));
		for (Equipo aux : Liga.getInstances().getEquipos())
			cbEquipo.addItem(""+aux.getNombre());
		cbEquipo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int opt = cbEquipo.getSelectedIndex();	
				Load_Player();
				switch (opt) 
				{
				//Si se selecciona un equipo se pone todo true.
				case 0:
					lblNombre.setEnabled(false);
					txtNombre.setEnabled(false);
					lblApellido.setEnabled(false);
					txtApellido.setEnabled(false);
					lblEdad.setEnabled(false);
					lblPosicion.setEnabled(false);
					cbPosicion.setEnabled(false);
					lblPeso.setEnabled(false);
					spnPeso.setEnabled(false);
					lblHeight.setEnabled(false);
					spnAltura.setEnabled(false);
					spnPies.setEnabled(false);
					lblNacimiento.setEnabled(false);
					btnInsert.setEnabled(false);
					lblNacimiento.setEnabled(false);
					lblNo.setEnabled(false);
					spnNumero.setEnabled(false);
					dateChooser.setEnabled(false);
					txtEdad.setEnabled(false);
					lblLesion.setEnabled(false);
					cbLesion.setEnabled(false);
					break;
				default:
					lblNombre.setEnabled(true);
					txtNombre.setEnabled(true);
					lblApellido.setEnabled(true);
					txtApellido.setEnabled(true);
					lblEdad.setEnabled(true);
					lblPosicion.setEnabled(true);
					cbPosicion.setEnabled(true);
					lblPeso.setEnabled(true);
					spnPeso.setEnabled(true);
					lblHeight.setEnabled(true);
					spnAltura.setEnabled(true);
					spnPies.setEnabled(true);
					lblNacimiento.setEnabled(true);
					btnInsert.setEnabled(true);
					lblNacimiento.setEnabled(true);
					lblNo.setEnabled(true);
					spnNumero.setEnabled(true);
					dateChooser.setEnabled(true);
					txtEdad.setEnabled(true);
					lblLesion.setEnabled(true);
					cbLesion.setEnabled(true);
				}
			}
		});
		cbEquipo.setBounds(99, 34, 181, 20);
		panel.add(cbEquipo);
		lblHeight = new JLabel("Height:");
		lblHeight.setEnabled(false);
		lblHeight.setBounds(294, 127, 46, 27);
		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setBounds(20, 31, 69, 27);
		panel.add(lblEquipo);
		lblAltura = new JLabel("Altura:");
		lblAltura.setEnabled(false);
		lblAltura.setBounds(359, 103, 100, 27);
		panel.add(lblAltura);
		cbPosicion = new JComboBox();
		cbPosicion.setEnabled(false);
		cbPosicion.setBounds(469, 34, 181, 20);
		panel.add(cbPosicion);
		cbPosicion.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "PG", "SG", "SF", "PF", "C"}));
		lblPosicion = new JLabel("Posicion:");
		lblPosicion.setEnabled(false);
		lblPosicion.setBounds(359, 31, 100, 27);
		panel.add(lblPosicion);
		lblPeso = new JLabel("Peso:");
		lblPeso.setEnabled(false);
		lblPeso.setBounds(359, 141, 100, 27);
		panel.add(lblPeso);
		{
			lblEdad = new JLabel("Edad:");
			lblEdad.setEnabled(false);
			lblEdad.setBounds(20, 103, 69, 27);
			panel.add(lblEdad);
		}
		lblNacimiento = new JLabel("Fecha:");
		lblNacimiento.setEnabled(false);
		lblNacimiento.setBounds(20, 137, 69, 27);
		panel.add(lblNacimiento);
		spnPeso = new JSpinner();
		spnPeso.setEnabled(false);
		spnPeso.setModel(new SpinnerNumberModel(100, 100, 500, 1));
		spnPeso.setBounds(469, 144, 82, 20);
		panel.add(spnPeso);
		spnPies = new JSpinner();
		spnPies.setModel(new SpinnerNumberModel(0, 0, 11, 1));
		spnPies.setEnabled(false);
		spnPies.setBounds(568, 106, 82, 20);
		panel.add(spnPies);
		spnAltura = new JSpinner();
		spnAltura.setModel(new SpinnerNumberModel(5, 5, 11, 1));
		spnAltura.setEnabled(false);
		spnAltura.setBounds(469, 106, 82, 20);
		panel.add(spnAltura);
		lblNo = new JLabel("No.");
		lblNo.setEnabled(false);
		lblNo.setBounds(187, 103, 37, 27);
		panel.add(lblNo);
		spnNumero = new JSpinner();
		spnNumero.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnNumero.setEnabled(false);
		spnNumero.setBounds(223, 106, 57, 20);
		panel.add(spnNumero);
		JSeparator separator = new JSeparator();
		separator.setBounds(14, 200, 660, 2);
		contentPanel.add(separator);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				btnModify.setEnabled(true);
			}
		});
		scrollPane.setBounds(13, 209, 558, 253);
		scrollPane.setBounds(14, 277, 618, 253);
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(14, 213, 660, 283);
		contentPanel.add(scrollPane1);
		SimpleDateFormat format = new SimpleDateFormat("MMM/dd/yyyy");
		Date minDate = null, maxDate = null, selectDate = null;
		try
		{
			minDate = format.parse("Jan/01/1977");
			maxDate = format.parse("Dec/31/1997");
			selectDate = format.parse("Jan/01/1997");
		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		dateChooser = new JDateChooser();
		dateChooser.setEnabled(false);
		dateChooser.setBounds(99, 141, 181, 20);
		panel.add(dateChooser);
		dateChooser.setSelectableDateRange(minDate, maxDate);
		dateChooser.setDate(selectDate);
		String Born = new SimpleDateFormat("MMM/dd/yyyy").format(dateChooser.getDate());
		aux = ""+Born.charAt(7)+Born.charAt(8)+Born.charAt(9)+Born.charAt(10);
		year = Integer.parseInt(aux);
		txtEdad = new JTextField();
		txtEdad.setEnabled(false);
		txtEdad.setEditable(false);
		txtEdad.setBounds(99, 106, 57, 20);
		panel.add(txtEdad);
		txtEdad.setColumns(10);
		lblLesion = new JLabel("Les:");
		lblLesion.setBounds(568, 141, 37, 27);
		lblLesion.setEnabled(false);
		panel.add(lblLesion);
		cbLesion = new JComboBox();
		cbLesion.setModel(new DefaultComboBoxModel(new String[] {"No", "Si"}));
		cbLesion.setBounds(604, 144, 46, 20);
		cbLesion.setEnabled(false);
		panel.add(cbLesion);
		dateChooser.getDateEditor().addPropertyChangeListener( new PropertyChangeListener() 
		{
		    @Override
		    public void propertyChange(PropertyChangeEvent e) 
		    {
		    	String Born = new SimpleDateFormat("MMM/dd/yyyy").format(dateChooser.getDate());
				aux = ""+Born.charAt(7)+Born.charAt(8)+Born.charAt(9)+Born.charAt(10);
				year = Integer.parseInt(aux);	
		        txtEdad.setText(""+(2016-year));
		        txtEdad.validate();
		    }
		});
		tableJugadores = new JTable();
		tableJugadores.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (btnModify.isEnabled() == false && tableJugadores.isEnabled() == true) 
				{
					btnModify.setEnabled(true);
					btnDelete.setEnabled(true);
				}
				else 
				{
					;
				}
			}
		});
		scrollPane1.setViewportView(tableJugadores);
		{
			
			tableModel = new DefaultTableModel
				(
					new Object[][] {},
					new String[] 
						{
						"Posicion", "No.", "Nombre", "Apellido", "Edad", "Peso", "Estatura", "Lesion", "Nacimiento", "Equipo"
						}
				);
			tableJugadores.setModel(tableModel);
			//Crea el archivo de jugadores.
			JButton btnImprimir = new JButton("Imprimir");
			btnImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					   try{
				             
			               File file = new File("./Jugadores.txt");
			               
			               if(!file.exists()){
			                   file.createNewFile();
			               }
			               
			               FileWriter fw = new FileWriter(file.getAbsoluteFile());
			               BufferedWriter bw = new BufferedWriter(fw);
			               
			               bw.write("\n														JUGADORES DE LA SERIE NACIONAL															\n");
			               bw.write("-----------------------------------------------------------------------------------------------------------------------------------------------\n");
			               bw.write("Posicion \tNo. \t\tNombre \t\t\tApellido \t\tEdad \t\tPeso \t\t\tEstatura \t\tLesion \t\tNacimiento \t\t\t\tEquipo\n");
			               bw.write("-----------------------------------------------------------------------------------------------------------------------------------------------\n");
			               for(int i = 0; i < tableJugadores.getRowCount(); i++){
			                  
			                   for(int j = 0; j < tableJugadores.getColumnCount(); j++){
			                       bw.write(tableJugadores.getModel().getValueAt(i, j)+"			 ");
			                     
			                   }
			                   bw.write("\n");
			               
			               }
			               bw.write("-----------------------------------------------------------------------------------------------------------------------------------------------\n");;
			              
			               bw.close();
			              
			               fw.close();
			               JOptionPane.showMessageDialog(null, "Lista de jugadores impresa!");
			               
			               }catch(Exception ex){
			                   ex.printStackTrace();
			               }
				}
			});
			btnImprimir.setBounds(14, 507, 89, 23);
			contentPanel.add(btnImprimir);
			tableJugadores.getColumnModel().getColumn(0).setPreferredWidth(90);
			tableJugadores.getColumnModel().getColumn(1).setPreferredWidth(100);
			tableJugadores.getColumnModel().getColumn(2).setPreferredWidth(140);
			tableJugadores.getColumnModel().getColumn(3).setPreferredWidth(140);
			tableJugadores.getColumnModel().getColumn(4).setPreferredWidth(100);
			tableJugadores.getColumnModel().getColumn(5).setPreferredWidth(110);
			tableJugadores.getColumnModel().getColumn(6).setPreferredWidth(50);
			tableJugadores.getColumnModel().getColumn(7).setPreferredWidth(60);
			tableJugadores.getColumnModel().getColumn(8).setPreferredWidth(80);
			tableJugadores.getColumnModel().getColumn(9).setPreferredWidth(110);		
		}
	}
	
	@SuppressWarnings("rawtypes")
	public JComboBox getComboBox_SelectTeam() 
	{
		return cbEquipo;
	}
	
	@SuppressWarnings("rawtypes")
	public void setComboBox_SelectTeam(JComboBox comboBox_SelectTeam) 
	{
		this.cbEquipo = comboBox_SelectTeam;
	}
	
	private void cleanField() 
	{	
		txtNombre.setText("");
		txtApellido.setText("");
		spnPeso.setValue(100);
		cbPosicion.setSelectedIndex(0);
		cbEquipo.setSelectedIndex(0);
		spnPies.setValue(new Integer(0));
		spnAltura.setValue(new Integer(5));
		spnNumero.setValue(new Integer(0));
		cbLesion.setSelectedIndex(0);
	}
	
	public void Modify_Player() 
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MMM/dd/yyyy");
		Date date = null;
		char Feets, Inches;
		int feets, inches;
		String Position = (String) tableModel.getValueAt(tableJugadores.getSelectedRow(), 0);
		int Number = (int) tableModel.getValueAt(tableJugadores.getSelectedRow(), 1);
		String Name = (String) tableModel.getValueAt(tableJugadores.getSelectedRow(), 2);
		String LastName = (String) tableModel.getValueAt(tableJugadores.getSelectedRow(), 3);
		int Age = (int) tableModel.getValueAt(tableJugadores.getSelectedRow(), 4);
		int Weight = (int) tableModel.getValueAt(tableJugadores.getSelectedRow(), 5);
		String Height = (String) tableModel.getValueAt(tableJugadores.getSelectedRow(), 6);
		Feets = Height.charAt(0);
		Inches = Height.charAt(2);
		feets = Character.getNumericValue(Feets);
		inches = Character.getNumericValue(Inches);
		String Injuried = (String) tableModel.getValueAt(tableJugadores.getSelectedRow(), 7);
		try
		{
			date = formatter.parse((String) tableModel.getValueAt(tableJugadores.getSelectedRow(), 8));
		}
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		String Team = (String) tableModel.getValueAt(tableJugadores.getSelectedRow(), 9);
		Delete_Player();
		cbPosicion.setSelectedItem(Position);
		txtNombre.setText(Name);
		txtApellido.setText(LastName);
		spnPeso.setValue(Weight);
		spnAltura.setValue(feets);
		spnPies.setValue(inches);
		cbEquipo.setSelectedItem(Team);
		spnNumero.setValue(Number);
		dateChooser.setDate(date);
		txtEdad.setText(""+Age);
		if (Injuried == "No") 
		{
			cbLesion.setSelectedIndex(0);
		}
		else
		{
			cbLesion.setSelectedIndex(1);
		}
	}
	
	public void Delete_Player()
	{
		String Name = (String) tableModel.getValueAt(tableJugadores.getSelectedRow(), 2);
		for(Equipo aux : Liga.getInstances().getEquipos())
		{
			for(Jugador aux2 : aux.getJugadores())
			{
				if (Name.equalsIgnoreCase(aux.getJugadores().get(0).getNombre())) 
				{
					aux.getJugadores().remove(aux2);
				}
			}
		}
	}	
	
	
	public void Load_Player()  {
		
		tableModel.setRowCount(0); 
		row = new Object[tableModel.getColumnCount()];
				

			      for(Equipo aux : Liga.getInstances().getEquipos()){
						
						for (Jugador aux2 : aux.getJugadores()) {
							row[0] = aux2.getPosicion();
							row[1] = aux2.getNumero();
							row[2] = aux2.getNombre();
							row[3] = aux2.getApellido();
							row[4] = aux2.getEdad();
							row[5] = aux2.getPeso();
							row[6] = aux2.getPies() + "'" + aux2.getPulgadas();
							if (aux2.isLesionado() == false) {
								row[7] = "No";
							}
							else {
								row[7] = "Si";
							}
							row[8] = aux2.getNacimiento();
							row[9] = aux2.getEquipo();
							
							
							tableModel.addRow(row);
						}
					}
		
		tableJugadores.setModel(tableModel);
		tableJugadores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableJugadores.getTableHeader().setReorderingAllowed(false);
		TableColumnModel modeloColumna = tableJugadores.getColumnModel();
		modeloColumna.getColumn(0).setPreferredWidth(50);
		modeloColumna.getColumn(1).setPreferredWidth(25);
		modeloColumna.getColumn(2).setPreferredWidth(80);
		modeloColumna.getColumn(3).setPreferredWidth(80);
		modeloColumna.getColumn(4).setPreferredWidth(30);
		modeloColumna.getColumn(5).setPreferredWidth(50);
		modeloColumna.getColumn(6).setPreferredWidth(50);
		modeloColumna.getColumn(7).setPreferredWidth(50);
		modeloColumna.getColumn(8).setPreferredWidth(87);
		modeloColumna.getColumn(9).setPreferredWidth(155);
			
		}
	}