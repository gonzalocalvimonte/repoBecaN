package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Ronda;
import proyectoIntMaven.CalculadoraDePronosticos;

import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;

public class Interfaz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		//PANELES
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 2, 0, 15));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setColumns(50);
		textArea.setRows(10);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		//contentPane.add(textArea, BorderLayout.CENTER);
		//panel_1.add(textArea);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane);
		
		
		
		
		/*JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazCargaProno frameProno = new InterfazCargaProno();
				frameProno.setVisible(true);
			}
		});
		
		scrollPane.setRowHeaderView(btnNewButton);*/
		
		//LABELS
		JLabel lblNewLabel_1 = new JLabel("Puntos por acierto: "+Ronda.getPuntosXAcierto()); //Al principio son cero
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Puntos extra: "+Ronda.getPuntosExtra());
		panel.add(lblNewLabel_2);
		//BOTON
		JButton btnNewButton_1 = new JButton("Calcular");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ACA TENEMOS QUE LLAMAR AL METODO CALCULADORA CUANDO CLICKEAMOS EN CALCULAR
				CalculadoraDePronosticos calc = new CalculadoraDePronosticos("../repoBecaN/resultados.txt","../repoBecaN/pronosticos.txt");
				textArea.setText("Hice click en calcular!!!");
				calc.calculadora();//Podria devolver un String con los resultados de cada ROnda tipo "Ronda:1\n P1:puntos\tP2:puntos\t...Pn:puntos
				//Con el string devuelto puedo setear el texto del textArea.
				lblNewLabel_1.setText("Puntos por acierto: "+Ronda.getPuntosXAcierto());
				lblNewLabel_2.setText("Puntos extra: "+Ronda.getPuntosExtra());
				textArea.setText(calc.calculadora());
				
				
			}
		});
		contentPane.add(btnNewButton_1, BorderLayout.SOUTH);
		

	}

}
