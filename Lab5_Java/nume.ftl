<html>
    <head>
        <title>${title}</title>
    </head>
    <body>
        <h1>${catalog.name}</h1>
        <h2>${catalog.path}</h2>
        <#list items as item>
            <h2>${item_index + 1}. ${item.name} is at path: ${item.location} <br/></h2>
        </#list>
    </body>
</html>