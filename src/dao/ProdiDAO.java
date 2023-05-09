/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import connection.DbConnection;
import entity.Prodi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProdiDAO {
   private DbConnection dbcon = new DbConnection();
    private Connection con;

    public void insertProdi(Prodi p) {

        con = dbcon.makeConnection();
                
        String sql = "INSERT INTO prodi(kode_prodi, nama_prodi) VALUES ('" 
                + p.getKodeProdi() + "','" + p.getNamaProdi() + "')";
        
        System.out.println("Adding Prodi...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Prodi");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Prodi...");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
    }

    
        public void updateProdi(Prodi p) {

        con = dbcon.makeConnection();
        
        String sql = "UPDATE prodi SET nama_prodi = '" + p.getNamaProdi()+
                "' WHERE kode_prodi = '" + p.getKodeProdi() + "'";
        
        System.out.println("Editing Prodi...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Prodi");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Prodi...");
            System.out.println(e);
        }

        dbcon.closeConnection();
    }

          public void deleteProdi(String kodeprodi) {

        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM prodi WHERE kode_prodi = '" + kodeprodi + "'";

        System.out.println("Deleting Prodi...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Prodi " + kodeprodi);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting Prodi...");
            System.out.println(e);
        }

        dbcon.closeConnection();
          }

          public List<Prodi> showProdi() {

        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM prodi";

        System.out.println("Mengambil data Prodi...");
        
        List<Prodi> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null) {
                while (rs.next()) {
                    Prodi p = new Prodi(rs.getString("kode_prodi"), 
                            rs.getString("nama_prodi"));
                    list.add(p);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }

        dbcon.closeConnection();

        return list;
       }

          
          public Prodi searchProdi(String kodeprodi) {

        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM prodi WHERE kode_prodi = '"
                + kodeprodi + "'";

        System.out.println("Searching Prodi...");
        
        Prodi p = null;
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs != null) {
                while (rs.next()) {
                    p = new Prodi(rs.getString("kode_prodi"), 
                            rs.getString("nama_prodi"));
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }

        dbcon.closeConnection();

        return p;
        }

        


}


