package components;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.help.*;
import javax.swing.JOptionPane;

public class LanzaAyuda implements ActionListener {
    JTextArea output;
    JScrollPane scrollPane;

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem, menuItem2;

        //Create the menu bar.
        menuBar = new JMenuBar();
                
        //Creamos los ficheros de ayuda
        HelpSet hs = obtenFicAyuda();
        HelpBroker hb = hs.createHelpBroker();

        //Build the first menu.
        menu = new JMenu("Ayuda");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("El Menu del Programa");
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem = new JMenuItem("Contenido de Ayuda", KeyEvent.VK_F1);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        menuItem.getAccessibleContext().setAccessibleDescription("El apartado Ayuda del Menu");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        //Asociamos la ayuda al item del menu
        hb.enableHelpOnButton(menuItem, "Reserva_Habitaciones", hs);
        hb.enableHelpKey(menuItem, "Reserva_Habitaciones", hs);
        
        menuItem2 = new JMenuItem("About");
        menuItem2.getAccessibleContext().setAccessibleDescription("El apartado About del Menu");
        menuItem2.addActionListener(this);
        menu.add(menuItem2);

        return menuBar;
    }

    public Container createContentPane() 
    {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Aplicacion Swing con Ayuda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        LanzaAyuda demo = new LanzaAyuda();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());

        //Display the window.
        frame.setSize(450, 260);
        frame.setVisible(true);
    }
    
    public HelpSet obtenFicAyuda(){
    try {
        ClassLoader cl = LanzaAyuda.class.getClassLoader();
        URL res = LanzaAyuda.class.getResource("/components/help/HelpSet.hs");
        File file = new File(res.getFile());
        URL url = file.toURI().toURL();
        // crea un objeto Helpset
        HelpSet hs = new HelpSet(null,url);
        return hs;
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null,"Fichero HelpSet no encontrado " +  ex.getMessage());
        return null;
        }
   }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
