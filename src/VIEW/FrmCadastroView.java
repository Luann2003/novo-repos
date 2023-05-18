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
	private JTextField textEmail;

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
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setBounds(23, 70, 169, 14);
		contentPane.add(lblNewLabel);
		
		textusuario = new JTextField();
		textusuario.setBounds(23, 95, 169, 20);
		contentPane.add(textusuario);
		textusuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(23, 126, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textSenha = new JTextField();
		textSenha.setBounds(23, 151, 169, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cadastro();
			}
		});
		btnCadastro.setBounds(54, 198, 89, 23);
		contentPane.add(btnCadastro);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(23, 23, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textEmail = new JTextField();
		textEmail.setBounds(22, 48, 170, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
	}
	public void cadastro() {
		
		String nome, senha, email;
		
		nome = textusuario.getText();
		senha = textSenha.getText();
		email = textEmail.getText();
		
		UsuarioDTO objusaDto = new UsuarioDTO();
		objusaDto.setNome_usuario(nome);
		objusaDto.setSenha_usuario(senha);
		objusaDto.setEmail_usuario(email);
		
		CadastroDAO objcadastro = new CadastroDAO();
		objcadastro.cadastrarFuncionario(objusaDto);
			
		
		
	
	}
}
