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
import controller.MergeSort;
import controller.dataStructure.list.Lista;
import model.Candidato;
import model.DadosGerais;
import model.Inscricao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Classificados extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Lista<Inscricao> lista = new Lista<Inscricao>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classificados frame = new Classificados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Classificados() {
		this.setExtendedState(MAXIMIZED_BOTH);
		setTitle("Classificados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 687, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 235, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblListaDeInscricoes = new JLabel("Lista de Classificados");
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
	}
	
	private void organizaJTable() {
		DefaultTableModel modelo = new DefaultTableModel();
		
		MergeSort dadosMergeSort = new MergeSort();
		
		DadosGerais[] lista = dadosMergeSort.getListaGeral();
		
		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("RG");
		modelo.addColumn("Deficiencia");
		modelo.addColumn("E-mail");
		modelo.addColumn("Genero");
		modelo.addColumn("Idade");
		modelo.addColumn("Data Entrevista");
		modelo.addColumn("Status Entrevista");
		modelo.addColumn("Status Currículo");
		modelo.addColumn("Semestre/Ano");
		modelo.addColumn("Curso");
		modelo.addColumn("Status Curriculo");
		modelo.addColumn("Status Inscrição");
		modelo.addColumn("Turno");
		
		if (lista.length == 0) {
			modelo.addRow(new String[] {"Sem informações", "Sem informações"});
		} else {
			for (int i = 0; i < lista.length; i++) {
				modelo.addRow(new String[] {
						lista[i].getNome(),
						lista[i].getCpf(),
						lista[i].getRg(),
						lista[i].getDeficiencia(),
						lista[i].getEmail(),
						lista[i].getGenero(),
						String.valueOf(lista[i].getIdade()),
						lista[i].getDataEntrevista(),
						lista[i].getStatusEntrevista(),
						lista[i].getStatusCurriculo(),
						lista[i].getSemestreAno(),
						lista[i].getCurso(),
						lista[i].getStatusCurriculo(),
						lista[i].getStatusInscricao(),
						lista[i].getTurno()
				});
			}
		}
		
		table.setModel(modelo);
	}
}
