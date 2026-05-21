<%
String user = request.getParameter("username");
String pass = request.getParameter("password");

if(user.equals("admin") && pass.equals("admin")){
    out.println("<h1>Login Berhasil</h1>");
} else {
    out.println("<h1>Login Gagal</h1>");
}
%>