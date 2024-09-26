package ejercicio2.frame;

import java.awt.Color;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5798757860036616983L;
	private JPanel contentPanel;
	private JTable table1;
	private JTable table2;
	private JTextField textFieldStart1;
	private JTextField textFieldStart2;
	private JTextField textFieldStart3;

	public void run() {
		try {
			Frame frame = new Frame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Frame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 535);
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(64, 128, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JButton buttonStart3 = new JButton("START");
		buttonStart3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonStart3.setBounds(437, 112, 89, 23);
		contentPanel.add(buttonStart3);

		JLabel lblPid = new JLabel("PID:");
		lblPid.setBounds(26, 193, 46, 14);
		contentPanel.add(lblPid);

		JLabel lblIdPadre = new JLabel("PID PADRE:");
		lblIdPadre.setBounds(26, 237, 83, 14);
		contentPanel.add(lblIdPadre);

		table1 = new JTable();
		table1.setBounds(150, 298, 195, 187);
		contentPanel.add(table1);

		table2 = new JTable();
		table2.setBounds(374, 298, 195, 187);
		contentPanel.add(table2);

		JLabel lblresultado = new JLabel("RESULTADO:");
		lblresultado.setBounds(26, 298, 83, 14);
		contentPanel.add(lblresultado);

		JLabel lblStart1 = new JLabel("");
		lblStart1.setBounds(106, 193, 89, 14);
		contentPanel.add(lblStart1);

		JLabel lblStart1_1 = new JLabel("");
		lblStart1_1.setBounds(106, 237, 89, 14);
		contentPanel.add(lblStart1_1);

		JLabel lblStart2 = new JLabel("");
		lblStart2.setBounds(276, 193, 89, 14);
		contentPanel.add(lblStart2);

		JLabel lblStart2_1 = new JLabel("");
		lblStart2_1.setBounds(276, 237, 89, 14);
		contentPanel.add(lblStart2_1);

		JLabel lblStart3 = new JLabel("");
		lblStart3.setBounds(437, 193, 89, 14);
		contentPanel.add(lblStart3);

		JLabel lblStart3_1 = new JLabel("");
		lblStart3_1.setBounds(437, 237, 89, 14);
		contentPanel.add(lblStart3_1);

		textFieldStart1 = new JTextField();
		textFieldStart1.setBounds(106, 71, 89, 20);
		contentPanel.add(textFieldStart1);
		textFieldStart1.setColumns(10);

		textFieldStart2 = new JTextField();
		textFieldStart2.setColumns(10);
		textFieldStart2.setBounds(276, 71, 89, 20);
		contentPanel.add(textFieldStart2);

		textFieldStart3 = new JTextField();
		textFieldStart3.setColumns(10);
		textFieldStart3.setBounds(437, 71, 89, 20);
		contentPanel.add(textFieldStart3);

		JButton buttonStart1 = new JButton("START");
		buttonStart1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldStart1.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Introduzca la aplicacion que quiera ejecutar");
				} else {
					String nombreProceso = textFieldStart1.getText();
					ProcessBuilder pb = new ProcessBuilder(nombreProceso);
					try {
						pb.start();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					ProcessHandle currentProcess = ProcessHandle.current();
					lblStart1.setText(String.valueOf(currentProcess));

					ProcessHandle parentProcess = currentProcess.parent().orElse(null);
					lblStart1_1.setText(String.valueOf(parentProcess));
				}
			}
		});
		buttonStart1.setBounds(106, 112, 89, 23);
		contentPanel.add(buttonStart1);
		
		JButton buttonStart2 = new JButton("START");
		buttonStart2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldStart2.getText().isEmpty();
				if (textFieldStart2.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Introduzca la comando que quiera ejecutar");
				} else {
					String nombreProceso2 = textFieldStart2.getText();
					ProcessBuilder pb2 = new ProcessBuilder("CMD", "/c" + nombreProceso2);
					try {
						pb2.start();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					ProcessHandle currentProcess2 = ProcessHandle.current();
					lblStart2.setText(String.valueOf(currentProcess2));

					ProcessHandle parentProcess2 = currentProcess2.parent().orElse(null);
					lblStart2_1.setText(String.valueOf(parentProcess2));
				}
			}
		});
		buttonStart2.setBounds(276, 112, 89, 23);
		contentPanel.add(buttonStart2);

		
	}
}
