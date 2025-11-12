import Db.DB;
import Db.DbIntegrityException;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import org.junit.jupiter.api.*;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartmentDaoJDBCTest {

    private DepartmentDao dao;
    private Connection conn;

    @BeforeEach
    public void setup() {
        conn = DB.getConnection();
        dao = DaoFactory.createDepartmentDao();
    }

    @AfterEach
    public void tearDown() {
        DB.closeConnection();
    }

    @Test
    @Order(1)
    void deleteById_WithAssociatedSellers_ShouldThrowDbIntegrityException() {
        int departmentIdWithSellers = 2; // Esse ID deve estar relacionado a um Seller no BD

        assertThrows(DbIntegrityException.class, () -> {
            dao.deleteById(departmentIdWithSellers);
        }, "Deve lançar DbIntegrityException ao deletar um Departamento com Vendedores.");
    }

    @Test
    @Order(2)
    void deleteById_WithoutAssociatedSellers_ShouldCompleteSuccessfully() {
        int safeDepartmentId = 5; // Use um ID que não tenha Sellers associados

        assertDoesNotThrow(() -> {
            dao.deleteById(safeDepartmentId);
        }, "A deleção de um Departamento sem FKs associadas deve ser concluída sem exceção.");
    }
}

