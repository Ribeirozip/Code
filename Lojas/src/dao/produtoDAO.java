package dao;

import beans.Produtos;
import conexao.Conexao;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class produtoDAO {
    private Conexao conexao;
    private Connection con;

    public produtoDAO(){
        this.conexao = new Conexao();
        this.con = this.conexao.getConexao();
    }
    public void inserir(Produtos produtos){
        String sql ="INSERT INTO produtos(nome_prod,desc_prod,preco_prod,quant_prond) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1,produtos.getTitulo());
            stmt.setString(2,produtos.getDescricao());
            stmt.setFloat(3,produtos.getPrice());
            stmt.setInt(4,produtos.getQuant());
            stmt.execute();
        }catch (Exception e){
            System.out.println("Erro ao inserir curso: "+e.getMessage());
        }
        }
    public void editar(Produtos produtos){
        String sql = "UPDATE produtos SET nome_prod =?,desc_prod =?,preco_prod =?,quant_prond =? WHERE id=?";
        try{
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1,produtos.getTitulo());
            stmt.setString(2, produtos.getDescricao());
            stmt.setFloat(3,produtos.getPrice());
            stmt.setInt(4, produtos.getQuant());
            stmt.setInt(5, produtos.getId());
            stmt.execute();
        }catch (Exception e){
           System.out.println("Erro ao editar curso:"+ e.getMessage());
        }
    }
    public void excluir(int id){
        String sql = "DELETE FROM produtos WHERE id =?";
        try{
           PreparedStatement stmt = this.con.prepareStatement(sql); 
           stmt.setInt(1, id);
           stmt.execute();
        }catch(Exception e){
            System.out.println("Erro ao excluir curso: "+ e.getMessage());
        }
    }
    
    public Produtos getProdutos(int id){
        String sql = "SELECT * FROM produtos WHERE id = ?";
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
            produtos.setQuant(rs.getInt("quant_prond"));
            return produtos;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
            
        }
    }
    public List<Produtos> getProdutos(String nome_prod){
        String sql = "SELECT * FROM produtos WHERE nome_prod LIKE ?";
        try{
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1,"%"+nome_prod+"%");
            
            ResultSet rs = stmt.executeQuery();
            List<Produtos> listP = new ArrayList<>();
            while(rs.next()){
                Produtos produtos = new Produtos();
                produtos.setId(rs.getInt("id"));
            produtos.setTitulo(rs.getString("nome_prod"));
            produtos.setDescricao(rs.getString("desc_prod"));
            produtos.setPrice(rs.getFloat("preco_prod"));
            produtos.setQuant(rs.getInt("quant_prond"));
            listP.add(produtos);
            }
            return listP;
        }catch(Exception e){
            return null;
        }
    }
}

   
    
    
