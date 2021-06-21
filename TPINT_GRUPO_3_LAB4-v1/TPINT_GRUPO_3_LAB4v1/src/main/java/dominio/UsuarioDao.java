package dominio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daoImpl.Conexion;

import java.sql.Connection;


import interfaz.IUsuarioDao;

public class UsuarioDao implements IUsuarioDao {
	private static final String validate = "SELECT u.Estado From Usuarios as u where u.Usuario = ? and u.Contra = ? ";


    public Boolean validate(Usuario usuario) throws SQLException {
    	String result = null;
        PreparedStatement statement;
        ResultSet resultSet = null; //Guarda el resultado de la query
        try
        {
            Connection conexion = Conexion.getConexion().getSQLConexion();

            statement = conexion.prepareStatement(validate);
            //statement.setString(1, usuario.dni);
            statement.setString(1, usuario.getUsuario());
            statement.setString(2, usuario.getContra());
            resultSet = statement.executeQuery();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
	     while(resultSet.next()) {
		        result = resultSet.getString(1);
		    }
			   if(result != null && result.contains("1")){
			            return true;
			      }
			        else return false;
			        
    }

    
}
