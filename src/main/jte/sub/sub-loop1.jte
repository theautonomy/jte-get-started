@import com.mycompany.app.Entries

@param Entries model 
@param String name
@param boolean verbose = false


@for(Entries.Entry entry : model.entries())
    <li>${entry.title()}</li>
@endfor

@if(verbose)
 ${name} 
@endif