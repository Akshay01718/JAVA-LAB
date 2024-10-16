package Cycle3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Traffic {
    public static void main(String[] args) {
        TrafficLightFrame frame = new TrafficLightFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static class TrafficLightFrame extends JFrame {
        public static final int DEFAULT_WIDTH = 300;
        public static final int DEFAULT_HEIGHT = 400;

        private JRadioButton redButton;
        private JRadioButton yellowButton;
        private JRadioButton greenButton;
        private LightPanel lightPanel;

        private boolean redLightOn = false;
        private boolean yellowLightOn = false;
        private boolean greenLightOn = false;

        public TrafficLightFrame() {
            setTitle("Traffic Light");
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 1));

            // Listener for radio buttons
            ActionListener listener = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    if (event.getSource() == redButton) {
                        redLightOn = true;
                        yellowLightOn = false;
                        greenLightOn = false;
                    } else if (event.getSource() == yellowButton) {
                        yellowLightOn = true;
                        greenLightOn = false;
                        redLightOn = false;
                    } else if (event.getSource() == greenButton) {
                        greenLightOn = true;
                        yellowLightOn = false;
                        redLightOn = false;
                    }
                    repaint();
                }
            };

            // Creating radio buttons
            redButton = new JRadioButton("Red");
            redButton.addActionListener(listener);
            panel.add(redButton);

            yellowButton = new JRadioButton("Yellow");
            yellowButton.addActionListener(listener);
            panel.add(yellowButton);

            greenButton = new JRadioButton("Green");
            greenButton.addActionListener(listener);
            panel.add(greenButton);

            // Group the radio buttons so only one can be selected
            ButtonGroup group = new ButtonGroup();
            group.add(redButton);
            group.add(yellowButton);
            group.add(greenButton);

            // Add the button panel at the top
            add(panel, BorderLayout.NORTH);

            // Create and add the light panel for drawing the traffic lights
            lightPanel = new LightPanel();
            add(lightPanel, BorderLayout.CENTER);
        }

        // Inner class for drawing the traffic lights
        public class LightPanel extends JPanel {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int x = getWidth() / 2 - 20;
                int y = getHeight() / 2 - 50;

                // Draw red light
                if (redLightOn) {
                    g.setColor(Color.RED);
                    g.fillOval(x, y, 40, 40);
                } else {
                    g.setColor(Color.DARK_GRAY);
                    g.fillOval(x, y, 40, 40);
                }

                // Draw yellow light
                if (yellowLightOn) {
                    g.setColor(Color.YELLOW);
                    g.fillOval(x, y + 50, 40, 40);
                } else {
                    g.setColor(Color.DARK_GRAY);
                    g.fillOval(x, y + 50, 40, 40);
                }

                // Draw green light
                if (greenLightOn) {
                    g.setColor(Color.GREEN);
                    g.fillOval(x, y + 100, 40, 40);
                } else {
                    g.setColor(Color.DARK_GRAY);
                    g.fillOval(x, y + 100, 40, 40);
                }
            }
        }
    }
}
