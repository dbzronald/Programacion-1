package visual;
 
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logical.Equipo;
import logical.Liga;

import javax.swing.JTable;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.table.TableCellRenderer;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;

import java.awt.Color;

import java.awt.GridLayout;
 
public class CrearEquipo extends JDialog implements Serializable {
 
        private final JPanel contentPanel = new JPanel();
        private JTextField txtNombreEquipo;
        private JTextField txtCoach;
        private JButton ButtonModify,ButtonDelete, ButtonInsertar;
        private ArrayList<Equipo> auxT = new ArrayList<Equipo>();
        Object[] fila;
        JComboBox<Object> cbLocacion;
        private static final long serialVersionUID = 1L;
        CrearJugador pla;
       
        private class CELL_RENDERER extends JCheckBox implements TableCellRenderer{
                private static final long serialVersionUID = 1L;
         
                public CELL_RENDERER(){
                    setHorizontalAlignment(JLabel.CENTER);
                }
                @Override
                public Component getTableCellRendererComponent(JTable arg0,
                        Object value, boolean arg2, boolean arg3, int arg4, int arg5) {
                    setSelected((value != null && ((Boolean) value).booleanValue()));
                    setBackground(arg0.getBackground());
                    setHorizontalAlignment(JLabel.CENTER);
                    return this;
                }
                 
            }
           
         	private class CELL_EDITOR extends DefaultCellEditor{
                 private static final long serialVersionUID = 1L;
         
                public CELL_EDITOR(JCheckBox checkBox) {
                    super(checkBox);
                    checkBox.setHorizontalAlignment(JLabel.CENTER);
                   
                }
            }
         
       
       
        public class TABLE_MODEL extends DefaultTableModel{
               
                private static final long serialVersionUID = 1L;
               
                public TABLE_MODEL(){
                    addColumn("Select");
                    addColumn("Nombre");
                    addColumn("Coach");
                    addColumn("Locacion");
                
                    Object object[]={new Boolean(false)};
                    addRow(object);
            }
   
}
       
         static JTable table = null;   
         private static JTable tableEquipos;
         JButton button = new JButton();
         TABLE_MODEL tablem = new TABLE_MODEL();

