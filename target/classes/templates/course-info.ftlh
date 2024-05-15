<#import "blocks/template.ftlh" as t>
<@t.template user>

<p><h1 style="text-align: center">${course.getTitle()} | ${course.getPrice()} ₽</h1></p>
    <br>
    <br>
    <#if notFoundCourse>
        <form action="/course/${course.getId()}" align="center">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <button type='submit' style="width: 100%" class="btn btn-dark">Записатся</button>
        </form>
        <br>
        <br>
    </#if>

    <p style="text-align: center">${course.getDescription()}</p>
    <br>
    <br>
     <p style="text-align: center">Задания дня :</p>
     <br>
     <br>
     <#list tasks as task>
         <div class="container">
             <a class="a_style" href="/course/${course.getId()}/task/${task.getId()}">Задание дня № ${task.getNamber()}</a>
         </div>
         <br>
     </#list>
    <br>

</@t.template>