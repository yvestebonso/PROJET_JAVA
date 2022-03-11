<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<%@include file="/WEB-INF/views/common/head.jsp"%>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    <!-- Left side column. contains the logo and sidebar -->
    <%@ include file="/WEB-INF/views/common/sidebar.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
               Modifier Reservations
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Horizontal Form -->
                    <div class="box">
                        <!-- form start -->
                        <form class="form-horizontal" method="post" action="editer">
                            <div class="box-body">
                            <div class="form-group">
                                    <div class="col-sm-10">
                                        <input type="hidden" class="form-control" id="id" name="id" value="${idReser}">  <!-- permet de recuperer l'id du client -->
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="car" class="col-sm-2 control-label">Voiture</label>

                                    <div class="col-sm-10">
                                       <!--  <select class="form-control" id="car" name="car">
                                            <option value="1">Renault Clio</option>
                                            <option value="2">Citroen" C2</option>
                                        </select> -->
                                        
                                        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
											<select class="form-control" id="idVehicle" name="idVehicle">
												<c:forEach items="${ reservations }" var="resas"
													varStatus="loop">
													<option value="${id_vehicule}">${resas.voiture}</option>
												</c:forEach> 
												<c:forEach items="${ listvehicles }" var="vehicle"
													varStatus="loop">
													<option value="${vehicle.id}">${vehicle.model}</option>
												</c:forEach>
											</select>
											
											
										</div>
                                </div>
                                <div class="form-group">
                                    <label for="client" class="col-sm-2 control-label">Client</label>

                                    <div class="col-sm-10">
                                        <!-- <select class="form-control" id="client" name="client">
                                            <option value="1">John Doe</option>
                                            <option value="2">Jane Doe</option>
                                        </select> -->
                                        
                                        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
											<select class="form-control" id="idClient" name="idClient">
												<c:forEach items="${ reservations }" var="resas"
													varStatus="loop">
													<option value="${id_client}" selected>${resas.client}</option>
												</c:forEach>
												<c:forEach items="${ listUsers }" var="user"
													varStatus="loop">
													<option value="${user.id}">${user.name} ${user.lastname}</option>
												</c:forEach>
											</select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="begin" class="col-sm-2 control-label">Date de debut</label>

                                    <div class="col-sm-10">
                                        <input type="Date" class="form-control" id="begin" name="begin" value="${ date_debut }" required>
                                    <!--            data-inputmask="'alias': 'yyyy/mm/dd'" data-mask -->
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="end" class="col-sm-2 control-label">Date de fin</label>

                                    <div class="col-sm-10">
                                        <input type="Date" class="form-control" id="end" name="end" value="${ date_fin }"required>
                                               <!-- data-inputmask="'alias': 'yyyy/mm/dd'" data-mask -->
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="submit" class="btn btn-info pull-right">Editer</button>
                            </div>
                            <!-- /.box-footer -->
                        </form>
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col -->
            </div>
        </section>
        <!-- /.content -->
    </div>

    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</div>
<!-- ./wrapper -->

<%@ include file="/WEB-INF/views/common/js_imports.jsp" %>
<script src="${pageContext.request.contextPath}/resources/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${pageContext.request.contextPath}/resources/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script>
    $(function () {
        $('[data-mask]').inputmask()
    });
</script>
</body>
</html>
