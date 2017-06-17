package visual;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;




import logical.Delegacion;
import logical.Equipo;

public class TablaDatos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTable tableDatos;
	JButton btnEliminar;
	JButton btnModificar;
	static DefaultTableModel tableModel;
	static Object[] fila;
	Equipo selectDeleg = null;



	public TablaDatos() {
		setBounds(100, 100, 517, 317);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 507, 278);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		tableDatos = new JTable();
		tableDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nombre;
				if(tableDatos.getSelectedRow()>=0){
					btnEliminar.setEnabled(true);
					//btnModificar.setEnabled(true);
					nombre = (String) tableDatos.getValueAt(tableDatos.getSelectedRow(), 0);
					selectDeleg = Delegacion.getInstance().buscarNombreDeTeam(nombre);
				}
			}
		});
		tableDatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableDatos.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableDatos.setBounds(35, 226, 202, -44);
		tableModel = new DefaultTableModel();
		String[] columnNames = {"Nombre", "Med. Oro","Med. Plata","Med. Bronce","Med. Total"};
		tableModel.setColumnIdentifiers(columnNames);
		loadData(0);
		
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 51, 487, 184);
		scrollPane1.setViewportView(tableDatos);
		contentPanel.add(scrollPane1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 246, 507, 32);
			contentPanel.add(buttonPane);
			{
				buttonPane.setLayout(null);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBounds(408, 5, 89, 23);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(selectDeleg != null){
							int resp=JOptionPane.showConfirmDialog(null,"Esta seguro que desea eliminar estos datos:");
						      if (JOptionPane.OK_OPTION == resp){
						          Delegacion.getInstance().deleteEquipo(selectDeleg);
						          loadData(0);
						      }
						      if(JOptionPane.NO_OPTION == resp){
						        dispose();
						   }
						      if(JOptionPane.CANCEL_OPTION == resp){
							        dispose();
							   }
						}
					}
				});
				btnEliminar.setBounds(114, 5, 94, 23);
				buttonPane.add(btnEliminar);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			/*btnModificar = new JButton("Modificar");
			btnModificar.setEnabled(false);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {*/
				/*	if(selectDeleg!= null){
						Records rec = new Records(selectDeleg);
						rec.setVisible(true);
						rec.setModal(true);
						rec.setLocationRelativeTo(null);
					}*/
				}
			/*});
			btnModificar.setBounds(10, 5, 94, 23);
			buttonPane.add(btnModificar);
		}*/
		
		
	}
	
	public static void loadData(int type){
		tableModel.setRowCount(0);
		fila = new Object[tableModel.getColumnCount()];
		if(type == 0){
		for (Equipo aux : Delegacion.getInstance().getMiEquipo()) {
				fila[0] = aux.getNombreTeam();
				fila[1] = aux.getCantMedOro();
				fila[2] = aux.getCantMedPlata();
				fila[3] = aux.getCantMedBronce();
				fila[4] = aux.totalMedallasEquipo();
			tableModel.addRow(fila);
		 }
		}
		if(type == 1){
			for (Equipo aux : Delegacion.getInstance().getMiEquipo()) {
					fila[0] = aux.getNombreTeam();
					fila[1] = aux.getCantMedOro();
					fila[2] = aux.getCantMedPlata();
					fila[3] = aux.getCantMedBronce();
					fila[4] = aux.totalMedallasEquipo();
					
				tableModel.addRow(fila);
				}
		 }
		
		if(type == 2){
			for (Equipo aux : Delegacion.getInstance().getMiEquipo()) {
				
					fila[0] = aux.getNombreTeam();
					fila[1] = aux.getCantMedOro();
					fila[2] = aux.getCantMedPlata();
					fila[3] = aux.getCantMedBronce();
					fila[4] = aux.totalMedallasEquipo();
			
				tableModel.addRow(fila);
				}
		 }	
		if(type == 3){
			for (Equipo aux : Delegacion.getInstance().getMiEquipo()) {
				
					fila[0] = aux.getNombreTeam();
					fila[1] = aux.getCantMedOro();
					fila[2] = aux.getCantMedPlata();
					fila[3] = aux.getCantMedBronce();
					fila[4] = aux.totalMedallasEquipo();
			
				tableModel.addRow(fila);
				}
		 }
		
		tableDatos.setModel(tableModel);
		tableDatos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableDatos.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = tableDatos.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(100);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(3).setPreferredWidth(110);
		
	
		
	}
}

