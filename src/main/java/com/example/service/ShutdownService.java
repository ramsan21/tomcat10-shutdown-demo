package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Service;

@Service
public class ShutdownService implements DisposableBean, SmartLifecycle {
    
    private static final Logger logger = LoggerFactory.getLogger(ShutdownService.class);
    private volatile boolean running = false;
    
    public void performShutdownTasks() {
        logger.info("Executing shutdown tasks from ServletContextListener");
        // Add your shutdown logic here
        cleanupResources();
    }
    
    private void cleanupResources() {
        logger.info("Cleaning up application resources");
        try {
            // Simulate cleanup work
            logger.info("Closing database connections...");
            Thread.sleep(500);
            
            logger.info("Flushing cached data...");
            Thread.sleep(500);
            
            logger.info("Releasing file handles...");
            Thread.sleep(500);
            
            logger.info("All resources cleaned up successfully");
        } catch (InterruptedException e) {
            logger.error("Resource cleanup was interrupted", e);
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            logger.error("Error during resource cleanup", e);
        }
    }
    
    // DisposableBean implementation
    @Override
    public void destroy() throws Exception {
        logger.info("DisposableBean destroy method called");
        cleanupResources();
    }
    
    // SmartLifecycle implementation
    @Override
    public void start() {
        logger.info("Application lifecycle starting");
        this.running = true;
    }
    
    @Override
    public void stop() {
        logger.info("Application lifecycle stopping - Spring SmartLifecycle");
        cleanupResources();
        this.running = false;
    }
    
    @Override
    public boolean isRunning() {
        return running;
    }
    
    @Override
    public int getPhase() {
        // Lower phase value means this bean stops earlier in the shutdown process
        return 0;
    }
    
    @Override
    public boolean isAutoStartup() {
        return true;
    }
}
