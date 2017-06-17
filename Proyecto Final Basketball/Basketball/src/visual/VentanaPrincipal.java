package visual;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;
import visual.CrearJugador;
import logical.Jugador;
import logical.Liga;

public class VentanaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Calendar now;
	final DateFormat dateFormat;
	private static Liga lig;
	 File f = new File("./Datos.dat");
	
	Jugador jugador;
	Object[] row;
	DefaultTableModel tableModel;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal(lig);
					frame.setExtendedState(Frame.MAXIMIZED_BOTH);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal(final Liga lig) {
		
		now = Calendar.getInstance();
		now.get(Calendar.MONTH);
		dateFormat = new SimpleDateFormat("H:mm:ss");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1357, 738);
		
		Liga.getInstances().loadLiga(lig);
		
		Toolkit.getDefaultToolkit().getScreenSize();
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		jugador = new Jugador();
		JMenu mnGames = new JMenu("Juegos");
		menuBar.add(mnGames);
		
		JMenuItem mntmNewGame = new JMenuItem("Registrar Partido");
		mntmNewGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				InsertarPartido insert_game = new InsertarPartido();
				insert_game.setVisible(true);
			}
		});
		mnGames.add(mntmNewGame);
	
		JMenuItem mntmSchedule = new JMenuItem("Horario");
		mntmSchedule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Horario schedule = new Horario();
				try {
					schedule.Load_Games();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				schedule.setVisible(true);
			}
		});
		mnGames.add(mntmSchedule);
		
		
		JMenu mnTeams = new JMenu("Equipos");
		menuBar.add(mnTeams);
		
		JMenuItem mntmInsertTeams = new JMenuItem("Crear Equipo");
		mntmInsertTeams.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CrearEquipo insert_team = new CrearEquipo();
				insert_team.setVisible(true);
			}
		});
		mnTeams.add(mntmInsertTeams);
		
		
		
		JMenu mnPlayers = new JMenu("Jugadores");
		menuBar.add(mnPlayers);
		
		JMenuItem mntmInsertPlayer = new JMenuItem("Crear Jugador");
		mntmInsertPlayer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CrearJugador insert_player = null;
				try {
					insert_player = new CrearJugador();
				} catch (ClassNotFoundException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				insert_player.Load_Player();
				insert_player.setVisible(true);
			}
		});
		mnPlayers.add(mntmInsertPlayer);
		
		
		
		JMenu mnInjuries = new JMenu("Lesiones");
		menuBar.add(mnInjuries);
		
		JMenuItem mntmAddInjury = new JMenuItem("Agregar Lesion");
		mntmAddInjury.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				InsertarLesion insert_injury = new InsertarLesion();
				insert_injury.setVisible(true);
				
			}
		});
		mnInjuries.add(mntmAddInjury);
		
		JMenuItem mntmHistory = new JMenuItem("Historial");
		mntmHistory.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LesionesHistorial injuries_history = new LesionesHistorial();
				injuries_history.setVisible(true);
			}
		});
		mnInjuries.add(mntmHistory);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/MainImagen.jpg")));
		lblNewLabel.setBounds(0, 0, 1348, 684);
		getContentPane().add(lblNewLabel);
		
		addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {	
                Liga.getInstances().saveLiga(Liga.getInstances());;
                e.getWindow().dispose();
            }
        });
		}
	
}
