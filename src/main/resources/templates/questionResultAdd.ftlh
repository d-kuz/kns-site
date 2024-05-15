<#import "blocks/template.ftlh" as t>
<@t.template user>
<h1 style="text-align: center">Добавление результата</h1><hr>
    <form action="/test/#{testid}/resultAdd" method="post">
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <input name="resultText" type="text" id="resultText" class="form-control" placeholder="Text" required/>
        <br><br>
        <input name="min" type="number" id="min" class="form-control" placeholder="Min" required/>
        <br><br>
        <input name="max" type="number" id="max" class="form-control" placeholder="Max" required/>
        <br><br>
        <button type="submit" class="btn btn-dark" id="email">Добавить курс</button>
        <br>
        <br>
        <#if errorMessage??>
            <h2 style="color: red">${errorMessage}</h2>
        </#if>
    </form>
</@t.template>