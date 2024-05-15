<#import "blocks/template.ftlh" as t>
<@t.template user>
<h1 style="text-align: center">Добавление теста</h1><hr>
    <form action="/testAdd" method="post">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <input name="testTitle" type="text" id="testTitle" class="form-control" placeholder="testTitle" required/>
        <br><br>
        <input name="testDescription" type="text" id="testDescription" class="form-control" placeholder="testDescription" required/>
        <br><br>
        <button type="submit" class="btn btn-dark">Добавить тест</button>
        <br>
        <br>
        <#if errorMessage??>
            <h2 style="color: red">${errorMessage}</h2>
        </#if>
    </form>
</@t.template>