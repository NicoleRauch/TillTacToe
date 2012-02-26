import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GrafikKaestchen extends JButton {

	private static final long serialVersionUID = 1L;

	private static Spieler aktuellerSpieler = Spieler.KREUZ;
	private Kaestchen kaestchen;

	public GrafikKaestchen(Spielbrett spielbrett, int zeilennummer,
			int spaltennummer) {
		kaestchen = spielbrett.get(zeilennummer, spaltennummer);

		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kaestchen.set(aktuellerSpieler);
				derNaechsteSpielerIstDran();
			}
		});

	}

	private void derNaechsteSpielerIstDran() {
		if (aktuellerSpieler == Spieler.KREUZ) {
			aktuellerSpieler = Spieler.KREIS;
		} else
		if (aktuellerSpieler == Spieler.KREIS) {
			aktuellerSpieler = Spieler.KREUZ;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setText(kaestchen.get().toString());
	}

}