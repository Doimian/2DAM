import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

import java.awt.BorderLayout;

public class MainWindow extends JFrame
{
	//Items
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JTextField txtDomicilio;
	private JSpinner spinnerAnioNacimiento;
	private JComboBox comboEstadoCivil;
	private JSlider sliderNumeroHijos;
	private JComboBox comboSituacionLaboral;
	private JTextArea txtAreaObservaciones;
	private JButton btnAceptar;
	private JButton btnLimpiar;
	private JLabel lblTextoName;
	
	//Paneles
	private JPanel panelIzq;
	private JPanel panelDer;
	private JPanel panelInf;
	private JPanel panelCen;
	
	// Clase para escritura en fichero
	private Data data;
	
	// Constructor
	public MainWindow()
	{
		this.setTitle("Actividad 1.10");
		this.setSize(600,270);
		
		//Crea el objero data
		data = new Data(this);
		
		// Layout del JFrame
		this.getContentPane().setLayout(new BorderLayout());
		
		// Crea paneles
		createPanelSup();
		createPanelIzq();
		createPanelCentral();
		createPanelDer();
		createPanelInf();
	}
	
	private void createPanelSup()
	{
		lblTextoName = new JLabel("Datos Personales");
		this.getContentPane().add(lblTextoName, BorderLayout.NORTH);
	}
	
	private void createPanelIzq()
	{
		txtNombre = new JTextField("Nombre",15);
		txtApellidos = new JTextField("Apellidos",15);
		txtDni = new JTextField("DNI",15);
		txtDomicilio = new JTextField("Domicilio",15);


		// Panel
		panelIzq = new JPanel();
		panelIzq.setLayout(new BoxLayout(panelIzq,BoxLayout.Y_AXIS));
		
		// Añade al panel
		panelIzq.add(txtNombre);
		panelIzq.add(txtApellidos);
		panelIzq.add(txtDni);
		panelIzq.add(txtDomicilio);
		
	    // Añade al JFrame
		this.getContentPane().add(panelIzq, BorderLayout.WEST);	
	}
	
	private void createPanelCentral()
	{
		// Año nacimiento 2000-2022
		String valores[] = new String[23];
		for(int i = 0; i <= 22; i++)
			valores[i] = String.valueOf(2000 + i);
		SpinnerListModel modelo = new SpinnerListModel(valores);
		spinnerAnioNacimiento = new JSpinner(modelo);
		
		// Estado Civil
		String estados[] = {"Soltero/a","Casado/a","Separado/a","Divorciado/a","Viudo/a"};
		comboEstadoCivil = new JComboBox(estados);
		
		// Numero de hijos
		sliderNumeroHijos = new JSlider(JSlider.HORIZONTAL,0,10,0);
		sliderNumeroHijos.setMajorTickSpacing(10);
		sliderNumeroHijos.setMinorTickSpacing(1);
		sliderNumeroHijos.setPaintLabels(true);
		sliderNumeroHijos.setPaintTicks(true);
		
		// Situacion laboral
		String laborales[] = {"Empleado","Desempleado","Estudiante","ERTE","ERE"};
		comboSituacionLaboral = new JComboBox<String>(laborales);
		
		// Todo al panel central
		panelCen = new JPanel();
		panelCen.setLayout(new BoxLayout(panelCen,BoxLayout.Y_AXIS));
		panelCen.add(spinnerAnioNacimiento);
		panelCen.add(comboEstadoCivil);
		panelCen.add(sliderNumeroHijos);
		panelCen.add(comboSituacionLaboral);
		
		// Al JFrame
		this.getContentPane().add(panelCen, BorderLayout.CENTER);
	}
	//Panel derecho
	private void createPanelDer()
	{
		//Observaciones
		txtAreaObservaciones = new JTextArea("Observaciones",10,20);
		panelDer = new JPanel();
		panelDer.add(txtAreaObservaciones);
		this.getContentPane().add(panelDer,BorderLayout.EAST);
		
	}
	private void createPanelInf()
	{
		//Botones
		btnAceptar = new JButton("Aceptar");
		btnLimpiar = new JButton("Limpiar");
		panelInf = new JPanel();
		panelInf.add(btnAceptar);
		panelInf.add(btnLimpiar);
		this.getContentPane().add(panelInf, BorderLayout.SOUTH);
	}
	
	public void setVisible()
	{
		this.setVisible(true);
	}
}
