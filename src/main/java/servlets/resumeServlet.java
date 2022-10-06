package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ContactType;
import model.Resume;

import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "resume", value = "/resume")
public class resumeServlet extends HttpServlet {

    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String name = request.getParameter("name");

        Writer writer = response.getWriter();
        writer.write(
                """
                        <html>
                        <head>
                            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                            <link rel="stylesheet" href="css/style.css">
                            <title>Список всех резюме</title>
                        </head>
                        <body>
                        <section>
                        <table border="1" cellpadding="8" cellspacing="0">
                            <tr>
                                <th>Имя</th>
                                <th>Email</th>
                            </tr>
                        """);
        for (Resume resume : storage.getAllSorted()) {
            writer.write(
                    "<tr>\n" +
                            "<td><a href=\"resume?uuid=\" + resume.getUuid() + \">" + resume.getFullName() + "</a></td>\n" +
                            "<td>" + resume.getContact(ContactType.MAIL) + "</td>\n" +
                            "</tr>\n"
            );
        }
    }

    public void destroy() {
    }

}
