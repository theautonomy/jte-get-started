@import com.mycompany.app.Entries

@import gg.jte.support.ForSupport

@param Entries model 

@for(Entries.Entry entry : model.entries())
    <li>${entry.title()}</li>
@endfor

