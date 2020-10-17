package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import controller.InscricaoController;
import controller.dataStructure.list.Lista;
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
		setTitle("Inscrições");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	
	private void criaJTable() {
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		organizaJTable();
		selecionaInscricao();
	}
	
	private void selecionaInscricao() {
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override public void valueChanged(ListSelectionEvent evt) {
				if (evt.getValueIsAdjusting())
					return; int row = table.getSelectedRow();
					int column = table.getSelectedColumn();
					Object selected = table.getModel().getValueAt(row, column);
					DadosInscricoes frameDadosInscricoes = new DadosInscricoes(selected);
					frameDadosInscricoes.Teste(selected);
				}
			}
		);
	}
	
	private void organizaJTable() {
		Inscricao dados;
		DefaultTableModel modelo = new DefaultTableModel();
		InscricaoController inscricaoController = new InscricaoController();
		
		inscricaoController.getListaInscricao();
		
		modelo.addColumn("Id");
		modelo.addColumn("Entrevista");
		modelo.addColumn("Currículo");
		modelo.addColumn("Cronograma");
		if (inscricaoController.estaVazia()) {
			modelo.addRow(new String[] {"Sem informações", "Sem informações"});
		} else {
			for (int i = 0; i < inscricaoController.retornaTamanho(); i++) {
				dados = inscricaoController.recuperar(i);
				modelo.addRow(new String[] {
						dados.getId().toString(),
						dados.getId().toString(),
						dados.getStatusCurriculo().toString(),
						dados.getIdCronograma().toString()
				});
			}
		}
		
		table.setModel(modelo);
	}
}
