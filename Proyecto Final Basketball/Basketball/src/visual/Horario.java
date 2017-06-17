package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logical.Liga;
import logical.Partido;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Horario extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTable tableCalendario;
	private JButton btnPlay;
	public DefaultTableModel tableModel;
	Liga liga;
	Object[] row;


	/**
	 * Create the dialog.
	 */
	public Horario() {
		
		setModal(true);
		setTitle("Horario");
		liga = new Liga();
		setBounds(100, 100, 543, 371);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 301, 527, 32);
			contentPanel.add(buttonPane);
			
			{
				JButton btnClose = new JButton("Close");
				btnClose.setBounds(425, 5, 82, 23);
				btnClose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.setLayout(null);
				btnClose.setActionCommand("Cancel");
				buttonPane.add(btnClose);
			}
			{
				btnPlay = new JButton("Play Game");
				btnPlay.setEnabled(false);
				btnPlay.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegistrarPartido register_game = new RegistrarPartido();
						String Visit = (String) tableModel.getValueAt(tableCalendario.getSelectedRow(), 2);
						String Local = (String) tableModel.getValueAt(tableCalendario.getSelectedRow(), 3);
						register_game.textField_EquipoVisit.setText(""+Visit);
						register_game.textField_EquipoLocal.setText(""+Local);
						register_game.Fill_Fields();
						register_game.Reset();
						register_game.setVisible(true);
						dispose();
					}
				});
				btnPlay.setBounds(10, 5, 108, 23);
				buttonPane.add(btnPlay);
			}
			
			JButton btnImprimir = new JButton("Imprimir");
			btnImprimir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 try{
			             
			               File file = new File("./Horarios.txt");
			               
			               if(!file.exists()){
			                   file.createNewFile();
			               }
			               
			               FileWriter fw = new FileWriter(file.getAbsoluteFile());
			               BufferedWriter bw = new BufferedWriter(fw);
			               
			               bw.write("\n								HORARIO DE PARTIDOS\n");
			               bw.write("-----------------------------------------------------------------------------------------\n");
			               bw.write("Fecha \t\t\t\tTiempo \t\t\t\tAway team \t\t\t\tHome team\n");
			               bw.write("-----------------------------------------------------------------------------------------\n");
			               for(int i = 0; i < tableCalendario.getRowCount(); i++){
			                  
			                   for(int j = 0; j < tableCalendario.getColumnCount(); j++){
			                       bw.write(tableCalendario.getModel().getValueAt(i, j)+"			 ");
			                     
			                   }
			                   bw.write("\n");
			                  
			                  
			               }
			               bw.write("-----------------------------------------------------------------------------------------");;
			              
			             
			               bw.close();
			              
			               fw.close();
			               JOptionPane.showMessageDialog(null, "Horario Imprimido!");
			               
			               }catch(Exception ex){
			                   ex.printStackTrace();
			               }
				}
			});
			btnImprimir.setBounds(127, 5, 89, 23);
			buttonPane.add(btnImprimir);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 507, 279);
		contentPanel.add(scrollPane);
		
		tableCalendario = new JTable();
		tableCalendario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnPlay.setEnabled(true);
			}
		});
		scrollPane.setViewportView(tableCalendario);
		{
			tableModel = new DefaultTableModel(
					new Object[][] {
							
					},
					new String[] {
							"Fecha", "Tiempo", "Away team", "Home team"
					});
			tableCalendario.setModel(tableModel);
			tableCalendario.getColumnModel().getColumn(0).setPreferredWidth(125);
			tableCalendario.getColumnModel().getColumn(1).setPreferredWidth(109);
			tableCalendario.getColumnModel().getColumn(2).setPreferredWidth(135);
			tableCalendario.getColumnModel().getColumn(3).setPreferredWidth(135);
			try {
				
					Load_Games();
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {	
				e.printStackTrace();
			}
		}
	}
	public void Load_Games() throws IOException, ClassNotFoundException {
		tableModel.setRowCount(0);
		row = new Object[tableModel.getColumnCount()];
		
		for (Partido aux : Liga.getInstances().getPartidos()) {
			row[0] = aux.getDate();
			row[1] = aux.getTiempo();
			row[2] = aux.getAway();
			row[3] = aux.getHome();
			
			tableModel.addRow(row);
		}
		
		tableCalendario.setModel(tableModel);
		tableCalendario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableCalendario.getTableHeader().setReorderingAllowed(false);
		TableColumnModel modeloColumna = tableCalendario.getColumnModel();
		modeloColumna.getColumn(0).setPreferredWidth(125);
		modeloColumna.getColumn(1).setPreferredWidth(109);
		modeloColumna.getColumn(2).setPreferredWidth(135);
		modeloColumna.getColumn(2).setPreferredWidth(135);
	}
}
