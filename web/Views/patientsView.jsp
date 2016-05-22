<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" pageEncoding="WINDOWS-1251"%>
<div class="row">
  <c:forEach items = "${patients}" var="patient">
    <div class="col-md-4">
      <div class="panel panel-info" style="margin-top: 20px;">
        <div class="panel-heading" style="height: 50px !important;">
          <label style="vertical-align: bottom"><c:out value="${patient.getName()}"/> <c:out value="${patient.getSurname()}"/></label>
          <c:if test="${currentUser.isAdmin()}">
            <span class="pull-right">
              <form class="tool-form" action = "/updatePatient" method="get">
                <button type="submit" class="btn btn-default btn-sm tool">
                  <i class="fa fa-pencil tool-icon"></i>Редактировать</button>
                <input type="hidden" name="id" value="${patient.getId()}">
              </form>
              <form class="tool-form" action = "/deletePatient" method="get">
                <input type="hidden" name="id" value="${patient.getId()}">
                <input type="hidden" name="addressId" value="${patient.getAddress().getId()}">
                <button type="submit" class="btn btn-default btn-sm tool">
                  <i class="fa fa-user-times" aria-hidden="true"></i>Удалить</button>
              </form>
            </span>
          </c:if>
        </div>
        <div class="panel-body" style="padding: 0 !important;">
          <table class="table table-striped" style="margin: 0 !important;">
            <tr>
              <td>№ клининики</td>
              <td><c:out value="${patient.getClinicNumber()}"/></td>
            </tr>
            <tr>
              <td>Улица</td>
              <td><c:out value="${patient.getAddress().getStreet()}"/></td>
            </tr>
            <tr>
              <td>Дом</td>
              <td><c:out value="${patient.getAddress().getHouse()}"/></td>
            </tr>
            <tr>
              <td>Корпус</td>
              <td><c:out value="${patient.getAddress().getHousing()}"/></td>
            </tr>
            <tr>
              <td>Квартира</td>
              <td><c:out value="${patient.getAddress().getApartment()}"/></td>
            </tr>
            <tr>
              <td>Визиты</td>
              <td>
                <form action= "/patientVisits" method="get"
                      style="
                        margin: 0 !important;
                        display: inline;
                        ">
                  <input type="hidden" name="idPatient" value="${patient.getId()}">
                  <input class="btn btn-success blue" type="submit" value="Открыть список визитов">
                </form>
              </td>
            </tr>
          </table>
        </div>
      </div>
    </div>
  </c:forEach>
</div>

<c:if test="${currentUser.isAdmin() && false}">
  <form action = "/createPatient" method="get">
    <tr >
      <input type="hidden" name="id" value="0">
      <td colspan="9">Создать пациента</td>
      <td><input type="image" src="/Views/Images/add.png"></td>
    </tr>
  </form>
</c:if>