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
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;

public class FrmCadastroView extends JFrame {

	private JPanel contentPane;
	private JTextField textusuario;
	private JTextField textEmail;
	private JPasswordField textSenha;

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

	public FrmCadastroView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(264, 184, 169, 23);
		contentPane.add(lblNewLabel);
		
		textusuario = new JTextField();
		textusuario.setBounds(210, 218, 169, 23);
		contentPane.add(textusuario);
		textusuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(264, 252, 65, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					cadastro();
				} catch (SQLException e1) {
					 e1.printStackTrace();
				}
			}
		});
		btnCadastro.setBounds(243, 314, 98, 23);
		contentPane.add(btnCadastro);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(264, 119, 55, 23);
		contentPane.add(lblNewLabel_2);
		
		textEmail = new JTextField();
		textEmail.setBounds(210, 153, 170, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(210, 283, 169, 20);
		contentPane.add(textSenha);
		
		JLabel lblNewLabel_3 = new JLabel("Tela de Cadastro");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(210, 47, 180, 50);
		contentPane.add(lblNewLabel_3);
	}
	public void cadastro() throws SQLException {
		
		if(textEmail.getText().matches("") || textusuario.getText().matches("") || textSenha.getText().matches("")) {
			
			JOptionPane.showMessageDialog(null, "Preencha todos os campos");
		}else {
		
		String nome, senha, email;
		
		nome = textusuario.getText();
		senha = textSenha.getText();
		email = textEmail.getText();
		
		UsuarioDTO objusaDto = new UsuarioDTO();
		
		objusaDto.setNome_usuario(nome);
		objusaDto.setSenha_usuario(senha);
		objusaDto.setEmail_usuario(email);
		
		CadastroDAO objcadastro = new CadastroDAO();
		
		objcadastro.verificarEmailExistente(email);
		objcadastro.verificarUsuarioExistente(nome);
		
		if(!objcadastro.verificarEmailExistente (email) && !objcadastro.verificarUsuarioExistente(nome)) {
			objcadastro.cadastrarFuncionario(objusaDto);
		}
		else {
			JOptionPane.showMessageDialog(null, "Email ou Usuário já cadastradado");
		}
		
		FrmLoginView telalogin = new FrmLoginView();
		telalogin.setVisible(true);
		dispose();
		

		}
		
	
	}
}
