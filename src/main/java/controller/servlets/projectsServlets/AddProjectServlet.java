package controller.servlets.projectsServlets;

import config.DataBaseManagerConnector;
import config.HikariProvider;
import config.PropertiesUtil;
import dl.ProjectsRepository;
import model.converter.ProjectsConverter;
import model.dto.ProjectsDto;
import service.ProjectsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;


@WebServlet(urlPatterns = "/addProject")
public class AddProjectServlet extends HttpServlet {

    ProjectsService service;

    @Override
    public void init() {
        PropertiesUtil props = new PropertiesUtil(getServletContext());
        DataBaseManagerConnector connector = new HikariProvider(props.getHostname(),
                props.getPort(), props.getSchema(), props.getUser(),
                props.getPassword(), props.getJdbcDriver());
        service = new ProjectsService(new ProjectsConverter(), new ProjectsRepository(connector));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("projectName");
        Date startDate = Date.valueOf(req.getParameter("projectDate"));
        Double cost = Double.parseDouble(req.getParameter("projectCost"));
        ProjectsDto project = new ProjectsDto();
        project.setProjectName(name);
        project.setStartDate(startDate);
        project.setCost(cost);
        service.save(project);
        resp.sendRedirect("/projectsPage");
    }
}
