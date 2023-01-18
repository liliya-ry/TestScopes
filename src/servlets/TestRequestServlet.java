package servlets;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import scopes.Config;
import scopes.HelloGeneratorRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestRequestServlet extends HttpServlet {
    AnnotationConfigWebApplicationContext webAppContext;

    @Override
    public void init() throws ServletException {
        webAppContext = new AnnotationConfigWebApplicationContext();
        webAppContext.register(Config.class);
        webAppContext.refresh();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HelloGeneratorRequest requestScopedBean = webAppContext.getBean(HelloGeneratorRequest.class);
        System.out.println(requestScopedBean);
        System.out.println(requestScopedBean.getMessage());
    }
}
