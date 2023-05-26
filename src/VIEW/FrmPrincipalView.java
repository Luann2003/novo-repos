package VIEW;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Canvas;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Scrollbar;
import java.awt.List;
import java.awt.Choice;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.Box;
import javax.swing.JComboBox;

public class FrmPrincipalView extends JFrame {

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipalView frame = new FrmPrincipalView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipalView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 559);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsuario = new JMenu("");
		mnUsuario.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\user-avatar.png"));
		menuBar.add(mnUsuario);
		
		
		
		//JMenuItem mnNovoprojeto = new JMenuItem("Novo Projeto");
		//mnNovoprojeto.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
			//	FrmNovoProjeto obj = new FrmNovoProjeto();
			//	obj.main(null);
		//	}
		//});
		//mnNovoprojeto.setHorizontalAlignment(SwingConstants.LEFT);
		//mnUsuario.add(mnNovoprojeto);
		
		
		
		
		JMenuItem mntSairdaConta = new JMenuItem("Sair da Conta");
		mntSairdaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmLoginView obj = new FrmLoginView();
				obj.main(null);
				dispose();
			}
		});
		mntSairdaConta.setHorizontalAlignment(SwingConstants.LEFT);
		mnUsuario.add(mntSairdaConta);
		
		JMenu mnArquivo = new JMenu("Arquivos");
		mnArquivo.setSelectedIcon(new ImageIcon("C:\\Users\\User\\Downloads\\png-transparent-computer-icons-setting-icon-cdr-svg-setting-icon.png"));
		mnArquivo.setIcon(null);
		mnArquivo.setHorizontalAlignment(SwingConstants.LEFT);
		menuBar.add(mnArquivo);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mntmNewMenuItem.setSelectedIcon(new ImageIcon("C:\\Users\\User\\Downloads\\kisspng-computer-icons-50x50-voicemail-download-message-box-5ad035e21972e7.5277757115235947221043.jpg"));
		mnArquivo.add(mntmNewMenuItem);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		getContentPane().setLayout(null);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}