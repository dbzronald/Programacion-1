package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.Serializable;

import javax.swing.JScrollPane;

import logical.Equipo;
import logical.Jugador;
import logical.Lesion;
import logical.Liga;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

import java.awt.Color;

public class LesionesHistorial extends JDialog implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private Object[] row;
	public static JTable table;
	private static JTable tableLesiones;
	private JLabel lblJugador,lblEquip;

	public static DefaultTableModel tableModel;
	public JComboBox<String> cbEquipos;
	public JComboBox<String> cbJugadores;
	
	public LesionesHistorial() {
		
		setModal(true);
		setTitle("Historial de Lesiones");
		setBounds(100, 100, 848, 495);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(281, 11, 549, 402);
		contentPanel.add(scrollPane);
		
		tableLesiones = new JTable();
		
		scrollPane.setViewportView(tableLesiones);
		{
			tableModel = new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Equipo", "Nombre", "Apellido", "Tipo", "Fecha", "Retorno"
					});
			tableLesiones.setModel(tableModel);
			
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Busqueda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 11, 261, 402);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			lblEquip = new JLabel("Equipo:");
			lblEquip.setBounds(10, 21, 60, 30);
			panel.add(lblEquip);
			
			cbEquipos = new JComboBox<String>();
			cbEquipos.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccionar Equipo>"}));
			cbEquipos.setBounds(80, 26, 171, 20);
			panel.add(cbEquipos);
			for (Equipo aux : Liga.getInstances().getEquipos())
				cbEquipos.addItem(aux.getNombre().toString());
			
			lblJugador = new JLabel("Jugadores:");
			lblJugador.setBounds(10, 62, 70, 30);
			panel.add(lblJugador);
			cbJugadores = new JComboBox<String>();
			cbJugadores.addActionListener(new ActionListener() 
			{
				//Todo esto debia tener las lesiones y jugadores para el historial, pero valio madres.
				public void actionPerformed(ActionEvent e) 
				{
					if(cbEquipos.getSelectedIndex()!=0)
					{
						cargarJugadoresDeEquipos();
						if(cbJugadores.getSelectedIndex()!=0)
						{
							cargarJugador();
						}
					}
				}
			});
			cbJugadores.setModel(new DefaultComboBoxModel<String>(new String[] {"<Seleccionar>"}));
			cbJugadores.setBounds(80, 67, 171, 20);
			if(cbEquipos.getSelectedIndex()==0)
				cbJugadores.setEnabled(false);
			
			panel.add(cbJugadores);
			
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnClose = new JButton("Close");
				btnClose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnClose.setActionCommand("Cancel");
				buttonPane.add(btnClose);
			}
		}
		cbEquipos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				cbJugadores.setModel(new DefaultComboBoxModel<String>(new String[] {"<Selccionar>"}));
				cbJugadores.setEnabled(true);
				for (Equipo aux : Liga.getInstances().getEquipos()){	
					for (Jugador aux2 : aux.getJugadores()){	
						for (Lesion aux3 : aux2.getLesiones()){	
							if (aux.getJugadores().get(0).getLesiones().size() > 0){
								if (cbEquipos.getSelectedItem().toString().equalsIgnoreCase(aux.getNombre()))
								{
									cbJugadores.addItem(aux2.getNombre()+" "+aux2.getApellido());
								}
							}
						}
					}
				}
				if(cbEquipos.getSelectedIndex()==0)
				{
					cbJugadores.setEnabled(false);
					CargarLesiones();
				}
				if(cbEquipos.getSelectedIndex()!=0)
				{
					cargarJugadoresDeEquipos();
					if(cbJugadores.getSelectedIndex()!=0)
					{
						cargarJugador();
					}
				}
			}
		});
		
	}

}
	public void CargarLesiones() 
	{
		tableModel.setRowCount(0); 
		row = new Object[tableModel.getColumnCount()];
		for (Equipo aux : Liga.getInstances().getEquipos()){	
			for (Jugador aux2 : aux.getJugadores()){	
				for (Lesion aux3 : aux2.getLesiones()){	
					if (aux.getJugadores().get(0).getLesiones().size() > 0) 
					{
						row[0] = aux.getNombre();
						row[1] = aux2.getNombre();
						row[2] = aux2.getApellido();
						row[3] = aux3.getTipo();
						row[4] = aux3.getDate();
						row[5] = aux3.getRecuperacion();
						
						tableModel.addRow(row);
					}
				}
			}
		}
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel modeloColumna = table.getColumnModel();
		modeloColumna.getColumn(0).setPreferredWidth(95);
		modeloColumna.getColumn(1).setPreferredWidth(90);
		modeloColumna.getColumn(2).setPreferredWidth(90);
		modeloColumna.getColumn(3).setPreferredWidth(61);
		modeloColumna.getColumn(4).setPreferredWidth(90);
		modeloColumna.getColumn(5).setPreferredWidth(120);
	}
	
	public void cargarJugadoresDeEquipos()
	{
		tableModel.setRowCount(0);
		row = new Object[tableModel.getColumnCount()];
		
		for (Equipo aux : Liga.getInstances().getEquipos()){
			if(cbEquipos.getSelectedItem().toString().equalsIgnoreCase(aux.getNombre())){
				for (Jugador aux2 : aux.getJugadores()){	
					for (Lesion aux3 : aux2.getLesiones()){
						if (aux.getJugadores().get(0).getLesiones().size() > 0) 
						{							
								row[0] = aux.getNombre();
								row[1] = aux2.getNombre();
								row[2] = aux2.getApellido();
								row[3] = aux3.getTipo();
								row[4] = aux3.getDate();
								row[5] = aux3.getRecuperacion();
								
								tableModel.addRow(row);
						}
					}	
				}
			}
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel modeloColumna = table.getColumnModel();
		modeloColumna.getColumn(0).setPreferredWidth(95);
		modeloColumna.getColumn(1).setPreferredWidth(90);
		modeloColumna.getColumn(2).setPreferredWidth(90);
		modeloColumna.getColumn(3).setPreferredWidth(61);
		modeloColumna.getColumn(4).setPreferredWidth(90);
		modeloColumna.getColumn(5).setPreferredWidth(120);
		}
	}
	
	public void cargarJugador()
	{
		tableModel.setRowCount(0);
		row = new Object[tableModel.getColumnCount()];
		for (Equipo aux : Liga.getInstances().getEquipos()){
			if(cbEquipos.getSelectedItem().toString().equalsIgnoreCase(aux.getNombre())){
				for (Jugador aux2 : aux.getJugadores()){	
					if(cbJugadores.getSelectedItem().toString().equalsIgnoreCase(aux2.getNombre()+" "+aux2.getApellido())){
						for (Lesion aux3 : aux2.getLesiones()){
							if (aux.getJugadores().get(0).getLesiones().size() > 0) 
							{								
								row[0] = aux.getNombre();
								row[1] = aux2.getNombre();
								row[2] = aux2.getApellido();
								row[3] = aux3.getTipo();
								row[4] = aux3.getDate();
								row[5] = aux3.getRecuperacion();
								
								tableModel.addRow(row);
							}
						}
					}
				}	
			}
		}
		table.setModel(tableModel);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel modeloColumna = table.getColumnModel();
		modeloColumna.getColumn(0).setPreferredWidth(95);
		modeloColumna.getColumn(1).setPreferredWidth(90);
		modeloColumna.getColumn(2).setPreferredWidth(90);
		modeloColumna.getColumn(3).setPreferredWidth(61);
		modeloColumna.getColumn(4).setPreferredWidth(90);
		modeloColumna.getColumn(5).setPreferredWidth(120);
	}
	

}
