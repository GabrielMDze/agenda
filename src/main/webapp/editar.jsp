<!DOCTYPE html>
<%@page import="agenda.Contato"%>
<%@page import="agenda.DB"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
</head>
<%
String id = request.getParameter("id");

Contato c = new Contato();
DB db = new DB();

c = db.ver(Integer.parseInt(id));
System.out.println(c.getTelefone());
%>
<body>
	<h1>Editar</h1>
	<h3>
		<a href="javascript:history.back()">
			<button>Voltar</button>
		</a>
	</h3>
	<form method="post" action="main">
		Nome: <input type="text" name="nome" value="<%=c.getNome()%>"> Sobrenome: <input type="text" name="sobrenome" value="<%=c.getSobrenome()%>">
		<%-- Data de Nascimento: <input type="date" name="nascimento" value="<%=c.getNascimento()%>"> --%> Telefone: <input
			type="text" name="telefone" maxlength="12" value="<%=c.getTelefone()%>"> <input type="number" name="id" hidden="" value="<%=c.getId()%>"> <input type="submit" value="Salvar">
	</form>
</body>
</html>