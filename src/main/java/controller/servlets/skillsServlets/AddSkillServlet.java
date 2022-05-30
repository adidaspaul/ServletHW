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

@WebServlet(urlPatterns="/addSkill")
public class AddSkillServlet extends HttpServlet {
    SkillsService service;

    @Override
    public void init() {
        PropertiesUtil props = new PropertiesUtil(getServletContext());
        DataBaseManagerConnector connector = new HikariProvider(props.getHostname(),
                props.getPort(),props.getSchema(),props.getUser(),
                props.getPassword(),props.getJdbcDriver());
        service = new SkillsService(new SkillsConverter(), new SkillsRepository(connector));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String syntax = req.getParameter("skillSyntax");
        String rank = req.getParameter("skillRank");
        SkillsDto skill = new SkillsDto();
        skill.setSyntax(syntax);
        skill.setRank(rank);
        service.save(skill);
        resp.sendRedirect("/skillsPage");
    }
}
