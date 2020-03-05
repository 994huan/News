package com.fafu.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class TaskThreadPoolConfig {
    @Value("${spring.task.execution.pool.core-size}")
    private int corePoolSize;
    @Value("${spring.task.execution.pool.max-size}")
    private int maxPoolSize;
    @Value("${spring.task.execution.pool.keep-alive}")
    private int keepAliveSeconds;
    @Value("${spring.task.execution.pool.queue-capacity}")
    private int queueCapacity;
}
