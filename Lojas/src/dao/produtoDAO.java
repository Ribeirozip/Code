/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Produtos;
import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class produtoDAO {
    private Conexao conexao;
    private Connection con;

    public produtoDAO(){
        this.conexao = new Conexao();
        this.con = this.conexao.getConexao();
    }
    public void inserir(Produtos produto){
        String sql ="INSERT INTO produtos(nome_prod,desc_prod,preco_prod,quant_prond) VALUES "
                + "(?,?,?,?)";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1,produto.getTitulo());
            stmt.setString(2,produto.getDescricao());
            stmt.setFloat(3,produto.getPrice());
            stmt.setInt(4,produto.getQuant());
            stmt.execute();
        }catch (Exception e){
            System.out.println("Erro ao inserir curso: "+e.getMessage());
        }
        }
    public Produtos getproduto(int id){
        String sql = "SELECT * FROM produtos WHERE id =?";
        try{
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs =stmt.executeQuery();
            Produtos produtos = new Produtos();
            rs.first();
            produtos.setId(id);
            produtos.setTitulo(rs.getString("nome_prod"));
            produtos.setDescricao(rs.getString("desc_prod"));
            produtos.setPrice(rs.getFloat("preco_prod"));
            produtos.setQuant(rs.getInt("quant_prod"));
            return produtos;

        }catch(Exception e){
            return null;
        }
    }
    
}