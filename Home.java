import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;

public class Home extends JFrame 
{
    public Home() {
        setLayout(null);
        JLabel greeting = new JLabel("**Student's Record Management**");
        greeting.setBounds(310, 50, 650, 40);
        greeting.setForeground(Color.BLACK); // Set color to blue
        greeting.setFont(new Font("Arial", Font.BOLD, 40)); // Set font style, size, and bold
    
        JButton view_details = new JButton("View Details");
        view_details.setBounds(100, 150, 150, 40);
        view_details.setForeground(Color.RED); // Set color to red
        view_details.setFont(new Font("Arial", Font.BOLD, 16)); // Set font style and size
    
        JButton View_Marks = new JButton("View Marks");
        View_Marks.setBounds(300, 150, 150, 40);
        View_Marks.setForeground(Color.GREEN); // Set color to green
        View_Marks.setFont(new Font("Arial", Font.BOLD, 16)); // Set font style and size
    
        JButton Add_Marks = new JButton("Add Marks");
        Add_Marks.setBounds(500, 150, 150, 40);
        Add_Marks.setForeground(Color.ORANGE); // Set color to orange
        Add_Marks.setFont(new Font("Arial", Font.BOLD, 16)); // Set font style and size
    
        JButton Addst = new JButton("Add Student");
        Addst.setBounds(700, 150, 150, 40);
        Addst.setForeground(Color.MAGENTA); // Set color to magenta
        Addst.setFont(new Font("Arial", Font.BOLD, 16)); // Set font style and size
    
        JButton delst = new JButton("Delete Student");
        delst.setBounds(900, 150, 150, 40);
        delst.setForeground(Color.CYAN); // Set color to cyan
        delst.setFont(new Font("Arial", Font.BOLD, 16)); // Set font style and size
    
        JButton Search = new JButton("Search");
        Search.setBounds(1100, 150, 150, 40);
        Search.setForeground(Color.BLACK); // Set color to black
        Search.setFont(new Font("Arial", Font.BOLD, 16)); // Set font style and size
    
        add(greeting);add(view_details);add(View_Marks);add(Add_Marks);add(Addst);add(delst);add(Search);
        
        Search.addActionListener(e -> {
            new search();
        });
        delst.addActionListener(e -> {
            new Delete_Records();
        });
        Add_Marks.addActionListener(e -> {
            new addmarks();
        });
        Addst.addActionListener(e -> {
            new AddStudent();
        });
    
        view_details.addActionListener(e -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erp", "root", "root");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from student_det");
                JTable jTable1 = new JTable(buildTableModel(rs));
                JScrollPane jScrollPane1 = new JScrollPane(jTable1);
                jScrollPane1.setBounds(20, 200, 1200, 500);
                add(jScrollPane1);
                con.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });
        
        View_Marks.addActionListener(e -> {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/erp", "root", "root");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from marks");
                JTable jTable2 = new JTable(buildTableModel(rs));
                JScrollPane jScrollPane2 = new JScrollPane(jTable2);
                jScrollPane2.setBounds(20, 200, 1200, 500);
                add(jScrollPane2);
                con.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });
    
        
    
        setSize(1400, 800); // Set the size of the frame
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
    
        // Create column names
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i);
        }
    
        // Create table data
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        while (rs.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = rs.getObject(i);
            }
            tableModel.addRow(rowData);
        }
        return tableModel;
    }
    
    public static void main(String[] args) {
        new Home();
    }
}    