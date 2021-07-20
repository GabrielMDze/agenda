<!DOCTYPE html>
<%@page import="agenda.Contato"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AgendaTelefonica</title>
<script type="text/javascript">
	function confirma(id) {

		if (window.confirm("Tem cesteza que deseja excluir?")) {
			location.href = "main?id=" + id +"&acao=excluir";
		}

	}
</script>
</head>
<body>
	<h1>Agenda Telefonica</h1>
	<div>
		<%
		Object msg = request.getAttribute("msg");
		if (msg != null) {
			String msgStr = (String) msg;
			out.print(msg);
		}
		%>
	</div>
	<a href="cadastro.html">
		<button>Cadastrar</button>
	</a>
	<table style="width: 100%; padding: 5%;">
		<tr>
			<th style="width: 20%; border: 2px solid black;">Nome</th>
			<!-- <th style="width: 10%; border: 2px solid black;">Nascimento</th> -->
			<th style="width: 10%; border: 2px solid black;">Telefone</th>
			<th style="width: 5%; border: 2px solid black;">Ações</th>
		</tr>
		<%
		List<Contato> lista = (List<Contato>) request.getAttribute("lista");
		for (Contato c : lista) {
			out.print("<tr>");
			out.print("<td>" + c.getNome() + " " + c.getSobrenome() + "</td>");
			//out.print("<td>" + c.getNascimento() + "</td>");
			out.print("<td>" + c.getTelefone() + "</td>");
			out.print("<td style='width: 70px'><a href='editar.jsp?id=" + c.getId()
			+ "'><button>Editar</button></a> <a href='javascript:confirma(" + c.getId()
			+ ")'><button>Deletar</button></a></td>");
			out.print("</r>");
		}
		%>
	</table>
</body>
</html>