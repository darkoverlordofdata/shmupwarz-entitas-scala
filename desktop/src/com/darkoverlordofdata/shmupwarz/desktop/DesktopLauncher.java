package com.darkoverlordofdata.shmupwarz.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.darkoverlordofdata.shmupwarz.Shmupwarz;
import com.darkoverlordofdata.entitas.Version;

public class DesktopLauncher {
	public static void main (String[] arg) {
		final boolean desktop = true;
		final float scale = 1.5f;
		final int width = 1050;// desktop?700:(int)(350*scale);
		final int height = 720;//(int)(480*scale);

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = height;
    config.width = width;
		new LwjglApplication(new Shmupwarz(desktop, scale), config);
		System.out.println("Version ");
		System.out.println(Version.toString());
	}
}
