<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="row">
  <div class="col-sm-offset-1 col-sm-10 text-center">
    <c:if test="${currentUser.isDoctor()}">
      <form class="form-inline" action = "/createVisit" method="POST">
        <div class="form-group">
            <textarea class="description form-control" type="text"
                      name="comment" placeholder="Введите комментарий для визита"
                      cols="80" rows="3"></textarea>
          <input type="hidden" name="patientId" value="${patient.getId()}">
        </div>
        <button type="submit" class="btn btn-success blue">
          <i class="fa fa-ambulance" style="color: #ffffff;"></i>Добавить визит
        </button>
      </form>
    </c:if>
  </div>
</div>