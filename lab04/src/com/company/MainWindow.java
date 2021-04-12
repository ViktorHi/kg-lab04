package com.company;

import com.company.algorithms.Brezenkhem;
import com.company.algorithms.BrezenkhemCircle;
import com.company.algorithms.CDA;
import com.company.algorithms.StepByStep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    final private int WIDTH = 1100;
    final private int HEIGHT = 800;

    final private DrawPanel drawingPanel = new DrawPanel();

    final private JTextField x1Input = new JTextField(21);
    final private JTextField y1Input = new JTextField(21);
    final private JTextField x2Input = new JTextField(21);
    final private JTextField y2Input = new JTextField(21);
    final private JTextField radiusInput = new JTextField(21);

    final private JButton stepByStepButton;
    final private JButton DADButton;
    final private JButton brezenkhemButton;
    final private JButton brezenkhemCircleButton;


    final private double PANEL_SCALE_W = 1.0;
    final private double PANEL_SCALE_H = 0.6;

    final private Brezenkhem brezenkhem = new Brezenkhem();
    final private BrezenkhemCircle brezenkhemCircle = new BrezenkhemCircle();
    final private CDA cda = new CDA();
    final private StepByStep stepByStep = new StepByStep();

    public MainWindow(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setLayout(null);

        Font labelFont = new Font("Sans-Serif", Font.PLAIN, 20);

        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setFont(labelFont);
        timeLabel.setBounds(10, 700, 300, 40);
        add(timeLabel);

        stepByStepButton = new JButton("step by step");
        stepByStepButton.setBounds(10, 500, 160, 40);
        stepByStepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
                try {
                    x1 = Integer.parseInt(x1Input.getText());
                    y1 = Integer.parseInt(y1Input.getText());
                    x2 = Integer.parseInt(x2Input.getText());
                    y2 = Integer.parseInt(y2Input.getText());
                } catch (Exception ex) {

                }
                long start = System.nanoTime();
                drawingPanel.drawPoints(stepByStep.stepByStep(x1, y1, x2, y2));
                long end = System.nanoTime();
                timeLabel.setText("Time: "  +  (end -start)/1000 + " ms");
            }
        });
        add(stepByStepButton);

        DADButton = new JButton("CDA");
        DADButton.setBounds(10, 550, 160, 40);
        DADButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
                try {
                    x1 = Integer.parseInt(x1Input.getText());
                    y1 = Integer.parseInt(y1Input.getText());
                    x2 = Integer.parseInt(x2Input.getText());
                    y2 = Integer.parseInt(y2Input.getText());
                } catch (Exception ex) {

                }

                long start = System.nanoTime();
                drawingPanel.drawPoints(cda.cda(x1, y1, x2, y2));
                long end = System.nanoTime();
                timeLabel.setText("Time: "  +  (end - start)/1000 + " ms");

            }
        });
        add(DADButton);

        brezenkhemButton = new JButton("Brezenkhem");
        brezenkhemButton.setBounds(10, 600, 160, 40);
        brezenkhemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
                try {
                    x1 = Integer.parseInt(x1Input.getText());
                    y1 = Integer.parseInt(y1Input.getText());
                    x2 = Integer.parseInt(x2Input.getText());
                    y2 = Integer.parseInt(y2Input.getText());
                } catch (Exception ex) {

                }
                long start = System.nanoTime();
                drawingPanel.drawPoints(brezenkhem.bresenham(x1, y1, x2, y2));
                long end = System.nanoTime();
                timeLabel.setText("Time: "  + (end - start)/1000 + " ms");

            }
        });
        add(brezenkhemButton);

        brezenkhemCircleButton = new JButton("Bezenkhem circle");
        brezenkhemCircleButton.setBounds(10, 650, 160, 40);
        brezenkhemCircleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x1 = 0, y1 = 0, r = 0;
                try {
                    x1 = Integer.parseInt(x1Input.getText());
                    y1 = Integer.parseInt(y1Input.getText());
                    r = Integer.parseInt(radiusInput.getText());
                } catch (Exception ex) {

                }
                long start = System.nanoTime();
                drawingPanel.drawPoints(brezenkhemCircle.brezenkhemCircle(x1, y1, r));
                long end = System.nanoTime();
                timeLabel.setText("Time: "  + (end- start)/1000 + " ms");
            }
        });
        add(brezenkhemCircleButton);

        drawingPanel.setBounds((int)((1 - PANEL_SCALE_W) * WIDTH), 0, (int)(PANEL_SCALE_W * WIDTH), (int)(PANEL_SCALE_H * HEIGHT));
        add(drawingPanel);

        JLabel x1Label = new JLabel("X1: ");
        x1Label.setFont(labelFont);
        x1Label.setBounds(600, 500, 50, 40);
        add(x1Label);

        x1Input.setBounds(670, 500, 400, 40);
        x1Input.setFont(labelFont);
        add(x1Input);

        JLabel y1Label = new JLabel("Y1: ");
        y1Label.setFont(labelFont);
        y1Label.setBounds(600, 550, 50, 40);
        add(y1Label);

        y1Input.setBounds(670, 550, 400, 40);
        y1Input.setFont(labelFont);
        add(y1Input);


        JLabel x2Label = new JLabel("X2: ");
        x2Label.setFont(labelFont);
        x2Label.setBounds(600, 600, 50, 40);
        add(x2Label);

        x2Input.setBounds(670, 600, 400, 40);
        x2Input.setFont(labelFont);
        add(x2Input);


        JLabel y2Label = new JLabel("Y2: ");
        y2Label.setFont(labelFont);
        y2Label.setBounds(600, 650, 50, 40);
        add(y2Label);

        y2Input.setBounds(670, 650, 400, 40);
        y2Input.setFont(labelFont);
        add(y2Input);

        JLabel radiusLabel = new JLabel(" R: ");
        radiusLabel.setFont(labelFont);
        radiusLabel.setBounds(600, 700, 60, 40);
        add(radiusLabel);

        radiusInput.setBounds(670, 700, 400, 40);
        radiusInput.setFont(labelFont);
        add(radiusInput);


        setResizable(false);
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.repaint();
    }
}
