package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EntrevistaController;
import controller.InscricaoController;
import controller.dataStructure.list.Lista;
import model.Entrevista;
import model.Inscricao;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class DadosEntrevistas extends JFrame {

	private JPanel contentPane;
	private Lista<Entrevista> lista;

	/**
	 * Launch the application.
	 */
	public static void ChamaDados(Object id, Object nome, Object curso, Object turno, Object semestreAno, Object deficiencia, Object dataEntrevista,
			Object statusEntrevista, Object row) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DadosEntrevistas frame = new DadosEntrevistas(id, nome, curso, turno, semestreAno, deficiencia, dataEntrevista,
							statusEntrevista, row);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DadosEntrevistas() {}

	/**
	 * Create the frame.
	 */
	public DadosEntrevistas(Object id, Object nome, Object curso, Object turno, Object semestreAno, Object deficiencia, Object dataEntrevista,
			Object statusEntrevista, Object row) {
		setTitle("Dados entrevista do candidato " + id.toString());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCandidato = new JLabel("Entrevista Candidato " + id.toString());
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
				EntrevistaController entrevistaController = new EntrevistaController();
				entrevistaController.getListaEntrevista();
				int pos = entrevistaController.contem(Long.parseLong(id.toString()), Integer.parseInt(row.toString()));
				if (pos > 0) {
					Entrevista novoValor = new Entrevista(Long.parseLong(id.toString()),
							dataEntrevista.toString(),
							0);
					entrevistaController.substituir(pos-1, novoValor);
				}
				entrevistaController.saveListCandidato(entrevistaController.montaTxt());
				dispose();
				Entrevistas view = new Entrevistas();
				view.dispose();
				view.setVisible(true);
			}
		});
		btnReprovar.setBounds(492, 334, 89, 23);
		contentPane.add(btnReprovar);
		
		JButton btnAprovar = new JButton("Aprovar");
		btnAprovar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EntrevistaController entrevistaController = new EntrevistaController();
				entrevistaController.getListaEntrevista();
				int pos = entrevistaController.contem(Long.parseLong(id.toString()), Integer.parseInt(id.toString()));
				if (pos > 0) {
					Entrevista novoValor = new Entrevista(Long.parseLong(id.toString()),
							dataEntrevista.toString(),
							1);
					entrevistaController.substituir(pos-1, novoValor);
				}
				entrevistaController.saveListCandidato(entrevistaController.montaTxt());
				dispose();
				Entrevistas view = new Entrevistas();
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
}
