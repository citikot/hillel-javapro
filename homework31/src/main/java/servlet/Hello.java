package servlet;

import java.io.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "servlet.Hello", urlPatterns = "/hello")
public class Hello extends HttpServlet {
    private String message;
    public static final Logger log = LoggerFactory.getLogger(Hello.class);

    @Override
    public void init() {
        log.info("Servlet initialized.");
        message = "Hello World!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        log.info("Servlet doGet() method is called.");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        log.info("Servlet destroyed!");
    }
}