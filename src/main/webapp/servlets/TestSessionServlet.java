package main.webapp.servlets;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import javax.servlet.http.*;

import main.webapp.scopes.*;

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
            HttpSession session = req.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            req.getSession(true);
        }

        HelloGeneratorSession sessionScopedBean = webAppContext.getBean(HelloGeneratorSession.class);
        System.out.println(sessionScopedBean);
        System.out.println(sessionScopedBean.getMessage());
    }
}
