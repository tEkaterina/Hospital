<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<input name="visitId" value="${visitId}" hidden>
<input name="id" value="${analyz.getId()}" hidden>
<div class="form-group">
    <label class="control-label" for="hbA1c">Уровень hbA1c</label>
    <div class="inner-addon right-addon">
        <i class="fa fa-percent"></i>
        <input class="form-control" type="number"
               min="0" max="100" value="${analyz.getHbA1c()}" id="hbA1c" name="hbA1c" placeholder="Уровень hbA1c" step="any" required>
    </div>
</div>
<div class="form-group inner-addon right-addon">
    <label for="cholesterol" class="control-label">Общий холестерин</label>
    <div class="inner-addon right-addon">
        <i class="fa">ммоль/л</i>
        <input class="form-control" type="number" id="cholesterol" name="cholesterol" min="0" max="10" step="any" placeholder="Общий холестерин" required
             style="padding-right: 60px !important;" value="${analyz.getTotalCholesterol()}">
    </div>
</div>
<div class="form-group inner-addon right-addon">
  <label for="triglycerides" class="control-label">Триглицериды</label>
    <div class="inner-addon right-addon">
        <i class="fa">ммоль/л</i>
        <input class="form-control" type="number" min="0" max="5" id="triglycerides" name="triglycerides" step="any" placeholder="Триглицериды" required
          style="padding-right: 60px !important;" value="${analyz.getTriglycerides()}">
    </div>
</div>