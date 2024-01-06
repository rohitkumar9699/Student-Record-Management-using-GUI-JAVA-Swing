import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class search extends JFrame {
    search() 
    {
        JLabel roll = new JLabel("Enter Roll");
        roll.setBounds(80, 180, 120, 20);
        roll.setForeground(Color.RED); // Set foreground color
        roll.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        JTextField rollTF = new JTextField();
        rollTF.setBounds(190, 180, 160, 20);
        rollTF.setFont(new Font("Arial", Font.BOLD, 20));
        add(roll);  
        add(rollTF);

        JButton ok = new JButton("OK");
        ok.setBounds(160, 240, 100, 30);
        ok.setBackground(Color.YELLOW); // Set background color
        ok.setForeground(Color.BLACK); // Set foreground color
        ok.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
        add(ok);

        ok.addActionListener(er -> {
            getContentPane().setBackground(Color.BLACK);

            JLabel DAA = new JLabel(" DAA");
            DAA.setBounds(480, 290, 80, 20);
            DAA.setForeground(Color.GREEN); // Set foreground color
            DAA.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
            JLabel JAVA = new JLabel(" JAVA");
            JAVA.setBounds(480, 330, 80, 20);
            JAVA.setForeground(Color.BLUE); // Set foreground color
            JAVA.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
            JLabel PYTHON = new JLabel(" Python");
            PYTHON.setBounds(480, 370, 80, 20);
            PYTHON.setForeground(Color.ORANGE); // Set foreground color
            PYTHON.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
            JLabel C = new JLabel(" C");
            C.setBounds(480, 410, 80, 20);
            C.setForeground(Color.MAGENTA); // Set foreground color
            C.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
            JTextField DAATF = new JTextField();
            DAATF.setBounds(560, 290, 100, 20);
            DAATF.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
            JTextField JAVATF = new JTextField();
            JAVATF.setBounds(560, 330, 100, 20);
            JAVATF.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
            JTextField PYTHONTF = new JTextField();
            PYTHONTF.setBounds(560, 370, 100, 20);
            PYTHONTF.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
            JTextField CTF = new JTextField();
            CTF.setBounds(560, 410, 100, 20);
            CTF.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size


            JLabel NAME = new JLabel(" Name");
            NAME.setBounds(720, 290, 80, 20);
            NAME.setForeground(Color.RED); // Set foreground color
            NAME.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
            JLabel EMAIL = new JLabel(" Email");
            EMAIL.setBounds(720, 330, 80, 20);
            EMAIL.setForeground(Color.RED); // Set foreground color
            EMAIL.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
            JLabel YEAR = new JLabel(" Year");
            YEAR.setBounds(720, 370, 80, 20);
            YEAR.setForeground(Color.RED); // Set foreground color
            YEAR.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
            JLabel SECTION = new JLabel("Section");
            SECTION.setBounds(720, 410, 80, 20);
            SECTION.setForeground(Color.RED); // Set foreground color
            SECTION.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
            JTextField NAMETF = new JTextField("");
            NAMETF.setBounds(800, 290, 180, 20);
            NAMETF.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
            JTextField EMAILTF = new JTextField("");
            EMAILTF.setBounds(800, 330, 180, 20);
            EMAILTF.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
            JTextField YEARTF = new JTextField("");
            YEARTF.setBounds(800, 370, 180, 20);
            YEARTF.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size
            JTextField SECTIONTF = new JTextField("");
            SECTIONTF.setBounds(800, 410, 180, 20);
            SECTIONTF.setFont(new Font("Arial", Font.BOLD, 20)); // Set font and size

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
            add(NAME);
            add(EMAIL);
            add(YEAR);
            add(SECTION);
            add(NAMETF);
            add(EMAILTF);
            add(YEARTF);
            add(SECTIONTF);
            try {
                String rollValue = rollTF.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erp", "root", "root");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM student_det s, Marks m WHERE s.roll = m.roll AND s.roll = '" + rollValue + "';");

                if (rs.next()) {
                    String nameValue = rs.getString("name");
                    String emailValue = rs.getString("email");
                    int yearValue = rs.getInt("year");
                    String sectionValue = rs.getString("section");
                    int cValue = rs.getInt("C");
                    int pythonValue = rs.getInt("python");
                    int daaValue = rs.getInt("DAA");
                    int javaValue = rs.getInt("JAVA");

                    rollTF.setText(rollValue);
                    NAMETF.setText(nameValue);
                    EMAILTF.setText(emailValue);
                    YEARTF.setText(String.valueOf(yearValue));
                    SECTIONTF.setText(sectionValue);
                    CTF.setText(String.valueOf(cValue));
                    PYTHONTF.setText(String.valueOf(pythonValue));
                    DAATF.setText(String.valueOf(daaValue));
                    JAVATF.setText(String.valueOf(javaValue));
                } else 
                {
                    // Clear the text fields or display an error message
                    rollTF.setText("No Record");
                    NAMETF.setText("No Record");
                    EMAILTF.setText("No Record");
                    YEARTF.setText("No Record");
                    SECTIONTF.setText("No Record");
                    CTF.setText("No Record");
                    PYTHONTF.setText("No Record");
                    DAATF.setText("No Record");
                    JAVATF.setText("No Record");
                }

                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            setSize(getMaximumSize());
        });

        setSize(500, 500);
        getContentPane().setBackground(Color.blue); // Set frame background color
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new search();
    }
}
