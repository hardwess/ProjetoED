package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.CandidatoController;
import controller.CurriculoController;
import controller.EntrevistaController;
import controller.InscricaoController;
import model.Candidato;
import model.Curriculo;
import model.Entrevista;
import model.Inscricao;

public class Entrevistas extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrevistas frame = new Entrevistas();
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
	public Entrevistas() {
		this.setExtendedState(MAXIMIZED_BOTH);
		setTitle("Entrevistas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 687, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblListaDeEntrevistas = new JLabel("Lista de entrevistas pendentes");
		lblListaDeEntrevistas.setFont(new Font("Arial", Font.PLAIN, 18));
		lblListaDeEntrevistas.setForeground(new Color(255, 160, 122));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblListaDeEntrevistas, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblListaDeEntrevistas, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
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
		selecionaEntrevista();
	}
	
	private void organizaJTable() {
		Candidato candidato;
		Inscricao dados;
		Curriculo curriculo;
		Entrevista entrevista;
		DefaultTableModel modelo = new DefaultTableModel();
		CandidatoController candidatoController = new CandidatoController();
		InscricaoController inscricaoController = new InscricaoController();
		CurriculoController curriculoController = new CurriculoController();
		EntrevistaController entrevistaController = new EntrevistaController();
		
		candidatoController.getListaCandidato();
		inscricaoController.getListaInscricao();
		curriculoController.getListaCurriculo();
		entrevistaController.getListaEntrevista();
		
		modelo.addColumn("Id do candidato");
		modelo.addColumn("Nome");
		modelo.addColumn("Curso");
		modelo.addColumn("Turno");
		modelo.addColumn("Semestre");
		modelo.addColumn("Deficiência");
		modelo.addColumn("Data entrevista");
		modelo.addColumn("Status entrevista");
		if (entrevistaController.estaVazia()) {
			JOptionPane.showMessageDialog(null, "Sem entrevistas marcadas");
		} else {
			for (int i = 0; i < entrevistaController.retornaTamanho(); i++) {
				entrevista = entrevistaController.recuperar(i);
				int pos = inscricaoController.contem(Long.parseLong(entrevista.getId().toString()), Integer.parseInt(entrevista.getId().toString()));
				if (pos > 0) {
					dados = inscricaoController.recuperar(pos-1);
					candidato = candidatoController.recuperar(pos-1);
					modelo.addRow(new String[] {
							candidato.getIdCandidato().toString(),
							candidato.getNome(),
							dados.getCurso(),
							dados.getTurno(),
							dados.getSemestreAno(),
							candidato.getDeficiencia(),
							entrevista.getDataEntrevista(),
							entrevista.getStatusEntrevista()
					});
				}
			}
		}
		
		table.setModel(modelo);
	}
	
	private void selecionaEntrevista() {
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override public void valueChanged(ListSelectionEvent evt) {
				if (evt.getValueIsAdjusting())
					return; int row = table.getSelectedRow();
					int column = table.getSelectedColumn();
					Object id = table.getModel().getValueAt(row, 0);
					Object nome = table.getModel().getValueAt(row, 1);
					Object curso = table.getModel().getValueAt(row, 2);
					Object turno = table.getModel().getValueAt(row, 3);
					Object semestreAno = table.getModel().getValueAt(row, 4);
					Object deficiencia = table.getModel().getValueAt(row, 5);
					Object dataEntrevista = table.getModel().getValueAt(row, 6);
					Object statusEntrevista = table.getModel().getValueAt(row, 7);
					if (statusEntrevista == "Pendente") {
						DadosEntrevistas frameDadosEntrevistas = new DadosEntrevistas(id, nome, curso, turno, semestreAno, deficiencia,
								dataEntrevista, statusEntrevista, row);
						frameDadosEntrevistas.ChamaDados(id, nome, curso, turno, semestreAno, deficiencia,
								dataEntrevista, statusEntrevista, row);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Essa entrevista já foi realizada!");
					}
				}
			}
		);
	}
}
