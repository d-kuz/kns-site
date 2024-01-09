<#import "blocks/template.ftlh" as t>
<@t.template user>

<p><h1 style="text-align: center">${course.getTitle()} | ${course.getPrice()} ₽</h1></p>
    <br>
    <br>
    <form action="/course/{idCourse}" align="center">
        <button type="button" style="width: 100%" class="btn btn-dark">Записатся</button>
    </form>
    <br>
    <br>
    <p style="text-align: center">${course.getDescription()}</p>
    <br>
    <br>
    <#if user.foundCourses(course)>
         <p style="text-align: center">Задания дня :</p>
         <br>
         <br>
         <#list tasks as task>
                 <a class="a_style" href="/course/${course.getId()}/task/${task.getId()}">Задание дня № ${task.getNamber()}</a>
             <br>
             <br>
         </#list>
    <#else>
        <p style="text-align: center">Запишитесь на курс, чтобы начать выполнять задания.</p>
    </#if>



</@t.template>