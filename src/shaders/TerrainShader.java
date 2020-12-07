package shaders;

import Entities.Camera;
import Entities.Light;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;
import toolBox.Maths;

public class TerrainShader extends ShaderProgram{

    private static final String VERTEX_FILE = "src/shaders/terrainVertexShader.glsl";
    private static final String FRAGMENT_FILE = "src/shaders/terrainFragmentShader.glsl";
    private int location_transformationMatrix, location_projectionMatrix, location_viewMatrix, location_lightPosition,
            location_lightColour, location_shineDamper, location_reflectivity, location_skyColour, location_backgroundTexture,
            location_redTexture, location_greenTexture, location_blueTexture, location_blendMap;

    public TerrainShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void bindAttributes() {
        super.bindAttributes(0, "position");
        super.bindAttributes(1, "textureCoords");
        super.bindAttributes(2, "normal");
    }

    @Override
    protected void getAllUniformLocations() {
        location_transformationMatrix = super.getAllUniformLocations("transformationMatrix");
        location_projectionMatrix = super.getAllUniformLocations("projectionMatrix");
        location_viewMatrix = super.getAllUniformLocations("viewMatrix");
        location_lightPosition = super.getAllUniformLocations("lightPosition");
        location_lightColour = super.getAllUniformLocations("lightColour");
        location_shineDamper = super.getAllUniformLocations("shineDamper");
        location_reflectivity = super.getAllUniformLocations("reflectivity");
        location_skyColour = super.getAllUniformLocations("skyColour");
        location_backgroundTexture = super.getAllUniformLocations("backgroundTexture");
        location_redTexture = super.getAllUniformLocations("redTexture");
        location_greenTexture = super.getAllUniformLocations("greenTexture");
        location_blueTexture = super.getAllUniformLocations("blueTexture");
        location_blendMap = super.getAllUniformLocations("blendMap");
    }

    public void connectTextureUnits() {
        super.loadInt(location_backgroundTexture, 0);
        super.loadInt(location_redTexture, 1);
        super.loadInt(location_greenTexture, 2);
        super.loadInt(location_blueTexture, 3);
        super.loadInt(location_blendMap, 4);
    }

    public void loadSkyColour(float r, float g, float b) {
        super.loadVector(location_skyColour, new Vector3f(r, g, b));
    }

    public void loadShineVariables(float damper, float reflectivity) {
        super.loadFloat(location_shineDamper, damper);
        super.loadFloat(location_reflectivity, reflectivity);
    }

    public void loadTransformationMatrix(Matrix4f matrix) {
        super.loadMatrix(location_transformationMatrix, matrix);
    }

    public void loadLight(Light light) {
        super.loadVector(location_lightPosition, light.getPosition());
        super.loadVector(location_lightColour, light.getColour());
    }

    public void loadViewMatrix(Camera camera) {
        Matrix4f viewMatrix = Maths.createViewMatrix(camera);
        super.loadMatrix(location_viewMatrix, viewMatrix);
    }

    public void loadProjectionMatrix(Matrix4f matrix) {
        super.loadMatrix(location_projectionMatrix, matrix);
    }
}
