<%-- 
    Document   : ListHuman
    Created on : Jan 30, 2024, 11:04:47 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="Model.Human"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Human Check</title>
        <script src="js/myJs.js"></script>
    </head>
    <body>


    <center>
        <h1>List Human</h1>
        <table border>

            <tr>
                <th>Name</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>Type</th>
                <th></th>
            </tr>
            <%
                    ArrayList<Human> listHuman = (ArrayList<Human>)request.getAttribute("listHuman");
                    if(listHuman != null){
                        for(Human human : listHuman){
            %>
            <tr>

                <td><%= human.getName()%></td>
                <td><%= human.getDob()%></td>
                <td><img <%= human.isGender() ? "src=imgs/male.png" : "src=imgs/female.png"%> width="50px" height="40px" alt="ảnh giới tính"/></td>
                <td><%= human.getType().getName()%></td>
                <td >
                    <button  onclick="location.href='updateHuman?id=<%=human.getID()%>'" >edit</button>
                    
                    <button href="#" onclick="deleteHuman(<%=human.getID()%>)" >delete</button>
                </td>

            </tr>
            <%
                    }
                }
            %>
        </table>
        
        <button onclick="location.href ='index.html'">Back to main</button>
        </center>
    </body>
</html>
