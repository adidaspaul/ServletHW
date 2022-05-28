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

@WebServlet(urlPatterns = "/updateDev")
public class UpdateDev extends HttpServlet {

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPut(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String devName = req.getParameter("devName");
        String devSex = req.getParameter("devsSex");
        Double devSalary = Double.parseDouble(req.getParameter("devSalary"));
        DevelopersDto dev = new DevelopersDto(id, devName, devSex, devSalary);
        service.update(dev);
        resp.sendRedirect("/showAllDeveloperInfo");
    }
}
