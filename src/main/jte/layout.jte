@import com.mycompany.app.Loop
@import com.mycompany.app.EmailService

@param EmailService.EmailModel email
@param Loop model

@template.layout.my-layout(
    email = email,
    loop = model,
    content = @`
        <p>Welcome, ${model.entries().size()}.</p>
    `,
    footer = @`
        <p>Welcome, ${model.entries().size()}.</p>
    `
)