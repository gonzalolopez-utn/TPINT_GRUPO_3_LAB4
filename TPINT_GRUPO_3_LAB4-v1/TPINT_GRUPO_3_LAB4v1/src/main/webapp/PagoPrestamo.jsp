<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<h1>Pago de Préstamo</h1>
<br />
<br />
<form action="get">

<br />
<br />
Seleccione la cuota a anular:  <select name="CuotasPagarPrestamo">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
					</select> 
<br />
<br />
Seleccione la cuenta de donde se descontará el pago:  <select name="CuentasUsuario">
						<option value="1">Cuenta Bancaria 1</option>
						<option value="2">Cuenta Bancaria 2</option>
						<option value="3">Cuenta Bancaria 3</option>
					</select> 
<br />
<br />					
<input type="submit" name="btnPagoCuota" value="Pagar Cuota"/>

<br />
</form>


</body>
</html>