package by.it.bindyuk.project.java;

public enum Actions {

    INDEX {
        {
            this.jsp = "/index.jsp";
        }
    }, LOGIN {
        {
            this.jsp = "/login.jsp";
        }
    }, LOGOUT {
        {
            this.jsp = "/logout.jsp";
        }
    }, SIGNUP {
        {
            this.jsp = "/signup.jsp";
        }
    }, TICKET {
        {
            this.jsp = "/ticket.jsp";
        }
    }, REGISTRATION {
        {
            this.jsp = "/registration.jsp";
        }
    };

    public String jsp = "/error.jsp";
}

