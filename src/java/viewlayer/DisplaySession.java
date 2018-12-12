/* 
 * This Project is the property of Kevin Fox.
 * Created for CST 8288 and George Kriger.
 * All Rights Reserved.
 */
package viewlayer;

import businesslogic.LogInLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferObjects_WJPA.Session;
import transferObjects_WJPA.Users;

/**
 * The Servlet used to display tables
 *
 * @author kevin
 */
public class DisplaySession extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("Ive made it into ProcessRequest");

        // create an EntityManagerFactory for the persistence unit
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory(
                        "Foxs.Kevin.Project2PU");

        // create an EntityManager for interacting with the persistence unit
        EntityManager entityManager
                = entityManagerFactory.createEntityManager();

        //Select all query
        TypedQuery<Session> findAllSessions = entityManager.createNamedQuery(
                "Session.findAll", Session.class);

        //Header for the output
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:MM");

        // The format and printing of each value in the database
        List<Session> SessionList = findAllSessions.getResultList();

        //Print the Sessions from the jpa in the table
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<section>\n"
                    + "<style>" + "h1{\n"
                    + "  font-size: 30px;\n"
                    + "  color: #fff;\n"
                    + "  text-transform: uppercase;\n"
                    + "  font-weight: 300;\n"
                    + "  text-align: center;\n"
                    + "  margin-bottom: 15px;\n"
                    + "}\n"
                    + "table{\n"
                    + "  font-size: 20px;"
                    + "  width:100%;\n"
                    + "  table-layout: fixed;\n"
                    + "}\n"
                    + ".tbl-header{\n"
                    + "  background-color: rgba(255,255,255,0.3);\n"
                    + " }\n"
                    + ".tbl-content{\n"
                    + "  height:300px;\n"
                    + "  font-size: 20px;"
                    + "  overflow-x:auto;\n"
                    + "  margin-top: 0px;\n"
                    + "  border: 1px solid rgba(255,255,255,0.3);\n"
                    + "}\n"
                    + "th{\n"
                    + "  padding: 20px 15px;\n"
                    + "  font-size: 20px;"
                    + "  text-align: left;\n"
                    + "  font-weight: 500;\n"
                    + "  font-size: 12px;\n"
                    + "  color: #fff;\n"
                    + "  text-transform: uppercase;\n"
                    + "}\n"
                    + "td{\n"
                    + "  padding: 15px;\n"
                    + "  font-size: 20px;"
                    + "  text-align: left;\n"
                    + "  vertical-align:middle;\n"
                    + "  font-weight: 300;\n"
                    + "  font-size: 12px;\n"
                    + "  color: #fff;\n"
                    + "  border-bottom: solid 1px rgba(255,255,255,0.1);\n"
                    + "}\n"
                    + "\n"
                    + "\n"
                    + "/* demo styles */\n"
                    + "\n"
                    + "@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);\n"
                    + "body{\n"
                    + "  background: -webkit-linear-gradient(left, #25c481, #25b7c4);\n"
                    + "  background: linear-gradient(to right, #25c481, #25b7c4);\n"
                    + "  font-family: 'Roboto', sans-serif;\n"
                    + "}\n"
                    + "section{\n"
                    + "  margin: 50px;\n"
                    + "}\n"
                    + "\n"
                    + "\n"
                    + "/* follow me template */\n"
                    + ".made-with-love {\n"
                    + "  margin-top: 40px;\n"
                    + "  padding: 10px;\n"
                    + "  clear: left;\n"
                    + "  text-align: center;\n"
                    + "  font-size: 10px;\n"
                    + "  font-family: arial;\n"
                    + "  color: #fff;\n"
                    + "}\n"
                    + ".made-with-love i {\n"
                    + "  font-style: normal;\n"
                    + "  color: #F50057;\n"
                    + "  font-size: 14px;\n"
                    + "  position: relative;\n"
                    + "  top: 2px;\n"
                    + "}\n"
                    + ".made-with-love a {\n"
                    + "  color: #fff;\n"
                    + "  text-decoration: none;\n"
                    + "}\n"
                    + ".made-with-love a:hover {\n"
                    + "  text-decoration: underline;\n"
                    + "}\n"
                    + "\n"
                    + "\n"
                    + "/* for custom scrollbar for webkit browser*/\n"
                    + "\n"
                    + "::-webkit-scrollbar {\n"
                    + "    width: 6px;\n"
                    + "} \n"
                    + "::-webkit-scrollbar-track {\n"
                    + "    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); \n"
                    + "} \n"
                    + "::-webkit-scrollbar-thumb {\n"
                    + "    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); \n"
                    + "}"
                    + "</style>"
                    + "<script>" + "$(window).on(\"load resize \", function() {\n"
                    + "  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();\n"
                    + "  $('.tbl-header').css({'padding-right':scrollWidth});\n"
                    + "}).resize();"
                    //Start of the webpage 

                    + "</script>"
                    + "  <!--for demo wrap-->\n"
                    + "  <h1>Displaying Sessions</h1>\n"
                    + "  <div class=\"tbl-header\">\n"
                    + "    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n"
                    + "      <thead>\n"
                    + "        <tr>\n"
                    + "          <th>Date</th>\n"
                    + "          <th>Time</th>\n"
                    + "          <th>Student Last Name</th>\n"
                    + "          <th>Session Status</th>\n"
                    + "          <th>Session Topic</th>\n"
                    + "          <th>Tutor ID</th>\n"
                    + "          <th>Course Code</th>\n"
                    + "          <th>Student ID</th>\n"
                    + "        </tr>\n"
                    + "      </thead>\n"
                    + "    </table>\n"
                    + "  </div>\n"
                    + "  <div class=\"tbl-content\">\n"
                    + "    <table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n"
                    + "      <tbody>\n");

            // Prints each session object from the query
            for (Session session : SessionList) {

                out.println("<tr><td>" + df.format(session.getSessionPK().getDateKey()) + "</td>");
                out.println("<td>" + simpleDateFormat.format(session.getSessionPK().getTimeKey()) + "</td>");
                out.println("<td>" + session.getStudentLastName() + "</td>");
                out.println("<td>" + session.getSessionStatus() + "</td>");
                out.println("<td>" + session.getSessionTopic() + "</td>");
                out.println("<td>" + session.getSessionPK().getTutorTutorID() + "</td>");
                out.println("<td>" + session.getSessionPK().getCourseCourseCode() + "</td>");
                out.println("<td>" + session.getSessionPK().getStudentStudentID() + "</td></tr>");
            }

            out.println("      </tbody>\n"
                    + "    </table>\n"
                    + "  </div>\n"
                    + "</section>\n"
                    + "\n"
                    + "\n"
                    + "<!-- follow me template -->\n"
                    + "<div class=\"made-with-love\">\n"
                    + "  Made with\n"
                    + "  <i>♥</i> by\n"
                    + "  <a target=\"_blank\" href=\"https://codepen.io/nikhil8krishnan\">Nikhil Krishnan Eddited by Kevin Fox</a>\n"
                    + "</div>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Hi im here in get");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hi im here in post");
        LogInLogic passLogic = new LogInLogic();
        String user = request.getParameter("username");
        String pass = passLogic.get_SHA_512_SecurePassword(request.getParameter("password"), "");

        // create an EntityManagerFactory for the persistence unit
        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory(
                        "Foxs.Kevin.Project2PU");

        // create an EntityManager for interacting with the persistence unit
        EntityManager entityManager
                = entityManagerFactory.createEntityManager();

        //Select all query
        TypedQuery<Users> query = entityManager.createNamedQuery(
                "Users.findAll", Users.class);

        // The format and printing of each value in the database
        List<Users> UserList = query.getResultList();

        for (Users userone : UserList) {
            System.out.println(pass + "\n" + userone.getPassword());
            if (userone.getPassword().equals(pass) && (userone.getUsername().equals(user))) {
                processRequest(request, response);
            }
        }

        response.sendRedirect("/Foxs.Kevin.Project2/indexWError.html");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
