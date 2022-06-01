package controller.servlets.clientsServlets;

import config.DataBaseManagerConnector;
import config.HikariProvider;
import config.PropertiesUtil;
import dl.ClientsRepository;
import model.converter.ClientsConverter;
import model.dto.ClientsDto;
import service.ClientsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/clientsPage")
public class ClientsPage extends HttpServlet {

    ClientsService service;
    @Override
    public void init() {
        PropertiesUtil props = new PropertiesUtil(getServletContext());
        DataBaseManagerConnector connector = new HikariProvider(props.getHostname(),
                props.getPort(), props.getSchema(), props.getUser(),
                props.getPassword(), props.getJdbcDriver());
        service = new ClientsService(new ClientsConverter(), new ClientsRepository(connector));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ClientsDto> list = service.findAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/JSP/clientsPage.jsp").forward(req, resp);
    }
}
