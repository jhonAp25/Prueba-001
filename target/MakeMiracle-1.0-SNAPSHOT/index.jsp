
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://bootswatch.com/4/flatly/bootstrap.min.css" >
        <script src="https://kit.fontawesome.com/6a6cda8880.js" crossorigin="anonymous"></script>
    </head>
    <body>

   
        <div class="" style="display: flex">

            <div class="container mt-4 col-lg-4 col-xs-4">
                <div class="card border-info">
                    <div  class="card-header bg-info">
                        <h4>AGREGAR REGISTRO</h4>
                    </div>
                </div>
                <div class="card-body">


                    <div class="row">
                        <form action="" method="post" class="form-row">
                            <div class="col-lg-4">   
                                <label>ID </label>
                                <input type="text" id="est_cod" class="form-control" disabled="">
                            </div>


                            <div class="col-lg-5">
                                <label>DNI </label>
                                <input type="number" id="est_dni" class="form-control " pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==8) return false;">
                            </div>

                            <div class="mt-2 col-lg-3">
                                <label></label>
                                <input type="submit" value="verificar" class="btn btn-success form-control ">
                            </div>

                            <div class="col-lg-6">   
                                <label>APELLIDOS </label>
                                <input type="text" id="est_apellidos" class="form-control">
                            </div>

                            <div class="col-lg-6">   
                                <label>NOMBRES </label>
                                <input type="text" id="est_nombres" class="form-control">
                            </div>

                            <div class="col-lg-4">   
                                <label>SEXO </label>
                                <input type="radio" id="sexo" name="est_sexo" value="M" class="" checked="" />
                                <label for="sexM"  class="" >M</label>
                                <input type="radio" id="sexo" name="est_sexo" class="" value="F" />
                                <label for="sexF"  class="" >F</label>

                            </div>

                            <div class="col-lg-8">
                                <label>FECHA DE NACIMIENTO </label>
                                <input type="text" id="est_nacimiento" class="form-control">
                            </div>



                            <div class="col-lg-7">   
                                <label>DIRRECION </label>
                                <input type="text" id="est_direccion" class="form-control">

                            </div>

                            <div class="col-lg-5">

                                <label>DISTRITO</label>

                                <select  class="form-control" id="dist" >
                                    <option value="1">San Juan de Lurigancho</option>
                                    <option value="2">Barranco</option>
                                    <option value="3">Rimac</option>
                                    <option value="4" >Miraflores</option>

                                </select>
                            </div>

                            <div class="col-lg-4">   
                                <label>TELF </label>
                                <input type="text" id="est_telefono" class="form-control">
                            </div>

                            <div class="col-lg-8">
                                <label>CORREO </label>
                                <input type="email" id="est_correo" class="form-control">  
                                <input type="hidden" id="estado" value="ACTIVO">  
                            </div>

                            <div class="mt-4 col-lg-3">
                                <input type="button" value="agregar" id="guardar" class="btn btn-success form-control">
                            </div>

                            <div class="mt-4 col-lg-3">
                                <a href="index.htm"  class="form-control btn btn-info">Regresar</a>
                            </div>


                        </form>
                    </div>

                </div>


            </div> 






            <div class="container-fluid">



                <div class="container mt-4">

                    <button type="submit" class="btn btn-info"><i class="fas fa-user-plus"></i></button>


                    <table border="1" class="table table-hover mt-4">
                        <thead class="bg-primary" style="color: white;"> 
                            <tr>
                                <th>DNI</th>
                                <th>NOMBRE</th>
                                <th>SEXO</th>
                                <th>DIRECCION</th>
                                <th>ESTADO</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody id="tbody-list">
                            <!---      <tr class="col-12">
                                      <td></td>
                                      <td></td>
                                      <td></td>
                                      <td></td>
                                      <td></td>
                                      <td><a href="#" class="btn btn-warning col-4"><i class="fas fa-user-edit"></i></a>
                                          <a href="#" class="btn btn-danger col-4"><i class="fas fa-user-slash"></i></a></td>
                                  </tr>--->




                        </tbody>
                    </table>

                </div>


            </div>


        </div>
    
    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    <script src="js/Metodos.js" type="text/javascript"></script>
</body>
</html>
