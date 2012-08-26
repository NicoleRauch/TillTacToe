package tilltactoe;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import scalaCode.Spielbrett;

public class GamePanel extends JPanel {

	private List<UIField> uiFields = new ArrayList<UIField>();
	private Spielbrett spielbrett;

	public GamePanel(Spielbrett spielbrett) {
		super();
		this.spielbrett = spielbrett;
		initialize();
	}

	private void initialize() {
		this.setLayout(new GridLayout(3, 3));
		for (int zeile = 0; zeile < 3; zeile++) {
			for (int spalte = 0; spalte < 3; spalte++) {
				this.add(createField(zeile, spalte));
			}
		}
	}

	private UIField createField(int zeile, int spalte) {
		UIField uiField = new UIField(spielbrett, zeile, spalte);
		uiFields.add(uiField);
		return uiField;
	}

	public void valueChangedAt(int zeile, int spalte) {
		for (UIField field : uiFields) {
			if (field.isFor(zeile, spalte)) {
				field.valueChanged();
			}
		}
	}

	public void gameOver() {
		for (UIField field : uiFields) {
			field.gameOver();
		}
	}

	public void setNeuesSpiel(Spielbrett spielbrett) {
		this.spielbrett = spielbrett;
		for (UIField field : uiFields) {
			field.setNeuesSpiel(spielbrett);
		}
	}

}
