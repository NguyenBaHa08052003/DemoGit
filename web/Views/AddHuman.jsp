<%-- 
    Document   : AddHuman
    Created on : Jan 30, 2024, 9:21:51 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.util.List"%>
<%@page  import="Model.HumanType"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    
        <form method="post">
            <div>
            <label>ID</label>
            <input required name="getId"><!-- comment -->
        </div>
        
        <div>
            <label>Human Name</label>
            <input required name="getName"><!-- comment -->
        </div>
        
        <div>
            <label>DOB</label>
            <input  required name="getDOB" type="date" "><!-- comment -->
        </div>
            
        <div>
            <label>Gender</label>
            <input checked type="radio" name="getGender" value="male"> Male <!-- comment -->
            <input type="radio" name="getGender" value="female"> Female<!-- comment -->
        </div>
        
        <div>
            <select name="getTypeId">
                <%
                    List<HumanType> listHumanType = (List<HumanType>)request.getAttribute("listHumanType");
                    if(listHumanType != null && !listHumanType.isEmpty()){
                        for(HumanType humanType : listHumanType){
                        %>
                        <option value="<%=humanType.getTypeId() %>"><%=humanType.getName()%></option>
                        <%
                    }                                        
                    
                    
                    }
                
                %>
                
            </select>
        </div>
            <input value="Submit" type="submit"/>
        </form>
        
        <div>
            <%
                    String err = (String)request.getAttribute("err");
                    
                    if(err!=null && !err.isEmpty()){
                    out.print("<h1>" + err +"</h1>");
                    }
            
            %>
            
            <%
                    java.sql.Date date = (java.sql.Date)request.getAttribute("date");
                    
                    if(date!=null){
                    out.print("<h1>" + date +"</h1>");
                    }
            
            %>
            
        </div>
        <button onclick="location.href ='index.html'">Back to main</button>
    </body>
</html>
