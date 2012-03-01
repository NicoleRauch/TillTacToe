package java.nicole;

import java.awt.Dimension;
import java.awt.Window;

public final class WindowUtilities {

    private WindowUtilities() {
        // do not instantiate this class
    }

    protected static void packAndShowOnScreenCenter( Window window ) {
        packAndLocateOnOpticalScreenCenter( window );
        window.setVisible( true );
    }

    public static void packAndShowOnScreenCenter( Window window, Dimension windowSize ) {
        window.setSize( windowSize );
        locateOnOpticalScreenCenter( window );
        window.setVisible( true );
    }

    /**
     * Locates the given component on the screen's center.
     * 
     * @param window
     *                the component to be centered
     */
    private static void packAndLocateOnOpticalScreenCenter( Window window ) {
        window.pack();
        locateOnOpticalScreenCenter( window );
    }

    private static void locateOnOpticalScreenCenter( Window window ) {
        Dimension paneSize = window.getSize();
        Dimension screenSize = window.getToolkit().getScreenSize();
        window.setLocation( (screenSize.width - paneSize.width) / 2, (int)((screenSize.height - paneSize.height) * 0.45) );
    }

}
