package by.it.galushka.project.java;

public enum Action {

    INDEX {{
        this.jsp = "/index.jsp";
    }},
    LOGIN {{
        this.jsp = "/login.jsp";
    }},
    SIGNUP {{
        this.jsp = "/logout.jsp";
    }},
    LOGOUT {{
        this.jsp = "/signup.jsp";
    }};

    public String jsp = "/error.jsp";
}
