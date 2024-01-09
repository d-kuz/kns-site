<#import "blocks/template.ftlh" as t>
<@t.template user>
    <p align="center">Это задание пока недоступно!</p>
    <br>
    <br>
    <#if errorTask??>
        <p style="text-align: center">#{errorTask}</p>
    </#if>
    <#if errorTime??>
        <p style="text-align: center">#{errorTime}</p>
    </#if>

</@t.template>