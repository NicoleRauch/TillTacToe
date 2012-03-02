package tilltactoe;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class TillTacToeFrame extends JFrame {

	private final class NeuesSpiel extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public NeuesSpiel(TillTacToeFrame tillTacToeFrame) {
			super("Neues Spiel");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			resetGamePanel();			
		}

	}

	private Action action = new NeuesSpiel(this);
	private Component gamePanel = new GamePanel(action);

	public static void main(String[] args) throws Exception {
		final TillTacToeFrame frame = new TillTacToeFrame();
		SwingUtilities.invokeAndWait(new Runnable() {

			@Override
			public void run() {
				frame.pack();

				Dimension screenSize = Toolkit.getDefaultToolkit()
						.getScreenSize();
				int screenwidth = (int) screenSize.getWidth();
				int screenheight = (int) screenSize.getHeight();
				int left = (screenwidth - frame.getWidth()) / 2;
				int top = (screenheight - frame.getHeight()) / 2;
				frame.setLocation(left, top);
				frame.setVisible(true);
			}
		});
	}

	public TillTacToeFrame() {
		super();
		initialize();
	}

	public void resetGamePanel() {
		Dimension size = gamePanel.getSize();
		this.getContentPane().remove(gamePanel);
		gamePanel = new GamePanel(action);
		gamePanel.setPreferredSize(size);
		this.getContentPane().add(gamePanel, BorderLayout.CENTER);
		pack();
	}

	private void initialize() {
		final JMenuBar menu = createMenu();
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(gamePanel, BorderLayout.CENTER);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				if (getWidth() != getHeight() - menu.getHeight()) {
					setSize(getWidth(), getWidth() + menu.getHeight());
				}
			}
		});
	}

	private JMenuBar createMenu() {
		JMenuBar menueLeiste = new JMenuBar();
		JMenu spielMenue = new JMenu("Tic Tac Toe");
		menueLeiste.add(spielMenue);
		JMenuItem neuesSpiel = new JMenuItem("Neues Spiel");

		spielMenue.add(neuesSpiel);
		neuesSpiel.setAction(action);
		
		this.setJMenuBar(menueLeiste);
		return menueLeiste;
	}

}
