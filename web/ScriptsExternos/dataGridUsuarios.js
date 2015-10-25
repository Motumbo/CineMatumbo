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
                    email: {path: "email", type: String},
                    categoria: {path: "categoria", type: String}
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
            {field: "nombre", title: "Nombre de usuario"},
            {field: "email", title: "Correo electronico"},
            {field: "categoria", title: "Categoria", editor: myCustomEditor},
            {
                title: "Guardar o Borrar",
                buttons: [
                    {cls: "saveButton", commandName: "save", caption: "<span>Guardar</span>"},
                    {cls: "deleteButton", commandName: "delete", caption: "<span>Borrar</span>"}
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
                        return "¿Borrar al usuario = " + item.nombre + "?";
                    }
                },
                "save": {
                    enabled: true,
                    template: function (item){
                        return "¿Guardar cambios?";
                    }
                }
            }
        },
        events:
                {
                    getCustomEditorValue: function (e) {
                        e.value = $("#dropdown").swidget().value();
                        $("#dropdown").swidget().destroy();
                    }
                }
    });
});
function myCustomEditor(cell, item) {
    $('<div id="dropdown"/>')
            .appendTo(cell)
            .shieldDropDown({
                dataSource: {
                    data: ["admin", "usuario"]
                },
                value: !item["categoria"] ? null : item["categoria"].toString()
            }).swidget().focus();
}