package scheduling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class method  {
    
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        private int numOfObs;
        private int numOfpreg;
        private int numOfanak;
        private int numOfhiwalay;
        
        
        public method(){
            con = Connect.ConnectDB();
            setnum();
        }
        
        public void setnum(){
            String query = "Select status from client";
            
            try(PreparedStatement pst = con.prepareStatement(query) ; ResultSet rs = pst.executeQuery()) {
                while(rs.next()){
                    String stat = rs.getString("status");
                    switch (stat) {
                        case "observation":
                            this.numOfObs +=1;
                            break;
                        case "pregnant":
                            this.numOfpreg +=1;
                            break;
                        case "nanganak na":
                            this.numOfanak+=1;
                            break;
                        case "hiwalay na":
                            this.numOfhiwalay+=1;
                            break;
                        default:
                            System.out.println("something is wrong");
                            break;
                    }
                }                  
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        public int getnumOfObs(){
            return numOfObs;
        }
        public int getnumOfpreg(){
            return numOfpreg;
        }
        public int getnumOfanak(){
            return numOfanak;
        }
        public int getnumOfhiwalay(){
            return numOfhiwalay;
        }
    }

    