package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

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
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

import javax.swing.JScrollPane;

import logical.Sum;
import logical.Vehiculo;
import logical.Vendedor;
import logical.Ventas;

public class ListCarros extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim3;
	private static DefaultTableModel tableModel;
	
	private static Vendedor ven;
			static Object[] fila;
	private static JTable table;
	private JButton btnModificar;
	private JButton btnEliminar;
	private String Nombre;
	private static Sum sumi;
	private static Vehiculo veh;

	/**
	 * Create the dialog.
	 */
	public ListCarros(Vendedor pven) {
		setTitle("Vehiculos");
		this.ven = pven;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 228, 181));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		dim3 = super.getToolkit().getScreenSize(); 
		super.setSize(dim3);
		this.setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		String[] columnsHeaders = {"Modelo","Suministrador","Marca","Tipo","Color","Precio"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnsHeaders);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 11, 1329, 667);
		contentPanel.add(scrollPane);
		{
			
			table = new JTable();
			table.setBackground(new Color(255, 228, 181));
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(table.getSelectedRow()>=0){
						btnModificar.setEnabled(true);
						btnEliminar.setEnabled(true);
						int index = table.getSelectedRow();
						Nombre = (String)table.getModel().getValueAt(index, 0);
						
						
					}
				}
			});
			table.setModel(tableModel);
			
			scrollPane.setViewportView(table);
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(Color.BLACK);
				cancelButton.setForeground(Color.WHITE);
				cancelButton.setLocation(648, 5);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				
				{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setBackground(Color.BLACK);
				btnEliminar.setForeground(Color.WHITE);
				buttonPane.add(btnEliminar);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Vehiculo veh = ven.findModelo(Nombre);
						ven.deleteVehiculo(veh);
						JOptionPane.showMessageDialog(null, "Vehiculo eliminado satisfactoriamente", null, JOptionPane.INFORMATION_MESSAGE, null);
						loadVehiculos();
					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
				}
				{
				btnModificar = new JButton("Modificar");
				btnModificar.setBackground(new Color(0, 0, 0));
				btnModificar.setForeground(new Color(255, 255, 255));
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Vehiculo veh = ven.findModelo(Nombre);
						boolean option = false;
						RegCarro car = new RegCarro(ven, "MODIFICAR", option, veh);
						car.setModal(true);
						car.setVisible(true);
						
						}
				});
				buttonPane.add(btnModificar);
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				
			}
			
			loadVehiculos();
		}
		
		
		
	}
	
	public static void loadVehiculos(){
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
		fila = new Object[tableModel.getColumnCount()];
		for(int i = 0; i < ven.getCantVehiculos(); i++){
			
			fila[0] = ven.getListaVehiculos()[i].getModelo();
			fila[1] = ven.getListaVehiculos()[i].getSumi();
			fila[2] = ven.getListaVehiculos()[i].getMarca();
			fila[3] = ven.getListaVehiculos()[i].getTipo().toString();
			fila[4] = ven.getListaVehiculos()[i].getColor();
			fila[5] = ven.getListaVehiculos()[i].getPrecio();
			tableModel.addRow(fila);
			
		}
	}
}
