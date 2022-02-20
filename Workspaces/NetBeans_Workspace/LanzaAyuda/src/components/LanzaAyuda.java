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

public class LanzaAyuda implements ActionListener 
{
    JTextArea output;
    JScrollPane scrollPane;

    //Crear el menú que muestra la ayuda
    public JMenuBar createMenuBar() 
    {
        //Atributos
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItem, menuItem2;

        //Barra de Menú
        menuBar = new JMenuBar();
                
        //Ficheros de ayuda
        HelpSet hs = obtenFicAyuda();
        HelpBroker hb = hs.createHelpBroker();

        //Construir el menu principal
        menu = new JMenu("Ayuda");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription("El Menu del Programa");
        menuBar.add(menu);

        //Los apartados del menu
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

    //Panel de contenido
    public Container createContentPane() 
    {
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        return contentPane;
    }

    //Crear y mostrar la ventana principal
    private static void createAndShowGUI() 
    {
        JFrame frame = new JFrame("Aplicacion Swing con Ayuda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LanzaAyuda demo = new LanzaAyuda();
        frame.setJMenuBar(demo.createMenuBar());
        frame.setContentPane(demo.createContentPane());
        frame.setSize(450, 260);
        frame.setVisible(true);
    }
    
    //Crear y cargar el fichero HelpSet
    public HelpSet obtenFicAyuda()
    {
        try {
            ClassLoader cl = LanzaAyuda.class.getClassLoader();
            URL res = LanzaAyuda.class.getResource("/components/help/HelpSet.hs");
            File file = new File(res.getFile());
            URL url = file.toURI().toURL();
            HelpSet hs = new HelpSet(null,url);
            return hs;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Fichero HelpSet no encontrado " +  ex.getMessage());
            return null;
        }
    }

    public static void main(String[] args) 
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                createAndShowGUI();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}
