/** To change this license header, choose License Headers in Project Properties.
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
public class productOrder {
    private int idCliente;
    private int idOrdemCompra;
    private String dataCompra;
    private int qtdeOrdemCompra;
    private int idProduto;

    public static ArrayList<productOrder> getList(int id) throws Exception{
        ArrayList<productOrder> list = new ArrayList();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/sample";
        String user = "app";
        String pass = "app";
        
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement stmt = con.createStatement();
        //Incluindo SELECT dos atributos CUSTOMER_ID, ORDER_NUM,SALES_DATE, QUANTITY e PRODUCT_ID 
        //da Entidade PURCHASE_ORDER fazendo WERE pelo ID do Cliente,
        //conforme solicitado no enunciado do projeto_05.
        String sql = "SELECT CUSTOMER_ID, ORDER_NUM, SALES_DATE, QUANTITY, PRODUCT_ID FROM PURCHASE_ORDER WHERE CUSTOMER_ID = "+ id;
        //...
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()) {
            //Instanciando productOrder c, adicionando CUSTOMER_ID, ORDER_NUM, SALES_DATE, QUANTITY e PRODUCT_ID
            //da Entidade PURCHASE_ORDER, conforme solicitado no enunciado do projeto_05.  
            productOrder c = new productOrder(rs.getInt("CUSTOMER_ID"), rs.getInt("ORDER_NUM"), rs.getString("SALES_DATE"),
                rs.getInt("QUANTITY"), rs.getInt("PRODUCT_ID"));
            //...
            list.add(c);
        }
        
        return list;
    }
    
      public productOrder(int CUSTOMER_ID, int ORDER_NUM, String SALES_DATE, int QUANTITY, int PRODUCT_ID) {
        this.idCliente = CUSTOMER_ID;
        this.idOrdemCompra = ORDER_NUM;
        this.dataCompra = SALES_DATE;
        this.qtdeOrdemCompra = QUANTITY;
        this.idProduto = PRODUCT_ID;
    }
       
        public int getIdCliente() {
        return idCliente;
    }

        public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

        public int getIdOrdemCompra() {
        return idOrdemCompra;
    }

        public void setIdOrdemCompra(int idOrdemCompra) {
        this.idOrdemCompra = idOrdemCompra;
    }

        public String getDataCompra() {
        return dataCompra;
    }
        
    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getQtdeOrdemCompra() {
        return qtdeOrdemCompra;
    }

    public void setQtdeOrdemCompra(int qtdeOrdemCompra) {
        this.qtdeOrdemCompra = qtdeOrdemCompra;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
      
}
