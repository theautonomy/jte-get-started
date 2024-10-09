@import gg.jte.Content
@import com.mycompany.app.Loop
@import com.mycompany.app.EmailService

@param EmailService.EmailModel email
@param Loop loop

@param Content content
@param Content footer = null

${email.name}

<body>
    <h1>${email.activationLink}</h1>
    
    @for(Loop.Entry entry : loop.entries())
    <li>${entry.title()}</li>
    @endfor

    <div class="content">
        ${content}
    </div>
    @if (footer != null)
        <div class="footer">
            ${footer}
        </div>
    @endif
</body>