        /**
         * Create the dialog.
         */
        @SuppressWarnings({ "unchecked", "rawtypes" })
        public CrearEquipo() {
        	
        	setResizable(false);
               
                LoadTeam();
       
                setModal(true);
               
                setTitle("Crear Equipo");
                setBounds(100, 100, 817, 503);
                getContentPane().setLayout(new BorderLayout());
                contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
                getContentPane().add(contentPanel, BorderLayout.CENTER);
                contentPanel.setLayout(null);
               
                JPanel panel = new JPanel();
                panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
                panel.setBounds(10, 11, 781, 148);
                contentPanel.add(panel);
                panel.setLayout(null);
               
                JLabel lblNombre = new JLabel("Nombre:");
                lblNombre.setBounds(10, 21, 57, 24);
                panel.add(lblNombre);
               
                txtNombreEquipo = new JTextField();
                txtNombreEquipo.setBounds(82, 23, 327, 20);
                panel.add(txtNombreEquipo);
                txtNombreEquipo.setColumns(10);
               
                JLabel label_1 = new JLabel("Coach:");
                label_1.setBounds(10, 52, 46, 24);
                panel.add(label_1);
               
                txtCoach = new JTextField();
                txtCoach.setBounds(82, 54, 327, 20);
                panel.add(txtCoach);
                txtCoach.setColumns(10);
               
                JLabel lblLocalizacion = new JLabel("Localizacion:\r\n");
                lblLocalizacion.setBounds(10, 85, 78, 24);
                panel.add(lblLocalizacion);
               
                cbLocacion = new JComboBox<Object>();
                cbLocacion.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Quicken Loans Arena", "Oracle Arena", "Madison Square Garden", "Rose Garden"}));
                cbLocacion.setBounds(82, 87, 327, 20);
    
                panel.add(cbLocacion);
               
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setBounds(108, 171, 623, 214);
                contentPanel.add(scrollPane);
               
               
                scrollPane.setViewportView(tableEquipos);
                {                      
                	
                	tableEquipos.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                        	
                        	Boolean checked=(Boolean)tablem.getValueAt(table.getSelectedRow(),0);
                            if (checked!=null && checked) {
                         	   
                         	   auxT.add(Liga.getInstances().getEquipos().get(table.getSelectedRow()));
                         	   
                         	   
                          }
                        }
                	}
                	);}
                        JPanel buttonPane = new JPanel();
                        getContentPane().add(buttonPane, BorderLayout.SOUTH);
                       
                        ButtonInsertar = new JButton("Insertar");
                        ButtonInsertar.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                       
                                	//Insertar un equipo.
                                        if (txtNombreEquipo.getText().isEmpty() || txtCoach.getText().isEmpty() || cbLocacion.getSelectedIndex() == 0) {
                                                JOptionPane.showMessageDialog(null, "Campos vacios", "Warning", JOptionPane.WARNING_MESSAGE);
                                        }
                                        else {
                                                Equipo team = new Equipo(txtNombreEquipo.getText(), txtCoach.getText(), cbLocacion.getSelectedItem().toString());
                                                Liga.getInstances().InsertarEquipo(team);
                                                JOptionPane.showMessageDialog(null, "El equipo ha sido creado", null, JOptionPane.INFORMATION_MESSAGE, null);
                                                Clean();
                                                LoadTeam();

                                                cbLocacion.setEnabled(true);
                                        }
 
                                }
                        });
                       
                        ButtonDelete = new JButton("Borrar");
                        ButtonDelete.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent arg0) {
                                        int answer = JOptionPane.showConfirmDialog(null, "Desea borrar este equipo?",null,JOptionPane.YES_NO_OPTION);
                                if (answer == JOptionPane.YES_OPTION) {
                                        Delete_Team();
                                        LoadTeam();
                                      
                                }
                                else {
                                        return;
                                }
                                       
                                }
                        });
                        buttonPane.setLayout(new GridLayout(0, 4, 0, 0));
                        
                        JButton btnImpEquip = new JButton("Imprimir");
                        btnImpEquip.addActionListener(new ActionListener() {
                        	public void actionPerformed(ActionEvent e) {
                        		 try{
        				             
          			               File file = new File("./Equipos.txt");
          			               
          			               if(!file.exists()){
          			                   file.createNewFile();
          			               }
          			               
          			               FileWriter fw = new FileWriter(file.getAbsoluteFile());
          			               BufferedWriter bw = new BufferedWriter(fw);
          			               
          			               bw.write("\n														EQUIPOS DE LA SERIE NACIONAL															\n");
          			               bw.write("-----------------------------------------------------------------------------------------------------------------------------------------------\n");
          			               bw.write("\t\t\t\tNombre \t\t\tCoach \t\t\tLocacion\n");
          			             bw.write("-----------------------------------------------------------------------------------------------------------------------------------------------\n");
          			               for(int i = 0; i < tableEquipos.getRowCount(); i++){
          			                  
          			                   for(int j = 0; j < tableEquipos.getColumnCount(); j++){
          			                       bw.write(tableEquipos.getModel().getValueAt(i, j)+"			 ");
          			                     
          			                   }
          			                   bw.write("\n");
          			               
          			                
          			                   
          			               }
          			             bw.write("-----------------------------------------------------------------------------------------------------------------------------------------------\n");
          			              
          			             
          			               bw.close();
          			              
          			               fw.close();
          			               JOptionPane.showMessageDialog(null, "Lista de equipos esta impresa!");
          			               
          			               }catch(Exception ex){
          			                   ex.printStackTrace();
          			               }
                        	}
                        });
                        buttonPane.add(btnImpEquip);
                        buttonPane.add(ButtonDelete);
                       
                      

                        buttonPane.add(ButtonInsertar);
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
        
       
        public void LoadTeam (){
                tablem.setRowCount(0);
                fila = new Object[tablem.getColumnCount()];
                
        tableEquipos= new JTable(tablem);
        tableEquipos.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {                	 
                           
                        ButtonDelete.setEnabled(true);
                        //ButtonModify.setEnabled(true);
                        table.setEnabled(true);
                }
        });
        tableEquipos.getColumn("Select").setCellRenderer(new CELL_RENDERER());
        tableEquipos.getColumn("Select").setMaxWidth(60);
        tableEquipos.getColumn("Select").setCellEditor(new CELL_EDITOR(new JCheckBox()));
        tableEquipos.setRowSelectionAllowed(true);
       
        for (Equipo aux : Liga.getInstances().getEquipos()) {


			 fila[1] = aux.getNombre();
			 fila[2] = aux.getCoach();
			 fila[3] = aux.getLocacion();
					
			
			tablem.addRow(fila);
			
		}
		

		tableEquipos.setModel(tablem);
		tableEquipos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableEquipos.getTableHeader().setReorderingAllowed(false);

		TableColumnModel modeloColumna = tableEquipos.getColumnModel();
		modeloColumna.getColumn(0).setPreferredWidth(50);
		modeloColumna.getColumn(1).setPreferredWidth(190);
		modeloColumna.getColumn(2).setPreferredWidth(180);
		modeloColumna.getColumn(3).setPreferredWidth(200);
		                   
		
	}

        public void Modify_Team() {
               
                String Name = (String) tablem.getValueAt(tableEquipos.getSelectedRow(), 1);
                String HeadCoach = (String) tablem.getValueAt(tableEquipos.getSelectedRow(), 2);
                String Location = (String) tablem.getValueAt(tableEquipos.getSelectedRow(), 3);
               
               
                txtNombreEquipo.setText(Name);
                txtCoach.setText(HeadCoach);
                cbLocacion.setSelectedItem(Location);
               
                Delete_Team();
        }
 
        public void Delete_Team() {
                
        	int temp = 0;
        	for (int i = 0; i < Liga.getInstances().getEquipos().size(); i++) {
        		    for (int j = 0; j < auxT.size(); j++) {
						if (auxT.get(j).getNombre().equalsIgnoreCase(Liga.getInstances().getEquipos().get(i).getNombre())) {
							Liga.getInstances().getEquipos().remove(i);
							temp = i;
						}
					}
			}
        	
        	Liga.getInstances().getEquipos().remove(temp);
        	tablem.fireTableDataChanged();
        }
       
        private void Clean() {
               
                txtNombreEquipo.setText("");
                txtCoach.setText("");
                cbLocacion.setSelectedIndex(0);
        }
 }

