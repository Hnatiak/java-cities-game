package org.example.ui;

import javax.swing.*;
import java.awt.*;

public class WelcomeFrame extends JFrame {

    public WelcomeFrame() {

        ImageIcon icon = new ImageIcon(
                getClass().getResource("/icon.png")
        );

        setIconImage(icon.getImage());

        setTitle("Вітаємо");
        setSize(400, 100);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JLabel label = new JLabel(
                "Вітаємо вас у грі дитинства і всіх розумників!"
        );

        JButton button = new JButton("OK");

        panel.add(label);
        panel.add(button);

        add(panel);

        button.addActionListener(e -> {
            dispose();
            new GameFrame();
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}