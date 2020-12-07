package Entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
    private Vector3f position  = new Vector3f(100, 35, 50);
    private float pitch = 10, yaw = 0, roll;
    private boolean cameraMovement;

    public Camera() {}

    public void move() {
        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
            System.exit(0);
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_C)) {
            cameraMovement = !cameraMovement;
        }

        if (cameraMovement) {
            if(Keyboard.isKeyDown(Keyboard.KEY_K)){
                if (position.z < 0) {
                    if (Keyboard.isKeyDown(Keyboard.KEY_LMENU)) {
                        position.z += 0.35f;
                    } else {
                        position.z += 0.70f;
                    }
                }
            }

            if(Keyboard.isKeyDown(Keyboard.KEY_L)){
                if (position.x < 790) {
                    if (Keyboard.isKeyDown(Keyboard.KEY_LMENU)) {
                        position.x += 0.35f;
                    } else {
                        position.x += 0.70f;
                    }
                }
            }

            if(Keyboard.isKeyDown(Keyboard.KEY_I)){
                if (position.z > -760) {
                    if(Keyboard.isKeyDown(Keyboard.KEY_LMENU)) {
                        position.z -= 0.35f;
                    } else {
                        position.z -= 0.70f;
                    }
                }
            }

            if(Keyboard.isKeyDown(Keyboard.KEY_J)){
                if (position.x > -790) {
                    if(Keyboard.isKeyDown(Keyboard.KEY_LMENU)) {
                        position.x -= 0.35f;
                    } else {
                        position.x -= 0.70f;
                    }
                }
            }

            if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
                if (position.y <= 50) {
                    position.y += 0.70f;
                }
            }

            if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
                if (position.y >= 10) {
                    position.y -= 0.70f;
                }
            }
        }
    }

    public Vector3f getPosition() {
        return position;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getRoll() {
        return roll;
    }
}
