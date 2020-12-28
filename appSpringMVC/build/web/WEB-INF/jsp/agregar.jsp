
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
              crossorigin="anonymous">
        <title>Agregar</title>
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card border-info">
                <div class="card-header bginfo">
                    <h4>Agregar nuevo registro</h4>
                </div>
                <div class="card-body">
                    <form method="post">
                        <label>Nombres:</label>
                        <input type="text" name="nombre" class="form-control">
                        <label>Correo:</label>
                        <input type="text" name="correo" class="form-control">
                        <label>Nacionalidad:</label>
                        <input type="text" name="nacionalidad" class="form-control">
                        <input type="submit" value="Agregar" class="btn btn-success">
                        <a href="index.htm">Regresar</a>
                    </form>
                </div>
            </div>
        </div> 
    </body>
</html>
