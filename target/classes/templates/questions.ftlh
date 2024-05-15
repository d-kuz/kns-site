<#import "blocks/template.ftlh" as t>
<@t.template user>
    <form action="/test/${idTest}/questions">
        <div class="container">
        <#list test.getQuestions() as questions>
        <div class="container">
            ${question.getText()}
            <#list questions.getQuestionsAnswer() as answer>
                <input type="radio" value="${answer.getPoint()}"> ${answer.getText()}
            </#list>
        </div>
        <br>
        </#list>
        </div>
        <br>
        <input type="submit">
    </a>
    </form>
</@t.template>