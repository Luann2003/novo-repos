package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import java.awt.Color;
import java.awt.Font;

public class FrmLoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLoginView frame = new FrmLoginView();
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
	public FrmLoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nomeUsuario = new JLabel("Usuário");
		nomeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeUsuario.setBounds(248, 125, 106, 21);
		contentPane.add(nomeUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(165, 157, 228, 24);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel nomeSenha = new JLabel("Senha");
		nomeSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nomeSenha.setBounds(248, 192, 63, 21);
		contentPane.add(nomeSenha);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			logar();
			}
		});
		btnLogin.setBounds(215, 259, 132, 23);
		contentPane.add(btnLogin);
		
		textSenha = new JPasswordField();
		textSenha.setBounds(165, 224, 228, 24);
		contentPane.add(textSenha);
		
		JButton btnRealizarCadastro = new JButton("Realizar Cadastro");
		btnRealizarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmCadastroView telacadastro = new FrmCadastroView();
				telacadastro.setVisible(true);
				dispose();
			}
		});
		btnRealizarCadastro.setBackground(Color.CYAN);
		btnRealizarCadastro.setBounds(202, 318, 160, 23);
		contentPane.add(btnRealizarCadastro);
		
		JLabel lblNewLabel = new JLabel("Tela de Login");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(215, 55, 135, 30);
		contentPane.add(lblNewLabel);
	}
	public void logar() {
		String nome_usuario, senha_usuario;
		
		try {
			
			UsuarioDTO objusuario = new UsuarioDTO();
			objusuario.setNome_usuario(textUsuario.getText());
			objusuario.setSenha_usuario(textSenha.getText());
			
			UsuarioDAO objusuariodao = new UsuarioDAO();
			ResultSet rsusariodao = objusuariodao.autenticacaoUsuario(objusuario);
			
			if(rsusariodao.next()) {
				
				FrmPrincipalView objfrmprincpalview = new FrmPrincipalView();
				objfrmprincpalview.setVisible(true);
				
				dispose();
				
			}
			else {
				JOptionPane.showMessageDialog(null, "usuario ou senha invalido");
			}
			
		} catch (SQLException erro) {
			
			JOptionPane.showMessageDialog(null, " FRMLOGIN " + erro);
			
		}
	}
}