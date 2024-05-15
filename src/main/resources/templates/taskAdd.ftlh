<#import "blocks/template.ftlh" as t>
<@t.template user>
<h1 style="text-align: center">Добавление заданий дня</h1><hr>
    <form action="/course/#{courseid}/taskAdd" method="post">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <input name="Namber" type="number" id="Namber" class="form-control" placeholder="Namber" required/>
        <br><br>
        <input name="Text" type="text" id="Text" class="form-control" placeholder="Text" required/>
        <br><br>
        <input name="link" type="text" id="link" class="form-control" placeholder="Link"/>
        <br><br>
        <button type="submit" class="btn btn-dark">Добавить задание</button>
        <br>
        <br>
        <#if errorMessage??>
            <h2 style="color: red">${errorMessage}</h2>
        </#if>
    </form>
</@t.template>