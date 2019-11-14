$(document).ready(function () {
    console.log('JQuery esta funcionando');

    function Listar() {
        $.post('EstudianteServlet', {op: "listar"}, function (response) {
//            console.log(response);
            const datos = JSON.parse(response);
            console.log(datos);
            let template = '';
            datos.forEach(item => {
                template += `<tr  class="col-12">
                                <td>${item.id}</td>
                                <td>${item.apellido}  ${item.nombres}</td>
                                <td>${item.sexo}</td>
                                <td>${item.fechaNac}</td>
                                <td>${item.estado}</td>
                                <td>
                                    <button class="btn btn-warning  col-4 editar" id="${item.id}">
                                       <i class="fas fa-user-edit"></i>
                                    </button>
                                    <button class="btn btn-danger col-4 eliminar" id="${item.id}">
                                      <i class="fas fa-user-slash"></i>
                                    </button>
                                </td>
                            </tr>
                            `;
            });

            $('#tbody-list').html(template);



        });
    }

    Listar();
    function Obtener() {
        var id = $('#est_cod').val();
        var dni = $('#est_dni').val();
        var apellidos = $('#est_apellidos').val();
        var nombre = $('#est_nombres').val();
        
        var sexo = $('#sexo').val();
        
        
        var fechaNac = $('#est_nacimiento').val();
        var direccion = $('#est_direccion').val();
        var idDist = $('#dist').val();
        var telefono = $('#est_telefono').val();
        var correo = $('#est_correo').val();
        var estado = $('#estado').val();

        var op;
        if (id.length === 0) {
            op = 'insertar';
        } else {
            op = 'actualizar';
        }

        const datos = {
            op, id, dni, apellidos, nombre, sexo, fechaNac, direccion, idDist, telefono, correo, estado
        };

        return datos;
    }

    function Limpiar() {
        $('#est_cod').val("");
        $('#est_dni').val("");
        $('#est_apellidos').val("");
        $('#est_nombres').val("");
        $('#sexo').val("");
        $('#est_nacimiento').val("");
        $('#est_direccion').val("");
        $('#dist').val("");
        $('#est_telefono').val("");
        $('#est_correo').val("");
        $('#estado').val("");
    }

    $('#guardar').click(function () {
        const datos = Obtener();
        console.log(datos);
        $.post('./EstudianteServlet',datos, function(response){
            console.log(response);
            Listar();
            Limpiar();
        });
    });

    $(document).on('click', '.editar', function () {
      
        const id = $(this).attr('id');
        $.post('EstudianteServlet', {op: "listarID", id}, function (response) {
            console.log(response);
             
            const datos = JSON.parse(response);
            

            $('#est_cod').val(datos[0].id);
            $('#est_dni').val(datos[0].dni);
            $('#est_apellidos').val(datos[0].apellido);
            $('#est_nombres').val(datos[0].nombres);
//            $('#sexo').val(datos[0].sexo);
            $('#est_nacimiento').val(datos[0].fechaNac);
            $('#est_direccion').val(datos[0].direc);
            $('#dist').val(datos[0].idDist);
            $('#est_telefono').val(datos[0].telefono);
            $('#est_correo').val(datos[0].correo);
            $('#estado').val(datos[0].estado);
        });
    });


    $(document).on('click', '.eliminar', function () {
        const id = $(this).attr('id');
        $.post('EstudianteServlet', {op: "eliminar", id}, function (response) {
            console.log(response);
            Listar();
        });
    });

});