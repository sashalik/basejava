package ru.javawebinar.basejava.web;

import ru.javawebinar.basejava.Config;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.Storage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class ResumeServlet extends HttpServlet {
    private Storage storage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storage = Config.get().getStorage();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Writer writer = response.getWriter();
        writer.write(
                "<html>" +
                        "<head>" +
                        "    <title>Список резюме</title>" +
                        "</head>" +
                        "<body>" +
                        "  <center>" +
                        "  <table border=1 width=640>" +
                        "    <tr height = 50>" +
                        "      <td colspan=3> <font size = 5> Список резюме </font> </td>" +
                        "    </tr>");
        for (Resume resume : storage.getAllSorted()) {
            writer.write(
                    "<tr height = 50>" +
                            "<td> <center>" + resume.getUuid() + "</center></td>" +
                            "<td> <center>" + resume.getFullName() + "</center></td>" +
                            "</tr>");
        }
        writer.write("</table>" +
                "</center>" +
                "</body>" +
                "</html>");
    }
}
