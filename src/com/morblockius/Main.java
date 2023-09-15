package com.morblockius;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.awt.AWTGLCanvas;
import org.lwjgl.opengl.awt.GLData;

import java.awt.*;


public class Main  {
    public static void main(String[] args) {
        Frame f = new Frame();


        GLData data = new GLData();
        data.majorVersion = 3;
        data.minorVersion = 3;
        data.profile = GLData.Profile.CORE;
        data.samples = 4;
        f.add(new AWTGLCanvas(data) {

            @Override
            public void initGL() {
            }

            @Override
            public void paintGL() {

            }
            
        });

        Label l = (Label) f.add(new Label("Hello World"));

        l.setAlignment(Label.CENTER);

        f.setBounds(0, 0, 100, 100);

        f.setVisible(true);
        
        System.out.println("Hello World");
    }
}