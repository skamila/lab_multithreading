package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Executor;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    private PatriotBattery batteryMock;
    private Executor executor;

    @Before
    public void init() {
        batteryMock = mock(PatriotBattery.class);
        executor = new RadarExecutor(ExecutorOptions.CURRENT_THREAD);
    }

    @Test
    public void launchPatriotsWhenNoticesAScudMissle1() {
        BetterRadar radar = new BetterRadar(batteryMock, 1, executor);
        radar.notice(new Scud());
        verify(batteryMock, atLeast(1)).launchPatriot();
    }

    @Test
    public void launchPatriotsWhenNoticesAScudMissle2() {
        BetterRadar radar = new BetterRadar(batteryMock, 2, executor);
        radar.notice(new Scud());
        verify(batteryMock, atLeast(2)).launchPatriot();
    }

    @Test
    public void launchPatriotsWhenNoticesAScudMissle3() {
        BetterRadar radar = new BetterRadar(batteryMock, 2, executor);
        radar.notice(new Scud());
        radar.notice(new Scud());
        radar.notice(new Scud());
        verify(batteryMock, atLeast(6)).launchPatriot();
    }

}
