package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import controller.CandidatoController;
import controller.InscricaoController;
import controller.dataStructure.list.Lista;
import model.Candidato;
import model.Inscricao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Inscricoes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Lista<Inscricao> lista = new Lista<Inscricao>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscricoes frame = new Inscricoes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inscricoes() {
		this.setExtendedState(MAXIMIZED_BOTH);
		setTitle("Inscrições");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 687, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblListaDeInscricoes = new JLabel("Lista de inscrições pendentes de avalia\u00E7\u00E3o");
		lblListaDeInscricoes.setFont(new Font("Arial", Font.PLAIN, 18));
		lblListaDeInscricoes.setForeground(new Color(255, 160, 122));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(lblListaDeInscricoes, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(lblListaDeInscricoes)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
					.addContainerGap())
		);
				
		criaJTable();
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void criaJTable() {
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		organizaJTable();
		selecionaInscricao();
	}
	
	private void selecionaInscricao() {
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override public void valueChanged(ListSelectionEvent evt) {
				if (evt.getValueIsAdjusting())
					return; int row = table.getSelectedRow();
					int column = table.getSelectedColumn();
					Object id = table.getModel().getValueAt(row, 0);
					Object nome = table.getModel().getValueAt(row, 1);
					Object cpf = table.getModel().getValueAt(row, 2);
					Object rg = table.getModel().getValueAt(row, 3);
					Object semestreAno = table.getModel().getValueAt(row, 4);
					Object curso = table.getModel().getValueAt(row, 5);
					Object turno = table.getModel().getValueAt(row, 6);
					Object entrevista = table.getModel().getValueAt(row, 7);
					Object statusCurriculo = table.getModel().getValueAt(row, 8);
					Object statusInscricao = table.getModel().getValueAt(row, 9);
					Object deficiencia = table.getModel().getValueAt(row, 10);
					if (statusInscricao == "Pendente") {
						DadosInscricoes frameDadosInscricoes = new DadosInscricoes(id, cpf, rg, deficiencia, curso, nome, semestreAno, entrevista,
								statusCurriculo, statusInscricao, turno, row);
						frameDadosInscricoes.ChamaDados(id, cpf, rg, deficiencia, curso, nome, semestreAno, entrevista,
								statusCurriculo, statusInscricao, turno, row);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Essa inscrição já foi avaliada. Tente outra.");
					}
				}
			}
		);
	}
	
	private void organizaJTable() {
		Candidato candidato;
		Inscricao dados;
		DefaultTableModel modelo = new DefaultTableModel();
		CandidatoController candidatoController = new CandidatoController();
		InscricaoController inscricaoController = new InscricaoController();
		
		candidatoController.getListaCandidato();
		inscricaoController.getListaInscricao();
		
		modelo.addColumn("Id do candidato");
		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("RG");
		modelo.addColumn("Semestre/Ano");
		modelo.addColumn("Curso");
		modelo.addColumn("Turno");
		modelo.addColumn("Entrevista");
		modelo.addColumn("Status Currículo");
		modelo.addColumn("Status Inscrição");
		modelo.addColumn("Deficiência");
		if (inscricaoController.estaVazia()) {
			modelo.addRow(new String[] {"Sem informações", "Sem informações"});
		} else {
			for (int i = 0; i < inscricaoController.retornaTamanho(); i++) {
				candidato = candidatoController.recuperar(i);
				dados = inscricaoController.recuperar(i);
				if(!"Aprovado".equals(dados.getStatusInscricao())) {
					modelo.addRow(new String[] {
							candidato.getIdCandidato().toString(),
							candidato.getNome(),
							candidato.getCpf(),
							candidato.getRg(),
							dados.getSemestreAno(),
							dados.getCurso(),
							dados.getTurno(),
							null,
							dados.getStatusCurriculo(),
							dados.getStatusInscricao(),
							candidato.getDeficiencia(),
					});
				}
			}
		}
		
		table.setModel(modelo);
	}
}
