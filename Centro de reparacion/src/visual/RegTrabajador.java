package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegTrabajador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtSalarioDiario;
	private JTextField txtAntiguedad;
	private JTextField txtIncrementoSalario;
	private JSpinner spnDiasTrabaj;
	private JRadioButton rdbtnRiesgo;
	private JRadioButton rdbtnImprescindible;	
	private JSpinner spnIndice;
	private JPanel panelImprescin;
	private JPanel deRiesgoPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegTrabajador dialog = new RegTrabajador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegTrabajador() {
		setBounds(100, 100, 545, 481);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Datos Trabajador", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(27, 29, 46, 14);
		contentPanel.add(lblNombre);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(340, 29, 46, 14);
		contentPanel.add(lblCedula);
		
		JLabel lblSalarioDiario = new JLabel("Salario Diario");
		lblSalarioDiario.setBounds(27, 115, 81, 14);
		contentPanel.add(lblSalarioDiario);
		
		JLabel lblAntiguedad = new JLabel("Antiguedad");
		lblAntiguedad.setBounds(340, 115, 72, 14);
		contentPanel.add(lblAntiguedad);
		
		JLabel lblDiasTrabajados = new JLabel("Dias Trabajados");
		lblDiasTrabajados.setBounds(27, 207, 81, 14);
		contentPanel.add(lblDiasTrabajados);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(22, 43, 158, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(337, 43, 158, 20);
		contentPanel.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtSalarioDiario = new JTextField();
		txtSalarioDiario.setBounds(22, 129, 158, 20);
		contentPanel.add(txtSalarioDiario);
		txtSalarioDiario.setColumns(10);
		
		txtAntiguedad = new JTextField();
		txtAntiguedad.setBounds(340, 129, 155, 20);
		contentPanel.add(txtAntiguedad);
		txtAntiguedad.setColumns(10);
		
		spnDiasTrabaj = new JSpinner();
		spnDiasTrabaj.setModel(new SpinnerNumberModel(0, 0, 365, 1));
		spnDiasTrabaj.setBounds(27, 221, 153, 20);
		contentPanel.add(spnDiasTrabaj);
		
		rdbtnRiesgo = new JRadioButton("Riesgo");
		rdbtnRiesgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnRiesgo.isSelected()){
					rdbtnImprescindible.setSelected(false);
					deRiesgoPanel.setVisible(true);
					panelImprescin.setVisible(false);
				}
			}
		});
		rdbtnRiesgo.setBounds(340, 220, 109, 23);
		contentPanel.add(rdbtnRiesgo);
		
		rdbtnImprescindible = new JRadioButton("Imprescindible");
		rdbtnImprescindible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnImprescindible.isSelected()){
					rdbtnRiesgo.setSelected(false);
					deRiesgoPanel.setVisible(false);
					panelImprescin.setVisible(true);
				}
			}
		});
		rdbtnImprescindible.setBounds(340, 194, 109, 23);
		contentPanel.add(rdbtnImprescindible);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 275, 507, 2);
		contentPanel.add(separator);
		
		deRiesgoPanel = new JPanel();
		deRiesgoPanel.setBorder(new TitledBorder(null, "Trabajador de Riesgo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		deRiesgoPanel.setBounds(10, 288, 507, 110);
		contentPanel.add(deRiesgoPanel);
		deRiesgoPanel.setLayout(null);
		
		JLabel lblIndice = new JLabel("Indice");
		lblIndice.setBounds(10, 37, 46, 14);
		deRiesgoPanel.add(lblIndice);
		
		spnIndice = new JSpinner();
		spnIndice.setModel(new SpinnerNumberModel(0, 0, 5, 1));
		spnIndice.setBounds(10, 58, 105, 20);
		deRiesgoPanel.add(spnIndice);
		
		JLabel lblTipoDeTrabajador = new JLabel("Tipo de Trabajador");
		lblTipoDeTrabajador.setBounds(340, 173, 96, 14);
		contentPanel.add(lblTipoDeTrabajador);
		
		panelImprescin = new JPanel();
		panelImprescin.setBounds(10, 288, 507, 110);
		contentPanel.add(panelImprescin);
		panelImprescin.setBorder(new TitledBorder(null, "Trabajador Imprescindible", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelImprescin.setLayout(null);
		
		JLabel lblIncrementoDeSalario = new JLabel("Incremento de Salario");
		lblIncrementoDeSalario.setBounds(10, 34, 123, 14);
		panelImprescin.add(lblIncrementoDeSalario);
		
		txtIncrementoSalario = new JTextField();
		txtIncrementoSalario.setBounds(10, 58, 123, 20);
		panelImprescin.add(txtIncrementoSalario);
		txtIncrementoSalario.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nombre= txtNombre.getText();
						String cedula = txtCedula.getText();
						Double salarioDiario=new Double(txtSalarioDiario.getText());
						int antiguedad = Integer.valueOf(txtAntiguedad.getText());
						int cantDiasTrabajados= new Integer(spnDiasTrabaj.getValue().toString());
						if(rdbtnRiesgo.isSelected()){
							
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
