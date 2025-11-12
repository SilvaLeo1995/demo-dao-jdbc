package model.entities;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class SellerTest {

    private Department mockDepartment = new Department(10, "Mock Dept");

    @Test
    void testEquals_SameId_ShouldBeTrue() {
        Seller s1 = new Seller(5, "Leonardo Gabriel", "Lg@test.com", new Date(), 3000.0, mockDepartment);
        Seller s2 = new Seller(5, "Carlos Lucio", "Cl@test.com", new Date(), 4500.0, mockDepartment);

        assertTrue(s1.equals(s2),
                "Vendedores com o mesmo ID devem ser considerados iguais.");
    }

    @Test
    void testEquals_DifferentId_ShouldBeFalse() {
        Seller s1 = new Seller(5, "Leonardo Gabriel", "Lg@test.com", new Date(), 3000.0, mockDepartment);
        Seller s2 = new Seller(6, "Leonardo Gabriel", "Lg@test.com", new Date(), 3000.0, mockDepartment);

        assertFalse(s1.equals(s2),
                "Vendedores com IDs diferentes não devem ser iguais.");
    }

    @Test
    void testFullConstructorAndGetters() {
        Date mockDate = new Date();
        Seller newSeller = new Seller(7, "Test Name", "test@mail.com", mockDate, 1500.0, mockDepartment);

        assertEquals(7, newSeller.getId(), "ID deve ser 7.");
        assertEquals("Test Name", newSeller.getName(), "Nome deve ser 'Test Name'.");
        assertEquals(1500.0, newSeller.getBaseSalary(), 0.001, "Salário deve ser 1500.0.");
        assertEquals(mockDepartment, newSeller.getDepartment(), "O Departamento deve ser o Mock Dept.");
    }
}

