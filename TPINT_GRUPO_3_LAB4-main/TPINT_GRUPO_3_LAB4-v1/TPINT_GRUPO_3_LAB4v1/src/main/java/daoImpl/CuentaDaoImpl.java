package daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dominio.Cuenta;



public class CuentaDaoImpl implements dominio.CuentaDao
{
	private static final String insert = "INSERT INTO cuentas(idcuenta, saldo, fecha, cbu, estado, tipocuenta, dnicliente) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "UPDATE cuentas SET estado = ? WHERE cbu = ?";
	private static final String readall = "SELECT * FROM cuentas";
	private static final String update = "UPDATE cuentas SET idcuenta = ?, saldo = ?, fecha = ?, cbu = ?, estado = ?, tipocuenta = ?, dnicliente = ?, where idcuenta = ?";
	private static final String contar = "SELECT COUNT(*) AS contar  FROM cuentas WHERE dnicliente = ?";
	
	public Boolean Insert(Cuenta cuenta) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, cuenta.getIdcuenta());
			statement.setFloat(2, cuenta.getSaldo());
			statement.setString(3, cuenta.getFecha());
			statement.setString(4, cuenta.getCbu());
			statement.setInt(5, cuenta.getEstado());
			statement.setInt(6, cuenta.getTipoCuenta());
			statement.setInt(7, cuenta.getDni());

			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}

	/**
	 * @param Objeto cuenta a modificar
	 * @return Retorna true si modific�, sino, retorna false
	 */
	public Boolean Modify(Cuenta cuenta, int IdCuenta) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setFloat(1, cuenta.getSaldo());
			statement.setString(2, cuenta.getFecha());
			statement.setString(3, cuenta.getCbu());
			statement.setInt(4, cuenta.getEstado());
			statement.setInt(5, cuenta.getTipoCuenta());
			statement.setInt(6, cuenta.getDni());
			statement.setString(7, cuenta.getUsuario());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}

	public Boolean Delete(Cuenta cuenta) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			cuenta.setEstado(0);
			statement.setInt(1, cuenta.getEstado());
			statement.setString(2, cuenta.getCbu());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}

	public List<Cuenta> ReadAll() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				cuentas.add(getCuenta(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return cuentas;
	}



	/**
	 * @param Objeto resulSet que obtiene de la query.
	 *
	 * @return Retorna una nueva instancia de cuenta.
	 */
	private Cuenta getCuenta(ResultSet resultSet) throws SQLException
	{	
		Cuenta c = new Cuenta();
		c.setIdcuenta(resultSet.getInt("idcuenta"));
		c.setSaldo(resultSet.getFloat("saldo"));
		c.setFecha(resultSet.getString("fecha"));
		c.setCbu(resultSet.getString("cbu"));
		c.setEstado(resultSet.getInt("estado"));
		c.setTipoCuenta(resultSet.getInt("tipocuenta"));
		c.setDni(resultSet.getInt("dnicliente"));
		
		return c;
	}

	public int contarCuenta(int dnicuenta) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(contar);
			statement.setInt(1, dnicuenta);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				return resultSet.getInt("contar");
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return -1;
	}

	
	
}