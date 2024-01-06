import javax.swing.*;
import java.awt.Color;
import java.io.*;

public class login extends JFrame {
    private JLabel id;
    private JLabel pass;
    private JLabel output;
    private JTextField idTF;
    private JTextField passTF;
    private JButton sbmt;
    private JButton reset;

    public login() {
        id = new JLabel("Enter ID");
        id.setBounds(80, 90, 80, 20);
        id.setForeground(Color.WHITE); // Set foreground color

        pass = new JLabel("Password");
        pass.setBounds(80, 130, 80, 20);
        pass.setForeground(Color.WHITE); // Set foreground color

        output = new JLabel("");
        output.setBounds(130, 230, 150, 40);
        output.setForeground(Color.RED); // Set foreground color

        idTF = new JTextField();
        idTF.setBounds(160, 90, 100, 20);

        passTF = new JTextField();
        passTF.setBounds(160, 130, 100, 20);

        sbmt = new JButton("Submit");
        sbmt.setBounds(60, 170, 100, 30);

        reset = new JButton("Reset");
        reset.setBounds(160, 170, 100, 30);

        add(id);
        add(pass);
        add(idTF);
        add(passTF);
        add(sbmt);
        add(reset);
        add(output);

        getContentPane().setBackground(Color.DARK_GRAY); // Set background color for the frame

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sbmt.addActionListener(e -> {
            String username = idTF.getText();
            String password = passTF.getText();

            boolean isAuthenticated = false;
            try {
                File file = new File("users.txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    String savedUsername = parts[0];
                    String savedPassword = parts[1];
                    if (savedUsername.equals(username) && savedPassword.equals(password)) {
                        isAuthenticated = true;
                        break;
                    }
                }
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (isAuthenticated) {
                new Home();
                dispose();
            } else {
                output.setText("Invalid Password");
                output.setForeground(Color.RED);
            }
        });

        reset.addActionListener(e -> {
            idTF.setText("");
            passTF.setText("");
            output.setText("Please Provide Password");
            output.setForeground(Color.RED);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(login::new);
    }
}
