package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import logical.ComplejoLacteo;
import logical.Factura;

public class Facturas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	private static Object[] fila;
	private static JTable table;
	private static JTable tablaFacturas;
	JButton btnEliminar;
	Factura delFact = null;
	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public Facturas(ComplejoLacteo pComp) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		String[] columnsHeaders = {"ID Factura","Nombre","Cedula","Telefono","Monto"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnsHeaders);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 206);
		contentPanel.add(scrollPane);
		{	tablaFacturas = new JTable(tableModel){
			
			private static final long serialVersionUID = 1L;

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int column){
				 switch (column) {
	             case 0:
	                 return Integer.class;
	             case 1:
	                 return String.class;
	             case 2:
	            	 return String.class;
	             case 3:
	            	 return Integer.class;
	             default:
	                 return Float.class;
			
				 }
			}	
			
		}; 
		tablaFacturas.setModel(tableModel);
		
		scrollPane.setViewportView(tablaFacturas);	
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}

		
		}
		loadFacturas();
		}
		
	

	
	public static void loadFacturas(){
		tableModel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		tablaFacturas.getColumnModel().getColumn(0).setCellRenderer(tcr);
		tablaFacturas.getColumnModel().getColumn(1).setCellRenderer(tcr);
		tablaFacturas.getColumnModel().getColumn(2).setCellRenderer(tcr);
		tablaFacturas.getColumnModel().getColumn(3).setCellRenderer(tcr);
		tablaFacturas.getColumnModel().getColumn(4).setCellRenderer(tcr);
		
		fila = new Object[tableModel.getColumnCount()];
			for(Factura aux : ComplejoLacteo.getInstance().getListaFacturas())
			{
					fila[0] = aux.getId();
					fila[1] = aux.getClientes().getNombre();
					fila[3] = aux.getClientes().getCedula();
					fila[4] = aux.getMonto();
					
					tableModel.addRow(fila);
				
		}
	}
}



