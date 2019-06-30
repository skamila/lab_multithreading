package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class RadarExecutor implements Executor {

    private ExecutorOptions executorOptions;

    public RadarExecutor(ExecutorOptions executorOptions) {
        this.executorOptions = executorOptions;
    }

    @Override
    public void execute(Runnable command) {
        if (executorOptions == ExecutorOptions.CURRENT_THREAD) {
            command.run();
        } else if (executorOptions == ExecutorOptions.NEW_THREAD) {
            new Thread(command).start();
        } else {
            throw new NullPointerException();
        }
    }
}
