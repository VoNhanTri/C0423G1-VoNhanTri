import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DescriptionServlet", value = "/DescriptionServlet")
public class DescriptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("Description");
        double price = Double.parseDouble(request.getParameter("List_Price"));
        double discount = Double.parseDouble(request.getParameter("Discount_Percent"));
        double discountMount = price * discount *0.01;
        double discountPrice = price - discountMount;
        request.setAttribute("discountPrice",discountPrice);
        request.setAttribute("discountMount",discountMount);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("discountPrice.jsp");
        requestDispatcher.forward(request, response);
    }
}
