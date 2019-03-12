package ua.prog.kiev.servlet;
import ua.prog.kiev.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class PersonServlet extends HttpServlet {

    static EntityManagerFactory entityManagerFactory;
    static EntityManager entityManager;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("datasent", false);
        req.getRequestDispatcher("person.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstname = req.getParameter("firstname");
        String secondname = req.getParameter("secondname");
        Integer age = Integer.valueOf(req.getParameter("age"));
        String phoneNumber = req.getParameter("phone");

        entityManagerFactory = Persistence.createEntityManagerFactory("PersonApp");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Person(firstname, secondname, age, phoneNumber));
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        req.setAttribute("datasent", true);
        req.getRequestDispatcher("person.jsp").forward(req, resp);
    }
}
