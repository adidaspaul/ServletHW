package controller.servlets.skillsServlets;

import config.DataBaseManagerConnector;
import config.HikariProvider;
import config.PropertiesUtil;
import dl.SkillsRepository;
import model.converter.SkillsConverter;
import model.dto.SkillsDto;
import service.SkillsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/skillsPage")
public class SkillsPageServlet extends HttpServlet {

   SkillsService service;

    @Override
    public void init(){
        PropertiesUtil props = new PropertiesUtil(getServletContext());
        DataBaseManagerConnector connector = new HikariProvider(props.getHostname(),
                props.getPort(),props.getSchema(),props.getUser(),
                props.getPassword(),props.getJdbcDriver());
        service = new SkillsService(new SkillsConverter(), new SkillsRepository(connector));
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SkillsDto> list = service.findAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/JSP/skillsPage.jsp").forward(req, resp);
    }
}
