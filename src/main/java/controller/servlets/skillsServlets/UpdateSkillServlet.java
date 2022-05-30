package controller.servlets.skillsServlets;

import config.DataBaseManagerConnector;
import config.HikariProvider;
import config.PropertiesUtil;
import dl.SkillsRepository;
import model.converter.SkillsConverter;
import model.dto.DevelopersDto;
import model.dto.SkillsDto;
import service.SkillsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateSkill")
public class UpdateSkillServlet extends HttpServlet {


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
        this.doPut(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String syntax = req.getParameter("syntaxName");
        String rank = req.getParameter("skillRank");
        SkillsDto skill = new SkillsDto(id, rank, syntax);
        service.update(skill);
        resp.sendRedirect("/skillsPage");
    }
}
