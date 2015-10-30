$(document).ready(function () {
    $("#grid").shieldGrid({
        dataSource: {
            data: gridData,
            schema: {
                fields: {
                    id: {path: "id", type: Number},
                    nombre: {path: "nombre", type: String},
                    filas: {path: "filas", type: Number},
                    columnas: {path: "columnas", type: Number},
                    tiempoLimpieza: {path: "tiempoLimpieza", type: Number}
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