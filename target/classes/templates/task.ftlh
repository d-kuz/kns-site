<#import "blocks/template.ftlh" as t>
<@t.template user>
<p align="center">Задание ${task.getNamber()}</p>
    <br>
<p align="center"> ${task.getText()} </p>
    <br>
    <div class="container">
        <iframe  width="560" height="315"
                 src="${task.getLink()}"
                 title="YouTube video player" frameborder="0"
                 allow="accelerometer; autoplay; clipboard-write; encrypted-media;
            gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
        <br><br>
    </div>

    <div class="container">
        <#if task.getId()==1>
            <iframe width="560" height="315" src="https://www.youtube.com/embed/EAolQ30ErBk?si=ToryATBQ4p7GH_Et"
                    title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write;
                encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
        </#if>


    </div>


<#if noAnsw>
    <p align="center">Ответ на задание:</p>
    <div class="container">
<form action="/course/#{courseid}/task/#{task.getId()}" align="center" method="POST">
    <input type="hidden" name="example" value=""/>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
        <textarea align="center" cols="50" rows="10" name="text" id="text" class="form-control"
                  placeholder="Ответ" required></textarea>
        <br>
        <br>
        <button style="width: 100%" type="submit" class="btn btn-light" id="addAnswerUser">Отправить ответ</button>
</form>
</div>
<#else>
    <div class="container">
    <p> Ответ уже отправлен!</p>
    </div>

</#if>

</@t.template>


<div class="container">
    <form action="/course/#{courseid}/task/#{task.getId()}/change" align="center" method="POST">
        <input type="hidden" name="example" value=""/>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <textarea align="center" cols="50" rows="10" name="text" id="text" class="form-control" placeholder="Ответ" required>
                #{task.getAnswers()}
            </textarea>
        <br>
        <br>
        <button style="width: 100%" type="submit" class="btn btn-light" id="addAnswerUser">Изменить ответ</button>
    </form>
</div>