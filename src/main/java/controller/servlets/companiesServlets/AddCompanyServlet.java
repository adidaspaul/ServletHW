package controller.servlets.companiesServlets;

import config.DataBaseManagerConnector;
import config.HikariProvider;
import config.PropertiesUtil;
import dl.CompaniesRepository;
import model.converter.CompaniesConverter;
import model.dto.CompaniesDto;
import service.CompaniesService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/addCompany")
public class AddCompanyServlet extends HttpServlet {

CompaniesService service;

    @Override
    public void init() {
        PropertiesUtil props = new PropertiesUtil(getServletContext());
        DataBaseManagerConnector connector = new HikariProvider(props.getHostname(),
                props.getPort(), props.getSchema(), props.getUser(),
                props.getPassword(), props.getJdbcDriver());
        service = new CompaniesService(new CompaniesConverter(), new CompaniesRepository(connector));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        CompaniesDto company = new CompaniesDto();
        company.setCompanyName(name);
        company.setCity(city);
        service.save(company);
        resp.sendRedirect("/companiesPage");
    }

}

