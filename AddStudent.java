import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;

public class AddStudent extends JFrame {
    AddStudent() {
        JLabel roll = new JLabel("Enter Roll");
        roll.setBounds(100, 40, 150, 30);
        roll.setForeground(Color.RED); // Set foreground color
        roll.setFont(new Font("Arial", Font.BOLD, 18)); // Set font and size

        JLabel name = new JLabel("Enter Name");
        name.setBounds(100, 80, 150, 30);
        name.setForeground(Color.GREEN); // Set foreground color
        name.setFont(new Font("Arial", Font.BOLD, 18)); // Set font and size

        JLabel emil = new JLabel("Enter Email");
        emil.setBounds(100, 120, 150, 30);
        emil.setForeground(Color.BLUE); // Set foreground color
        emil.setFont(new Font("Arial", Font.BOLD, 18)); // Set font and size

        JLabel y = new JLabel("Enter Year");
        y.setBounds(100, 160, 150, 30);
        y.setForeground(Color.ORANGE); // Set foreground color
        y.setFont(new Font("Arial", Font.BOLD, 18)); // Set font and size

        JLabel section = new JLabel("Enter Section");
        section.setBounds(100, 200, 150, 30);
        section.setForeground(Color.MAGENTA); // Set foreground color
        section.setFont(new Font("Arial", Font.BOLD, 18)); // Set font and size

        JTextField rollTF = new JTextField();
        rollTF.setBounds(250, 40, 150, 30);

        JTextField nameTF = new JTextField();
        nameTF.setBounds(250, 80, 150, 30);

        JTextField emilTF = new JTextField();
        emilTF.setBounds(250, 120, 150, 30);

        JTextField yearTF = new JTextField();
        yearTF.setBounds(250, 160, 150, 30);

        JTextField secTF = new JTextField();
        secTF.setBounds(250, 200, 150, 30);

        add(roll);
        add(name);
        add(emil);
        add(y);
        add(section);
        add(rollTF);
        add(nameTF);
        add(emilTF);
        add(yearTF);
        add(secTF);

        JButton ok = new JButton("OK");
        ok.setBounds(160, 260, 180, 40);
        ok.setBackground(Color.YELLOW); // Set background color
        ok.setForeground(Color.BLACK); // Set foreground color
        ok.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        add(ok);

        ok.addActionListener(er -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ERP", "root", "root");
                PreparedStatement ps = con.prepareStatement("insert into student_det values(?,?,?,?,?)");

                String id = rollTF.getText();
                String fname = nameTF.getText();
                String email = emilTF.getText();
                int year = Integer.parseInt(yearTF.getText());
                String sec = secTF.getText();

                ps.setString(1, id);
                ps.setString(2, fname);
                ps.setString(3, email);
                ps.setInt(4, year);
                ps.setString(5, sec);

                ps.executeUpdate(); // Execute the SQL statement to insert the data
                ok.setText("Successfully Added");

                PreparedStatement rk = con.prepareStatement("insert into marks values(?,?,?,?,?)");
                rk.setString(1, id);
                rk.setNull(2, java.sql.Types.INTEGER);
                rk.setNull(3, java.sql.Types.INTEGER);
                rk.setNull(4, java.sql.Types.INTEGER);
                rk.setNull(5, java.sql.Types.INTEGER);
                rk.executeUpdate();
                con.close();
            } catch (Exception ex) {
                ok.setText("Try Again!");
            }
        });

        getContentPane().setBackground(Color.BLACK); // Set background color for the frame

        setSize(500, 500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
