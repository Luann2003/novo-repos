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

public class FrmLoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textSenha;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nomeUsuario = new JLabel("Nome de Usu\u00E1rio");
		nomeUsuario.setBounds(10, 11, 424, 14);
		contentPane.add(nomeUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(10, 36, 228, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel nomeSenha = new JLabel("Senha de Usu\u00E1rio");
		nomeSenha.setBounds(10, 67, 132, 14);
		contentPane.add(nomeSenha);
		
		textSenha = new JTextField();
		textSenha.setBounds(10, 92, 228, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			logar();
			}
		});
		btnLogin.setBounds(10, 128, 89, 23);
		contentPane.add(btnLogin);
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