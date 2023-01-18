package servlets;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import javax.servlet.http.*;

import main.webapp.scopes.*;

public class TestAppServlet extends HttpServlet {
    AnnotationConfigWebApplicationContext webAppContext;

    @Override
    public void init() {
        webAppContext = new AnnotationConfigWebApplicationContext();
        webAppContext.register(Config.class);
        webAppContext.refresh();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HelloGeneratorApp appScopedBean = webAppContext.getBean(HelloGeneratorApp.class);
        System.out.println(appScopedBean);
        System.out.println(appScopedBean.getMessage());
    }
}
