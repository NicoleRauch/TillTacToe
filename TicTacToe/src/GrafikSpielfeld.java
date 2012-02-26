import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GrafikSpielfeld extends JFrame {

	private static final long serialVersionUID = 1L;

	public GrafikSpielfeld() {
		super("Tic Tac Toe");

		JMenuBar menueLeiste = new JMenuBar();
		JMenu spielMenue = new JMenu("Tic Tac Toe");
		menueLeiste.add(spielMenue);
		JMenuItem neuesSpiel = new JMenuItem("Neues Spiel");

		spielMenue.add(neuesSpiel);
		neuesSpiel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new PreferencesWindow( MainWindow.this, propertyManager,
				// transmissionManager ).initAndShow();
			}
		});

		this.setJMenuBar(menueLeiste);
		erzeugeFensterinhalt();
		WindowUtilities
				.packAndShowOnScreenCenter(this, new Dimension(300, 300));

	}

	private void erzeugeFensterinhalt() {
		JPanel spielfeld = new JPanel();
		BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		getContentPane().add(spielfeld, BorderLayout.CENTER);
		Spielbrett spielbrett = new Spielbrett();

		spielfeld.setLayout(new GridLayout(3, 3));
		spielfeld.add(new GrafikKaestchen(spielbrett, 0, 0));
		spielfeld.add(new GrafikKaestchen(spielbrett, 0, 1));
		spielfeld.add(new GrafikKaestchen(spielbrett, 0, 2));
		spielfeld.add(new GrafikKaestchen(spielbrett, 1, 0));
		spielfeld.add(new GrafikKaestchen(spielbrett, 1, 1));
		spielfeld.add(new GrafikKaestchen(spielbrett, 1, 2));
		spielfeld.add(new GrafikKaestchen(spielbrett, 2, 0));
		spielfeld.add(new GrafikKaestchen(spielbrett, 2, 1));
		spielfeld.add(new GrafikKaestchen(spielbrett, 2, 2));
	}

}