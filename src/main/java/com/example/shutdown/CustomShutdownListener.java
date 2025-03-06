package com.example.shutdown;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.service.ShutdownService;

public class CustomShutdownListener implements ServletContextListener {
    
    private static final Logger logger = LoggerFactory.getLogger(CustomShutdownListener.class);
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Application is starting up");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("Application shutdown event received - beginning graceful shutdown");
        
        try {
            // Get the Spring application context
            WebApplicationContext springContext = WebApplicationContextUtils
                    .getWebApplicationContext(sce.getServletContext());
            
            if (springContext != null) {
                // Get our shutdown service
                ShutdownService shutdownService = springContext.getBean(ShutdownService.class);
                shutdownService.performShutdownTasks();
            } else {
                logger.warn("Spring application context not found during shutdown");
            }
            
            logger.info("Application shutdown completed successfully");
        } catch (Exception e) {
            logger.error("Error during application shutdown", e);
        }
    }
}
