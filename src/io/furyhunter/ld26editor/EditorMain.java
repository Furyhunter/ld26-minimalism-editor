package io.furyhunter.ld26editor;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class EditorMain {

	private JFrame frmMinimalismEditor;
	private EditorPanel editor;
	private JComboBox comboBox;
	
	private File current;
	private final Action save = new Save();
	private final Action open = new Open();
	private final Action saveas = new SaveAs();
	private final Action newbuf = new New();
	private final Action exit = new Exit();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorMain window = new EditorMain();
					window.frmMinimalismEditor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditorMain() {
		initialize();
	}
	
	public void setCurrentFile(File f) {
		current = f;
		frmMinimalismEditor.setTitle("Minimalism Editor - " + f.getName());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMinimalismEditor = new JFrame();
		frmMinimalismEditor.setTitle("Minimalism Editor");
		frmMinimalismEditor.setBounds(100, 100, 800, 600);
		frmMinimalismEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			
		}
		
		JMenuBar menuBar = new JMenuBar();
		frmMinimalismEditor.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem((String) null);
		mntmNew.setAction(newbuf);
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem((String) null);
		mntmOpen.setAction(open);
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem((String) null);
		mntmSave.setAction(save);
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem((String) null);
		mntmSaveAs.setAction(saveas);
		mnFile.add(mntmSaveAs);
		
		JMenuItem mntmExit = new JMenuItem((String) null);
		mntmExit.setAction(exit);
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
		mnFile.add(mntmExit);
		
		editor = new EditorPanel(this);
		frmMinimalismEditor.getContentPane().add(editor);
		
		JPanel panel = new JPanel();
		frmMinimalismEditor.getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editor.setType((EntityTypes)comboBox.getItemAt(comboBox.getSelectedIndex()));
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(EntityTypes.values()));
		panel.add(comboBox);
	}

	public JComboBox getComboBox() {
		return comboBox;
	}
	
	private class Save extends AbstractAction {
		public Save() {
			putValue(NAME, "Save");
			putValue(SHORT_DESCRIPTION, "Save the current file");
		}
		
		public void actionPerformed(ActionEvent e) {
			if (current == null) {
				saveas.actionPerformed(e);
			} else {
				try {
					editor.getLevel().save(current);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	private class Open extends AbstractAction {
		public Open() {
			putValue(NAME, "Open");
			putValue(SHORT_DESCRIPTION, "Open selected file");
		}
		
		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(frmMinimalismEditor);
			
			File f = fc.getSelectedFile();
			if (f != null) {
				try {
					editor.setLevel(new Level(f));
					current = f;
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	private class SaveAs extends AbstractAction {
		public SaveAs() {
			putValue(NAME, "Save As...");
			putValue(SHORT_DESCRIPTION, "Save a selected file");
		}
		
		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser();
			fc.showSaveDialog(frmMinimalismEditor);
			
			File f = fc.getSelectedFile();
			if (f != null) {
				try {
					editor.getLevel().save(f);
					current = f;
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	private class New extends AbstractAction {
		public New() {
			putValue(NAME, "New");
			putValue(SHORT_DESCRIPTION, "Clear the buffer");
		}
		
		public void actionPerformed(ActionEvent e) {
			editor.setLevel(new Level());
		}
	}
	
	private class Exit extends AbstractAction {
		public Exit() {
			putValue(NAME, "Exit");
			putValue(SHORT_DESCRIPTION, "Quit the editor");
		}
		
		public void actionPerformed(ActionEvent e) {
			frmMinimalismEditor.setVisible(false);
			System.exit(0);
		}
	}
}
