package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.UsuarioDTO;

public class CadastroDAO {

Connection conn;
	
	public void autenticacaoUsuario(UsuarioDTO objusuariodto) {
		conn = new ConexaoDAO().conectaBD();
		
		try {
			
			String sql = "INSERT INTO gerenciamento_projetos (usuario, senha) VALUES (?, ?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objusuariodto.getEmail_usuario());
			pstm.setString(2, objusuariodto.getSenha_usuario());
			
			int linhas = pstm.executeUpdate();
			if (linhas > 0) {
		        System.out.println("Usuário cadastrado com sucesso!");
		    } else {
		        System.out.println("Falha ao cadastrar usuário.");
		    }
			
			
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "UsuarioDAO " + erro);
			
		}
		
		
	}
	

	
}

