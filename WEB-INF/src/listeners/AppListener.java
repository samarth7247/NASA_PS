package listeners;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;





@WebListener 
public class AppListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent ev) {
        ServletContext context = ev.getServletContext();

        // Database connection parameters
        String dbURL = context.getInitParameter("dbURL");
        String dbUser = context.getInitParameter("dbUser");
        String dbPassword = context.getInitParameter("dbPassword");

        System.out.println("####################################");
        System.out.println("DB URL: " + dbURL);
        System.out.println("DB User: " + dbUser);
        System.out.println("DB Password: " + (dbPassword != null ? "********" : null));
         
        
    }
    



    @Override
    public void contextDestroyed(ServletContextEvent ev) {
        System.out.println("################### Application context destroyed #########################");
    }
}
