<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="col-md-4 col-sm-6">
  <div class="panel panel-info" style="margin-top: 20px;">
    <div class="panel-heading">
      <label style="vertical-align: bottom"><c:out value="${patient.getName()}"/> <c:out value="${patient.getSurname()}"/>
        <c:if test="${currentUser.isAdmin()}">
          <span class="pull-right">
            <form class="tool-form" action = "/updatePatient" method="get">
              <button type="submit" class="btn btn-default btn-sm tool">
                <i class="fa fa-pencil tool-icon"></i>Редактировать</button>
              <input type="hidden" name="id" value="${patient.getId()}">
            </form>
            <form id="${patient.getId()}Delete" class="tool-form" action = "/deletePatient" method="get">
              <input type="hidden" name="id" value="${patient.getId()}">
              <input type="hidden" name="addressId" value="${patient.getAddress().getId()}">
              <button type="submit" class="btn btn-default btn-sm tool">
                <i class="fa fa-user-times" aria-hidden="true"></i>Удалить
              </button>
            </form>
          </span>
      </label>
      </c:if>
    </div>
    <div class="panel-body" style="padding: 0 !important;">
      <table class="table table-striped table-bordered" style="margin: 0 !important;">
        <tr>
          <td><i class="fa fa-hospital-o" aria-hidden="true"></i></td>
          <td>№ клининики</td>
          <td><c:out value="${patient.getClinicNumber()}"/></td>
        </tr>
        <tr>
          <td><i class="fa fa-road" aria-hidden="true"></i></td>
          <td>Улица</td>
          <td><c:out value="${patient.getAddress().getStreet()}"/></td>
        </tr>
        <tr>
          <td><i class="fa fa-home" aria-hidden="true"></i></td>
          <td>Дом</td>
          <td><c:out value="${patient.getAddress().getHouse()}"/></td>
        </tr>
        <tr>
          <td><i class="fa fa-building-o" aria-hidden="true"></i></td>
          <td>Корпус</td>
          <td><c:out value="${patient.getAddress().getHousing()}"/></td>
        </tr>
        <tr>
          <td><i class="fa fa-bed" aria-hidden="true"></i></td>
          <td>Квартира</td>
          <td><c:out value="${patient.getAddress().getApartment()}"/></td>
        </tr>
        <tr>
          <td><i class="fa fa-users" aria-hidden="true"></i></td>
          <td>Визиты</td>
          <td>
            <form action= "/patientVisits" method="get"
                  style="
                        margin: 0 !important;
                        display: inline;
                        ">
              <input type="hidden" name="patientId" value="${patient.getId()}">
              <input class="btn btn-success blue" type="submit" value="Открыть список визитов">
            </form>
          </td>
        </tr>
      </table>
    </div>
  </div>
</div>
