package dl;

import config.DataBaseManagerConnector;
import config.HikariProvider;
import model.dao.CompaniesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompaniesRepository implements Repository<CompaniesDao> {

    private final DataBaseManagerConnector connector;

    private static final String SELECT_ALL_COMPANIES = "SELECT * FROM companies";
    private static final String UPDATE_COMPANY = "UPDATE companies SET company_name = ?, city = ? WHERE id = ?";
    private static final String DELETE_COMPANY_BY_ID = "DELETE FROM companies WHERE id = ?";
    private static final String FIND_BY_ID = "SELECT * FROM companies c WHERE c.id = ?";
    private static final String INSERT = "INSERT INTO companies (company_name, city) VALUES (?, ?)";
    private static final String INSERT_WITH_ID = "INSERT INTO companies (id, company_name, city) VALUES (?, ?, ?)";
    private static final String FIND_BY_NAME = "SELECT * FROM companies c WHERE c.company_name = ?";

    public CompaniesRepository(DataBaseManagerConnector connector) {
        this.connector = connector;
    }

    @Override
    public CompaniesDao findById(Integer id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            return mapToCompaniesDao(resultSet);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private CompaniesDao mapToCompaniesDao(ResultSet resultSet) throws SQLException {
        CompaniesDao companiesDao = new CompaniesDao();
        while (resultSet.next()) {
            companiesDao.setId(resultSet.getInt("id"));
            companiesDao.setCompanyName(resultSet.getString("company_name"));
            companiesDao.setCity(resultSet.getString("city"));
        }
        return companiesDao;
    }

    @Override
    public Integer save(CompaniesDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(1, entity.getCompanyName());
            statement.setString(2, entity.getCity());
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
    public void saveWithId(CompaniesDao entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_WITH_ID)) {
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getCompanyName());
            statement.setString(3, entity.getCity());
            statement.execute();
        } catch (SQLException e) {
            System.out.println("!!!The ID already exists!!!");
        }
    }

    @Override
    public int update(CompaniesDao entity) {
        int columnsUpdated = 0;
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_COMPANY)) {
            statement.setString(1, entity.getCompanyName());
            statement.setString(2, entity.getCity());
            statement.setInt(3, entity.getId());
            columnsUpdated = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnsUpdated;
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_COMPANY_BY_ID)) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CompaniesDao> selectAll() {
        List<CompaniesDao> coDaoList = new ArrayList<>();
        try(Connection connection = connector.getConnection();
        PreparedStatement statement = connection.prepareStatement(SELECT_ALL_COMPANIES)) {
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                CompaniesDao coDao = new CompaniesDao();
                coDao.setId(resultSet.getInt("id"));
                coDao.setCompanyName(resultSet.getString("company_name"));
                coDao.setCity(resultSet.getString("city"));
                coDaoList.add(coDao);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return coDaoList;
    }
    public CompaniesDao findByName(String name) {
        try (Connection connection = connector.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            return mapToCompaniesDao(resultSet);
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
