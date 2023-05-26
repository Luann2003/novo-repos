package VIEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrmMenuView {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem;

    public FrmMenuView() {
        JFrame frame = new JFrame("Menu Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Cria a barra de menu
        menuBar = new JMenuBar();

        // Cria o menu
        menu = new JMenu("Menu");
        menuBar.add(menu);

        // Cria o item de menu
        menuItem = new JMenuItem("Item");
        menu.add(menuItem);

        // Adiciona um ouvinte de mouse para permitir o movimento do menu
        menuBar.addMouseListener(new MouseAdapter() {
            private Point offset;

            public void mousePressed(MouseEvent e) {
                offset = new Point(e.getX(), e.getY());
            }

            public void mouseDragged(MouseEvent e) {
                Point currentLocation = frame.getLocation();
                frame.setLocation(currentLocation.x + e.getX() - offset.x, currentLocation.y + e.getY() - offset.y);
            }
        });

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FrmMenuView::new);
    }
}