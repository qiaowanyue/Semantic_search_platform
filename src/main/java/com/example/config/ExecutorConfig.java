package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ExecutorConfig {
    /** 核心线程数（默认线程数） */
    private static final int corePoolSize = 10;
    /** 最大线程数 */
    private static final int maxPoolSize = 15;
    /** 允许线程空闲时间（单位：默认为秒） */
    private static final int keepAliveTime = 10;
    /** 缓冲队列大小 */
    private static final int queueCapacity = 25;
    /** 线程池名前缀 */
    private static final String threadNamePrefix = "async-";

    /**
     * 线程池
     *
     * @return
     */
    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // Wait for all tasks to complete before continuing to destroy other beans
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // The waiting time for a task in the thread pool, and if it is not destroyed by this time, force destruction to ensure that the application can eventually be shut down, rather than blocked
        executor.setAwaitTerminationSeconds(60);
        executor.initialize();
        return executor;
    }

}
