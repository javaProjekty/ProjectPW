package pl.edu.pw.fizyka.pojava.JankowskiOsinski.people;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.math.Vector2;

import pl.edu.pw.fizyka.pojava.JankowskiOsinski.map.TextureMapObjectRenderer;

public class Bot {

	public static final String toFilePath = "bot.png";

	TextureMapObjectRenderer tiledMapRenderer;
	MapLayer monsterLayer;
	MapObjects monsterObjects;
	List<MapObject> monsterList;

	public Bot(TextureMapObjectRenderer tiledMapRenderer) {
		this.tiledMapRenderer = tiledMapRenderer;
		monsterLayer = tiledMapRenderer.getMap().getLayers().get("monster");
		monsterObjects = monsterLayer.getObjects();
		monsterList = new ArrayList<>();
		monsterList.add(monsterObjects.get("dragon"));
		monsterList.add(monsterObjects.get("goblin"));
		monsterList.add(monsterObjects.get("demon"));
	}

	public void update(float delta) {
		for (MapObject mapObject : monsterList) {
			tiledMapRenderer.renderObject(mapObject);
		}
	}

	// getting position of the monster 
	public Vector2 position(String which) {
		return new Vector2((float)monsterList.get(0).getProperties().get("xPos"),
				(float)monsterList.get(0).getProperties().get("yPos"));
	}

}
