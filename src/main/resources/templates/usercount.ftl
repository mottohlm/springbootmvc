<html>
<body>

  <p> 用户总人数为：</p>
  <p> ${count }</p>
  <p>用户分别是：</p>
  <#if list?exists>
  <#list list as user>
  <p>用户名： ${user.userName }</p>
  <p>密码： ${user.password }</p>
  </#list>
  </#if>
</body>
</html>