var gridData =
        [
            {
                "id": 0,
                "nombre": "Nico Kaker",
                "email": "nico@gmail.com",
                "categoria": "admin"
            },
            {
                "id": 1,
                "nombre": "Guido Suller",
                "email": "guido@hotmail.com",
                "categoria": "admin"
            },
            {
                "id": 2,
                "nombre": "Miller Gomez",
                "email": "millergomez@quilm.com",
                "categoria": "usuario"
            },
            {
                "id": 3,
                "nombre": "Teniente Dan",
                "email": "blabla@gilquesobra.com",
                "categoria": "usuario"
            },
            {
                "id": 4,
                "nombre": "Paco Cero",
                "email": "gomamon@arrobapunto.com",
                "categoria": "usuario"
            }
        ];

$(document).ready(function () {
    $("#grid").shieldGrid({
        dataSource: {
            data: gridData,
            schema: {
                fields: {
                    //id: {path: "id", type: Number},
                    nombre: {path: "nombre", type: String},
                    filas: {path: "filas", type: int},
                    columnas: {path: "columnas", type: int},
                    tiempoLimpieza: {path: "tiempoLimpieza", type: int}
                }
            }
        },
        paging: {
            pageSize: 10
        },
        sorting: {
            multiple: true
        },
        rowHover: false,
        columns: [
            {field: "nombre", title: "Nombre de sala"},
            {field: "filas", title: "Numero de filas"},
            {field: "columnas", title: "Numero de columnas"},
            {field: "tiempoLimpieza", title: "Tiempo de limpieza"},
            {
                width: "154px",
                title: "Delete Column",
                buttons: [
                    {cls: "deleteButton", commandName: "delete", caption: "<span>Delete</span>"}
                ]
            }
        ],
        editing: {
            enabled: true,
            event: "click",
            type: "cell",
            confirmation: {
                "delete": {
                    enabled: true,
                    template: function (item) {
                        return "Borrar la sala = " + item.nombre + "?";
                    }
                }
            }
        }
    });
});