/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fatecpg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author a helio
 */
public class Manufacturer {
    private int id;
    //Incluíndo as variáveis String name, cidade, estado e email, como atributos da classe Manufacturer, 
    //conforme solicitado no enunciado do projeto_05.
    private String name;
    private String cidade;
    private String estado;
    private String email;
    //...
 
    public static ArrayList<Manufacturer> getList() throws Exception {
        ArrayList<Manufacturer> list = new ArrayList();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String pass = "app";
        
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement stmt = con.createStatement();
        //Incluindo SELECT dos atributos NAME, CITY, STATE e EMAIL da Entidade MANUFACTURER,
        //conforme solicitado no enunciado do projeto_05.
        String sql = "SELECT manufacturer_id, name, city, state, email FROM MANUFACTURER";
        //...
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()) {
            //Instanciando Manufacturer c, adicionando os atributos NAME, CITY, STATE e EMAIL
            //da Entidade MANUFACTURER, conforme solicitado no enunciado do projeto_05.  
            Manufacturer c = new Manufacturer(rs.getInt("manufacturer_id"), rs.getString("name"),
                rs.getString("city"), rs.getString("state"), rs.getString("email"));
            //...
            list.add(c);
        }
        
        return list;
    }
    //Passando os parâmetros String name, cidade, estado e email no Método Construtor da classe Manufacturer, 
    //e atribuindo os mesmos aos atributos da classe, conforme solicitado no enunciado do projeto_05.
    public Manufacturer(int id, String name, String city, String state, String email) {
        this.id = id;
        //...
        this.name = name;
        this.cidade = city;
        this.estado = state;
        this.email = email;
        //...
    }
      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //Criando os métodos GET e SET dos atributos name, cidade, estado e email da classe Manufacturer.
    //conforme solicitado no enunciado do projeto_05.
    public String getName() { 
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    //...    
    }

}
