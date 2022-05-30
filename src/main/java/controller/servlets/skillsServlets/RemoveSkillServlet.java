package controller.servlets.skillsServlets;

import config.DataBaseManagerConnector;
import config.HikariProvider;
import config.PropertiesUtil;
import dl.SkillsRepository;
import model.converter.SkillsConverter;
import service.SkillsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/removeSkill")
public class RemoveSkillServlet extends HttpServlet {

    SkillsService service;

    @Override
    public void init() throws ServletException {
        PropertiesUtil props = new PropertiesUtil(getServletContext());
        DataBaseManagerConnector connector = new HikariProvider(props.getHostname(),
                props.getPort(),props.getSchema(),props.getUser(),
                props.getPassword(),props.getJdbcDriver());
        service = new SkillsService(new SkillsConverter(), new SkillsRepository(connector));
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doDelete(req,resp);
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String skillId = req.getParameter("id");
        service.delete(Integer.parseInt(skillId));
        resp.sendRedirect("/skillsPage");
    }


}
