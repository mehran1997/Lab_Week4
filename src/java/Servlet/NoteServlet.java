/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author 842458
 */
public class NoteServlet extends HttpServlet {
    
    ArrayList<String> data = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession hts = request.getSession();
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        PrintWriter pwr = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        for(String temp = br.readLine(); temp != null; temp = br.readLine()){
            data.add(temp);
        }
        hts.setAttribute("data", data);
        request.setAttribute("data", data);
        
        request.getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession hs = request.getSession();
        PrintWriter wrt = response.getWriter();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        wrt.println(content);
        String ns = title + "\n" + content;
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        boolean status;
        
        wrt.print(path);
        data.clear();
        data.add(title);
        data.add(content);
        request.setAttribute("data", data);
        
        try (PrintWriter pw = new PrintWriter(new FileWriter(new File(path), true))) {
            pw.println(data.get(0));
           
            pw.close();
            status=true;
            wrt.print(status);
        } catch (IOException e) {
            status=false;
            System.out.println("Exception while file write:" + e);
        }
        request.getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

   
}
