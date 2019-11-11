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
 * @author helio
 */
public class Produtos {
    private int idFabricante;
    private int idProduto;
    private int descricaoProduto;
    private int qtdeEstoque;
    
     public static ArrayList<Produtos> getList(int id) throws Exception{
        ArrayList<Produtos> list = new ArrayList();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String pass = "app";
        
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement stmt = con.createStatement();
        //Incluindo SELECT dos atributos MANUFACTURER_ID, PRODUCT_ID, DESCRIPTION, QUANTITY_ON_HAND, 
        //da Entidade PRODUCT fazendo WERE pelo ID do Fabricante,
        //conforme solicitado no enunciado do projeto_05.
        String sql = "SELECT MANUFACTURER_ID, PRODUCT_ID, DESCRIPTION, QUANTITY_ON_HAND FROM PRODUCT WHERE MANUFACTURER_ID = " + id;
        //...
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()) {
            //Instanciando Produto a, adicionando MANUFACTURER_ID,PRODUCT_ID, DESCRIPTION, QUANTITY_ON_HAND,
            //da Entidade PRODUCT, conforme solicitado no enunciado do projeto_05.  
            Produtos c = new Produtos(rs.getInt("MANUFACTURER_ID"), rs.getInt("PRODUCT_ID"), rs.getInt("DESCRIPTION"), rs.getInt("QUANTITY_ON_HAND"));
            //...
            list.add(c);
        }
        return list;
    }

    public Produtos(int MANUFACTURER_ID, int PRODUCT_ID, int DESCRIPTION, int QUANTITY_ON_HAND) {
        this.idFabricante = MANUFACTURER_ID;
        this.idProduto = PRODUCT_ID;
        this.descricaoProduto = DESCRIPTION;
        this.qtdeEstoque = QUANTITY_ON_HAND;
    }
    
     public int getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(int descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public int getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(int qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

}    