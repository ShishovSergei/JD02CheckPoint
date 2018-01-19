package by.itacademy;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author Сергей
 */
@WebServlet("/filmtitle")
public class FilmTitleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("filmtitle", new FilmService().getDefaultFIlm());
        req.getRequestDispatcher("/WEB-INF/jsp/filmtitle.jsp")
                .forward(req, resp);
    }
}
