package com.morblockius;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL33;
import org.lwjgl.opengl.awt.AWTGLCanvas;
import org.lwjgl.opengl.awt.GLData;

import java.awt.*;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Frame f = new Frame();
        f.setLayout(new GridBagLayout());
        GLData data = new GLData();
        data.majorVersion = 3;
        data.minorVersion = 3;
        data.profile = GLData.Profile.CORE;
        data.samples = 4;

        AWTGLCanvas canvas;

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridwidth = GridBagConstraints.RELATIVE;
        constraints.gridheight = GridBagConstraints.RELATIVE;
        constraints.fill = GridBagConstraints.BOTH;

        constraints.weightx = 1;
        constraints.weighty = 1;
        f.add(canvas = new AWTGLCanvas(data) {

            @Override
            public void initGL() {
                GL.createCapabilities();
                GL33.glClearColor(1.0f, 0.0f, 0.0f, 1);
            }

            @Override
            public void paintGL() {
                GL33.glClearColor(1.0f, 0.0f, 0.0f, 1);
                swapBuffers();

            }

        }, constraints);

        canvas.setBounds(0, 0, 100, 100);

        f.setBounds(0, 0, 100, 100);

        f.setVisible(true);

        Runnable drawLoop = new Runnable() {

            @Override
            public void run() {
                if (!canvas.isValid()) {
                    GL.setCapabilities(null);
                    return;
                }
                canvas.render();
                SwingUtilities.invokeLater(this);
            }

        };

        SwingUtilities.invokeLater(drawLoop);

    }
}