package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.InscricaoController;
import controller.dataStructure.list.Lista;
import model.Inscricao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class DadosInscricoes extends JFrame {

	private JPanel contentPane;
	private Lista<Inscricao> lista;

	/**
	 * Launch the application.
	 */
	public static void ChamaDados(Object id, Object cpf, Object rg, Object deficiencia, Object curso, Object nome, Object semestreAno,
			Object entrevista, Object statusCurriculo, Object statusInscricao, Object turno, Object row) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DadosInscricoes frame = new DadosInscricoes(id, cpf, rg, deficiencia, curso, nome, semestreAno, entrevista,
							statusCurriculo, statusInscricao, turno, row);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DadosInscricoes() {}

	/**
	 * Create the frame.
	 */
	public DadosInscricoes(Object id, Object cpf, Object rg, Object deficiencia, Object curso, Object nome, Object semestreAno,
			Object entrevista, Object statusCurriculo, Object statusInscricao, Object turno, Object row) {
		setTitle("Dados inscrição do candidato " + id.toString());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCandidato = new JLabel("Inscrição Candidato " + id.toString());
		lblCandidato.setForeground(new Color(255, 160, 122));
		lblCandidato.setFont(new Font("Arial", Font.BOLD, 26));
		lblCandidato.setBounds(177, 11, 426, 59);
		contentPane.add(lblCandidato);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 109, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblNomeData = new JLabel(nome.toString());
		lblNomeData.setBounds(66, 109, 221, 14);
		contentPane.add(lblNomeData);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(10, 252, 46, 14);
		contentPane.add(lblCurso);
		
		JLabel lblCursoData = new JLabel(curso.toString());
		lblCursoData.setBounds(66, 252, 317, 14);
		contentPane.add(lblCursoData);
		
		JLabel lblPossuiDeficincia = new JLabel("Possui defici\u00EAncia:");
		lblPossuiDeficincia.setBounds(273, 81, 110, 14);
		contentPane.add(lblPossuiDeficincia);
		
		JLabel lblDeficienciaData = new JLabel(deficiencia.toString());
		lblDeficienciaData.setBounds(317, 155, 93, 14);
		contentPane.add(lblDeficienciaData);
		lblPossuiDeficincia.setBounds(10, 182, 110, 14);
		lblDeficienciaData.setBounds(130, 182, 93, 14);
		
		JButton btnReprovar = new JButton("Reprovar");
		btnReprovar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InscricaoController insc = new InscricaoController();
				insc.getListaInscricao();
				int pos = insc.contem(Long.parseLong(id.toString()), Integer.parseInt(row.toString()));
				if (pos > 0) {
					Inscricao novoValor = new Inscricao(Long.parseLong(id.toString()),
							curso.toString(), semestreAno.toString(),
							null, returnStatusCurriculo(statusCurriculo.toString()),
							0, turno.toString());
					insc.substituir(pos-1, novoValor);
				}
				insc.saveListInscricao(insc.montaTxt());
				dispose();
				Inscricoes view = new Inscricoes();
				view.dispose();
				view.setVisible(true);
			}
		});
		btnReprovar.setBounds(492, 334, 89, 23);
		contentPane.add(btnReprovar);
		
		JButton btnAprovar = new JButton("Aprovar");
		btnAprovar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InscricaoController insc = new InscricaoController();
				insc.getListaInscricao();
				int pos = insc.contem(Long.parseLong(id.toString()), Integer.parseInt(id.toString()));
				if (pos > 0) {
					Inscricao novoValor = new Inscricao(Long.parseLong(id.toString()),
							curso.toString(), semestreAno.toString(),
							null, returnStatusCurriculo(statusCurriculo.toString()),
							1, turno.toString());
					insc.substituir(pos-1, novoValor);
				}
				insc.saveListInscricao(insc.montaTxt());
				dispose();
				Inscricoes view = new Inscricoes();
				view.dispose();
				view.setVisible(true);
			}
		});
		btnAprovar.setBounds(597, 334, 89, 23);
		contentPane.add(btnAprovar);
		
		JLabel lblSemestreano = DefaultComponentFactory.getInstance().createLabel("Semestre/Ano:");
		lblSemestreano.setBounds(366, 109, 92, 14);
		contentPane.add(lblSemestreano);
		
		JLabel lblSemestreanoData = new JLabel(semestreAno.toString());
		lblSemestreanoData.setBounds(468, 109, 92, 14);
		contentPane.add(lblSemestreanoData);
		
		JLabel lblTurno = DefaultComponentFactory.getInstance().createLabel("Turno:");
		lblTurno.setBounds(366, 182, 92, 14);
		contentPane.add(lblTurno);
		
		JLabel lblTurnoData = new JLabel(turno.toString());
		lblTurnoData.setBounds(468, 182, 92, 14);
		contentPane.add(lblTurnoData);
	}
	
	public int returnStatusCurriculo(String status) {
		int newStatus = 0;
		if (status == "Pendente") {
			newStatus = 2;
		} else if (status == "Aprovado") {
			newStatus = 1;
		} else if (status == "Reprovado") {
			newStatus = 0;
		}
		
		return newStatus;
	}
}
