package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

import logical.Vendedor;
import logical.Ventas;

import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ListVentas extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	
	private static Vendedor ven;
			static Object[] fila;
	private static JTable table;
	private JButton bModificar;
	private JButton bEliminar;
	private String cedula;
	private Dimension dim2;
	private static Ventas vent;

	/**
	 * Create the dialog.
	 */
	public ListVentas(Vendedor pven, Ventas vn) {
		setBackground(new Color(255, 228, 181));
		setResizable(false);
		this.ven = pven;
		vent = vn;
		setTitle("LISTA");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\buch\\workspace\\Tarea1\\icon.png"));
		setBounds(100, 100, 450, 300);
		dim2 = super.getToolkit().getScreenSize(); 
		super.setSize(dim2);
		this.setResizable(false);
		setLocationRelativeTo(null);
		
		String[] columnsHeaders = {"Cedula","Nombre","Apellido","Telefono","Direccion","Codigo","Marca","Monto","Fecha"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnsHeaders);
		
		
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 3, 1329, 667);
		contentPanel.add(scrollPane);
		{
			table = new JTable();
			table.setBackground(new Color(255, 228, 181));
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(table.getSelectedRow()>=0){
						bModificar.setEnabled(true);
						bEliminar.setEnabled(true);
						int index = table.getSelectedRow();
						cedula = (String)table.getModel().getValueAt(index, 0);
						
						
					}
				}
			});
			table.setModel(tableModel);
			
			scrollPane.setViewportView(table);
			{
				JButton cancelButton = new JButton("OK");
				cancelButton.setBounds(609, 683, 143, 23);
				contentPanel.add(cancelButton);
				cancelButton.setBackground(Color.BLACK);
				cancelButton.setForeground(Color.WHITE);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 228, 181));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		loadVentas();
	}
	
	public static void loadVentas(){
		tableModel.setRowCount(0);
		tableModel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table.getColumnModel().getColumn(3).setCellRenderer(tcr);
		table.getColumnModel().getColumn(4).setCellRenderer(tcr);
		table.getColumnModel().getColumn(5).setCellRenderer(tcr);
		table.getColumnModel().getColumn(6).setCellRenderer(tcr);
		table.getColumnModel().getColumn(7).setCellRenderer(tcr);
		table.getColumnModel().getColumn(8).setCellRenderer(tcr);
		fila = new Object[tableModel.getColumnCount()];
		for(int i = 0; i < ven.getCantVentas(); i++){
			fila[0] = ven.getListaVentas()[i].getClientes().getCedula();
			fila[1] = ven.getListaVentas()[i].getClientes().getNombre();
			fila[2] = ven.getListaVentas()[i].getClientes().getApellido();
			fila[3] = ven.getListaVentas()[i].getClientes().getTelefono();
			fila[4] = ven.getListaVentas()[i].getClientes().getDireccion();
			fila[5] = ven.getListaVentas()[i].getCodigoVenta();
			fila[6] = ven.getListaVentas()[i].getProducto();
			fila[7] = ven.getListaVentas()[i].getMonto();
			fila[8] = ven.getListaVentas()[i].getFecha();
			tableModel.addRow(fila);
			
		}
	}
}
