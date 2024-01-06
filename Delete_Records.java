import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;

public class Delete_Records extends JFrame {
    Delete_Records() {
        JLabel roll = new JLabel("Enter Roll");
        roll.setBounds(80, 180, 120, 20);
        roll.setForeground(Color.RED); // Set foreground color
        roll.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        JTextField rollTF = new JTextField();
        rollTF.setBounds(200, 180, 160, 20);
        rollTF.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        add(roll);
        add(rollTF);

        JButton ok = new JButton("OK");
        ok.setBounds(160, 240, 100, 30);
        ok.setBackground(Color.YELLOW); // Set background color
        ok.setForeground(Color.BLACK); // Set foreground color
        ok.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        add(ok);

        ok.addActionListener(er -> {
            JLabel Lev = new JLabel("");
            Lev.setBounds(160, 280, 200, 30);
            Lev.setForeground(Color.GREEN); // Set foreground color
            Lev.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
            add(Lev);

            String id = rollTF.getText(); // Replace "555" with the actual roll value

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ERP", "root", "root");
                Statement stmt = con.createStatement();

                // Delete from student_det table
                String deleteStudentDet = "DELETE FROM student_det WHERE roll = '" + id + "'";
                int rowsAffected1 = stmt.executeUpdate(deleteStudentDet);

                // Delete from marks table
                String deleteMarks = "DELETE FROM marks WHERE roll = '" + id + "'";
                int rowsAffected2 = stmt.executeUpdate(deleteMarks);
                if (rowsAffected1 > 0 || rowsAffected2 > 0) {
                    Lev.setText("Record Deleted");
                } else {
                    Lev.setText("NO Record Deleted");
                }
                
                con.close();
            } catch (Exception ex) {
                Lev.setText("Try Again");
            }

        });

        getContentPane().setBackground(Color.CYAN); // Set background color for the frame

        setSize(500, 500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Delete_Records();
    }
}
