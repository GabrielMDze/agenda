package agenda;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/main")
public class Main extends HttpServlet {
	
	Contato c = new Contato();
	DB db = new DB();
	
	List<Contato> lista = new ArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String acao = req.getParameter("acao");
		if (id!=null && id!="" && acao!=null && acao.equals("excluir")) {
			System.out.println(id);
			c.Deletar(Integer.parseInt(id));
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		
		lista = db.listar();
		
		req.setAttribute("lista", lista);
		
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		this.c.setNome(req.getParameter("nome"));
		this.c.setSobrenome(req.getParameter("sobrenome"));
		//this.c.setNascimento(req.getParameter("nascimento"));
		this.c.setTelefone(Integer.parseInt(req.getParameter("telefone")));
		

		if (id!=null && id!="") {
			
			this.c.setId(Integer.parseInt(id));
			
			c.Editar(this.c);
			
		}else {
			
			c.Cadastrar(this.c);
			
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
		lista = db.listar();
		req.setAttribute("msg", "Cadastrado com sucesso!");
		req.setAttribute("lista", lista);
		dispatcher.forward(req, resp);
	}

}
