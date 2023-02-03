package com.vvv.sevensegments.frame;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("Seven Segment Display in Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setResizable(false);
        setLayout(new BorderLayout());
        setVisible(true);
    }
}
