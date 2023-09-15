package com.morblockius;

import org.lwjgl.glfw.*;
import java.awt.*;

public class Main  {
    public static void main(String[] args) {
        Frame f = new Frame();

        Label l = (Label) f.add(new Label("Hello World"));

        l.setAlignment(Label.CENTER);

        f.setBounds(0, 0, 100, 100);

        f.setVisible(true);
        
        System.out.println("Hello World");
    }
}