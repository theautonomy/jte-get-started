@import gg.jte.Content
@import com.mycompany.app.Entries
@import com.mycompany.app.Email

@param Email.EmailModel email
@param Entries entries

@param Content content
@param Content footer = null

${email.name}

<body>
    <h1>${email.activationLink}</h1>
    
    @for(Entries.Entry entry : entries.entries())
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