<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registered Users</title>
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script
        src="https://cdn.datatables.net/1.10.9/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet"
        href="http://cdn.datatables.net/1.10.9/css/jquery.dataTables.min.css" />
    <link rel="stylesheet"
        href="http://code.jquery.com/ui/1.11.4/themes/flick/jquery-ui.css">
    <script>
        
    var saveme =  $.ajax({
        type: "POST",
        url: "http://localhost:8080/listarUsuarios", //nombre del archivo php que consultaremos.
      
        success: function(data) {
          $.each(data, function(i, item) {
          lista = document.getElementById("myTable");
          var tr = document.createElement("tr");
          
          var columna1 = document.createElement("th")
          columna1.innerHTML = item.cedula_Usuario; /*par�metro Cliente DTO*/
          
          var columna2 = document.createElement("th")
          columna2.innerHTML = item.nombre_usuario;
          
          var columna3 = document.createElement("th")
          columna3.innerHTML = item.email_usuario;
          
          var columna4 = document.createElement("th")
          columna4.innerHTML = item.password;
          
          var columna5 = document.createElement("th")
          columna5.innerHTML = item.usuario;
        
          lista.appendChild(tr);
          tr.appendChild(columna1);
          tr.appendChild(columna2);
          tr.appendChild(columna3);
          tr.appendChild(columna4);
          tr.appendChild(columna5);
       
         });
        }
      });
    
    </script>

<style>
table, th, td {
  border: 1px solid black;
  font-family: Arial;
}

th{
color: black;
background-color: rgb(217, 215, 228);;
}

</style>

    </head>
    <body>
    
    <table id="tabla">
<thead>
  <tr>
    <th>CEDULA</th>
    <th>NOMBRE</th>
    <th>CORREO ELECTRONICO</th>
    <th>PASSWORD</th>
    <th>USUARIO</th>

  </tr>
  </thead>
  
<tbody id="myTable">
</tbody>
    
    </body>
    </html>