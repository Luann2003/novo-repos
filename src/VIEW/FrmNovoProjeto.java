package VIEW;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DAO.ProjetosDAO;
import DTO.TabelaDTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class FrmNovoProjeto extends JFrame {
	
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField textRe1;
    private JTextField textRe2;
    private JTextField textRe3;
    private JTextField textTop1;
    private JTextField textTop2;
    private JTextField textTop3;
    private JTextField textRe4;
    private JTextField textTop4;
    private JTable table_1;
    

    public FrmNovoProjeto() throws SQLException {
    	
    	
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1756, 521);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"RE", "TOP", "SOD", "IMP", "ARQ-B", "PL",	"VIG",	"PPCI",	"EST",	"DRE",	"HID",	"ELE",	"COM",	"MET",	"CLI",	"GMD",	"MD",	"IMG",	"ORÇ"}
        );

        table = new JTable(tableModel);
        table.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(101, 5, 1629, 29);
        
        JPanel panelBotoes = new JPanel();
        panelBotoes.setBounds(5, 454, 1130, 23);
        panelBotoes.setLayout(new GridLayout(1, 2, 10, 0));
        contentPane.setLayout(null);
        contentPane.add(scrollPane);
        contentPane.add(panelBotoes);
        
        textRe1 = new JTextField();
        textRe1.setBounds(101, 33, 86, 29);
        contentPane.add(textRe1);
        textRe1.setColumns(10);
        
        textRe2 = new JTextField();
        textRe2.setColumns(10);
        textRe2.setBounds(101, 61, 86, 29);
        contentPane.add(textRe2);
        
        textRe3 = new JTextField();
        textRe3.setColumns(10);
        textRe3.setBounds(101, 89, 86, 29);
        contentPane.add(textRe3);
        
        textTop1 = new JTextField();
        textTop1.setColumns(10);
        textTop1.setBounds(185, 33, 86, 29);
        contentPane.add(textTop1);
        
        textTop2 = new JTextField();
        textTop2.setColumns(10);
        textTop2.setBounds(185, 61, 86, 29);
        contentPane.add(textTop2);
        
        textTop3 = new JTextField();
        textTop3.setColumns(10);
        textTop3.setBounds(185, 89, 86, 29);
        contentPane.add(textTop3);
        
        JButton btnatualizar = new JButton("atualizar");
        btnatualizar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		try {
					atualizar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
       
        btnatualizar.setBounds(12, 210, 89, 23);
        contentPane.add(btnatualizar);
        
        textRe4 = new JTextField();
        textRe4.setColumns(10);
        textRe4.setBounds(101, 117, 86, 29);
        contentPane.add(textRe4);
        
        textTop4 = new JTextField();
        textTop4.setColumns(10);
        textTop4.setBounds(185, 117, 86, 29);
        contentPane.add(textTop4);
        
        JScrollPane scrollPane_1 = new JScrollPane((Component) null);
        scrollPane_1.setBounds(10, 5, 91, 145);
        contentPane.add(scrollPane_1);
        
        table_1 = new JTable();
        table_1.setRowHeight(30);

        table_1.setRowSelectionAllowed(false);
        table_1.setModel(new DefaultTableModel(
        	new Object[][] {
        		{"Respons\u00E1vel"},
        		{"Status"},
        		{"Prazo"},
        		{"Entrega"},
        	},
        	new String[] {
        		"Fase"
        	}
        ) {
        	boolean[] columnEditables = new boolean[] {
        		false
        	};
        	public boolean isCellEditable(int row, int column) {
        		return columnEditables[column];
        	}
        });
        table_1.getColumnModel().getColumn(0).setResizable(false);
        scrollPane_1.setViewportView(table_1);
        
        carregarDados();
    }
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmNovoProjeto frame = new FrmNovoProjeto();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public void atualizar() throws SQLException {
    	
    	String respo, status, preparo, entrega;
    	for(int i = 0; i<1; i++) {
    	
    	respo = textRe1.getText();
    	status = textRe2.getText();
    	preparo = textRe3.getText();
    	entrega = textRe4.getText();
    	
    	TabelaDTO tabeladto = new TabelaDTO();
    	
    	tabeladto.setResponsavel(respo);
    	tabeladto.setStatus(status);
    	tabeladto.setPrazoEstimado(preparo);
    	tabeladto.setEntrega(entrega);
    	
    	ProjetosDAO dao = new ProjetosDAO();
    	dao.tabela(tabeladto);
    	}
    	
    	
    	
    	for(int i = 0; i<1; i++) {
        	
        	respo = textTop1.getText();
        	status = textTop2.getText(); 
        	preparo = textTop3.getText();
        	entrega = textTop4.getText();
        	
        	TabelaDTO tabeladto = new TabelaDTO();
        	
        	tabeladto.setResponsavel(respo);
        	tabeladto.setStatus(status);
        	tabeladto.setPrazoEstimado(preparo);
        	tabeladto.setEntrega(entrega);
        	
        	ProjetosDAO dao = new ProjetosDAO();
        	dao.tabela(tabeladto);
        	}
    	
    }
    
    private void carregarDados() {
    	ProjetosDAO dao = new ProjetosDAO();
    	
        // Recupere os dados do banco de dados e armazene-os em variáveis ou objetos
        String valorCampoRe1 = dao.recuperarValorDoBancoDeDadosRe1();
      
        // Atribua os valores recuperados aos campos de texto correspondentes
        textRe1.setText(valorCampoRe1);
    
    }

}
