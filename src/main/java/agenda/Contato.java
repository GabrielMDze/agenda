package agenda;

import java.util.Date;

public class Contato {

	private int id;
	private String nome;
	private String Sobrenome;
	private Date Nascimento;
	private int Telefone;
	private int Parentesco;

	DB db = new DB();

	public void Cadastrar(Contato c) {
		String query = "INSERT INTO contato (nome,sobrenome,nascimento,telefone) " + "VALUES ('" + c.getNome() + "','"
				+ c.getSobrenome() + "'," + c.getNascimento() + "," + c.getTelefone() + ");";
		// System.out.println(query);
		db.executeQuey(query);

	}

	public void Editar(Contato c) {
		String query = "UPDATE contato SET nome = '" + c.getNome() + "'" + ",sobrenome = '" + c.getSobrenome() + "'"
				+ ",nascimento = '" + c.getNascimento() + "'" + ",telefone = '" + c.getTelefone() + "'" + "WHERE id = '"
				+ c.getId() + "';";
		// System.out.println(query);
		db.executeQuey(query);

	}

	public void Deletar(int id) {
		String query = "DELETE FROM contato WHERE id = '" + id + "';";

		db.executeQuey(query);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return Sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}

	public Date getNascimento() {
		return Nascimento;
	}

	public void setNascimento(Date nascimento) {
		Nascimento = nascimento;
	}

	public int getTelefone() {
		return Telefone;
	}

	public void setTelefone(int i) {
		Telefone = i;
	}

	public int getParentesco() {
		return Parentesco;
	}

	public void setParentesco(int parentesco) {
		Parentesco = parentesco;
	}

}
