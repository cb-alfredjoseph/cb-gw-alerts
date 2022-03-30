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
        <th>Name</th>
        <th>Link</th>
    </tr>


    <#list merchantDomainList as merchantDomainList>
        <tr style="text-align: center">
            <td>${(gateway)!"NA"}</td>
            <td>${(paymentMethod)!"NA"}</td>
            <td>${(status)!"NA"}</td>
            <td>${(merchantDomainList.count)!"NA"}</td>

            <td>${(merchantDomainList.name)!"NA"}</td>
            <td>${(merchantDomainList.link)!"NA"}</td>
        </tr>
    </#list>

</table>
<#--<#list merchantDomainList as merchantDomainList>-->
<#--    <h1>${merchantDomainList.count}</h1>-->
<#--</#list>-->
</body>
</html>
