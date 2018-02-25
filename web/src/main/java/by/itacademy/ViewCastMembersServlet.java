package by.itacademy;

import by.itacademy.dto.CastMemberDto;
import by.itacademy.entity.CastMember;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewcastmembers")
public class ViewCastMembersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer page;
        try {
            page = Integer.valueOf(req.getParameter("page"));
        } catch (NumberFormatException e) {
            page = 1;
        }
        Integer limit = Integer.valueOf((String) session.getAttribute("limit"));
        CastMemberDto castMemberDto = new CastMemberDto(((String) session.getAttribute("gender")),
                (String) session.getAttribute("name"),
                (String) session.getAttribute("surname"), limit, page);
        List<CastMember> castMembers = new CastMemberService().getCastMembersByParams(castMemberDto);
        req.setAttribute("castmembers", castMembers);
        req.setAttribute("pages", Math.ceil(new CastMemberService().getCastMembersCount(castMemberDto) / limit));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/viewcastmembers.jsp").forward(req, resp);
    }
}
