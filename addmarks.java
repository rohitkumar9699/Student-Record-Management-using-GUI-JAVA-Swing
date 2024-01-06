import java.sql.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class addmarks extends JFrame {
    addmarks() {
        JLabel roll = new JLabel("Enter ROLL");
        roll.setBounds(200, 40, 120, 20);
        roll.setForeground(Color.RED); // Set foreground color
        roll.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        
        JLabel DAA = new JLabel("Enter DAA");
        DAA.setBounds(200, 80, 120, 20);
        DAA.setForeground(Color.GREEN); // Set foreground color
        DAA.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        
        JLabel JAVA = new JLabel("Enter JAVA");
        JAVA.setBounds(200, 120, 120, 20);
        JAVA.setForeground(Color.BLUE); // Set foreground color
        JAVA.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        
        JLabel PYTHON = new JLabel("Enter Python");
        PYTHON.setBounds(200, 160, 120, 20);
        PYTHON.setForeground(Color.ORANGE); // Set foreground color
        PYTHON.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        
        JLabel C = new JLabel("Enter C");
        C.setBounds(200, 200, 120, 20);
        C.setForeground(Color.MAGENTA); // Set foreground color
        C.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        
        JTextField rollTF = new JTextField();
        rollTF.setBounds(320, 40, 150, 20);
        rollTF.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        
        JTextField DAATF = new JTextField();
        DAATF.setBounds(320, 80, 150, 20);
        DAATF.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        
        JTextField JAVATF = new JTextField();
        JAVATF.setBounds(320, 120, 150, 20);
        JAVATF.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        
        JTextField PYTHONTF = new JTextField();
        PYTHONTF.setBounds(320, 160, 150, 20);
        PYTHONTF.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        
        JTextField CTF = new JTextField();
        CTF.setBounds(320, 200, 150, 20);
        CTF.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        
        add(DAA);
        add(roll);
        add(JAVA);
        add(PYTHON);
        add(C);
        add(rollTF);
        add(DAATF);
        add(JAVATF);
        add(PYTHONTF);
        add(CTF);

        JButton ok = new JButton("OK");
        ok.setBounds(240, 240, 100, 30);
        ok.setBackground(Color.YELLOW); // Set background color
        ok.setForeground(Color.BLACK); // Set foreground color
        ok.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        add(ok);

        JLabel lev = new JLabel("");
        lev.setBounds(250, 280, 150, 20);
        lev.setForeground(Color.BLUE); // Set foreground color
        lev.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        add(lev);
        ok.addActionListener(er -> 
        {
            String id = rollTF.getText();
            int daa = Integer.parseInt(DAATF.getText());
            int java = Integer.parseInt(JAVATF.getText());
            int python = Integer.parseInt(PYTHONTF.getText());
            int c = Integer.parseInt(CTF.getText());
            String sql = "update marks set DAA = ?, JAVA = ?, PYTHON = ?, C = ? where roll = ?";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ERP", "root", "root");
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1, daa); // Replace 1 with the actual value for DAA
                ps.setInt(2, python); // Replace 2 with the actual value for JAVA
                ps.setInt(3, java); // Replace 3 with the actual value for PYTHON
                ps.setInt(4, c); // Replace 4 with the actual value for C
                ps.setString(5, id); // Replace "555" with the actual roll value

                int i = ps.executeUpdate();
                if (i > 0) {
                    lev.setText("updated successfully");
                } else {
                    lev.setText("No rows updated");
                }

                con.close();
            } catch (Exception ex) {
                lev.setText("Try Again");
            }
        });

        getContentPane().setBackground(Color.CYAN); // Set background color for the frame

        setSize(650, 370);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new addmarks();
    }
}
