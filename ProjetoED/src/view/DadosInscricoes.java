package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.InscricaoController;
import controller.dataStructure.list.Lista;
import model.Inscricao;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class DadosInscricoes extends JFrame {

	private JPanel contentPane;
	private Lista<Inscricao> lista;

	/**
	 * Launch the application.
	 */
	public static void ChamaDados(Object id, Object cpf, Object rg, Object deficiencia, Object curso, Object nome, Object semestreAno,
			Object entrevista, Object statusCurriculo, Object statusInscricao) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DadosInscricoes frame = new DadosInscricoes(id, cpf, rg, deficiencia, curso, nome, semestreAno, entrevista,
							statusCurriculo, statusInscricao);
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
	public DadosInscricoes(Object id, Object cpf, Object rg, Object deficiencia, Object curso, Object nome, Object semestreAno,
			Object entrevista, Object statusCurriculo, Object statusInscricao) {
		setTitle("Dados inscrição do candidato " + id.toString());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCandidato = new JLabel("Candidato " + id.toString());
		lblCandidato.setForeground(new Color(255, 160, 122));
		lblCandidato.setFont(new Font("Arial", Font.BOLD, 26));
		lblCandidato.setBounds(248, 11, 221, 59);
		contentPane.add(lblCandidato);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 109, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblNomeData = new JLabel(nome.toString());
		lblNomeData.setBounds(66, 109, 221, 14);
		contentPane.add(lblNomeData);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(307, 145, 46, 14);
		contentPane.add(lblCpf);
		
		JLabel lblCpfData = new JLabel(cpf.toString());
		lblCpfData.setBounds(359, 145, 221, 14);
		contentPane.add(lblCpfData);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(10, 145, 46, 14);
		contentPane.add(lblRg);
		
		JLabel lblRgData = new JLabel(rg.toString());
		lblRgData.setBounds(66, 145, 221, 14);
		contentPane.add(lblRgData);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(307, 109, 46, 14);
		contentPane.add(lblCurso);
		
		JLabel lblCursoData = new JLabel(curso.toString());
		lblCursoData.setBounds(369, 109, 317, 14);
		contentPane.add(lblCursoData);
		
		JLabel lblPossuiDeficincia = new JLabel("Possui defici\u00EAncia:");
		lblPossuiDeficincia.setBounds(10, 182, 110, 14);
		contentPane.add(lblPossuiDeficincia);
		
		JLabel lblDeficienciaData = new JLabel(deficiencia.toString());
		lblDeficienciaData.setBounds(130, 182, 93, 14);
		contentPane.add(lblDeficienciaData);
		
		JButton btnReprovar = new JButton("Reprovar");
		btnReprovar.setBounds(492, 334, 89, 23);
		contentPane.add(btnReprovar);
		
		JButton btnAprovar = new JButton("Aprovar");
		btnAprovar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inscricao data = new Inscricao(Long.parseLong(id.toString()), curso.toString(), semestreAno.toString(), null,
						Boolean.valueOf(statusCurriculo.toString()), Boolean.valueOf(statusInscricao.toString()));
				InscricaoController insc = new InscricaoController();
				insc.getListaInscricao();
				System.out.println(insc.contem(data) + " " + data.toString());
				System.out.println(insc.getListaInscricao());
			}
		});
		btnAprovar.setBounds(597, 334, 89, 23);
		contentPane.add(btnAprovar);
	}
}
