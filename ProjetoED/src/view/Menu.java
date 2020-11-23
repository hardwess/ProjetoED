package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 391);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindoa = new JLabel("NOME DO USUÁRIO");
		lblBemVindoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindoa.setForeground(new Color(255, 160, 122));
		lblBemVindoa.setFont(new Font("Arial", Font.BOLD, 26));
		lblBemVindoa.setBounds(139, 11, 277, 59);
		contentPane.add(lblBemVindoa);
		
		JButton btnCurriculos = new JButton("CURR\u00CDCULOS");
		btnCurriculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Curriculos curriculo = new Curriculos();
				curriculo.setVisible(true);
			}
		});
		btnCurriculos.setBackground(new Color(255, 160, 122));
		btnCurriculos.setBounds(291, 68, 246, 45);
		contentPane.add(btnCurriculos);
		
		JButton btnEntrevistas = new JButton("ENTREVISTAS");
		btnEntrevistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Entrevistas entrevista = new Entrevistas();
				entrevista.setVisible(true);
			}
		});
		btnEntrevistas.setBackground(new Color(255, 160, 122));
		btnEntrevistas.setBounds(25, 140, 246, 45);
		contentPane.add(btnEntrevistas);
		
		JButton btnClassificados = new JButton("CLASSIFICADOS");
		btnClassificados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Classificados classificados = new Classificados();
				classificados.setVisible(true);
			}
		});
		btnClassificados.setBackground(new Color(255, 160, 122));
		btnClassificados.setBounds(291, 140, 246, 45);
		contentPane.add(btnClassificados);
		
		JButton btnCronograma = new JButton("CRONOGRAMA DE ENTREVISTAS");
		btnCronograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCronograma.setBackground(new Color(255, 160, 122));
		btnCronograma.setBounds(25, 207, 512, 45);
		contentPane.add(btnCronograma);
		
		JButton btnInscricoes = new JButton("INSCRI\u00C7\u00D5ES");
		btnInscricoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscricoes inscricoes = new Inscricoes();
				inscricoes.setVisible(true);
			}
		});
		btnInscricoes.setBackground(new Color(255, 160, 122));
		btnInscricoes.setBounds(25, 68, 246, 45);
		contentPane.add(btnInscricoes);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login Login = new Login();
				Login.setVisible(true);
			}
		});
		
		btnSair.setBackground(new Color(255, 160, 122));
		btnSair.setBounds(25, 275, 512, 45);
		contentPane.add(btnSair);
	}

}
