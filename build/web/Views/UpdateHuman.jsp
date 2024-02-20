<%-- 
    Document   : UpdateHuman
    Created on : Jan 31, 2024, 8:54:54 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="Model.Human" %> 
<%@page import="Model.HumanType" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>UPDATE HUMAN</h1>
        <%
                if(request.getAttribute("humanInList")!= null){
                Human human = (Human)request.getAttribute("humanInList");
                  %>   
                  <form action="updateHuman" method="post">           
            <div>
            <label>ID</label>
            <input  name="getId" value="<%=human.getID()%>" readonly><!-- comment -->
        </div>
        
        <div>
            <label>Human Name</label>
            <input required name="getName" value="<%=human.getName()%>"><!-- comment -->
        </div>
        
        
            <label>DOB</label>
            <input required name="getDOB" type="date" value="<%=human.getDob()%>">
        
            
        <div>
            <label>Gender</label>
            <input  type="radio" name="getGender" value="male" <%=human.isGender() == true ? "checked" : "" %> > Male<!-- comment -->
            <input  type="radio" name="getGender" value="female" <%=human.isGender() == false ? "checked" : "" %>> Female<!-- comment -->
        </div>
        
        <div>
            <select name="getTypeId">
                <%
                      List<HumanType>  humanType = (List<HumanType>)request.getAttribute("humanTypeInList");
                      if(humanType != null && !humanType.isEmpty()){
                            for(HumanType hmType : humanType){
                            
                    
                      %>
                      <option  value="<%=hmType.getTypeId()%>" <%=human.getType().getTypeId() == hmType.getTypeId() ? "selected" : "" %>><%=hmType.getName()%></option>      
                    <%
                        }
                    }
                
                %>
            </select>
        </div>
            <input value="Update" type="submit"/>
            
        </form>
                <%
                    }
                    %>
                    <button onclick="location.href='listHuman'">Back To List</button>
    </body>
</html>
