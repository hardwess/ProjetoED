package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.CandidatoController;
import controller.CurriculoController;
import controller.InscricaoController;
import model.Candidato;
import model.Curriculo;
import model.Inscricao;

public class Curriculos extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Curriculos frame = new Curriculos();
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
	public Curriculos() {	
		this.setExtendedState(MAXIMIZED_BOTH);
		setTitle("Curr\u00EDculos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 687, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblListaDeCurrculos = new JLabel("Lista de curr\u00EDculos pendentes de avalia\u00E7\u00E3o");
		lblListaDeCurrculos.setFont(new Font("Arial", Font.PLAIN, 18));
		lblListaDeCurrculos.setForeground(new Color(255, 160, 122));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblListaDeCurrculos, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblListaDeCurrculos, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		criaJTable();
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	private void criaJTable() {
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		organizaJTable();
		selecionaCurriculo();
	}
	
	private void selecionaCurriculo() {
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override public void valueChanged(ListSelectionEvent evt) {
				if (evt.getValueIsAdjusting())
					return; int row = table.getSelectedRow();
					int column = table.getSelectedColumn();
					Object id = table.getModel().getValueAt(row, 0);
					Object nome = table.getModel().getValueAt(row, 1);
					Object cpf = table.getModel().getValueAt(row, 2);
					Object rg = table.getModel().getValueAt(row, 3);
					Object genero = table.getModel().getValueAt(row, 4);
					Object idade = table.getModel().getValueAt(row, 5);
					Object statusCurriculo = table.getModel().getValueAt(row, 6);
					Object statusInscricao = table.getModel().getValueAt(row, 7);
					Object deficiencia = table.getModel().getValueAt(row, 8);
					Object email = table.getModel().getValueAt(row, 9);
					if (statusCurriculo == "Pendente") {
						DadosCurriculo frameDadosCurriculo = new DadosCurriculo(id, cpf, rg, deficiencia, nome, genero, idade,
								statusCurriculo, statusInscricao, email, row);
						frameDadosCurriculo.ChamaDados(id, cpf, rg, deficiencia, nome, genero, idade,
								statusCurriculo, statusInscricao, email, row);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Esse currículo já foi avaliado. Tente outro.");
					}
				}
			}
		);
	}
	
	
	private void organizaJTable() {
		Candidato candidato;
		Inscricao dados;
		Curriculo curriculo;
		DefaultTableModel modelo = new DefaultTableModel();
		CandidatoController candidatoController = new CandidatoController();
		InscricaoController inscricaoController = new InscricaoController();
		CurriculoController curriculoController = new CurriculoController();
		
		candidatoController.getListaCandidato();
		inscricaoController.getListaInscricao();
		curriculoController.getListaCurriculo();
		
		modelo.addColumn("Id do candidato");
		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("RG");
		modelo.addColumn("Gênero");
		modelo.addColumn("Idade");
		modelo.addColumn("Status Currículo");
		modelo.addColumn("Status Inscrição");
		modelo.addColumn("Deficiência");
		modelo.addColumn("E-mail");
		if (inscricaoController.estaVazia()) {
			modelo.addRow(new String[] {"Sem informações", "Sem informações"});
		} else {
			for (int i = 0; i < inscricaoController.retornaTamanho(); i++) {
				candidato = candidatoController.recuperar(i);
				dados = inscricaoController.recuperar(i);
				curriculo = curriculoController.recuperar(i);
				if (dados.getStatusInscricao().toString() == "Aprovado") {
					modelo.addRow(new String[] {
							candidato.getIdCandidato().toString(),
							candidato.getNome(),
							candidato.getCpf(),
							candidato.getRg(),
							curriculo.getGenero(),
							curriculo.getIdade().toString(),
							dados.getStatusCurriculo().toString(),
							dados.getStatusInscricao().toString(),
							candidato.getDeficiencia(),
							candidato.getEmail()
							//Mostrar documentos
					});
				}
			}
		}
		
		table.setModel(modelo);
	}
}
