<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="form-group inner-addon left-addon">
  <i class="fa fa-user" aria-hidden="true"></i>
  <input class="form-control" type="text" name="name" placeholder="Имя" required value="${patient.getName()}">
</div>
<div class="form-group inner-addon left-addon">
  <i class="fa fa-user" aria-hidden="true"></i>
  <input class="form-control" type="text" name="surname" placeholder="Фамилия" required value="${patient.getSurname()}">
</div>
<div class="form-group inner-addon left-addon">
  <i class="fa fa-hospital-o" aria-hidden="true"></i>
  <input class="form-control" type="number" min="1" max="500" name="clinic" placeholder="№ клиники" required value="${patient.getClinicNumber()}">
</div>
<div class="form-group inner-addon left-addon">
  <i class="fa fa-road" aria-hidden="true"></i>
  <input class="form-control" type="text" name="street" placeholder="Улица" required value="${patient.getAddress().getStreet()}">
</div>
<div class="form-group inner-addon left-addon">
  <i class="fa fa-home" aria-hidden="true"></i>
  <input class="form-control" type="number" min="1" max="500" name="house" placeholder="Дом" required value="${patient.getAddress().getHouse()}">
</div>
<div class="form-group inner-addon left-addon">
  <i class="fa fa-building-o" aria-hidden="true"></i>
  <input class="form-control" type="number" name="housing" min="1" max="20" placeholder="Корпус" value="${patient.getAddress().getHousing()}">
</div>
<div class="form-group inner-addon left-addon">
  <i class="fa fa-bed" aria-hidden="true"></i>
  <input class="form-control" type="number" min="1" max="500" name="apartment" placeholder="Квартира" value="${patient.getAddress().getApartment()}">
</div>