package dl;

import config.DataBaseManagerConnector;
import model.dao.ProjectsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectsRepository implements Repository<ProjectsDao> {


    private DataBaseManagerConnector connector;

    private static final String SELECT_ALL_PROJECTS = "SELECT * FROM projects";
    private static final String UPDATE_PROJECT = "UPDATE projects SET project_name = ?, start_date = ?, cost = ? WHERE id = ?";
    private static final String DELETE_PROJECT_BY_ID = "DELETE FROM projects WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM projects p WHERE p.id = ?";
    private static final String INSERT = "INSERT INTO projects (project_name, start_date, cost) VALUES (?, ?, ?)";
    private static final String INSERT_WITH_ID = "INSERT INTO projects (id, project_name, start_date, cost) VALUES (?, ?, ?, ?)";
    private static final String FIND_BY_NAME = "SELECT id, project_name, start_date, cost FROM projects WHERE project_name = ?";
    public ProjectsRepository(DataBaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public ProjectsDao findById(Integer id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return mapToProjectsDao(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ProjectsDao mapToProjectsDao(ResultSet resultSet) throws SQLException {
        ProjectsDao pDao = new ProjectsDao();
        while (resultSet.next()) {
            pDao.setId(resultSet.getInt("id"));
            pDao.setProjectName(resultSet.getString("project_name"));
            pDao.setStartDate(resultSet.getDate("start_date"));
            pDao.setCost(resultSet.getDouble("cost"));
        }
        return pDao;
    }

    @Override
    public Integer save(ProjectsDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, entity.getProjectName());
            statement.setDate(2, entity.getStartDate());
            statement.setDouble(3, entity.getCost());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()){
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveWithId(ProjectsDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_WITH_ID)) {
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getProjectName());
            statement.setDouble(3, entity.getCost());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("!!!The ID already exists!!!");
        }

    }

    @Override
    public int update(ProjectsDao entity) {
        int columnsUpdated = 0;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PROJECT)) {
            statement.setString(1, entity.getProjectName());
            statement.setDate(2, entity.getStartDate());
            statement.setDouble(3, entity.getCost());
            statement.setInt(4, entity.getId());
            columnsUpdated = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnsUpdated;
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PROJECT_BY_ID)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProjectsDao> selectAll() {
        List<ProjectsDao> projects = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PROJECTS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ProjectsDao pDao = new ProjectsDao();
                pDao.setId(resultSet.getInt("id"));
                pDao.setProjectName(resultSet.getString("project_name"));
                pDao.setStartDate(resultSet.getDate("start_date"));
                pDao.setCost(resultSet.getDouble("cost"));
                projects.add(pDao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    public ProjectsDao findByName(String name) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            return mapToProjectsDao(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
