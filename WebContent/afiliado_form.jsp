<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AFILIADO FORM</title>
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

	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">AFILIADO FORM</div>
			<div class="panel-body">
				<form action="AfiliadoServlet?accion=guardar" method="post">
					<div class="form-group">
						<label for="txtIdAfiliado">IDAFILIADO</label> <input type="text"
							class="form-control" name="txtIdAfiliado" readonly
							value="<c:out value='${afiliadoForm.idAfiliado}'/>">
					</div>
					
					<div class="form-group">
						<label for="cboIdFunci">ID_FUNCIONARIO</label> <select name="cboIdFunci"
							class="form-control">
							<option value="0">--SELECCIONE--</option>
							<c:forEach var="item" items="${funcionarioList}">
								<option value="${item.ID_FUNCIONARIO}"
									${item.ID_FUNCIONARIO == afiliadoForm.funcionario ? 'selected="selected"':'' }
									>
									${item.nombre}
									</option>
							</c:forEach>
						</select>
					</div>


					<div class="form-group">
						<label for="txtCliente">CLIENTE</label> <input type="text"
							class="form-control" name="txtCliente"
							value="<c:out value='${afiliadoForm.cliente}'/>">
					</div>

					<div class="form-group">
						<label for="txtPago">PAGO</label> <input type="text"
							class="form-control" name="txtPago"
							value="<c:out value='${afiliadoForm.pago}'/>">
					</div>

					

					<div class="form-group">
						<label for="cboEstado">ESTADO:</label> <select
							class="form-control" id="cboEstado" name="cboEstado">
							<option value="1" ${(afiliadoForm.estado==1)? 'SELECTED':''}>ACTIVO</option>
							<option value="2" ${(afiliadoForm.estado==2)? 'SELECTED':''}>INACTIVO</option>
						</select>
					</div>
					<input type="submit" class="btn btn-success" value="GUARDAR">
					<a href="afiliado_list.jsp" class="btn btn-danger">CANCELAR</a>
				</form>
			</div>
		</div>
	</div>


</body>
</html>