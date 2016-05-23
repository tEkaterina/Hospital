<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<div class="form-group">
    <textarea class="description form-control" type="text"
              name="comment" placeholder="¬ведите комментарий дл€ визита"
              cols="80" rows="3"><c:out value="${visit.getComment()}"/></textarea>
</div>