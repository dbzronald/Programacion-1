package visual;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import logical.Liga;
import logical.Estadisticas;

import java.awt.Color;
import java.awt.Font;

public class RegistrarPartido extends JDialog{


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public JTextField textField_EquipoVisit;
	public JTextField textField_EquipoLocal;
	public JTextField textField_EquipoVisit_0;
	public JTextField textField_EquipoVisit_1;
	private JTextField textField_EquipoVisit_2;
	private JTextField textField_EquipoVisit_3;
	private JTextField textField_EquipoVisit_4;
	private JTextField textField_EquipoVisit_5;
	private JTextField textField_EquipoVisit_6;
	private JTextField textField_EquipoVisit_7;
	private JTextField textField_EquipoVisit_8;
	private JTextField textField_EquipoVisit_9;
	private JTextField textField_EquipoVisit_10;
	private JTextField textField_EquipoVisit_11;
	private JPanel panel_Jugadores_EquipoLocal;
	public JTextField textField_EquipoLocal_0;
	public JTextField textField_EquipoLocal_1;
	private JTextField textField_EquipoLocal_2;
	private JTextField textField_EquipoLocal_3;
	private JTextField textField_EquipoLocal_4;
	private JTextField textField_EquipoLocal_5;
	private JTextField textField_EquipoLocal_6;
	private JTextField textField_EquipoLocal_7;
	private JTextField textField_EquipoLocal_8;
	private JTextField textField_EquipoLocal_9;
	private JTextField textField_EquipoLocal_10;
	private JTextField textField_EquipoLocal_11;
	private JPanel panel_Puntos_EquipoVisit;
	private JPanel panel_Libres_EquipoVisit;
	private JPanel panel_Tres_EquipoVisit;
	private JPanel panel_Puntos_EquipoLocal;
	private JPanel panel_Libres_EquipoLocal;
	private JPanel panel_Tres_EquipoLocal;
	private JTextField textField_EquipoLocalFouls;
	private JTextField textField_EquipoVisitFouls;
	private JTextField textField_EquipoVisitPuntos;
	private JTextField textField_HomeTeamPoints;
	private JTextField textField_Visit_Puntos_0;
	private JTextField textField_Visit_Puntos_1;
	private JTextField textField_Visit_Puntos_3;
	private JTextField textField_Visit_Puntos_2;
	private JTextField textField_Visit_Puntos_5;
	private JTextField textField_Visit_Puntos_4;
	private JTextField textField_Visit_Puntos_7;
	private JTextField textField_Visit_Puntos_6;
	private JTextField textField_Visit_Puntos_9;
	private JTextField textField_Visit_Puntos_8;
	private JTextField textField_Visit_Puntos_11;
	private JTextField textField_Visit_Puntos_10;
	private JTextField textField_Visit_Libres_0;
	private JTextField textField_Visit_Libres_1;
	private JTextField textField_Visit_Libres_2;
	private JTextField textField_Visit_Libres_3;
	private JTextField textField_Visit_Libres_4;
	private JTextField textField_Visit_Libres_5;
	private JTextField textField_Visit_Libres_6;
	private JTextField textField_Visit_Libres_7;
	private JTextField textField_Visit_Libres_8;
	private JTextField textField_Visit_Libres_9;
	private JTextField textField_Visit_Libres_10;
	private JTextField textField_Visit_Libres_11;
	private JTextField textField_Visit_Tres_0;
	private JTextField textField_Visit_Tres_1;
	private JTextField textField_Visit_Tres_2;
	private JTextField textField_Visit_Tres_3;
	private JTextField textField_Visit_Tres_4;
	private JTextField textField_Visit_Tres_5;
	private JTextField textField_Visit_Tres_6;
	private JTextField textField_Visit_Tres_7;
	private JTextField textField_Visit_Tres_8;
	private JTextField textField_Visit_Tres_9;
	private JTextField textField_Visit_Tres_10;
	private JTextField textField_Visit_Tres_11;

	
	private JTextField textField_Local_Puntos_0;
	private JTextField textField_Local_Puntos_1;
	private JTextField textField_Local_Puntos_2;
	private JTextField textField_Local_Puntos_3;
	private JTextField textField_Local_Puntos_4;
	private JTextField textField_Local_Puntos_5;
	private JTextField textField_Local_Puntos_6;
	private JTextField textField_Local_Puntos_7;
	private JTextField textField_Local_Puntos_8;
	private JTextField textField_Local_Puntos_9;
	private JTextField textField_Local_Puntos_10;
	private JTextField textField_Local_Puntos_11;
	private JTextField textField_Local_Libres_0;
	private JTextField textField_Local_Libres_1;
	private JTextField textField_Local_Libres_2;
	private JTextField textField_Local_Libres_3;
	private JTextField textField_Local_Libres_4;
	private JTextField textField_Local_Libres_5;
	private JTextField textField_Local_Libres_6;
	private JTextField textField_Local_Libres_7;
	private JTextField textField_Local_Libres_8;
	private JTextField textField_Local_Libres_9;
	private JTextField textField_Local_Libres_10;
	private JTextField textField_Local_Libres_11;
	private JTextField textField_Local_Tres_0;
	private JTextField textField_Local_Tres_1;
	private JTextField textField_Local_Tres_2;
	private JTextField textField_Local_Tres_3;
	private JTextField textField_Local_Tres_4;
	private JTextField textField_Local_Tres_5;
	private JTextField textField_Local_Tres_6;
	private JTextField textField_Local_Tres_7;
	private JTextField textField_Local_Tres_8;
	private JTextField textField_Local_Tres_9;
	private JTextField textField_Local_Tres_10;
	private JTextField textField_Local_Tres_11;
	
	
	private JButton btnSave;
	
	int VisitPuntosDeDos;
	int VisitPuntosDeDos0;
	int VisitPuntosDeDos1;
	int VisitPuntosDeDos2;
	int VisitPuntosDeDos3;
	int VisitPuntosDeDos4;
	int VisitPuntosDeDos5;
	int VisitPuntosDeDos6;
	int VisitPuntosDeDos7;
	int VisitPuntosDeDos8;
	int VisitPuntosDeDos9;
	int VisitPuntosDeDos10;
	int VisitPuntosDeDos11;
	
	int VisitTirosLibres0;
	int VisitTirosLibres1;
	int VisitTirosLibres2;
	int VisitTirosLibres3; 
	int VisitTirosLibres4;
	int VisitTirosLibres5;
	int VisitTirosLibres6;
	int VisitTirosLibres7;
	int VisitTirosLibres8;
	int VisitTirosLibres9;
	int VisitTirosLibres10;
	int VisitTirosLibres11; 
	
	int VisitTiroDeTres0; 
	int VisitTiroDeTres1; 
	int VisitTiroDeTres2; 
	int VisitTiroDeTres3; 
	int VisitTiroDeTres4;
	int VisitTiroDeTres5; 
	int VisitTiroDeTres6;
	int VisitTiroDeTres7;
	int VisitTiroDeTres8;
	int VisitTiroDeTres9; 
	int VisitTiroDeTres10; 
	int VisitTiroDeTres11;
	
	int LocalPuntosDeDos;
	int LocalPuntosDeDos0;
	int LocalPuntosDeDos1;
	int LocalPuntosDeDos2;
	int LocalPuntosDeDos3;
	int LocalPuntosDeDos4;
	int LocalPuntosDeDos5;
	int LocalPuntosDeDos6;
	int LocalPuntosDeDos7;
	int LocalPuntosDeDos8;
	int LocalPuntosDeDos9;
	int LocalPuntosDeDos10;
	int LocalPuntosDeDos11;
	
	int LocalTirosLibres0;
	int LocalTirosLibres1;
	int LocalTirosLibres2;
	int LocalTirosLibres3;
	int LocalTirosLibres4;
	int LocalTirosLibres5;
	int LocalTirosLibres6;
	int LocalTirosLibres7;
	int LocalTirosLibres8;
	int LocalTirosLibres9;
	int LocalTirosLibres10;
	int LocalTirosLibres11;
	
	int LocalTiroDeTres0;
	int LocalTiroDeTres1;
	int LocalTiroDeTres2;
	int LocalTiroDeTres3;
	int LocalTiroDeTres4;
	int LocalTiroDeTres5;
	int LocalTiroDeTres6;
	int LocalTiroDeTres7;
	int LocalTiroDeTres8;
	int LocalTiroDeTres9;
	int LocalTiroDeTres10;
	int LocalTiroDeTres11;
	

