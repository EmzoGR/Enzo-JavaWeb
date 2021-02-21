<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AFILIADOS</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div>
		<p style="text-align: center">
			<b>LISTA DE AFILIADOS</b>
		</p>
	</div>

	<div class="container">
		<div>
			<a href="AfiliadoServlet?accion=listar" class="btn btn-success">LISTAR</a>
			<a href="AfiliadoServlet?accion=nuevo" class="btn btn-info">NUEVO</a>
		</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-hover table-bordered">
						<thead>
							<tr>
								<td>ID AFILIADO</td>
								<td>ID FUNCIONARIO</td>
								<td>CLIENTE</td>
								<td>PAGO</td>
								<td>ESTADO</td>
								<td>ACCIONES</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="afi" items="${afiliadoList}">
								<tr>
									<td><c:out value="${afi.idAfiliado}" /></td>
									<td><c:out value="${afi.nomFun}" /></td>
									<td><c:out value="${afi.cliente}" /></td>
									<td><c:out value="${afi.pago}" /></td>
									<td><c:out
											value="${(afi.estado == 1)? 'ACTIVO':'INACTIVO'}" /></td>
									<td><a
										href="AfiliadoServlet?accion=editar&idAfiliado=<c:out value='${afi.idAfiliado}' /> "
										class="btn btn-warning"> EDITAR </a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>