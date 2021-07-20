package agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import agenda.ConnectionFactory;

public class DB {

	String url = "jdbc:mysql://localhost:3306/contatos";
	String user = "root";
	String password = "";

	Connection connection;
	java.sql.Statement statement;

	public void executeQuey(String query) {

		try (Connection c = ConnectionFactory.getConnection()) {
			statement = c.createStatement();
			statement.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static Contato ver(int id) {
		Contato contato = new Contato();
		
		String sql = "select * from contato where id="+id;
		
		try{
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement smt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = smt.executeQuery();
			if(rs.first()) {
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setSobrenome(rs.getString("sobrenome"));
				//contato.setNascimento(rs.getDate("nascimento"));
				contato.setTelefone(rs.getInt("telefone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return contato;
	}
	
	//ok
	public List<Contato> listar() {

		List<Contato> contatos = new ArrayList<>();
		String sql = "SELECT * FROM contato;";

		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement smt = con.prepareStatement(sql);
			ResultSet rs = smt.executeQuery();

			while (rs.next()) {
				Contato c = new Contato();

				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setSobrenome(rs.getString("sobrenome"));
				//c.setNascimento(rs.getDate("nascimento"));
				c.setTelefone(rs.getInt("telefone"));
				//c.setParentesco(rs.getInt("parentesco"));

				contatos.add(c);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contatos;
	}
}