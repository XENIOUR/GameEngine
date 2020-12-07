package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.*;
import org.newdawn.slick.opengl.ImageIOImageData;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class DisplayManager {

    private static final int WIDTH = 1366, HEIGHT = 768, FPS_CAP = 120;

    private static long lastFrameTime;
    private static float delta;

    public static void createDisplay() throws LWJGLException, IOException {
        ContextAttribs attributes = new ContextAttribs(3,2)
        .withForwardCompatible(true)
        .withProfileCore(true);

        Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
        Display.create(new PixelFormat(), attributes);
        Display.setTitle("Game Project");

        Display.setIcon(new ByteBuffer[] {
                new ImageIOImageData().imageToByteBuffer(ImageIO.read(new File("res/icons/gameIcon.png")), false, false, null)
        });

        GL11.glViewport(0,0, WIDTH, HEIGHT);
        lastFrameTime = getCurrentTime();
    }

    public static void updateDisplay() {
        Display.sync(FPS_CAP);
        Display.update();
        long currentFrameTime = getCurrentTime();
        delta = (currentFrameTime - lastFrameTime) / 1000f;
        lastFrameTime = currentFrameTime;
    }

    public static float getFrameTimeSec() {
        return delta;
    }

    public static void closeDisplay() {
        Display.destroy();
    }

    private static long getCurrentTime() {
        return Sys.getTime() * 1000 / Sys.getTimerResolution();
    }
}
