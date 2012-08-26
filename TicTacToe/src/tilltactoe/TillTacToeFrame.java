package tilltactoe;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javaCode.SpielbrettListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import scalaCode.Konsole;
import scalaCode.Spielbrett;
import scalaCode.Spieler;

public class TillTacToeFrame extends JFrame implements SpielbrettListener {

	private GamePanel gamePanel;
	private JTextField messageBox;
	private Spielbrett spielbrett;
	private JButton newGameButton;

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

	private void initialize() {
		spielbrett = new Spielbrett();
		spielbrett.setListener(this);

		rootPane.setLayout(new BorderLayout());
		rootPane.add(createGamePanel(spielbrett), BorderLayout.CENTER);

		messageBox = new JTextField();
		rootPane.add(messageBox, BorderLayout.SOUTH);
		Action action = new AbstractAction("Neues Spiel") {

			@Override
			public void actionPerformed(ActionEvent e) {
				spielbrett = new Spielbrett();
				spielbrett.setListener(TillTacToeFrame.this);
				gamePanel.setNeuesSpiel(spielbrett);
				messageBox.setText("");
			}
		};
		newGameButton = new JButton(action);
		rootPane.add(newGameButton, BorderLayout.NORTH);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				if (getWidth() != getHeight()) {
					setSize(getWidth(),
							getWidth() + messageBox.getPreferredSize().height
									+ newGameButton.getPreferredSize().height);
				}
			}
		});
	}

	private Component createGamePanel(Spielbrett spielbrett) {
		gamePanel = new GamePanel(spielbrett);
		return gamePanel;
	}

	@Override
	public void valueChangedAt(int zeile, int spalte, Spieler spieler) {
		gamePanel.valueChangedAt(zeile, spalte);
		Spieler werHatGewonnen = spielbrett.werHatGewonnen();
		if (spielbrett.sindAlleFelderBelegt() || !werHatGewonnen.istNiemand()) {
			if (werHatGewonnen.istNiemand()) {
				messageBox.setText("Unentschieden!");
			} else {
				String name = werHatGewonnen.istKreuz() ? "Kreuz" : "Kreis";
				messageBox.setText(name + " hat gewonnen!");
			}
			gamePanel.gameOver();
			return;
		}
		if (spieler.istKreis()) {
			try {
				Thread.sleep(2000);
				Konsole.fuehreComputerZugAus((Spielbrett) spielbrett);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
