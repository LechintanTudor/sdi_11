package ro.ubbcluj.rabbit.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class Initializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        try (var context = new AnnotationConfigWebApplicationContext()) {
            context.scan("ro.ubbcluj.rabbit.web.config");
            var dispatcher = servletContext.addServlet("rabbit", new DispatcherServlet(context));
            dispatcher.setLoadOnStartup(1);
            dispatcher.addMapping("/api/*");
        } catch (Exception error) {
            throw new RuntimeException(error);
        }
    }
}
