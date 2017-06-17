package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logical.ComplejoLacteo;
import logical.Factura;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ComplejoLacteo complejo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Arial", Font.PLAIN, 12));
		setJMenuBar(menuBar);
		
		JMenu mnMenuVentas = new JMenu("Ventas");
		mnMenuVentas.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnMenuVentas);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Registrar Venta");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegVentas venta = new RegVentas(complejo);
				venta.setModal(true);
				venta.setVisible(true);
			}
		});
		
		JMenuItem mntmRegistrarQueso = new JMenuItem("A\u00F1adir Queso");
		mntmRegistrarQueso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegQuesos quesos = new RegQuesos(null);
				quesos.setModal(true);
				quesos.setVisible(true);
			}
		});
		mntmRegistrarQueso.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenuVentas.add(mntmRegistrarQueso);
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenuVentas.add(mntmNewMenuItem_1);
		
		JMenu mnMenuReportes = new JMenu("Reportes");
		mnMenuReportes.setFont(new Font("Arial", Font.PLAIN, 12));
		menuBar.add(mnMenuReportes);
		
		JMenuItem mntmGananciasDelDia = new JMenuItem("Generar ganancias");
		mntmGananciasDelDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double sum = 0;
				for(Factura aux : ComplejoLacteo.getInstance().getListaFacturas()){
					sum = sum + aux.getMonto();
				}
				
				JOptionPane.showMessageDialog(null,"Su Ganancia es:\n $" + sum);
			}
		});
		mntmGananciasDelDia.setFont(new Font("Arial", Font.PLAIN, 12));
		mnMenuReportes.add(mntmGananciasDelDia);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Facturación");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Facturas factur = new Facturas(complejo);
				factur.setModal(true);
				factur.setVisible(true);
			}
		});
		mnMenuReportes.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.setFont(new Font("Arial", Font.PLAIN, 12));
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
