# Tomcat 10 Shutdown Demo

This sample Spring application demonstrates how to properly handle shutdown events in Tomcat 10.

## Overview

This application shows three different approaches to handling Tomcat 10 shutdown events:

1. Jakarta Servlet Context Listener
2. Spring DisposableBean interface
3. Spring SmartLifecycle interface

All three methods are implemented to ensure your application properly cleans up resources during shutdown.

## Key Features

- Demonstrates proper Jakarta EE (not javax) imports for Tomcat 10 compatibility
- Shows how to access Spring beans during shutdown
- Implements multiple shutdown strategies for resilience
- Includes proper logging configuration with Logback

## Project Structure

```
src/main/java/
├── com/example/
│   ├── controller/
│   │   └── SampleController.java
│   ├── service/
│   │   └── ShutdownService.java
│   └── shutdown/
│       └── CustomShutdownListener.java
│
src/main/resources/
└── logback.xml

src/main/webapp/
└── WEB-INF/
    ├── applicationContext.xml
    ├── dispatcher-servlet.xml
    ├── web.xml
    └── views/
        └── home.jsp
```

## Building and Running

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- Tomcat 10.x

### Build the Application
```
mvn clean package
```

### Deploy to Tomcat
1. Copy the generated WAR file from `target/tomcat10-shutdown-demo.war` to Tomcat's `webapps` directory.
2. Start Tomcat: `{TOMCAT_HOME}/bin/startup.sh` (or startup.bat on Windows)
3. Access the application at: http://localhost:8080/tomcat10-shutdown-demo/

### Testing Shutdown Events
1. View the logs at `{TOMCAT_HOME}/logs/tomcat10-shutdown-demo.log`
2. Shut down Tomcat gracefully using `{TOMCAT_HOME}/bin/shutdown.sh` (or shutdown.bat on Windows)
3. Check the logs again to see that the shutdown hooks were triggered

## Common Issues

1. **Context Not Found During Shutdown**: Ensure your web.xml correctly specifies the ContextLoaderListener.
2. **Shutdown Methods Not Called**: Verify you're using the correct Jakarta EE imports, not javax.
3. **Timing Issues**: Use the SmartLifecycle interface to control shutdown timing.

## License
MIT
