package view;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class DadosCurriculo extends JFrame {

	private JPanel contentPane;
	private Lista<Inscricao> lista;

	/**
	 * Launch the application.
	 */
	public static void ChamaDados(Object id, Object cpf, Object rg, Object deficiencia, Object nome, Object genero,
			Object idade, Object statusCurriculo, Object statusInscricao, Object email, Object row) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DadosCurriculo frame = new DadosCurriculo(id, cpf, rg, deficiencia, nome, genero, idade,
							statusCurriculo, statusInscricao, email, row);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DadosCurriculo() {}

	/**
	 * Create the frame.
	 */
	public DadosCurriculo(Object id, Object cpf, Object rg, Object deficiencia, Object nome, Object genero,
			Object idade, Object statusCurriculo, Object statusInscricao, Object email, Object row) {
		setTitle("Dados do candidato " + id.toString());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 712, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCandidato = new JLabel("Currículo Candidato " + id.toString());
		lblCandidato.setForeground(new Color(255, 160, 122));
		lblCandidato.setFont(new Font("Arial", Font.BOLD, 26));
		lblCandidato.setBounds(171, 11, 417, 59);
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
		
		JButton btnReprovar = new JButton("Reprovar");
		btnReprovar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InscricaoController insc = new InscricaoController();
				insc.getListaInscricao();
				int pos = insc.contem(Long.parseLong(id.toString()), Integer.parseInt(id.toString()));
				if (pos > 0) {
					Inscricao dado = insc.recuperar(pos-1);
					Inscricao novoValor = new Inscricao(Long.parseLong(id.toString()),
								dado.getCurso(), dado.getSemestreAno(),
								null, 0,
								returnStatusInscricao(statusInscricao.toString()), dado.getTurno());
					insc.substituir(pos-1, novoValor);
				}
				insc.saveListInscricao(insc.montaTxt());
				dispose();
				Curriculos view = new Curriculos();
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
					Inscricao dado = insc.recuperar(pos-1);
					Inscricao novoValor = new Inscricao(Long.parseLong(id.toString()),
								dado.getCurso(), dado.getSemestreAno(),
								null, 1,
								returnStatusInscricao(statusInscricao.toString()), dado.getTurno());
					insc.substituir(pos-1, novoValor);
					informaData(novoValor);
				}
				insc.saveListInscricao(insc.montaTxt());
				dispose();
				Curriculos view = new Curriculos();
				view.dispose();
				view.setVisible(true);
			}
		});
		btnAprovar.setBounds(597, 334, 89, 23);
		contentPane.add(btnAprovar);
		
		JLabel lblStatusInscrio = DefaultComponentFactory.getInstance().createLabel("Status Inscri\u00E7\u00E3o:");
		lblStatusInscrio.setBounds(307, 109, 114, 14);
		contentPane.add(lblStatusInscrio);
		
		JLabel lblStatusInscrioData = new JLabel(statusInscricao.toString());
		lblStatusInscrioData.setBounds(431, 109, 92, 14);
		contentPane.add(lblStatusInscrioData);
		
		JLabel lblEmail = DefaultComponentFactory.getInstance().createLabel("E-mail:");
		lblEmail.setBounds(10, 186, 92, 14);
		contentPane.add(lblEmail);
		
		JLabel lblEmailData = new JLabel(email.toString());
		lblEmailData.setBounds(66, 186, 355, 14);
		contentPane.add(lblEmailData);
	}
	
	public int returnStatusInscricao(String status) {
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
	
	private void informaData(Inscricao dadosInscricao) {
		String data = JOptionPane.showInputDialog("Informe um dia para a realização da entrevista (dd/MM/yyyy):");
		inserirEntrevista(dadosInscricao, data);
	}
	
	private void inserirEntrevista(Inscricao dadosInscricao, String data) {
		Entrevista entrevista = new Entrevista(dadosInscricao.getIdCandidato(), data, 2);
		EntrevistaController entrevistaController = new EntrevistaController();
		entrevistaController.inserirEntrevista(entrevista);
		entrevistaController.saveListCandidato(entrevistaController.montaTxt());
	}
}
