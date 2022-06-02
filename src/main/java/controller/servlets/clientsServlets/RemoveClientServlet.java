package controller.servlets.clientsServlets;

import config.DataBaseManagerConnector;
import config.HikariProvider;
import config.PropertiesUtil;
import dl.ClientsRepository;
import model.converter.ClientsConverter;
import service.ClientsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/removeClient")
public class RemoveClientServlet extends HttpServlet {

    ClientsService service;

    @Override
    public void init() throws ServletException {
        PropertiesUtil props = new PropertiesUtil(getServletContext());
        DataBaseManagerConnector connector = new HikariProvider(props.getHostname(), props.getPort(),
                props.getSchema(), props.getUser(), props.getPassword(), props.getJdbcDriver());
        service = new ClientsService(new ClientsConverter(), new ClientsRepository(connector));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doDelete(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        service.delete(id);
        resp.sendRedirect("/clientsPage");
    }
}

