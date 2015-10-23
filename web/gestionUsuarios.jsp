<%-- 
    Document   : gestionUsuarios
    Created on : Oct 22, 2015, 7:19:06 PM
    Author     : Nico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <link id="themecss" rel="stylesheet" type="text/css" href="//www.shieldui.com/shared/components/latest/css/light-bootstrap-gradient/all.min.css" />
        <script type="text/javascript" src="//www.shieldui.com/shared/components/latest/js/jquery-1.10.2.min.js"></script>
        <script type="text/javascript" src="//www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
    </head>
    <jsp:include page="topMenu.jsp" />
    <body class="theme-light">
        <div id="grid"></div>
        <script src="ScriptsExternos/shortGridData.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#grid").shieldGrid({
                    dataSource: {
                        data: gridData,
                        schema: {
                            fields: {
                                id: {path: "id", type: Number},
                                age: {path: "age", type: Number},
                                name: {path: "name", type: String},
                                company: {path: "company", type: String},
                                month: {path: "month", type: Date},
                                isActive: {path: "isActive", type: Boolean},
                                email: {path: "email", type: String},
                                transport: {path: "transport", type: String}
                            }
                        }
                    },
                    paging: {
                        pageSize: 4
                    },
                    sorting: {
                        multiple: true
                    },
                    rowHover: false,
                    columns: [
                        {field: "name", title: "Person Name"},
                        {field: "age", title: "Age"},
                        {field: "company", title: "Company Name"},
                        {field: "month", title: "Date of Birth", format: "{0:MM/dd/yyyy}"},
                        {field: "isActive", title: "Active"},
                        {field: "email", title: "Email Address", width: "270px"},
                        {field: "transport", title: "Column With Custom Editor", width: "220px", editor: myCustomEditor},
                        {
                            width: "154px",
                            title: "Delete Column",
                            buttons: [
                                {cls: "deleteButton", commandName: "delete", caption: "<img src='/Content/img/grid/delete.png' /><span>Delete</span>"}
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
                                    return "Delete row with ID = " + item.id
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
                                data: ["motorbike", "car", "truck"]
                            },
                            value: !item["transport"] ? null : item["transport"].toString()
                        }).swidget().focus();
            }
        </script>
        <style type="text/css">
            .sui-button-cell {
                text-align: center;
            }
            .deleteButton img
            {
                margin-right: 3px;
                vertical-align: bottom;
            }
        </style>
    </body>
</html>