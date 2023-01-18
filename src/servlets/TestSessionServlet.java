package servlets;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import scopes.Config;
import scopes.HelloGeneratorSession;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestSessionServlet extends HttpServlet {
    AnnotationConfigWebApplicationContext webAppContext;

    @Override
    public void init() {
        webAppContext = new AnnotationConfigWebApplicationContext();
        webAppContext.register(Config.class);
        webAppContext.refresh();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getPathInfo() != null) { //create new session
            req.getSession(false).invalidate();
            req.getSession(true);
        }

        HelloGeneratorSession sessionScopedBean = webAppContext.getBean(HelloGeneratorSession.class);
        System.out.println(sessionScopedBean);
        System.out.println(sessionScopedBean.getMessage());
    }
}
