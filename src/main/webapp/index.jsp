<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Prog Academy</title>
  </head>
  <body>
    <% String login = (String)session.getAttribute("user_login"); %>
    <% Integer age = (Integer) session.getAttribute("user_age"); %>
    <% Boolean passValid = (Boolean) session.getAttribute("pass_valid"); %>
    <% Boolean pas_log = (Boolean) session.getAttribute("log_pas"); %>

    <% if (login == null || "".equals(login))  { %>
        <form action="/login" method="POST">
            Login: <input type="text" name="login"><br>
            Password: <input type="password" name="password"><br>
            Age: <input type="text" name="age"><br>
            <input type="submit" />
        </form>
        <% if (age != null && age == -1){ %>
            <h2>you are under 18 years old</h2>
        <% } %>
        <% if (age != null && age == 0){ %>
            <h2>age is not entered or entered incorrectly</h2>
        <% } %>
        <% if (passValid!=null && passValid == false){ %>
            <h2>your password must be 10 characters long</h2>
        <% } %>
        <% if (pas_log !=null && pas_log  == true){ %>
            <h2>your password or login is wrong</h2>
        <% } %>
    <% } else { %>
        <h1>You are logged in as: <%= login %></h1>
        <br>Click this link to <a href="/login?a=exit">logout</a>
    <% } %>
  </body>
</html>
