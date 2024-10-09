@import com.mycompany.app.Entries
@import com.mycompany.app.Email

@param Email.EmailModel email
@param Entries entries

@template.layout.my-layout(
    email = email,
    entries = entries,
    content = @`
        <p>Welcome, ${entries.entries().size()}.</p>
    `,
    footer = @`
        <p>Welcome, ${entries.entries().size()}.</p>
    `
)