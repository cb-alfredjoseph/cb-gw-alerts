<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        table, th, td {
            border:1px dotted blue;
        }
    </style>
</head>
<body>
<table style="width:100%" >
    <tr>
        <th>Gateway</th>
        <th>Payment Method</th>
        <th>Status</th>
        <th>Count</th>
<#--        <th>Name</th>-->
<#--        <th>Link</th>-->
    </tr>

     <#list   paymentMethodList as paymentMethodList>
          <tr>
            <td>${gateway}</td>
            <td>${paymentMethod}</td>
            <td>${status}</td>
              <td>${paymentMethodList.merchantDomainList.count}</td>
<#--              <td>${merchant.name}</td>-->
<#--              <td>${merchant.link}</td>-->
        </tr>
     </#list>

</table>
<#--<#list merchantDomainList as merchantDomainList>-->
<#--    <h1>${merchantDomainList.count}</h1>-->
<#--</#list>-->
</body>
</html>
