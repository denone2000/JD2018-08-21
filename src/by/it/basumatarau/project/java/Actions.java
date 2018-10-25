package by.it.basumatarau.project.java;

public enum Actions {

    INDEX {{
        this.jsp = "/index.jsp";
    }},
    LOGIN {{
        this.jsp = "/login.jsp";
    }}, LOGOUT {{
        this.jsp = "/logout.jsp";
    }}, SIGNUP {{
        this.jsp = "/signup.jsp";
    }},CREATEVENUE {{
        this.jsp = "/createVenue.jsp";
    }},LISTWENUES{{
        this.jsp = "/listVenues.jsp";
    }};

    public String jsp = "/error.jsp";


}
