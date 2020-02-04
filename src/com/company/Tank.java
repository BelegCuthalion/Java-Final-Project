package com.company;

import java.awt.*;
import javax.swing.*;

public class Tank extends JFrame{
    double x, y, direction, av = 0.05, x_gun, y_gun;
    Color c;

    Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g2d);
        g2d.setColor(c);
        g2d.setStroke(new BasicStroke(10));

        x_gun = Math.round(this.x + 40 * Math.sin(this.direction));
        y_gun = Math.round(this.y + 40 * Math.cos(this.direction));

        g2d.fillOval((int)this.x - 30, (int)this.y - 30, 60, 60);
        g2d.drawLine((int)this.x, (int)this.y, (int)this.x_gun, (int)this.y_gun);

        Toolkit.getDefaultToolkit().sync();
    }

    public void change_direction(double amount) {
        this.direction = (this.direction + amount) % (2*Math.PI);
    }

    public void turn_left() {
        this.change_direction(av);
    }
    public void turn_right() {
        this.change_direction(-av);
    }

    void move() {
        this.x += Math.round(5 * Math.sin(this.direction));
        this.y += Math.round(5 * Math.cos(this.direction));
    }
}