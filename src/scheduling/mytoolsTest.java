package scheduling;





import java.awt.HeadlessException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class mytoolsTest {

    private final Connection con;
    private final LocalDate today = LocalDate.now();
  
    public mytoolsTest() {
        con = Connect.ConnectDB();
   
    }
   

  

   

public void processStatus(int clientId, String name, String status) {
    switch (status) {
        case "observation":
            handleClientAction(clientId, name, "pregnant", 115, 
                "Today is the due date for " + name + " (" + status + "). Nabuntis ba ang baboy?");
            break;
        case "pregnant":
            handleClientAction(clientId, name, "nanganak na", 40, 
                "Upcoming due date for " + name + " (" + status + "). Nanganak na ba ang baboy?");
            break;
        case "nanganak na":
            handleClientAction(clientId, name, "hiwalay na", 120, 
                "Upcoming due date for " + name + " (" + status + "). Nakahiwalay na ba ang baboy?");
            break;
        case "hiwalay na":
            handleClientAction(clientId,name,"fattener",120,"pwede na ibenta ung kay"+name);
        default:
            // Handle any unexpected statuses if needed
            System.out.println("something is wrong");
            break;
    }
}




    private void handleClientAction(int clientId, String name, String newStatus, int daysToAdd, String message) {
        int choice = JOptionPane.showConfirmDialog(null, message, "Due Date Alert", JOptionPane.YES_NO_OPTION);
        if("pregnant".equals(newStatus)){
            if (choice == JOptionPane.YES_OPTION) {
            LocalDate newDueDate = today.plusDays(daysToAdd);
            updateClientData(clientId, name, newStatus, newDueDate, daysToAdd);
           
        } else {
            try {
               PreparedStatement pst = con.prepareStatement("delete from client where id = ?");
               pst.setString(1, String.valueOf(clientId));
               JOptionPane.showMessageDialog(null, "entry has been deleted");
               pst.executeUpdate();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        }else{
            if (choice == JOptionPane.YES_OPTION) {
            LocalDate newDueDate = today.plusDays(daysToAdd);
            updateClientData(clientId, name, newStatus, newDueDate, daysToAdd);
        } else {
            JOptionPane.showMessageDialog(null, "Tignan mo kung ano nang lagay");
        }
        }
        
    }


    private void updateClientData(int clientId, String name, String status, LocalDate dueDate, int daysLeft) {
        String query = "UPDATE client SET entry_date = ?, status = ?, due_date = ?, days_left = ? WHERE id = ?";
        
        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setDate(1, Date.valueOf(today));
            pst.setString(2, status);
            pst.setDate(3, Date.valueOf(dueDate));
            pst.setInt(4, daysLeft);
            pst.setInt(5, clientId);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Action performed successfully for client: " + name);
            } else {
                JOptionPane.showMessageDialog(null, "No rows updated. Please check the client " + name + ".");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        
    }
      public void message(String ipAdd, String num){

                try {
                    
                    
                    String str = "Due date has come check your PC";
                    String str2 = str.replaceAll("\\s", "+");
                    URL url = new URL("http://" + ipAdd + ":8080/v1/sms/send/?phone="
                            + num + "&message=" + str2);
                    InputStream i = null;
                    JOptionPane.showMessageDialog(null, "Sent Successfully");
                    i = url.openStream();

                    if (i == null) {
                        System.out.println("Error");
                    }
                } catch (HeadlessException | IOException e) {
                    
                    JOptionPane.showMessageDialog(null, e+" sa message ang mali");
                }
                System.out.println(ipAdd + " "+ num);
    }
    
  

}


