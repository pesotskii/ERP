package erp.listeners;

import java.sql.Driver;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

//  Since Tomcat 6+ cannot deregister jdbc drivers, we will deregister them manually
//  For this we add Listener that will be used on webapp finish

public class ContextCleanupListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public final void contextDestroyed(ServletContextEvent sce) {

        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        // Loop through all drivers
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            if (driver.getClass().getClassLoader() == cl) {
                // This driver was registered by the webapp's ClassLoader, so deregister it:
                try {
                    DriverManager.deregisterDriver(driver);
                } catch (SQLException ex) {
                    System.err.println(ex.getMessage());
                }
            } else {
                // driver was not registered by the webapp's ClassLoader and may be in use elsewhere
                System.out.println("Not deregistering JDBC driver as it does not belong to this webapp's ClassLoader");
            }
        }
    }
}