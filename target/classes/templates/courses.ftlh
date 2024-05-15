<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1 style="text-align: center">Курсы</h1><hr>

    <hr>

        <#list courses as course>
            <div class="container">
            <a class="a_style" href="/course/${course.getId()}">
                        <h5>${course.title}</h5>
            </a>
            </div>
        </#list>

</@t.template>