	InsertarPartido insert_game;
	int HomeTeamFouls, AwayTeamFouls;
	Horario schedule;
	/**
	 * Create the dialog.
	 */
	public RegistrarPartido() {
		schedule = new Horario();
		setModal(true);
		insert_game = new InsertarPartido();
		
		setTitle("Juego en VIVO");
		setBounds(50, 10, 1171, 640);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
		}
		
		JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
		separator.setBounds(575, 11, 2, 431);
		contentPanel.add(separator);
		{
			JLabel lblAwayTeam = new JLabel("Equipo visitante:");
			lblAwayTeam.setBounds(83, 11, 117, 27);
			contentPanel.add(lblAwayTeam);
		}
		
		textField_EquipoVisit = new JTextField();
		textField_EquipoVisit.setHorizontalAlignment(SwingConstants.CENTER);
		textField_EquipoVisit.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_EquipoVisit.setEditable(false);
		textField_EquipoVisit.setBounds(185, 14, 200, 20);
		contentPanel.add(textField_EquipoVisit);
		textField_EquipoVisit.setColumns(10);
		{
			textField_EquipoLocal = new JTextField();
			textField_EquipoLocal.setHorizontalAlignment(SwingConstants.CENTER);
			textField_EquipoLocal.setFont(new Font("Tahoma", Font.BOLD, 14));
			textField_EquipoLocal.setEditable(false);
			textField_EquipoLocal.setColumns(10);
			textField_EquipoLocal.setBounds(760, 14, 200, 20);
			contentPanel.add(textField_EquipoLocal);
		}
		{
			JLabel lblHomeTeam = new JLabel("Equipo local:");
			lblHomeTeam.setBounds(675, 11, 75, 27);
			contentPanel.add(lblHomeTeam);
		}
		{
			JPanel panel_Players_AwayTeam = new JPanel();
			panel_Players_AwayTeam.setBorder(new TitledBorder(null, "Jugadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_Players_AwayTeam.setToolTipText("");
			panel_Players_AwayTeam.setBounds(10, 39, 165, 403);
			contentPanel.add(panel_Players_AwayTeam);
			panel_Players_AwayTeam.setLayout(null);
			{
				textField_EquipoVisit_0 = new JTextField();
				textField_EquipoVisit_0.setEditable(false);
				textField_EquipoVisit_0.setBounds(10, 31, 145, 20);
				panel_Players_AwayTeam.add(textField_EquipoVisit_0);
				textField_EquipoVisit_0.setColumns(10);
			}
			{
				textField_EquipoVisit_1 = new JTextField();
				textField_EquipoVisit_1.setEditable(false);
				textField_EquipoVisit_1.setColumns(10);
				textField_EquipoVisit_1.setBounds(10, 62, 145, 20);
				panel_Players_AwayTeam.add(textField_EquipoVisit_1);
			}
			{
				textField_EquipoVisit_2 = new JTextField();
				textField_EquipoVisit_2.setEditable(false);
				textField_EquipoVisit_2.setColumns(10);
				textField_EquipoVisit_2.setBounds(10, 124, 145, 20);
				panel_Players_AwayTeam.add(textField_EquipoVisit_2);
			}
			{
				textField_EquipoVisit_3 = new JTextField();
				textField_EquipoVisit_3.setEditable(false);
				textField_EquipoVisit_3.setColumns(10);
				textField_EquipoVisit_3.setBounds(10, 93, 145, 20);
				panel_Players_AwayTeam.add(textField_EquipoVisit_3);
			}
			{
				textField_EquipoVisit_4 = new JTextField();
				textField_EquipoVisit_4.setEditable(false);
				textField_EquipoVisit_4.setColumns(10);
				textField_EquipoVisit_4.setBounds(10, 186, 145, 20);
				panel_Players_AwayTeam.add(textField_EquipoVisit_4);
			}
			{
				textField_EquipoVisit_5 = new JTextField();
				textField_EquipoVisit_5.setEditable(false);
				textField_EquipoVisit_5.setColumns(10);
				textField_EquipoVisit_5.setBounds(10, 155, 145, 20);
				panel_Players_AwayTeam.add(textField_EquipoVisit_5);
			}
			{
				textField_EquipoVisit_6 = new JTextField();
				textField_EquipoVisit_6.setEditable(false);
				textField_EquipoVisit_6.setColumns(10);
				textField_EquipoVisit_6.setBounds(10, 248, 145, 20);
				panel_Players_AwayTeam.add(textField_EquipoVisit_6);
			}
			{
				textField_EquipoVisit_7 = new JTextField();
				textField_EquipoVisit_7.setEditable(false);
				textField_EquipoVisit_7.setColumns(10);
				textField_EquipoVisit_7.setBounds(10, 217, 145, 20);
				panel_Players_AwayTeam.add(textField_EquipoVisit_7);
			}
			{
				textField_EquipoVisit_8 = new JTextField();
				textField_EquipoVisit_8.setEditable(false);
				textField_EquipoVisit_8.setColumns(10);
				textField_EquipoVisit_8.setBounds(10, 310, 145, 20);
				panel_Players_AwayTeam.add(textField_EquipoVisit_8);
			}
			{
				textField_EquipoVisit_9 = new JTextField();
				textField_EquipoVisit_9.setEditable(false);
				textField_EquipoVisit_9.setColumns(10);
				textField_EquipoVisit_9.setBounds(10, 279, 145, 20);
				panel_Players_AwayTeam.add(textField_EquipoVisit_9);
			}
			{
				textField_EquipoVisit_10 = new JTextField();
				textField_EquipoVisit_10.setEditable(false);
				textField_EquipoVisit_10.setColumns(10);
				textField_EquipoVisit_10.setBounds(10, 372, 145, 20);
				panel_Players_AwayTeam.add(textField_EquipoVisit_10);
			}
			{
				textField_EquipoVisit_11 = new JTextField();
				textField_EquipoVisit_11.setEditable(false);
				textField_EquipoVisit_11.setColumns(10);
				textField_EquipoVisit_11.setBounds(10, 341, 145, 20);
				panel_Players_AwayTeam.add(textField_EquipoVisit_11);
			}
		}
		{
			panel_Jugadores_EquipoLocal = new JPanel();
			panel_Jugadores_EquipoLocal.setLayout(null);
			panel_Jugadores_EquipoLocal.setToolTipText("");
			panel_Jugadores_EquipoLocal.setBorder(new TitledBorder(null, "Jugadores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_Jugadores_EquipoLocal.setBounds(587, 39, 165, 403);
			contentPanel.add(panel_Jugadores_EquipoLocal);
			{
				textField_EquipoLocal_0 = new JTextField();
				textField_EquipoLocal_0.setEditable(false);
				textField_EquipoLocal_0.setColumns(10);
				textField_EquipoLocal_0.setBounds(10, 31, 145, 20);
				panel_Jugadores_EquipoLocal.add(textField_EquipoLocal_0);
			}
			{
				textField_EquipoLocal_1 = new JTextField();
				textField_EquipoLocal_1.setEditable(false);
				textField_EquipoLocal_1.setColumns(10);
				textField_EquipoLocal_1.setBounds(10, 62, 145, 20);
				panel_Jugadores_EquipoLocal.add(textField_EquipoLocal_1);
			}
			{
				textField_EquipoLocal_2 = new JTextField();
				textField_EquipoLocal_2.setEditable(false);
				textField_EquipoLocal_2.setColumns(10);
				textField_EquipoLocal_2.setBounds(10, 124, 145, 20);
				panel_Jugadores_EquipoLocal.add(textField_EquipoLocal_2);
			}
			{
				textField_EquipoLocal_3 = new JTextField();
				textField_EquipoLocal_3.setEditable(false);
				textField_EquipoLocal_3.setColumns(10);
				textField_EquipoLocal_3.setBounds(10, 93, 145, 20);
				panel_Jugadores_EquipoLocal.add(textField_EquipoLocal_3);
			}
			{
				textField_EquipoLocal_4 = new JTextField();
				textField_EquipoLocal_4.setEditable(false);
				textField_EquipoLocal_4.setColumns(10);
				textField_EquipoLocal_4.setBounds(10, 186, 145, 20);
				panel_Jugadores_EquipoLocal.add(textField_EquipoLocal_4);
			}
			{
				textField_EquipoLocal_5 = new JTextField();
				textField_EquipoLocal_5.setEditable(false);
				textField_EquipoLocal_5.setColumns(10);
				textField_EquipoLocal_5.setBounds(10, 155, 145, 20);
				panel_Jugadores_EquipoLocal.add(textField_EquipoLocal_5);
			}
			{
				textField_EquipoLocal_6 = new JTextField();
				textField_EquipoLocal_6.setEditable(false);
				textField_EquipoLocal_6.setColumns(10);
				textField_EquipoLocal_6.setBounds(10, 248, 145, 20);
				panel_Jugadores_EquipoLocal.add(textField_EquipoLocal_6);
			}
			{
				textField_EquipoLocal_7 = new JTextField();
				textField_EquipoLocal_7.setEditable(false);
				textField_EquipoLocal_7.setColumns(10);
				textField_EquipoLocal_7.setBounds(10, 217, 145, 20);
				panel_Jugadores_EquipoLocal.add(textField_EquipoLocal_7);
			}
			{
				textField_EquipoLocal_8 = new JTextField();
				textField_EquipoLocal_8.setEditable(false);
				textField_EquipoLocal_8.setColumns(10);
				textField_EquipoLocal_8.setBounds(10, 310, 145, 20);
				panel_Jugadores_EquipoLocal.add(textField_EquipoLocal_8);
			}
			{
				textField_EquipoLocal_9 = new JTextField();
				textField_EquipoLocal_9.setEditable(false);
				textField_EquipoLocal_9.setColumns(10);
				textField_EquipoLocal_9.setBounds(10, 279, 145, 20);
				panel_Jugadores_EquipoLocal.add(textField_EquipoLocal_9);
			}
			{
				textField_EquipoLocal_10 = new JTextField();
				textField_EquipoLocal_10.setEditable(false);
				textField_EquipoLocal_10.setColumns(10);
				textField_EquipoLocal_10.setBounds(10, 372, 145, 20);
				panel_Jugadores_EquipoLocal.add(textField_EquipoLocal_10);
			}
			{
				textField_EquipoLocal_11 = new JTextField();
				textField_EquipoLocal_11.setEditable(false);
				textField_EquipoLocal_11.setColumns(10);
				textField_EquipoLocal_11.setBounds(10, 341, 145, 20);
				panel_Jugadores_EquipoLocal.add(textField_EquipoLocal_11);
			}
		}
		{
			panel_Puntos_EquipoVisit = new JPanel();
			panel_Puntos_EquipoVisit.setBorder(new TitledBorder(null, "T-2Pts", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_Puntos_EquipoVisit.setBounds(185, 39, 67, 403);
			contentPanel.add(panel_Puntos_EquipoVisit);
			panel_Puntos_EquipoVisit.setLayout(null);
			
			textField_Visit_Puntos_0 = new JTextField();
			textField_Visit_Puntos_0.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Puntos_0.setBounds(10, 30, 47, 20);
			panel_Puntos_EquipoVisit.add(textField_Visit_Puntos_0);
			textField_Visit_Puntos_0.setColumns(10);
			
			textField_Visit_Puntos_1 = new JTextField();
			textField_Visit_Puntos_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Puntos_1.setColumns(10);
			textField_Visit_Puntos_1.setBounds(10, 62, 47, 20);
			panel_Puntos_EquipoVisit.add(textField_Visit_Puntos_1);
			
			textField_Visit_Puntos_2 = new JTextField();
			textField_Visit_Puntos_2.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Puntos_2.setColumns(10);
			textField_Visit_Puntos_2.setBounds(10, 93, 47, 20);
			panel_Puntos_EquipoVisit.add(textField_Visit_Puntos_2);
			
			textField_Visit_Puntos_3 = new JTextField();
			textField_Visit_Puntos_3.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Puntos_3.setColumns(10);
			textField_Visit_Puntos_3.setBounds(10, 124, 47, 20);
			panel_Puntos_EquipoVisit.add(textField_Visit_Puntos_3);
			
			textField_Visit_Puntos_4 = new JTextField();
			textField_Visit_Puntos_4.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Puntos_4.setColumns(10);
			textField_Visit_Puntos_4.setBounds(10, 155, 47, 20);
			panel_Puntos_EquipoVisit.add(textField_Visit_Puntos_4);
			
			textField_Visit_Puntos_5 = new JTextField();
			textField_Visit_Puntos_5.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Puntos_5.setColumns(10);
			textField_Visit_Puntos_5.setBounds(10, 186, 47, 20);
			panel_Puntos_EquipoVisit.add(textField_Visit_Puntos_5);
			
			textField_Visit_Puntos_6 = new JTextField();
			textField_Visit_Puntos_6.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Puntos_6.setColumns(10);
			textField_Visit_Puntos_6.setBounds(10, 217, 47, 20);
			panel_Puntos_EquipoVisit.add(textField_Visit_Puntos_6);
			
			textField_Visit_Puntos_7 = new JTextField();
			textField_Visit_Puntos_7.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Puntos_7.setColumns(10);
			textField_Visit_Puntos_7.setBounds(10, 248, 47, 20);
			panel_Puntos_EquipoVisit.add(textField_Visit_Puntos_7);
			
			textField_Visit_Puntos_8 = new JTextField();
			textField_Visit_Puntos_8.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Puntos_8.setColumns(10);
			textField_Visit_Puntos_8.setBounds(10, 279, 47, 20);
			panel_Puntos_EquipoVisit.add(textField_Visit_Puntos_8);
			
			textField_Visit_Puntos_9 = new JTextField();
			textField_Visit_Puntos_9.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Puntos_9.setColumns(10);
			textField_Visit_Puntos_9.setBounds(10, 310, 47, 20);
			panel_Puntos_EquipoVisit.add(textField_Visit_Puntos_9);
			
			textField_Visit_Puntos_10 = new JTextField();
			textField_Visit_Puntos_10.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Puntos_10.setColumns(10);
			textField_Visit_Puntos_10.setBounds(10, 341, 47, 20);
			panel_Puntos_EquipoVisit.add(textField_Visit_Puntos_10);
			
			textField_Visit_Puntos_11 = new JTextField();
			textField_Visit_Puntos_11.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Puntos_11.setColumns(10);
			textField_Visit_Puntos_11.setBounds(10, 372, 47, 20);
			panel_Puntos_EquipoVisit.add(textField_Visit_Puntos_11);
		}
		{
			panel_Libres_EquipoVisit = new JPanel();
			panel_Libres_EquipoVisit.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T-Libres", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_Libres_EquipoVisit.setBounds(259, 39, 75, 403);
			contentPanel.add(panel_Libres_EquipoVisit);
			panel_Libres_EquipoVisit.setLayout(null);
			
			textField_Visit_Libres_0 = new JTextField();
			textField_Visit_Libres_0.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Libres_0.setColumns(10);
			textField_Visit_Libres_0.setBounds(10, 31, 47, 20);
			panel_Libres_EquipoVisit.add(textField_Visit_Libres_0);
			
			textField_Visit_Libres_1 = new JTextField();
			textField_Visit_Libres_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Libres_1.setColumns(10);
			textField_Visit_Libres_1.setBounds(10, 62, 47, 20);
			panel_Libres_EquipoVisit.add(textField_Visit_Libres_1);
			
			textField_Visit_Libres_2 = new JTextField();
			textField_Visit_Libres_2.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Libres_2.setColumns(10);
			textField_Visit_Libres_2.setBounds(10, 93, 47, 20);
			panel_Libres_EquipoVisit.add(textField_Visit_Libres_2);
			
			textField_Visit_Libres_3 = new JTextField();
			textField_Visit_Libres_3.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Libres_3.setColumns(10);
			textField_Visit_Libres_3.setBounds(10, 124, 47, 20);
			panel_Libres_EquipoVisit.add(textField_Visit_Libres_3);
			
			textField_Visit_Libres_4 = new JTextField();
			textField_Visit_Libres_4.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Libres_4.setColumns(10);
			textField_Visit_Libres_4.setBounds(10, 155, 47, 20);
			panel_Libres_EquipoVisit.add(textField_Visit_Libres_4);
			
			textField_Visit_Libres_5 = new JTextField();
			textField_Visit_Libres_5.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Libres_5.setColumns(10);
			textField_Visit_Libres_5.setBounds(10, 186, 47, 20);
			panel_Libres_EquipoVisit.add(textField_Visit_Libres_5);
			
			textField_Visit_Libres_6 = new JTextField();
			textField_Visit_Libres_6.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Libres_6.setColumns(10);
			textField_Visit_Libres_6.setBounds(10, 217, 47, 20);
			panel_Libres_EquipoVisit.add(textField_Visit_Libres_6);
			
			textField_Visit_Libres_7 = new JTextField();
			textField_Visit_Libres_7.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Libres_7.setColumns(10);
			textField_Visit_Libres_7.setBounds(10, 248, 47, 20);
			panel_Libres_EquipoVisit.add(textField_Visit_Libres_7);
			
			textField_Visit_Libres_8 = new JTextField();
			textField_Visit_Libres_8.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Libres_8.setColumns(10);
			textField_Visit_Libres_8.setBounds(10, 279, 47, 20);
			panel_Libres_EquipoVisit.add(textField_Visit_Libres_8);
			
			textField_Visit_Libres_9 = new JTextField();
			textField_Visit_Libres_9.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Libres_9.setColumns(10);
			textField_Visit_Libres_9.setBounds(10, 310, 47, 20);
			panel_Libres_EquipoVisit.add(textField_Visit_Libres_9);
			
			textField_Visit_Libres_10 = new JTextField();
			textField_Visit_Libres_10.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Libres_10.setColumns(10);
			textField_Visit_Libres_10.setBounds(10, 341, 47, 20);
			panel_Libres_EquipoVisit.add(textField_Visit_Libres_10);
			
			textField_Visit_Libres_11 = new JTextField();
			textField_Visit_Libres_11.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Libres_11.setColumns(10);
			textField_Visit_Libres_11.setBounds(10, 372, 47, 20);
			panel_Libres_EquipoVisit.add(textField_Visit_Libres_11);
		}
		{
			panel_Tres_EquipoVisit = new JPanel();
			panel_Tres_EquipoVisit.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T-3Pts", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_Tres_EquipoVisit.setBounds(344, 39, 67, 403);
			contentPanel.add(panel_Tres_EquipoVisit);
			panel_Tres_EquipoVisit.setLayout(null);
			
			textField_Visit_Tres_0 = new JTextField();
			textField_Visit_Tres_0.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Tres_0.setColumns(10);
			textField_Visit_Tres_0.setBounds(10, 30, 47, 20);
			panel_Tres_EquipoVisit.add(textField_Visit_Tres_0);
			
			textField_Visit_Tres_1 = new JTextField();
			textField_Visit_Tres_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Tres_1.setColumns(10);
			textField_Visit_Tres_1.setBounds(10, 62, 47, 20);
			panel_Tres_EquipoVisit.add(textField_Visit_Tres_1);
			
			textField_Visit_Tres_2 = new JTextField();
			textField_Visit_Tres_2.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Tres_2.setColumns(10);
			textField_Visit_Tres_2.setBounds(10, 93, 47, 20);
			panel_Tres_EquipoVisit.add(textField_Visit_Tres_2);
			
			textField_Visit_Tres_3 = new JTextField();
			textField_Visit_Tres_3.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Tres_3.setColumns(10);
			textField_Visit_Tres_3.setBounds(10, 124, 47, 20);
			panel_Tres_EquipoVisit.add(textField_Visit_Tres_3);
			
			textField_Visit_Tres_4 = new JTextField();
			textField_Visit_Tres_4.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Tres_4.setColumns(10);
			textField_Visit_Tres_4.setBounds(10, 155, 47, 20);
			panel_Tres_EquipoVisit.add(textField_Visit_Tres_4);
			
			textField_Visit_Tres_5 = new JTextField();
			textField_Visit_Tres_5.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Tres_5.setColumns(10);
			textField_Visit_Tres_5.setBounds(10, 186, 47, 20);
			panel_Tres_EquipoVisit.add(textField_Visit_Tres_5);
			
			textField_Visit_Tres_6 = new JTextField();
			textField_Visit_Tres_6.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Tres_6.setColumns(10);
			textField_Visit_Tres_6.setBounds(10, 217, 47, 20);
			panel_Tres_EquipoVisit.add(textField_Visit_Tres_6);
			
			textField_Visit_Tres_7 = new JTextField();
			textField_Visit_Tres_7.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Tres_7.setColumns(10);
			textField_Visit_Tres_7.setBounds(10, 248, 47, 20);
			panel_Tres_EquipoVisit.add(textField_Visit_Tres_7);
			
			textField_Visit_Tres_8 = new JTextField();
			textField_Visit_Tres_8.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Tres_8.setColumns(10);
			textField_Visit_Tres_8.setBounds(10, 279, 47, 20);
			panel_Tres_EquipoVisit.add(textField_Visit_Tres_8);
			
			textField_Visit_Tres_9 = new JTextField();
			textField_Visit_Tres_9.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Tres_9.setColumns(10);
			textField_Visit_Tres_9.setBounds(10, 310, 47, 20);
			panel_Tres_EquipoVisit.add(textField_Visit_Tres_9);
			
			textField_Visit_Tres_10 = new JTextField();
			textField_Visit_Tres_10.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Tres_10.setColumns(10);
			textField_Visit_Tres_10.setBounds(10, 341, 47, 20);
			panel_Tres_EquipoVisit.add(textField_Visit_Tres_10);
			
			textField_Visit_Tres_11 = new JTextField();
			textField_Visit_Tres_11.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Visit_Tres_11.setColumns(10);
			textField_Visit_Tres_11.setBounds(10, 372, 47, 20);
			panel_Tres_EquipoVisit.add(textField_Visit_Tres_11);
		}

		{
			panel_Puntos_EquipoLocal = new JPanel();
			panel_Puntos_EquipoLocal.setBorder(new TitledBorder(null, "T-2Pts", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_Puntos_EquipoLocal.setBounds(760, 39, 67, 403);
			contentPanel.add(panel_Puntos_EquipoLocal);
			panel_Puntos_EquipoLocal.setLayout(null);
			
			textField_Local_Puntos_0 = new JTextField();
			textField_Local_Puntos_0.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Puntos_0.setColumns(10);
			textField_Local_Puntos_0.setBounds(10, 30, 47, 20);
			panel_Puntos_EquipoLocal.add(textField_Local_Puntos_0);
			
			textField_Local_Puntos_1 = new JTextField();
			textField_Local_Puntos_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Puntos_1.setColumns(10);
			textField_Local_Puntos_1.setBounds(10, 62, 47, 20);
			panel_Puntos_EquipoLocal.add(textField_Local_Puntos_1);
			
			textField_Local_Puntos_2 = new JTextField();
			textField_Local_Puntos_2.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Puntos_2.setColumns(10);
			textField_Local_Puntos_2.setBounds(10, 93, 47, 20);
			panel_Puntos_EquipoLocal.add(textField_Local_Puntos_2);
			
			textField_Local_Puntos_3 = new JTextField();
			textField_Local_Puntos_3.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Puntos_3.setColumns(10);
			textField_Local_Puntos_3.setBounds(10, 124, 47, 20);
			panel_Puntos_EquipoLocal.add(textField_Local_Puntos_3);
			
			textField_Local_Puntos_4 = new JTextField();
			textField_Local_Puntos_4.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Puntos_4.setColumns(10);
			textField_Local_Puntos_4.setBounds(10, 155, 47, 20);
			panel_Puntos_EquipoLocal.add(textField_Local_Puntos_4);
			
			textField_Local_Puntos_5 = new JTextField();
			textField_Local_Puntos_5.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Puntos_5.setColumns(10);
			textField_Local_Puntos_5.setBounds(10, 186, 47, 20);
			panel_Puntos_EquipoLocal.add(textField_Local_Puntos_5);
			
			textField_Local_Puntos_6 = new JTextField();
			textField_Local_Puntos_6.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Puntos_6.setColumns(10);
			textField_Local_Puntos_6.setBounds(10, 217, 47, 20);
			panel_Puntos_EquipoLocal.add(textField_Local_Puntos_6);
			
			textField_Local_Puntos_7 = new JTextField();
			textField_Local_Puntos_7.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Puntos_7.setColumns(10);
			textField_Local_Puntos_7.setBounds(10, 248, 47, 20);
			panel_Puntos_EquipoLocal.add(textField_Local_Puntos_7);
			
			textField_Local_Puntos_8 = new JTextField();
			textField_Local_Puntos_8.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Puntos_8.setColumns(10);
			textField_Local_Puntos_8.setBounds(10, 279, 47, 20);
			panel_Puntos_EquipoLocal.add(textField_Local_Puntos_8);
			
			textField_Local_Puntos_9 = new JTextField();
			textField_Local_Puntos_9.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Puntos_9.setColumns(10);
			textField_Local_Puntos_9.setBounds(10, 310, 47, 20);
			panel_Puntos_EquipoLocal.add(textField_Local_Puntos_9);
			
			textField_Local_Puntos_10 = new JTextField();
			textField_Local_Puntos_10.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Puntos_10.setColumns(10);
			textField_Local_Puntos_10.setBounds(10, 341, 47, 20);
			panel_Puntos_EquipoLocal.add(textField_Local_Puntos_10);
			
			textField_Local_Puntos_11 = new JTextField();
			textField_Local_Puntos_11.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Puntos_11.setColumns(10);
			textField_Local_Puntos_11.setBounds(10, 372, 47, 20);
			panel_Puntos_EquipoLocal.add(textField_Local_Puntos_11);
		}
		{
			panel_Libres_EquipoLocal = new JPanel();
			panel_Libres_EquipoLocal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T-Libres", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_Libres_EquipoLocal.setBounds(837, 39, 75, 403);
			contentPanel.add(panel_Libres_EquipoLocal);
			panel_Libres_EquipoLocal.setLayout(null);
			
			textField_Local_Libres_0 = new JTextField();
			textField_Local_Libres_0.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Libres_0.setColumns(10);
			textField_Local_Libres_0.setBounds(10, 30, 47, 20);
			panel_Libres_EquipoLocal.add(textField_Local_Libres_0);
			
			textField_Local_Libres_1 = new JTextField();
			textField_Local_Libres_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Libres_1.setColumns(10);
			textField_Local_Libres_1.setBounds(10, 62, 47, 20);
			panel_Libres_EquipoLocal.add(textField_Local_Libres_1);
			
			textField_Local_Libres_2 = new JTextField();
			textField_Local_Libres_2.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Libres_2.setColumns(10);
			textField_Local_Libres_2.setBounds(10, 93, 47, 20);
			panel_Libres_EquipoLocal.add(textField_Local_Libres_2);
			
			textField_Local_Libres_3 = new JTextField();
			textField_Local_Libres_3.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Libres_3.setColumns(10);
			textField_Local_Libres_3.setBounds(10, 124, 47, 20);
			panel_Libres_EquipoLocal.add(textField_Local_Libres_3);
			
			textField_Local_Libres_4 = new JTextField();
			textField_Local_Libres_4.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Libres_4.setColumns(10);
			textField_Local_Libres_4.setBounds(10, 155, 47, 20);
			panel_Libres_EquipoLocal.add(textField_Local_Libres_4);
			
			textField_Local_Libres_5 = new JTextField();
			textField_Local_Libres_5.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Libres_5.setColumns(10);
			textField_Local_Libres_5.setBounds(10, 186, 47, 20);
			panel_Libres_EquipoLocal.add(textField_Local_Libres_5);
			
			textField_Local_Libres_6 = new JTextField();
			textField_Local_Libres_6.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Libres_6.setColumns(10);
			textField_Local_Libres_6.setBounds(10, 217, 47, 20);
			panel_Libres_EquipoLocal.add(textField_Local_Libres_6);
			
			textField_Local_Libres_7 = new JTextField();
			textField_Local_Libres_7.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Libres_7.setColumns(10);
			textField_Local_Libres_7.setBounds(10, 248, 47, 20);
			panel_Libres_EquipoLocal.add(textField_Local_Libres_7);
			
			textField_Local_Libres_8 = new JTextField();
			textField_Local_Libres_8.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Libres_8.setColumns(10);
			textField_Local_Libres_8.setBounds(10, 279, 47, 20);
			panel_Libres_EquipoLocal.add(textField_Local_Libres_8);
			
			textField_Local_Libres_9 = new JTextField();
			textField_Local_Libres_9.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Libres_9.setColumns(10);
			textField_Local_Libres_9.setBounds(10, 310, 47, 20);
			panel_Libres_EquipoLocal.add(textField_Local_Libres_9);
			
			textField_Local_Libres_10 = new JTextField();
			textField_Local_Libres_10.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Libres_10.setColumns(10);
			textField_Local_Libres_10.setBounds(10, 341, 47, 20);
			panel_Libres_EquipoLocal.add(textField_Local_Libres_10);
			
			textField_Local_Libres_11 = new JTextField();
			textField_Local_Libres_11.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Libres_11.setColumns(10);
			textField_Local_Libres_11.setBounds(10, 372, 47, 20);
			panel_Libres_EquipoLocal.add(textField_Local_Libres_11);
		}
		{
			panel_Tres_EquipoLocal= new JPanel();
			panel_Tres_EquipoLocal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T-3Pts", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_Tres_EquipoLocal.setBounds(922, 39, 67, 403);
			contentPanel.add(panel_Tres_EquipoLocal);
			panel_Tres_EquipoLocal.setLayout(null);
			
			textField_Local_Tres_0 = new JTextField();
			textField_Local_Tres_0.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Tres_0.setColumns(10);
			textField_Local_Tres_0.setBounds(10, 30, 47, 20);
			panel_Tres_EquipoLocal.add(textField_Local_Tres_0);
			
			textField_Local_Tres_1 = new JTextField();
			textField_Local_Tres_1.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Tres_1.setColumns(10);
			textField_Local_Tres_1.setBounds(10, 62, 47, 20);
			panel_Tres_EquipoLocal.add(textField_Local_Tres_1);
			
			textField_Local_Tres_2 = new JTextField();
			textField_Local_Tres_2.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Tres_2.setColumns(10);
			textField_Local_Tres_2.setBounds(10, 93, 47, 20);
			panel_Tres_EquipoLocal.add(textField_Local_Tres_2);
			
			textField_Local_Tres_3 = new JTextField();
			textField_Local_Tres_3.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Tres_3.setColumns(10);
			textField_Local_Tres_3.setBounds(10, 124, 47, 20);
			panel_Tres_EquipoLocal.add(textField_Local_Tres_3);
			
			textField_Local_Tres_4 = new JTextField();
			textField_Local_Tres_4.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Tres_4.setColumns(10);
			textField_Local_Tres_4.setBounds(10, 155, 47, 20);
			panel_Tres_EquipoLocal.add(textField_Local_Tres_4);
			
			textField_Local_Tres_5 = new JTextField();
			textField_Local_Tres_5.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Tres_5.setColumns(10);
			textField_Local_Tres_5.setBounds(10, 186, 47, 20);
			panel_Tres_EquipoLocal.add(textField_Local_Tres_5);
			
			textField_Local_Tres_6 = new JTextField();
			textField_Local_Tres_6.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Tres_6.setColumns(10);
			textField_Local_Tres_6.setBounds(10, 217, 47, 20);
			panel_Tres_EquipoLocal.add(textField_Local_Tres_6);
			
			textField_Local_Tres_7 = new JTextField();
			textField_Local_Tres_7.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Tres_7.setColumns(10);
			textField_Local_Tres_7.setBounds(10, 248, 47, 20);
			panel_Tres_EquipoLocal.add(textField_Local_Tres_7);
			
			textField_Local_Tres_8 = new JTextField();
			textField_Local_Tres_8.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Tres_8.setColumns(10);
			textField_Local_Tres_8.setBounds(10, 279, 47, 20);
			panel_Tres_EquipoLocal.add(textField_Local_Tres_8);
			
			textField_Local_Tres_9 = new JTextField();
			textField_Local_Tres_9.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Tres_9.setColumns(10);
			textField_Local_Tres_9.setBounds(10, 310, 47, 20);
			panel_Tres_EquipoLocal.add(textField_Local_Tres_9);
			
			textField_Local_Tres_10 = new JTextField();
			textField_Local_Tres_10.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Tres_10.setColumns(10);
			textField_Local_Tres_10.setBounds(10, 341, 47, 20);
			panel_Tres_EquipoLocal.add(textField_Local_Tres_10);
			
			textField_Local_Tres_11 = new JTextField();
			textField_Local_Tres_11.setHorizontalAlignment(SwingConstants.CENTER);
			textField_Local_Tres_11.setColumns(10);
			textField_Local_Tres_11.setBounds(10, 372, 47, 20);
			panel_Tres_EquipoLocal.add(textField_Local_Tres_11);
		}

		
		JPanel panel_GameInfo = new JPanel();
		panel_GameInfo.setBorder(new TitledBorder(null, "Resumen de juego", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_GameInfo.setBounds(10, 453, 1133, 95);
		contentPanel.add(panel_GameInfo);
		panel_GameInfo.setLayout(null);
		
		JLabel lblHomeTeamFouls = new JLabel("Faltas Equipo/Local:");
		lblHomeTeamFouls.setBounds(588, 56, 105, 28);
		panel_GameInfo.add(lblHomeTeamFouls);
		
		textField_EquipoLocalFouls = new JTextField();
		textField_EquipoLocalFouls.setHorizontalAlignment(SwingConstants.CENTER);
		textField_EquipoLocalFouls.setBounds(703, 60, 44, 20);
		panel_GameInfo.add(textField_EquipoLocalFouls);
		textField_EquipoLocalFouls.setColumns(10);
		
		JLabel lblAwayTeamFouls = new JLabel("Faltas Equipo/Visitantes:");
		lblAwayTeamFouls.setBounds(10, 56, 105, 28);
		panel_GameInfo.add(lblAwayTeamFouls);
		
		textField_EquipoVisitFouls = new JTextField();
		textField_EquipoVisitFouls.setHorizontalAlignment(SwingConstants.CENTER);
		textField_EquipoVisitFouls.setColumns(10);
		textField_EquipoVisitFouls.setBounds(125, 60, 44, 20);
		panel_GameInfo.add(textField_EquipoVisitFouls);
		
		JLabel lblAwayTeam_points = new JLabel("PTS Total/Visitantes:");
		lblAwayTeam_points.setBounds(10, 17, 115, 28);
		panel_GameInfo.add(lblAwayTeam_points);
		
		textField_EquipoVisitPuntos = new JTextField();
		textField_EquipoVisitPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		textField_EquipoVisitPuntos.setEditable(false);
		textField_EquipoVisitPuntos.setBounds(125, 21, 44, 20);
		panel_GameInfo.add(textField_EquipoVisitPuntos);
		textField_EquipoVisitPuntos.setColumns(10);
		
		JLabel lblHomeTeam_1 = new JLabel("PTS Total/Local:");
		lblHomeTeam_1.setBounds(588, 17, 115, 28);
		panel_GameInfo.add(lblHomeTeam_1);
		
		textField_HomeTeamPoints = new JTextField();
		textField_HomeTeamPoints.setHorizontalAlignment(SwingConstants.CENTER);
		textField_HomeTeamPoints.setEditable(false);
		textField_HomeTeamPoints.setColumns(10);
		textField_HomeTeamPoints.setBounds(703, 21, 44, 20);
		panel_GameInfo.add(textField_HomeTeamPoints);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 559, 1155, 32);
			contentPanel.add(buttonPane);
			{
				JButton btnClose = new JButton("Cerrar");
				btnClose.setBounds(1049, 5, 101, 23);
				btnClose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();						
					}
				});
				buttonPane.setLayout(null);
				btnClose.setActionCommand("Cancelar");
				buttonPane.add(btnClose);
			}
			
			
			btnSave = new JButton("Salvar");
			btnSave.setEnabled(false);
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Juego guardado satisfactoriamente!", "", JOptionPane.INFORMATION_MESSAGE);
					Save();
					
					dispose();
				}
			});
			btnSave.setBounds(950, 5, 89, 23);
			buttonPane.add(btnSave);
			
			JButton btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Update();
					btnSave.setEnabled(true);
				}
			});
			btnUpdate.setBounds(10, 5, 89, 23);
			buttonPane.add(btnUpdate);
		}
	}
	
	public void Fill_Fields() {
		for (int i = 0; i < Liga.getInstances().getEquipos().size(); i++) {
			for (int j = 0; j < Liga.getInstances().getEquipos().get(i).getJugadores().size(); j++) {
				//AWAY TEAM
				if (Liga.getInstances().getEquipos().get(i).getNombre().equalsIgnoreCase(textField_EquipoVisit.getText())) {
					textField_EquipoVisit_0.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(0).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(0).getApellido());
					textField_EquipoVisit_1.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(1).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(1).getApellido());
					textField_EquipoVisit_2.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(2).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(2).getApellido());
					textField_EquipoVisit_3.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(3).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(3).getApellido());
					textField_EquipoVisit_4.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(4).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(4).getApellido());
					textField_EquipoVisit_5.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(5).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(5).getApellido());
					textField_EquipoVisit_6.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(6).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(6).getApellido());
					textField_EquipoVisit_7.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(7).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(7).getApellido());
					textField_EquipoVisit_8.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(8).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(8).getApellido());
					textField_EquipoVisit_9.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(9).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(9).getApellido());
					textField_EquipoVisit_10.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(10).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(10).getApellido());
					textField_EquipoVisit_11.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(11).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(11).getApellido());
				}
				
				//HOME TEAM
				if (Liga.getInstances().getEquipos().get(i).getNombre().equalsIgnoreCase(textField_EquipoLocal.getText())) {
					textField_EquipoLocal_0.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(0).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(0).getApellido());
					textField_EquipoLocal_1.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(1).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(1).getApellido());
					textField_EquipoLocal_2.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(2).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(2).getApellido());
					textField_EquipoLocal_3.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(3).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(3).getApellido());
					textField_EquipoLocal_4.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(4).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(4).getApellido());
					textField_EquipoLocal_5.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(5).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(5).getApellido());
					textField_EquipoLocal_6.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(6).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(6).getApellido());
					textField_EquipoLocal_7.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(7).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(7).getApellido());
					textField_EquipoLocal_8.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(8).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(8).getApellido());
					textField_EquipoLocal_9.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(9).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(9).getApellido());
					textField_EquipoLocal_10.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(10).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(10).getApellido());
					textField_EquipoLocal_11.setText(""+Liga.getInstances().getEquipos().get(i).getJugadores().get(11).getNombre()+" "+Liga.getInstances().getEquipos().get(i).getJugadores().get(11).getApellido());
				}
			}
		}
	}
	
	public void Reset() {
		textField_EquipoVisitPuntos.setText(""+0);
		
		textField_Visit_Puntos_0.setText(""+0);
		textField_Visit_Puntos_1.setText(""+0);
		textField_Visit_Puntos_2.setText(""+0);
		textField_Visit_Puntos_3.setText(""+0);
		textField_Visit_Puntos_4.setText(""+0);
		textField_Visit_Puntos_5.setText(""+0);
		textField_Visit_Puntos_6.setText(""+0);
		textField_Visit_Puntos_7.setText(""+0);
		textField_Visit_Puntos_8.setText(""+0);
		textField_Visit_Puntos_9.setText(""+0);
		textField_Visit_Puntos_10.setText(""+0);
		textField_Visit_Puntos_11.setText(""+0);
		
		textField_Visit_Libres_0.setText(""+0);
		textField_Visit_Libres_1.setText(""+0);
		textField_Visit_Libres_2.setText(""+0);
		textField_Visit_Libres_3.setText(""+0);
		textField_Visit_Libres_4.setText(""+0);
		textField_Visit_Libres_5.setText(""+0);
		textField_Visit_Libres_6.setText(""+0);
		textField_Visit_Libres_7.setText(""+0);
		textField_Visit_Libres_8.setText(""+0);
		textField_Visit_Libres_9.setText(""+0);
		textField_Visit_Libres_10.setText(""+0);
		textField_Visit_Libres_11.setText(""+0);
		
		textField_Visit_Tres_0.setText(""+0);
		textField_Visit_Tres_1.setText(""+0);
		textField_Visit_Tres_2.setText(""+0);
		textField_Visit_Tres_3.setText(""+0);
		textField_Visit_Tres_4.setText(""+0);
		textField_Visit_Tres_5.setText(""+0);
		textField_Visit_Tres_6.setText(""+0);
		textField_Visit_Tres_7.setText(""+0);
		textField_Visit_Tres_8.setText(""+0);
		textField_Visit_Tres_9.setText(""+0);
		textField_Visit_Tres_10.setText(""+0);
		textField_Visit_Tres_11.setText(""+0);
		

		//---------------------------------------------------------------------------------------------------------------------------------
		
		
		textField_HomeTeamPoints.setText(""+0);
		
		textField_Local_Puntos_0.setText(""+0);
		textField_Local_Puntos_1.setText(""+0);
		textField_Local_Puntos_2.setText(""+0);
		textField_Local_Puntos_3.setText(""+0);
		textField_Local_Puntos_4.setText(""+0);
		textField_Local_Puntos_5.setText(""+0);
		textField_Local_Puntos_6.setText(""+0);
		textField_Local_Puntos_7.setText(""+0);
		textField_Local_Puntos_8.setText(""+0);
		textField_Local_Puntos_9.setText(""+0);
		textField_Local_Puntos_10.setText(""+0);
		textField_Local_Puntos_11.setText(""+0);
		
		textField_Local_Libres_0.setText(""+0);
		textField_Local_Libres_1.setText(""+0);
		textField_Local_Libres_2.setText(""+0);
		textField_Local_Libres_3.setText(""+0);
		textField_Local_Libres_4.setText(""+0);
		textField_Local_Libres_5.setText(""+0);
		textField_Local_Libres_6.setText(""+0);
		textField_Local_Libres_7.setText(""+0);
		textField_Local_Libres_8.setText(""+0);
		textField_Local_Libres_9.setText(""+0);
		textField_Local_Libres_10.setText(""+0);
		textField_Local_Libres_11.setText(""+0);
		
		textField_Local_Tres_0.setText(""+0);
		textField_Local_Tres_1.setText(""+0);
		textField_Local_Tres_2.setText(""+0);
		textField_Local_Tres_3.setText(""+0);
		textField_Local_Tres_4.setText(""+0);
		textField_Local_Tres_5.setText(""+0);
		textField_Local_Tres_6.setText(""+0);
		textField_Local_Tres_7.setText(""+0);
		textField_Local_Tres_8.setText(""+0);
		textField_Local_Tres_9.setText(""+0);
		textField_Local_Tres_10.setText(""+0);
		textField_Local_Tres_11.setText(""+0);
		

		
		textField_EquipoVisitFouls.setText(""+0);
		textField_EquipoLocalFouls.setText(""+0);
	}
	
	public void Update() {
		//Away team points
		try {
			VisitPuntosDeDos = 0;
			VisitPuntosDeDos0 = Integer.parseInt(""+textField_Visit_Puntos_0.getText());
			VisitPuntosDeDos1 = Integer.parseInt(""+textField_Visit_Puntos_1.getText());
			VisitPuntosDeDos2 = Integer.parseInt(""+textField_Visit_Puntos_2.getText());
			VisitPuntosDeDos3 = Integer.parseInt(""+textField_Visit_Puntos_3.getText());
			VisitPuntosDeDos4 = Integer.parseInt(""+textField_Visit_Puntos_4.getText());
			VisitPuntosDeDos5 = Integer.parseInt(""+textField_Visit_Puntos_5.getText());
			VisitPuntosDeDos6 = Integer.parseInt(""+textField_Visit_Puntos_6.getText());
			VisitPuntosDeDos7 = Integer.parseInt(""+textField_Visit_Puntos_7.getText());
			VisitPuntosDeDos8 = Integer.parseInt(""+textField_Visit_Puntos_8.getText());
			VisitPuntosDeDos9 = Integer.parseInt(""+textField_Visit_Puntos_9.getText());
			VisitPuntosDeDos10 = Integer.parseInt(""+textField_Visit_Puntos_10.getText());
			VisitPuntosDeDos11 = Integer.parseInt(""+textField_Visit_Puntos_11.getText());
			
			//Total de puntos de 2
			VisitPuntosDeDos += (VisitPuntosDeDos0*2) + (VisitPuntosDeDos1*2) + (VisitPuntosDeDos2*2) + (VisitPuntosDeDos3*2) + (VisitPuntosDeDos4*2) + (VisitPuntosDeDos5*2) + (VisitPuntosDeDos6*2) + (VisitPuntosDeDos7*2) + 
					(VisitPuntosDeDos8*2) + (VisitPuntosDeDos9*2) + (VisitPuntosDeDos10*2) + (VisitPuntosDeDos11*2);
			
			textField_EquipoVisitPuntos.setText(""+VisitPuntosDeDos);
			
			//Estos son los tiros libres
			VisitTirosLibres0 = Integer.parseInt(""+textField_Visit_Libres_0.getText());
			VisitTirosLibres1 = Integer.parseInt(""+textField_Local_Libres_1.getText());
			VisitTirosLibres2 = Integer.parseInt(""+textField_Local_Libres_2.getText());
			VisitTirosLibres3 = Integer.parseInt(""+textField_Local_Libres_3.getText());
			VisitTirosLibres4 = Integer.parseInt(""+textField_Local_Libres_4.getText());
			VisitTirosLibres5 = Integer.parseInt(""+textField_Local_Libres_5.getText());
			VisitTirosLibres6 = Integer.parseInt(""+textField_Local_Libres_6.getText());
			VisitTirosLibres7 = Integer.parseInt(""+textField_Local_Libres_7.getText());
			VisitTirosLibres8 = Integer.parseInt(""+textField_Local_Libres_8.getText());
			VisitTirosLibres9 = Integer.parseInt(""+textField_Local_Libres_9.getText());
			VisitTirosLibres10 = Integer.parseInt(""+textField_Local_Libres_10.getText());
			VisitTirosLibres11 = Integer.parseInt(""+textField_Local_Libres_11.getText());
			
			VisitPuntosDeDos += (VisitTirosLibres0) + (VisitTirosLibres1) + (VisitTirosLibres2)+ (VisitTirosLibres3)+ (VisitTirosLibres4)+ (VisitTirosLibres5)+ (VisitTirosLibres6)+ (VisitTirosLibres7)+ (VisitTirosLibres8)+ 
					(VisitTirosLibres9)+ (VisitTirosLibres10)+ (VisitTirosLibres11);
			
			textField_EquipoVisitPuntos.setText(""+VisitPuntosDeDos);

			
			//Estos son los tiros de tres del visitante
			VisitTiroDeTres0 = Integer.parseInt(""+textField_Visit_Tres_0.getText());
			VisitTiroDeTres1 = Integer.parseInt(""+textField_Visit_Tres_1.getText());
			VisitTiroDeTres2 = Integer.parseInt(""+textField_Visit_Tres_2.getText());
			VisitTiroDeTres3 = Integer.parseInt(""+textField_Visit_Tres_3.getText());
			VisitTiroDeTres4 = Integer.parseInt(""+textField_Visit_Tres_4.getText());
			VisitTiroDeTres5 = Integer.parseInt(""+textField_Visit_Tres_5.getText());
			VisitTiroDeTres6 = Integer.parseInt(""+textField_Visit_Tres_6.getText());
			VisitTiroDeTres7 = Integer.parseInt(""+textField_Visit_Tres_7.getText());
			VisitTiroDeTres8 = Integer.parseInt(""+textField_Visit_Tres_8.getText());
			VisitTiroDeTres9 = Integer.parseInt(""+textField_Visit_Tres_9.getText());
			VisitTiroDeTres10 = Integer.parseInt(""+textField_Visit_Tres_10.getText());
			VisitTiroDeTres11 = Integer.parseInt(""+textField_Visit_Tres_11.getText());
			
			VisitPuntosDeDos += (VisitTiroDeTres0*3)+ (VisitTiroDeTres1*3)+ (VisitTiroDeTres2*3)+ (VisitTiroDeTres3*3)+ (VisitTiroDeTres4*3)+ (VisitTiroDeTres5*3)+ (VisitTiroDeTres6*3)+ (VisitTiroDeTres7*3)+ (VisitTiroDeTres8*3)+ 
					(VisitTiroDeTres9*3)+ (VisitTiroDeTres10*3)+ (VisitTiroDeTres11*3);
			
			textField_EquipoVisitPuntos.setText(""+VisitPuntosDeDos);

			
		
	//--------------------------------------------------------------------------------------------------------		
			
			//Home team points
			LocalPuntosDeDos = 0;
			LocalPuntosDeDos0 = Integer.parseInt(""+textField_Local_Puntos_0.getText());
			LocalPuntosDeDos1 = Integer.parseInt(""+textField_Local_Puntos_1.getText());
			LocalPuntosDeDos2 = Integer.parseInt(""+textField_Local_Puntos_2.getText());
			LocalPuntosDeDos3 = Integer.parseInt(""+textField_Local_Puntos_3.getText());
			LocalPuntosDeDos4 = Integer.parseInt(""+textField_Local_Puntos_4.getText());
			LocalPuntosDeDos5 = Integer.parseInt(""+textField_Local_Puntos_5.getText());
			LocalPuntosDeDos6 = Integer.parseInt(""+textField_Local_Puntos_6.getText());
			LocalPuntosDeDos7 = Integer.parseInt(""+textField_Local_Puntos_7.getText());
			LocalPuntosDeDos8 = Integer.parseInt(""+textField_Local_Puntos_8.getText());
			LocalPuntosDeDos9 = Integer.parseInt(""+textField_Local_Puntos_9.getText());
			LocalPuntosDeDos10 = Integer.parseInt(""+textField_Local_Puntos_10.getText());
			LocalPuntosDeDos11 = Integer.parseInt(""+textField_Local_Puntos_11.getText());
					
			//Total de puntos de 2
			LocalPuntosDeDos += (LocalPuntosDeDos0*2) + (LocalPuntosDeDos1*2) + (LocalPuntosDeDos2*2) + (LocalPuntosDeDos3*2) + (LocalPuntosDeDos4*2) + (LocalPuntosDeDos5*2) + (LocalPuntosDeDos6*2) 
					+ (LocalPuntosDeDos7*2) + (LocalPuntosDeDos8*2) + (LocalPuntosDeDos9*2) + (LocalPuntosDeDos10*2) + (LocalPuntosDeDos11*2);
			textField_HomeTeamPoints.setText(""+LocalPuntosDeDos);
					
			//Estos son los tiros libres
			LocalTirosLibres0 = Integer.parseInt(""+textField_Local_Libres_0.getText());
			LocalTirosLibres1 = Integer.parseInt(""+textField_Local_Libres_1.getText());
			LocalTirosLibres2 = Integer.parseInt(""+textField_Local_Libres_2.getText());
			LocalTirosLibres3 = Integer.parseInt(""+textField_Local_Libres_3.getText());
			LocalTirosLibres4 = Integer.parseInt(""+textField_Local_Libres_4.getText());
			LocalTirosLibres5 = Integer.parseInt(""+textField_Local_Libres_5.getText());
			LocalTirosLibres6 = Integer.parseInt(""+textField_Local_Libres_6.getText());
			LocalTirosLibres7 = Integer.parseInt(""+textField_Local_Libres_7.getText());
			LocalTirosLibres8 = Integer.parseInt(""+textField_Local_Libres_8.getText());
			LocalTirosLibres9 = Integer.parseInt(""+textField_Local_Libres_9.getText());
			LocalTirosLibres10 = Integer.parseInt(""+textField_Local_Libres_10.getText());
			LocalTirosLibres11 = Integer.parseInt(""+textField_Local_Libres_11.getText());
			
			LocalPuntosDeDos += LocalTirosLibres0 + LocalTirosLibres1+ LocalTirosLibres2+ LocalTirosLibres3+ LocalTirosLibres4+ LocalTirosLibres5+ LocalTirosLibres6+ LocalTirosLibres7+ 
					LocalTirosLibres8+ LocalTirosLibres9+ LocalTirosLibres10+ LocalTirosLibres11;
			
			textField_HomeTeamPoints.setText(""+LocalPuntosDeDos);

			
			//Estos son los tiros de tres de la casa
			LocalTiroDeTres0 = Integer.parseInt(""+textField_Local_Tres_0.getText());
			LocalTiroDeTres1 = Integer.parseInt(""+textField_Local_Tres_1.getText());
			LocalTiroDeTres2 = Integer.parseInt(""+textField_Local_Tres_2.getText());
			LocalTiroDeTres3 = Integer.parseInt(""+textField_Local_Tres_3.getText());
			LocalTiroDeTres4 = Integer.parseInt(""+textField_Local_Tres_4.getText());
			LocalTiroDeTres5 = Integer.parseInt(""+textField_Local_Tres_5.getText());
			LocalTiroDeTres6 = Integer.parseInt(""+textField_Local_Tres_6.getText());
			LocalTiroDeTres7 = Integer.parseInt(""+textField_Local_Tres_7.getText());
			LocalTiroDeTres8 = Integer.parseInt(""+textField_Local_Tres_8.getText());
			LocalTiroDeTres9 = Integer.parseInt(""+textField_Local_Tres_9.getText());
			LocalTiroDeTres10 = Integer.parseInt(""+textField_Local_Tres_10.getText());
			LocalTiroDeTres11 = Integer.parseInt(""+textField_Local_Tres_11.getText());
			

			LocalPuntosDeDos += (LocalTiroDeTres0*3) + (LocalTiroDeTres1*3)+ (LocalTiroDeTres2*3)+ (LocalTiroDeTres3*3)+ (LocalTiroDeTres4*3)+ (LocalTiroDeTres5*3)+
					(LocalTiroDeTres6*3)+ (LocalTiroDeTres7*3)+ (LocalTiroDeTres8*3)+ (LocalTiroDeTres9*3)+ (LocalTiroDeTres10*3)+ (LocalTiroDeTres11*3);

			textField_HomeTeamPoints.setText(""+LocalPuntosDeDos);

			//--------------------------------------------------------------------------------------------------------		
		}catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "No se aceptan letras. Solo numeros.", "", JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	public void Save() {
		
		for (int i = 0; i < Liga.getInstances().getEquipos().size(); i++) {
			if (textField_EquipoVisit.getText().equalsIgnoreCase(Liga.getInstances().getEquipos().get(i).getNombre())) {
				Liga.getInstances().getEquipos().get(i).getJugadores().get(0).InsertarEstadisticasJugador(new Estadisticas(VisitPuntosDeDos0, VisitTirosLibres0, VisitTiroDeTres0));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(1).InsertarEstadisticasJugador(new Estadisticas(VisitPuntosDeDos1, VisitTirosLibres1, VisitTiroDeTres1));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(2).InsertarEstadisticasJugador(new Estadisticas(VisitPuntosDeDos2, VisitTirosLibres2, VisitTiroDeTres2));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(3).InsertarEstadisticasJugador(new Estadisticas(VisitPuntosDeDos3, VisitTirosLibres3, VisitTiroDeTres3));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(4).InsertarEstadisticasJugador(new Estadisticas(VisitPuntosDeDos4, VisitTirosLibres4, VisitTiroDeTres4));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(5).InsertarEstadisticasJugador(new Estadisticas(VisitPuntosDeDos5, VisitTirosLibres5, VisitTiroDeTres5));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(6).InsertarEstadisticasJugador(new Estadisticas(VisitPuntosDeDos6, VisitTirosLibres6, VisitTiroDeTres6));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(7).InsertarEstadisticasJugador(new Estadisticas(VisitPuntosDeDos7, VisitTirosLibres7, VisitTiroDeTres7));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(8).InsertarEstadisticasJugador(new Estadisticas(VisitPuntosDeDos8, VisitTirosLibres8, VisitTiroDeTres8));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(9).InsertarEstadisticasJugador(new Estadisticas(VisitPuntosDeDos9, VisitTirosLibres9, VisitTiroDeTres9));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(10).InsertarEstadisticasJugador(new Estadisticas(VisitPuntosDeDos10, VisitTirosLibres10, VisitTiroDeTres10));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(11).InsertarEstadisticasJugador(new Estadisticas(VisitPuntosDeDos11, VisitTirosLibres11, VisitTiroDeTres11));
			}
			
			if (textField_EquipoLocal.getText().equalsIgnoreCase(Liga.getInstances().getEquipos().get(i).getNombre())) {
				Liga.getInstances().getEquipos().get(i).getJugadores().get(0).InsertarEstadisticasJugador(new Estadisticas(LocalPuntosDeDos0, LocalTirosLibres0, LocalTiroDeTres0));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(1).InsertarEstadisticasJugador(new Estadisticas(LocalPuntosDeDos1, LocalTirosLibres1, LocalTiroDeTres1));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(2).InsertarEstadisticasJugador(new Estadisticas(LocalPuntosDeDos2, LocalTirosLibres2, LocalTiroDeTres2));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(3).InsertarEstadisticasJugador(new Estadisticas(LocalPuntosDeDos3, LocalTirosLibres3, LocalTiroDeTres3));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(4).InsertarEstadisticasJugador(new Estadisticas(LocalPuntosDeDos4, LocalTirosLibres4, LocalTiroDeTres4));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(5).InsertarEstadisticasJugador(new Estadisticas(LocalPuntosDeDos5, LocalTirosLibres5, LocalTiroDeTres5));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(6).InsertarEstadisticasJugador(new Estadisticas(LocalPuntosDeDos6, LocalTirosLibres6, LocalTiroDeTres6));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(7).InsertarEstadisticasJugador(new Estadisticas(LocalPuntosDeDos7, LocalTirosLibres7, LocalTiroDeTres7));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(8).InsertarEstadisticasJugador(new Estadisticas(LocalPuntosDeDos8, LocalTirosLibres8, LocalTiroDeTres8));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(9).InsertarEstadisticasJugador(new Estadisticas(LocalPuntosDeDos9, LocalTirosLibres9, LocalTiroDeTres9));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(10).InsertarEstadisticasJugador(new Estadisticas(LocalPuntosDeDos10, LocalTirosLibres10, LocalTiroDeTres10));
				Liga.getInstances().getEquipos().get(i).getJugadores().get(11).InsertarEstadisticasJugador(new Estadisticas(LocalPuntosDeDos11, LocalTirosLibres11, LocalTiroDeTres11));
			}
		}
		
		Horario schedule = new Horario();
		Liga.getInstances().setPartido(schedule.tableCalendario.getSelectedRow(), schedule.tableModel.getValueAt(schedule.tableCalendario.getSelectedRow(), 0).toString(), schedule.tableModel.getValueAt(schedule.tableCalendario.getSelectedRow(), 3).toString(), schedule.tableModel.getValueAt(schedule.tableCalendario.getSelectedRow(), 2).toString(),Liga.getInstances().getEquipos().get(schedule.tableCalendario.getSelectedRow()).toString(), LocalPuntosDeDos, VisitPuntosDeDos, schedule.tableModel.getValueAt(schedule.tableCalendario.getSelectedRow(), 1).toString(), true);
	}
}
