package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BetterRadarTest {

	@Rule
	public RepeatRule repeatRule = new RepeatRule();

	@Mock
	PatriotBattery batteryMock;

	@Before
	public void setUp() {
		batteryMock = mock(PatriotBattery.class);
	}

	@Test
	@RepeatRule.Repeat(times = 10)
	public void launchTwoRocketsInTestThread() {

		RocketLauncher launcher = new RocketLauncher(false);
		BetterRadar radar = new BetterRadar(batteryMock, launcher, 2);

		radar.notice(new Scud());
		verify(batteryMock, times(2)).launchPatriot();
	}

}
