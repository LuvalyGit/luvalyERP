package Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ExeSql {
    private Conector Con;
    private ResultSet Rs;
    private String ElError;
    private int RowCount;
    private String ElSql;
    
    
    public ExeSql(){
        Con = new Conector();
       
    }
//------------------------------------------------------------------------------
//  ERROR EN SELECT
//------------------------------------------------------------------------------
    public String GetError(){
        return this.ElError;
    }
    
//------------------------------------------------------------------------------
//  SELECT
//------------------------------------------------------------------------------
    public ResultSet Select(String Consulta) throws SQLException{
        this.Rs=null;
        ElSql = Consulta;
        System.out.println(Consulta);
        System.out.println("");
        RowCount=0;
        Statement sentencia = Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        Rs = sentencia.executeQuery(Consulta);
        
        while(Rs.next())RowCount++;
                
        
        Rs.beforeFirst();
        this.Commit();
        return this.Rs;  
    }
//------------------------------------------------------------------------------
//  ROW
//------------------------------------------------------------------------------    
    public int GetRowCount(){
        return RowCount;
    }
//------------------------------------------------------------------------------
//  SELECT UNICO
//------------------------------------------------------------------------------
    public String SelectUnico(String Consulta)throws SQLException{
           PreparedStatement pst = Con.getConnection().prepareStatement(Consulta);
           Rs = pst.executeQuery();
           Rs.next();
           ElError = null;
           return Rs.getString(1);
    }
//------------------------------------------------------------------------------
//  COMMIT
//------------------------------------------------------------------------------
    public void Commit() throws SQLException{
        Con.Commit();
    }
//------------------------------------------------------------------------------
//  ROLLBACK
//------------------------------------------------------------------------------
   public void Rollback(){
       try {
           Con.RollBack();
       } catch (Exception e) {
           System.out.println(e);
       }
 
       
    }
//------------------------------------------------------------------------------
//  EJECUTA COMANDO (UPDATE, INSERT, DELETE)
//------------------------------------------------------------------------------
  public void ExeSql(String Sql)throws SQLException{
        ElSql=Sql;
        System.out.println(Sql);
        System.out.println("");
        Statement stm;
        stm = Con.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        stm.execute(Sql);
   }
  
  public int ExeSqlInt(String Sql)throws SQLException{
        int update;
        ElSql=Sql;
        System.out.println(Sql);
        System.out.println("");
        Statement stm;
        stm = Con.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        update = stm.executeUpdate(Sql);
        return update;
   }
  public void Close(){
      try {
          Con.Desconectar();
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
      }
  }
  public String GetSql(){
      return ElSql;
  }
}
    
    
    

