package dl;

import config.DataBaseManagerConnector;
import model.dao.DevelopersDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DevelopersRepository implements Repository<DevelopersDao> {

    private final DataBaseManagerConnector connector;
    private static final String SELECT_ALL_DEVELOPERS = "SELECT * FROM developers";
    private static final String UPDATE_DEVELOPER = "UPDATE developers SET name = ?, sex = ?, salary = ? WHERE id = ?";
    private static final String DELETE_DEV_BY_ID = "DELETE FROM developers WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM developers d WHERE d.id = ?";
    private static final String INSERT = "INSERT INTO developers (name, sex, salary) VALUES (?, ?, ?)";
    private static final String INSERT_WITH_ID = "INSERT INTO developers (id, name, sex, salary) VALUES (?, ?, ?, ?)";
    private static final String FIND_BY_NAME = "SELECT id, name, sex, salary FROM developers WHERE name = ?";


    public DevelopersRepository(DataBaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public DevelopersDao findById(Integer id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return mapToDevelopersDao(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public DevelopersDao findByName(String name) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            return mapToDevelopersDao(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<DevelopersDao> selectAll() {
        List<DevelopersDao> developers = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_DEVELOPERS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DevelopersDao developersDao = new DevelopersDao();
                developersDao.setId(resultSet.getInt("id"));
                developersDao.setName(resultSet.getString("name"));
                developersDao.setSex(resultSet.getString("sex"));
                developersDao.setSalary(resultSet.getDouble("salary"));
                developers.add(developersDao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developers;
    }

    @Override
    public Integer save(DevelopersDao developer) {

        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, developer.getName());
            statement.setString(2, developer.getSex());
            statement.setDouble(3, developer.getSalary());
            statement.execute();
            ResultSet generatedKey = statement.getGeneratedKeys();
            if(generatedKey.next()){
                return generatedKey.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveWithId(DevelopersDao developer) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_WITH_ID)) {
            statement.setInt(1, developer.getId());
            statement.setString(2, developer.getName());
            statement.setString(3, developer.getSex());
            statement.setDouble(4, developer.getSalary());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(DevelopersDao entity) {
        int columnsUpdated = 0;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_DEVELOPER)) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getSex());
            statement.setDouble(3, entity.getSalary());
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
             PreparedStatement statement = connection.prepareStatement(DELETE_DEV_BY_ID)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DevelopersDao mapToDevelopersDao(ResultSet resultSet) throws SQLException {
        DevelopersDao developersDao = new DevelopersDao();
        while (resultSet.next()) {
            developersDao.setId(resultSet.getInt("id"));
            developersDao.setName(resultSet.getString("name"));
            developersDao.setSex(resultSet.getString("sex"));
            developersDao.setSalary(resultSet.getDouble("salary"));
        }
        return developersDao;
    }
}
