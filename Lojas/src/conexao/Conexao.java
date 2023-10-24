/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public Connection getConexao(){
        try{
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dadosloja?serverTimezone=UTC",
                    "root",
                    "root");
            return con;

        } catch (Exception e){
            System.out.println("Erro ao conectar"+e.getMessage());
            return null;
        }
    }
}