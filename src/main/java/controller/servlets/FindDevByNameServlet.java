package controller.servlets;

import config.DataBaseManagerConnector;
import config.HikariProvider;
import config.PropertiesUtil;
import dl.DevelopersRepository;
import dl.Repository;
import model.converter.DevelopersConverter;
import model.dao.DevelopersDao;
import model.dto.DevelopersDto;
import service.DevelopersService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/findDeveloperByName")

public class FindDevByNameServlet extends HttpServlet {
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
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String devsName =   req.getParameter("devsName");
    DevelopersDto dev = service.findByName(devsName);
    req.setAttribute("devs", dev);
    req.getRequestDispatcher("/JSP/findDeveloperByNameForm.jsp").forward(req, resp);

    }


}
