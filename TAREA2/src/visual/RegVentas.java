package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;

import logical.Clientes;
import logical.ComplejoLacteo;
import logical.Factura;
import logical.QuesoCilindrico;
import logical.QuesoHueco;
import logical.Quesos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JSeparator;

public class RegVentas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static DefaultTableModel tableModel;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JFormattedTextField txtCedula;
	private JFormattedTextField txtTelefono;
	private MaskFormatter tel;
	private MaskFormatter ced;
	static Object[] fila;
	private static JTable table;
	private static boolean sel = false;
	private JTextField id;
	private int idFact = ComplejoLacteo.getInstance().getID2();
	private JTextField txtmonto;
	JButton btnEliminar;
	Factura delFact = null;

	/**
	 * Launch the application.
	 * @param Complejo 
	 */

	/**
	 * Create the dialog.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public RegVentas(ComplejoLacteo comp){
		setBounds(100, 100, 620, 457);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panelRegistro = new JPanel();
		panelRegistro.setBackground(new Color(255, 255, 255));
		panelRegistro.setBorder(new TitledBorder(null, "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRegistro.setBounds(10, 6, 584, 121);
		contentPanel.add(panelRegistro);
		panelRegistro.setLayout(null);
		
		String[] columnsHeaders = {"Seleccion","ID","Tipo", "Precio"};
		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnsHeaders);
		
		try {
			ced = new MaskFormatter("###-#######-#");
			tel = new MaskFormatter("(###)-###-####");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(17, 32, 61, 16);
		panelRegistro.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(76, 26, 122, 28);
		panelRegistro.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCedula = new JLabel("Telefono:");
		lblCedula.setBounds(381, 32, 61, 16);
		panelRegistro.add(lblCedula);
		
		
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(17, 82, 61, 16);
		panelRegistro.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(76, 76, 122, 28);
		panelRegistro.add(txtDireccion);
		
		JLabel lblTelefono = new JLabel("Cedula:");
		lblTelefono.setBounds(381, 82, 61, 16);
		panelRegistro.add(lblTelefono);
		
		txtTelefono = new JFormattedTextField(tel);
		txtTelefono.setBounds(451, 26, 122, 28);
		panelRegistro.add(txtTelefono);
		
		txtCedula = new JFormattedTextField(ced);
		txtCedula.setBounds(452, 76, 122, 28);
		panelRegistro.add(txtCedula);
		
		JPanel panelVentas = new JPanel();
		panelVentas.setLayout(null);
		panelVentas.setBorder(null);
		panelVentas.setBackground(new Color(255, 255, 255));
		panelVentas.setBounds(10, 148, 584, 226);
		contentPanel.add(panelVentas);
		
		JLabel lblPrecio = new JLabel("Monto Total:");
		lblPrecio.setBounds(22, 187, 76, 28);
		panelVentas.add(lblPrecio);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 17, 571, 170);
		panelVentas.add(scrollPane);
		{	table = new JTable(tableModel){
			
			private static final long serialVersionUID = 1L;


			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int column){
				 switch (column) {
	             case 0:
	                 return Boolean.class;
	             case 1:
	                 return String.class;
	             default:
	                 return Float.class;

	         }
			}
			
		};
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0){
					if(table.getSelectedRow()>=0){

						montoTabla();
					}
				}
			});
			table.setModel(tableModel);
			
			scrollPane.setViewportView(table);
			
			id = new JTextField();
			id.setBounds(480, 187, 61, 28);
			panelVentas.add(id);
			id.setColumns(10);
			id.setText(String.valueOf(idFact));
			id.setVisible(false);
			
			txtmonto = new JTextField();
			txtmonto.setBounds(102, 190, 122, 22);
			panelVentas.add(txtmonto);
			txtmonto.setColumns(10);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 135, 584, 2);
			contentPanel.add(separator);
			
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							Clientes client = new Clientes();
							
							client.setDireccion(txtDireccion.getText());
							client.setNombre(txtNombre.getText());
							client.setCedula(txtCedula.getText());
							client.setTelefono(txtTelefono.getText());
							float mont = Float.valueOf(txtmonto.getText());
							int count = table.getRowCount();
							Factura fact = new Factura(client,idFact);
							Quesos queso = null;
							int id = 0;
								
								for(int i = 0; i < count-1; i++){
										if(tableModel.getValueAt(i, 0)!=null){
											sel= (Boolean)tableModel.getValueAt(i, 0);
											
											if (sel==true){
											id = (int)tableModel.getValueAt(i, 1);
											queso = ComplejoLacteo.getInstance().buscarQueso(id);
											fact.getListaQuesos().add(queso);
											ComplejoLacteo.getInstance().getInventarioQuesos().remove(queso);
											
										}	
									}
								}
									fact.setMonto(mont);
									ComplejoLacteo.getInstance().getListaFacturas().add(fact);
									
								
								idFact++;
								ComplejoLacteo.getInstance().setID2(idFact);
								JOptionPane.showMessageDialog(null, "Factura Realizada!");
								dispose();
					}
					
					});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						ComplejoLacteo.getInstance().setID2(idFact);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(delFact != null){
						int resp=JOptionPane.showConfirmDialog(null,"Esta seguro que desea eliminar estos datos:");
					      if (JOptionPane.OK_OPTION == resp){
					          ComplejoLacteo.getInstance().deleteQueso(delFact);
					          loadQuesos();
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
		}

		loadQuesos();
	}
	
	public static void loadQuesos(){
	
		tableModel.setRowCount(0);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		table.getColumnModel().getColumn(1).setCellRenderer(tcr);
		table.getColumnModel().getColumn(2).setCellRenderer(tcr);
		table.getColumnModel().getColumn(3).setCellRenderer(tcr);

		fila = new Object[tableModel.getColumnCount()];
		
		ArrayList<Quesos> quesos = new ArrayList<Quesos>();
		quesos.addAll(ComplejoLacteo.getInstance().getInventarioQuesos());
		
		 for(Quesos aux : ComplejoLacteo.getInstance().getInventarioQuesos())
			{
					fila[0] = sel = false;
					fila[1] = aux.getId();
					
					if(aux instanceof QuesoHueco){
						fila[2]="Hueco";
					}
					else if(aux instanceof QuesoCilindrico){
						fila[2]="Cilindrico";
					}
					else{
						fila[2]="Esferico";
					}
					
					float vol = aux.Volumen();
					
					fila[3] = aux.precioTotal(vol);

					
					tableModel.addRow(fila);
		}	
	}
	
	public void montoTabla(){
		float precio, suma = 0;
		
		for(int i =0; i < table.getRowCount(); i++){
			
			sel = (boolean) table.getValueAt(i, 0);
			if(sel== true){
				precio = (float) table.getValueAt(i,3);
				suma = suma + precio;
			}
		}
		txtmonto.setText(String.valueOf(suma));	
	}
}
