package by.it.artemliashkov.jd03_03.dao;



public class Dao {
    private static Dao dao;

    public AgentDao agent;
    public CompanyDao company;
    public RoleDao role;

    private Dao() {
    }

    public static Dao getDAO() {
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null) {
                    dao = new Dao();
                    dao.agent = new AgentDao();
                    dao.company = new CompanyDao();
                    dao.role = new RoleDao();
                }
            }
        }
        return dao;
    }
}
