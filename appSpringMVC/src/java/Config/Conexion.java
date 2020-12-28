/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Nahuel
 */
public class Conexion {

    public DriverManagerDataSource Conectar() { //Metodo de la clase DMDT
        DriverManagerDataSource datasource = new DriverManagerDataSource(); //Creando o instanciando el objeto
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/registro");
        datasource.setUsername("root");
        datasource.setPassword("");

        return datasource;
    }
}
