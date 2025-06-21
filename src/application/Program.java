package application;

import model.entities.Department;
import model.entities.Seller;
import java.util.Date;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import java.util.List;
import java.util.Scanner;
import model.dao.DepartmentDao;
import model.entities.Department;


public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        SellerDao sellerDao = DaoFactory.createSellerDao();

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("\n=== TEST 1: Department findById =======");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("\n==== TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: Department findAll =======");
        List<Department> departmentList = departmentDao.findAll();
        for (Department d : departmentList) {
            System.out.println(d);
        }

        System.out.println("\n ==== TEST 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: Department insert =======");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());



        System.out.println("\n ==== TEST 3: seller findAll ====");
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: Department update =======");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Food");
        departmentDao.update(dep2);
        System.out.println("Update completed");


        System.out.println("\n ==== TEST 4: seller insert ====");
         Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000.0, department);
         sellerDao.insert(newSeller);
         System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n ==== TEST 5: seller update ====");
        seller = sellerDao.findById(1);
        seller.setName("Michael Owen");
        sellerDao.update(seller);
        System.out.println("Update complete!");

        System.out.println("\n=== TEST 5: Department delete =======");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");


        System.out.println("\n ==== TEST 6: seller delete ====");
        System.out.println("Enter id for delete test: ");
        int sellerId = sc.nextInt();
        sellerDao.deleteById(sellerId);
        System.out.println("Delete completed! ");

        sc.close();

    }
}
