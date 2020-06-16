package com.bl.demo.alert;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AlertMessages {

    public static PrintWriter getWriter(HttpServletResponse response) throws IOException {
        return response.getWriter();
    }

    public static void openScript(HttpServletResponse response) throws IOException {
        getWriter(response).println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
        getWriter(response).println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
        getWriter(response).println("<script>");
        getWriter(response).println("$(document).ready(function() {");
    }

    public static void closeScript(HttpServletResponse response) throws IOException {
        getWriter(response).println("});");
        getWriter(response).println("</script>");
    }

    public static void registerSuccessfulMessage(HttpServletResponse response) throws IOException {
        openScript(response);
        getWriter(response).println("swal ( 'Registration Successful' ,  '' ,  'success' );");
        closeScript(response);
    }

    public static void registrationFailMassage(HttpServletResponse response) throws IOException {
        openScript(response);
        getWriter(response).println("swal ( 'Registration Unsuccessful' ,  'Please Enter Correct Data!' ,  'error' );");
        closeScript(response);
    }

    public static void databaseErrorMassage(HttpServletResponse response) throws IOException {
        openScript(response);
        getWriter(response).println("swal ( 'Database Error' ,  'Database Not Able To Store Data!' ,  'error' );");
        closeScript(response);
    }
}
