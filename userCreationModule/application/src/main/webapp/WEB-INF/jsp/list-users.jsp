<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
<H1>List of users:</H1>

<!--
<p>${users}</p>
-->

<table border="1">
<thead>
<tr>
    <th>UserId</th>
    <th>Vardas</th>
    <th>Pavarde</th>
    <th>Telefono numeris</th>
    <th>Email</th>
    <th>Adresas</th>
    <th>Slaptazodis</th>
</tr>
</thead>
<tbody>
<c:forEach items="${users}" var="user">
<tr>
    <td>${user.userId}</td>
    <td>${user.vardas}</td>
    <td>${user.pavarde}</td>
    <td>${user.telefonoNumeris}</td>
    <td>${user.email}</td>
    <td>${user.adresas}</td>
    <td>${user.slaptazodis}</td>

    <td><a type="button" href="/update-user/${user.userId}">UPDATE</a></td>
    <td><a type="button" href="/delete-user/${user.userId}">DELETE</a></td>
</tr>
</c:forEach>

</tbody>
</table>

<div>
<a href="add-user">ADD User</a>
</div>
</div>
<%@ include file="common/footer.jspf"%>