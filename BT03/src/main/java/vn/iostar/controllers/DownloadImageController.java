package vn.iostar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;

import vn.iostar.util.Constant;

@WebServlet("/downloadImage")
public class DownloadImageController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        // Lấy tên file từ tham số URL
        String filename = req.getParameter("file");

        // Đường dẫn tới thư mục chứa ảnh (E:\category)
        File file = new File(Constant.DIR, filename);

        if (file.exists()) {
            // Thiết lập kiểu nội dung trả về
            resp.setContentType(getServletContext().getMimeType(file.getName()));
            resp.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");

            // Đọc file và ghi ra response
            try (FileInputStream fis = new FileInputStream(file);
                 OutputStream os = resp.getOutputStream()) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Không tìm thấy ảnh: " + filename);
        }
    }
}
