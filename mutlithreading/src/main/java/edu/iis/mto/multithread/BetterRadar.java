package edu.iis.mto.multithread;

public class BetterRadar {

	private PatriotBattery battery;
	private RocketLauncher launcher;
	private final int SALVO_SIZE;

	public BetterRadar(PatriotBattery battery, RocketLauncher launcher, int rocketPackSize) {
		this.SALVO_SIZE = rocketPackSize;
		this.battery = battery;
		this.launcher = launcher;
	}

	public void notice(Scud enemyMissle) {
		this.launcher.launchRockets(this.battery, SALVO_SIZE);
	}
}
