package edu.iis.mto.multithread;

import org.junit.Test;

import java.util.concurrent.Executor;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    @Test
    public void launchPatriotsWhenNoticesAScudMissle1(){
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Executor executor = new RadarExecutor(ExecutorOptions.CURRENT_THREAD);
        BetterRadar radar = new BetterRadar(batteryMock, 1, executor);
        radar.notice(new Scud());
        verify(batteryMock, atLeast(1)).launchPatriot();
    }

    @Test
    public void launchPatriotsWhenNoticesAScudMissle2(){
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Executor executor = new RadarExecutor(ExecutorOptions.CURRENT_THREAD);
        BetterRadar radar = new BetterRadar(batteryMock, 2, executor);
        radar.notice(new Scud());
        verify(batteryMock, atLeast(1)).launchPatriot();
    }

    @Test
    public void launchPatriotsWhenNoticesAScudMissle3(){
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Executor executor = new RadarExecutor(ExecutorOptions.CURRENT_THREAD);
        BetterRadar radar = new BetterRadar(batteryMock, 2, executor);
        radar.notice(new Scud());
        radar.notice(new Scud());
        radar.notice(new Scud());
        verify(batteryMock, atLeast(6)).launchPatriot();
    }

}
