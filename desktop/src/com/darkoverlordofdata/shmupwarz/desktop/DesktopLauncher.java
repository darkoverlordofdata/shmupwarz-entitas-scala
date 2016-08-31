package com.darkoverlordofdata.shmupwarz.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.darkoverlordofdata.shmupwarz.Shmupwarz;
import com.darkoverlordofdata.entitas.Version;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Shmupwarz(), config);
		System.out.println("Version ");
		System.out.println(Version.toString());
	}
}
