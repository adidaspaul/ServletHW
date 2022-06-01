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


@WebServlet(urlPatterns = "/findProjectById")
public class FindProjectByIdServlet extends HttpServlet {

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectId = req.getParameter("id");
        ProjectsDto project = service.findById(Integer.parseInt(projectId));
        req.setAttribute("project", project);
        req.getRequestDispatcher("/JSP/findProjectById.jsp").forward(req, resp);
    }
}
