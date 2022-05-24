package controller.servlets.devsServets;

import config.DataBaseManagerConnector;
import config.HikariProvider;
import config.PropertiesUtil;
import dl.DevelopersRepository;
import model.converter.DevelopersConverter;
import model.dto.DevelopersDto;
import service.DevelopersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/showAllDeveloperInfo")
public class ShowAllDevelopersServlet extends HttpServlet {

    DevelopersService service;

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
        List<DevelopersDto> list = service.findAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/JSP/showAllDeveloperInfo.jsp").forward(req, resp);

    }
}
