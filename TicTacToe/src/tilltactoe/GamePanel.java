package tilltactoe;

import java.awt.GridLayout;
import javaCode.ISpielbrett;

import javax.swing.Action;
import javax.swing.JPanel;

import scalaCode.Spielbrett;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final Action action;

	public GamePanel(Action action) {
		super();
		this.action = action;
		initialize();
	}

	private void initialize() {
		this.setLayout(new GridLayout(3, 3));
		ISpielbrett spielbrett = new Spielbrett();
		for (int zeile = 0; zeile < 3; zeile++) {
			for (int spalte = 0; spalte < 3; spalte++) {
				this.add(createField(spielbrett, zeile, spalte));
			}
		}
	}

	private UIField createField(ISpielbrett spielbrett, int zeile, int spalte) {
		return new UIField(spielbrett, zeile, spalte, action);
	}

}
