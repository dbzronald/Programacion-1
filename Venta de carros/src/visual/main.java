package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import java.awt.Color;
import java.awt.Toolkit;


import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JRadioButtonMenuItem;

import logical.Sum;
import logical.Vendedor;

public class main extends JFrame {
	private Vendedor ven;
	private Dimension dim;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vendedor ven = new Vendedor();
					Sum sum = new Sum();
							
					main frame = new main(ven);
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
	public main(Vendedor pVen) {
		getContentPane().setBackground(new Color(255, 228, 181));
		setBackground(Color.WHITE);
		setTitle("Vendedores de Autos CxA");
		this.ven = pVen;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\buch\\workspace\\Tarea1\\ico.png"));
		setForeground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 332);
		dim = super.getToolkit().getScreenSize(); 
		super.setSize(dim);
		this.setResizable(false);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(255, 222, 173));
		menuBar.setBackground(new Color(0, 0, 0));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Compras");
		mnNewMenu.setBackground(new Color(0, 0, 0));
		mnNewMenu.setForeground(new Color(255, 228, 181));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar Suministrador");
		mntmRegistrar.setForeground(new Color(255, 255, 255));
		mntmRegistrar.setBackground(new Color(0, 0, 0));
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean option = true;
				RegSum inter = new RegSum(ven , null, option);
				inter.setModal(true);
				inter.setVisible(true);
			}
		});

		mnNewMenu.add(mntmRegistrar);
		
		JMenuItem mntmRegistrarCarro = new JMenuItem("Registrar Carro");
		mntmRegistrarCarro.setForeground(new Color(255, 255, 255));
		mntmRegistrarCarro.setBackground(new Color(0, 0, 0));
		mntmRegistrarCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean option = true;
				RegCarro carr = new RegCarro(ven,"Registrar Vehiculo", option, null );
				carr.setModal(true);
				carr.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmRegistrarCarro);
		
		JMenu mnVentas = new JMenu("Ventas");
		mnVentas.setBackground(new Color(0, 0, 0));
		mnVentas.setForeground(new Color(255, 228, 181));
		menuBar.add(mnVentas);
		
		JMenuItem mntmLista_1 = new JMenuItem("Realizar Venta");
		mntmLista_1.setForeground(new Color(255, 255, 255));
		mntmLista_1.setBackground(new Color(0, 0, 0));
		mntmLista_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegVenta vent = new RegVenta(ven, null, null, null);
				vent.setModal(true);
				vent.setVisible(true);
			}
		});
		mnVentas.add(mntmLista_1);
		
		JMenu mnListas = new JMenu("Listas");
		mnListas.setBackground(new Color(0, 0, 0));
		mnListas.setForeground(new Color(255, 228, 181));
		menuBar.add(mnListas);
		
		JMenuItem mntmVentas = new JMenuItem("Ventas");
		mntmVentas.setBackground(new Color(0, 0, 0));
		mntmVentas.setForeground(new Color(255, 255, 255));
		mntmVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListVentas vent = new ListVentas(ven, null);
				vent.setModal(true);
				vent.setVisible(true);
			}
		});
		
		JMenuItem mntmSum = new JMenuItem("Suministradores");
		mntmSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaSum su = new ListaSum(ven);
				su.setModal(true);
				su.setVisible(true);
			}
		});
		mntmSum.setForeground(Color.WHITE);
		mntmSum.setBackground(Color.BLACK);
		mnListas.add(mntmSum);
		mnListas.add(mntmVentas);
		
		JMenuItem mntmVehiculos = new JMenuItem("Vehiculos");
		mntmVehiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListCarros ca = new ListCarros(ven);
				ca.setModal(true);
				ca.setVisible(true);
				
			}
		});
		mntmVehiculos.setBackground(new Color(0, 0, 0));
		mntmVehiculos.setForeground(new Color(255, 255, 255));
		mnListas.add(mntmVehiculos);
		getContentPane().setLayout(null);
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

