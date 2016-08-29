package com.darkoverlordofdata.demo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.darkoverlordofdata.demo.Demo;
import com.darkoverlordofdata.entitas.Version;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Demo(), config);
		System.out.println("Version ");
		System.out.println(Version.toString());
	}
}
