package engineTester;

import Entities.Camera;
import Entities.Entity;
import Entities.Light;
import Entities.Player;
import models.TexturedModel;
import objConverter.ModelData;
import objConverter.OBJFileLoader;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;
import renderEngine.*;
import models.RawModel;
import terrains.Terrain;
import terrains.TerrainTexture;
import terrains.TerrainTexturePack;
import textures.ModelTexture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainGameLoop {
    public static void main (String[] args) throws LWJGLException, IOException {
        DisplayManager.createDisplay();
        Loader loader = new Loader();
        /*float[] vertices = {
                -0.5f,0.5f,-0.5f,
                -0.5f,-0.5f,-0.5f,
                0.5f,-0.5f,-0.5f,
                0.5f,0.5f,-0.5f,

                -0.5f,0.5f,0.5f,
                -0.5f,-0.5f,0.5f,
                0.5f,-0.5f,0.5f,
                0.5f,0.5f,0.5f,

                0.5f,0.5f,-0.5f,
                0.5f,-0.5f,-0.5f,
                0.5f,-0.5f,0.5f,
                0.5f,0.5f,0.5f,

                -0.5f,0.5f,-0.5f,
                -0.5f,-0.5f,-0.5f,
                -0.5f,-0.5f,0.5f,
                -0.5f,0.5f,0.5f,

                -0.5f,0.5f,0.5f,
                -0.5f,0.5f,-0.5f,
                0.5f,0.5f,-0.5f,
                0.5f,0.5f,0.5f,

                -0.5f,-0.5f,0.5f,
                -0.5f,-0.5f,-0.5f,
                0.5f,-0.5f,-0.5f,
                0.5f,-0.5f,0.5f

        };

        float[] textureCoords = {

                0,0,
                0,1,
                1,1,
                1,0,
                0,0,
                0,1,
                1,1,
                1,0,
                0,0,
                0,1,
                1,1,
                1,0,
                0,0,
                0,1,
                1,1,
                1,0,
                0,0,
                0,1,
                1,1,
                1,0,
                0,0,
                0,1,
                1,1,
                1,0


        };

        int[] indices = {
                0,1,3,
                3,1,2,
                4,5,7,
                7,5,6,
                8,9,11,
                11,9,10,
                12,13,15,
                15,13,14,
                16,17,19,
                19,17,18,
                20,21,23,
                23,21,22

        };*/

        /*RawModel tree = OBJLoader.loadObjModel("tree", loader);
        ModelTexture treeTexture = new ModelTexture(loader.loadTexture("tree"));
        TexturedModel texturedModel = new TexturedModel(tree, treeTexture);
        treeTexture = texturedModel.getTexture();
        treeTexture.setShineDamper(10);
        treeTexture.setReflectivity(1);*/

        //ModelData treeData = OBJFileLoader.loadOBJ("lowPolyTree");
        //RawModel treeModel = loader.loadToVAO(treeData.getVertices(), treeData.getTextureCoords(), treeData.getNormals(), treeData.getIndices());

        //Terrain Texture Pack
        TerrainTexture backgroundTexture = new TerrainTexture(loader.loadTexture("grass2"));
        TerrainTexture redTexture = new TerrainTexture(loader.loadTexture("Dirt"));
        TerrainTexture greenTexture = new TerrainTexture(loader.loadTexture("grassNflowers"));
        TerrainTexture blueTexture = new TerrainTexture(loader.loadTexture("path"));

        TerrainTexturePack terrainTexturePack = new TerrainTexturePack(backgroundTexture, redTexture, greenTexture, blueTexture);
        TerrainTexture blendMap = new TerrainTexture(loader.loadTexture("blendMap"));

        TexturedModel grass = new TexturedModel(OBJLoader.loadObjModel("grassModel", loader), new ModelTexture(loader.loadTexture("grassTexture")));
        grass.getTexture().setHasTransparency(true);
        grass.getTexture().setUseFakeLighting(true);

        TexturedModel fern = new TexturedModel(OBJLoader.loadObjModel("fern", loader), new ModelTexture(loader.loadTexture("fern")));
        fern.getTexture().setHasTransparency(true);

        TexturedModel flower = new TexturedModel(OBJLoader.loadObjModel("grassModel", loader), new ModelTexture(loader.loadTexture("flower")));
        flower.getTexture().setHasTransparency(true);
        flower.getTexture().setShineDamper(20);

        TexturedModel lowPolyTree = new TexturedModel(OBJLoader.loadObjModel("lowPolyTree", loader), new ModelTexture(loader.loadTexture("lowPolyTree")));
        lowPolyTree.getTexture().setHasTransparency(true);
        lowPolyTree.getTexture().setShineDamper(20);

        TexturedModel playerModel = new TexturedModel(OBJLoader.loadObjModel("bunny", loader), new ModelTexture(loader.loadTexture("image")));
        lowPolyTree.getTexture().setHasTransparency(true);
        lowPolyTree.getTexture().setShineDamper(20);

        Player player = new Player(playerModel, new Vector3f(100, 0, -50), 0, 0, 0, 1);

        List<Entity> entities = new ArrayList<>();
        Random random = new Random(676452);
        /*for(int i=0;i<100;i++){
            if (i % 7 == 0) {
                entities.add(new Entity(grass, new Vector3f(random.nextFloat()*400 - 200,0,random.nextFloat() * -400),0,0,0,1.8f));
                entities.add(new Entity(flower, new Vector3f(random.nextFloat()*400 - 200,0,random.nextFloat() * -400),0,0,0,2.3f));
            }

            if (i % 3 == 0) {
                entities.add(new Entity(fern, new Vector3f(random.nextFloat()*400 - 200,0,random.nextFloat() * -400),0, random.nextFloat() * 360,0,0.9f));
                entities.add(new Entity(lowPolyTree, new Vector3f(random.nextFloat()*800 - 400,0,random.nextFloat() * -600),0,0,0, random.nextFloat() * 1 + 1));
            }
        }*/

        //Entity entity = new Entity(texturedModel, new Vector3f(0, 0, -25), 0, 0, 0, 1);
        Light light = new Light(new Vector3f(20000,40000,2000), new Vector3f(1, 1, 1));

        Terrain terrain = new Terrain(0, -1, loader, terrainTexturePack, blendMap);
        Terrain terrain2 = new Terrain(-1, -1, loader, terrainTexturePack, blendMap);

        Camera camera = new Camera();
        MasterRenderer renderer = new MasterRenderer();

        while (!Display.isCloseRequested()) {
            //game logic
            //entity.increasePosition(0, 0, -0.1f);
            //entity.increaseRotation(0 , 1, 0);

            camera.move();
            player.move();
            renderer.processEntity(player);

            //rendering
            for(Entity entity:entities){
                renderer.processEntity(entity);
            }
            renderer.processTerrain(terrain);
            renderer.processTerrain(terrain2);

            renderer.render(light, camera);
            DisplayManager.updateDisplay();
        }
        renderer.cleanUp();
        loader.cleanUp();
        DisplayManager.closeDisplay();
    }
}
