package pt.agendacontactos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


public class ContactDAO {
		
	public void InsertContact(Contact al)
	{
		JDBCConnector conn = new JDBCConnector();
        
        Connection c = conn.OpenDB();
        
        String sql = "INSERT INTO contactos (nome, email, data_aniv, tele) VALUES("
                +"'" + al.getNome() + "',"
                +"'" + al.getEmail() + "',"
                +"'" + al.getData_aniv() + "',"
                +"'" + al.getTele() + "');";
        
        Statement stmt = null;
         
        try
        {
            stmt = c.createStatement();
            stmt.executeUpdate(sql);
        }
        catch(SQLException ex)
        {
            System.out.println("Erro ao inserir o aluno: "+ ex);
        }
        finally{
            conn.CloseDB();
        }
    }
	
	
	public List<Contact> ListContacts()
	{
		JDBCConnector conn = new JDBCConnector();
        Connection c = conn.OpenDB();
        Statement stmt = null;
        ResultSet rs = null;
        List<Contact> contacts = new ArrayList<>();
        
        String sql = "SELECT * from alunos;";
       
        try{
            stmt = c.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                Contact con = new Contact();
                
                con.setId(rs.getInt("id"));
                con.setNome(rs.getString("nome"));
                con.setEmail(rs.getString("email"));
                con.setData_aniv(rs.getDate("data_aniv"));
                con.setTele(rs.getLong("tele"));
                
                contacts.add(con);
            }
        }
        catch(SQLException ex){
            System.out.println("Erro ao listar os contactos: "+ex);
        }
        finally{
            conn.CloseDB();
        }
        return contacts;
	}

	
	public Contact SearchByName(String name)
	{
		JDBCConnector conn = new JDBCConnector();
        Connection c = conn.OpenDB();
        ResultSet rs = null;
        String sql = "SELECT * FROM contactos WHERE nome =" + name + ";";
        Statement stmt = null;
        Contact contact = new Contact();
         
        try
        {
            stmt = c.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {                
                contact.setId(rs.getInt("id"));
                contact.setNome(rs.getString("nome"));
                contact.setEmail(rs.getString("email"));
                contact.setData_aniv(rs.getDate("data_aniv"));
                contact.setTele(rs.getLong("tele"));
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Erro ao inserir o aluno: "+ ex);
        }
        finally{
            conn.CloseDB();
        }
        
        return contact;
	}
	
	
	public Contact SearchById(int id)
	{
		JDBCConnector conn = new JDBCConnector();
        Connection c = conn.OpenDB();
        ResultSet rs = null;
        String sql = "SELECT * FROM contactos WHERE id =" + id + ";";
        Statement stmt = null;
        Contact contact = new Contact();
         
        try
        {
            stmt = c.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next())
            {                
                contact.setId(rs.getInt("id"));
                contact.setNome(rs.getString("nome"));
                contact.setEmail(rs.getString("email"));
                contact.setData_aniv(rs.getDate("data_aniv"));
                contact.setTele(rs.getLong("tele"));
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Erro ao inserir o aluno: "+ ex);
        }
        finally{
            conn.CloseDB();
        }
        
        return contact;
	}
	
	
	public Contact Update(Contact c)
	{
		return null;
	}
	
	 
	public boolean Delete(int id)
	{
		JDBCConnector conn = new JDBCConnector();
        Connection c = conn.OpenDB();
        boolean result = false;
        String sql = "DELETE FROM contactos WHERE id=" + id + ";";
        Statement stmt = null;
         
        try
        {
            stmt = c.createStatement();
            stmt.executeQuery(sql);
            result = true;
        }
        catch(SQLException ex)
        {
            System.out.println("Erro ao inserir o aluno: "+ ex);
        }
        finally{
            conn.CloseDB();
        }
        return result;
	}
}
