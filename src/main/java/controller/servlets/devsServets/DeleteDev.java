package controller.servlets.devsServets;

import config.DataBaseManagerConnector;
import config.HikariProvider;
import config.PropertiesUtil;
import dl.DevelopersRepository;
import model.converter.DevelopersConverter;
import service.DevelopersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns="/removeDeveloper")
public class DeleteDev extends HttpServlet {

    private DevelopersService service;

    @Override
    public void init(){
        PropertiesUtil props = new PropertiesUtil(getServletContext());
        DataBaseManagerConnector connector = new HikariProvider(props.getHostname(),
                props.getPort(),props.getSchema(),props.getUser(),
                props.getPassword(),props.getJdbcDriver());
        service = new DevelopersService(new DevelopersConverter(), new DevelopersRepository(connector));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doDelete(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String devId = req.getParameter("devId");
        service.delete(Integer.parseInt(devId));
        resp.sendRedirect("/showAllDeveloperInfo");
    }
}
