package com.mygdx.project;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class MyGdx extends ApplicationAdapter {
	ShapeRenderer shapeRenderer;
	Array<Vector2> coordinates;
	Vector2 coor1,coor2;
	int x1,x2,y1,y2,dx,dy,po, duaDy,duaDyDx;
	
	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
		initBresenham();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shapeRenderer.begin(ShapeRenderer.ShapeType.Point);
//		TODO : Create a logic to draw a point from bresenham Algorithm
		for (Vector2 titik : coordinates){
			shapeRenderer.point(titik.x, titik.y,0);
		}
		shapeRenderer.end();

	}
	@Override
	public void resize (int width, int height) {
		shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void dispose () {
        shapeRenderer.dispose();
	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

//	TODO : create method to draw a point
//	this method implement Bresenham Algorithm
	public void initBresenham(){
		coordinates = new Array<Vector2>();
		coor1 = new Vector2();
		coor2 = new Vector2();
		coor1.add(400, 100);
		coor2.add(800, 600);
		x1 = (int) coor1.x;
		x2 = (int) coor2.x;
		y1 = (int) coor1.y;
		y2 = (int) coor2.y;
		dx = x2-x1;
		dy = y2-y1;
		po = 2*dy-dx;
		duaDy = 2*dy;
		duaDyDx = 2*(dy-dx);

		for (int i = 0; i <= y2-y1; i++){
			if (po>0){
				po+=duaDyDx;
				coor1.x += 1;
				coor1.y += 1;
				coordinates.add(new Vector2(coor1.x, coor1.y));
				continue;
			}else if (po < 0){
				po+=duaDy;
				coor1.x += 1;
				coordinates.add(new Vector2(coor1.x, coor1.y));
				continue;
			}
		}
	}

}
