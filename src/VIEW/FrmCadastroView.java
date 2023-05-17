package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.CadastroDAO;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FrmCadastroView extends JFrame {

	private JPanel contentPane;
	private JTextField textusuario;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCadastroView frame = new FrmCadastroView();
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
	public FrmCadastroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("usuario");
		lblNewLabel.setBounds(23, 35, 169, 14);
		contentPane.add(lblNewLabel);
		
		textusuario = new JTextField();
		textusuario.setBounds(23, 63, 169, 20);
		contentPane.add(textusuario);
		textusuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(23, 97, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textSenha = new JTextField();
		textSenha.setBounds(23, 122, 169, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cadastro();
			}
		});
		btnCadastro.setBounds(54, 167, 89, 23);
		contentPane.add(btnCadastro);
	}
	public void cadastro() {
		
		 try {
		        CadastroDAO cadastroDAO;
		        UsuarioDTO objusuario = new UsuarioDTO();
		        objusuario.setEmail_usuario(textusuario.getText());
		        objusuario.setSenha_usuario(textSenha.getText());
		        
		  
		        
		    } catch (SQLException erro) {
		        JOptionPane.showMessageDialog(null, "Erro ao cadastrar: " + erro.getMessage());
		    }
		}
		
	
	}

