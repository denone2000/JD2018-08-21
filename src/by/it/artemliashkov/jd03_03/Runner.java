package by.it.artemliashkov.jd03_03;

import by.it.artemliashkov.jd03_03.beans.Agent;
import by.it.artemliashkov.jd03_03.beans.Company;
import by.it.artemliashkov.jd03_03.beans.Role;
import by.it.artemliashkov.jd03_03.dao.AgentDao;
import by.it.artemliashkov.jd03_03.dao.CompanyDao;
import by.it.artemliashkov.jd03_03.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws SQLException {
        Database.resetAndCreateDBWithTables();
        Dao dao = Dao.getDAO();
        System.out.println("Роли пользователей");
        for (Role role : dao.role.getAll("")) {
            System.out.println(role);
        }
        System.out.println("\n\n=================================== проверка агентов ===================================");
        showAgents();
        Agent agent = new Agent(0,"artem","ostroshitstskaia",1);
        if (dao.agent.create(agent))
            System.out.println("\nДобавлен:" + agent);
        showAgents();
        agent = dao.agent.getAll("WHERE Agents_id>2").get(0);
        agent.setName("artem");
        if (dao.agent.update(agent)) System.out.println("\nИзменен:" + agent);
        showAgents();
        if (dao.agent.delete(agent)) System.out.println("\nУдален:" + agent);
        showAgents();
        Company company = new Company(0,"TASK","insurance",  666,"ostrosh",1);
        if (dao.company.create(company))
            System.out.println("\nДобавлен:" + company);
        showCompanies();
    }


    private static void showCompanies() throws SQLException {
        System.out.println("\nТаблица компаний:");
        List<Company> companies = new CompanyDao().getAll("");
        for (Company each : companies) System.out.println(each);
    }


    private static void showAgents() throws SQLException {
        System.out.println("\nТаблица агентов:");
        List<Agent> agents = new AgentDao().getAll("");
        for (Agent each : agents) System.out.println(each);
    }
}
