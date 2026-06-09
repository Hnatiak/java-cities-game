package org.example;

import org.example.ui.WelcomeFrame;

import javax.swing.SwingUtilities;

public class AppLauncher {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                WelcomeFrame::new
        );
    }
}