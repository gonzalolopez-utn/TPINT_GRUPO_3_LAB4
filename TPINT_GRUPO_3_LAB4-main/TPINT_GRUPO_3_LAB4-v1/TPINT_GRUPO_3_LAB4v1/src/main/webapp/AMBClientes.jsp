<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Bienvenido ADMINISTRADOR!</h1>



	Seleccione que desea hacer:

	<table class="table">
		<thead class="thead-dark">
		</thead>
		<tbody>
			<tr>
				<td>
					<button type="submit" class="btn btn-primary">ABML CLIENTES
					</button>
				</td>
				<td>
					<button type="submit" class="btn btn-primary">ABML CUENTAS</button>
					</td>
				<td><button type="submit" class="btn btn-primary">Autorizaci�n Prestamos</button></td>
				<td><button type="submit" class="btn btn-primary">Informes</button></td> 

			</tr>
	</table>

<br>
<h2>ABML CLIENTES</h2>

<table class="table">
		<thead class="thead-dark">
		</thead>
		<tbody>
			<tr>
				<td>
					<button type="submit" class="btn btn-primary" name="btnAgregarCli">Agregar
					</button>
				</td>
				<td>
					<button type="submit" class="btn btn-primary" name="btnModifCli">Modificar</button>
					</td>
				<td><button type="submit" class="btn btn-primary" name="btnEliminCli">Eliminar</button></td>
				<td><button type="submit" class="btn btn-primary" name="btnModifCli">Listar</button></td> 

			</tr>
	</table>
<br><br>	
DNI: <input type="text" name="txtDNI"/>
<br>
CUIL: <input type="text" name="txtCuil"/>
<br>
Apellido: <input type="text" name="txtApellido"/>
<br>
Sexo :
		
		Masculino        <input type="radio" name="rbtnSexo" value="Masculino">
		Femenino         <input type="radio" name="rbtnSexo" value="Femenino">
<br>
Nacionalidad: <input type="text" name="txtNacionalidad"/>
<br>	
Fecha de nacimiento: <input type="text" name="txtfecNac"/>
<br>	
Direcci�n: <input type="text" name="txtDireccion"/>
<br>		
Localidad: <input type="text" name="txtLocalidad"/>
<br>
Provincia: <select name="CuentasUsuario">
						<option value="Buenos Aires">Buenos Aires</option>
						<option value="Cordoba">Cordoba</option>
						<option value="Santa fe">Santa fe</option>
					</select> 
<br>
Correo: <input type="text" name="txtCorreo"/>
<br>
Tel�fono: <input type="text" name="txtTelefono"/>
<br>

<h3>Asignar Usuario al nuevo cliente:</h3>
Usuario: <input type="text" name="txtDNI"/> <br>
Contrase�a: <input type="text" name="txtApellido"/>
<br>
<button type="submit" class="btn btn-primary">Aceptar </button>

</body>
</html>