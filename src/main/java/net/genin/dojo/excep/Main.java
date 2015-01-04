package net.genin.dojo.excep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * .
 */
public class Main extends JFrame implements ActionListener {

    private final JLabel response;

    private final MyService myService = new MyService();

    public Main(){
        super("Powered By D.A.");

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        };
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        getContentPane().add(new JLabel("The answer to life, the universe, and everything ??"));
        final JButton search = new JButton("Search");
        search.addActionListener(this);
        getContentPane().add(search);
        response = new JLabel();
        getContentPane().add(response);
                addWindowListener(l);
        setSize(300,100);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            final String result = myService.run();
            response.setText(result);
        } catch (MyBusinessException e1) {
            response.setText("");
            JOptionPane.showMessageDialog(this,
                    e1.label,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }


    }

    public static void main(String[] args) {
        final Main main = new Main();
//        main.pack();
    }


}
