package org.example.ui;

import javax.swing.*;

public class WelcomeFrame extends JFrame {

    public WelcomeFrame() {

        initializeFrame();

        initializeComponents();

        setVisible(true);
    }

    private void initializeFrame() {

        ImageIcon icon =
                new ImageIcon(
                        getClass().getResource("/icon.png")
                );

        setIconImage(icon.getImage());

        setTitle("Вітаємо");

        setSize(400, 100);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initializeComponents() {

        JPanel panel = new JPanel();

        JLabel label =
                new JLabel(
                        "Вітаємо вас у грі дитинства і всіх розумників!"
                );

        JButton button =
                new JButton("OK");

        panel.add(label);

        panel.add(button);

        add(panel);

        button.addActionListener(e -> {

            dispose();

            new GameFrame();
        });
    }
}