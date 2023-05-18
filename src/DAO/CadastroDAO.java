package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.UsuarioDTO;

public class CadastroDAO {
	
	Connection conn;
	PreparedStatement pstm;
	public void cadastrarFuncionario(UsuarioDTO usuariodto) {
		
		String sql = "INSERT INTO usuario (usuario, senha, email) VALUES (?, ?, ?)";		
		conn = new ConexaoDAO().conectaBD();
		
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,usuariodto.getNome_usuario());
			pstm.setString(2, usuariodto.getSenha_usuario());
			pstm.setString(3, usuariodto.getEmail_usuario());
			
			pstm.execute();
			pstm.close();
			
		} catch (Exception e) {
		
			JOptionPane.showMessageDialog(null, "CadastroDAO" + e);
		}
	}
	
}

