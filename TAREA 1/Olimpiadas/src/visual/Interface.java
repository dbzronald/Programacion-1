package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Interface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		JMenuItem mntmRecordsDeLas = new JMenuItem("Registrar Equipo");
		mntmRecordsDeLas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Records rec = new Records();
				rec.setVisible(true);
				/*rec.setModal(true);
				rec.setLocationRelativeTo(null);*/
				
				
			}
		});
		mnOpciones.add(mntmRecordsDeLas);
		
		JMenuItem mntmTabla = new JMenuItem("Lista de Medallas por Equipo");
		mntmTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaDatos tab = new TablaDatos();
				tab.setVisible(true);
				/*tab.setModal(true);
				tab.setLocationRelativeTo(null);*/
				
			}
		});
		mnOpciones.add(mntmTabla);
		
		JMenuItem mntmRegistroDeOlimpiadas = new JMenuItem("Registro de Deportistas");
		mntmRegistroDeOlimpiadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro reg = new Registro();
				reg.setVisible(true);
				/*reg.setModal(true);
				reg.setLocationRelativeTo(null);*/
				
			}
		});
		mnOpciones.add(mntmRegistroDeOlimpiadas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
