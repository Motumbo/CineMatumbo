package Modelo.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    private Connection _conexion;
    private Statement _sentencia;
    private ResultSet _resultado;

    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            setConexion(DriverManager.getConnection("jdbc:mysql://localhost:3306/db_cinema", "root", ""));
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desconectar() {
        try {
            getConexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConexion() {
        return _conexion;
    }

    public void setConexion(Connection _conexion) {
        this._conexion = _conexion;
    }

    public Statement getSentencia() {
        return _sentencia;
    }

    public void setSentencia(Statement _sentencia) {
        this._sentencia = _sentencia;
    }

    public ResultSet getResultado() {
        return _resultado;
    }

    public void setResultado(ResultSet _resultado) {
        this._resultado = _resultado;
    }
}
