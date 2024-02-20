/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function deleteHuman(id){
    if(confirm("are U sure delete ID = " + id)){
        window.location = "deleteHuman?id="+id;
    }
}

