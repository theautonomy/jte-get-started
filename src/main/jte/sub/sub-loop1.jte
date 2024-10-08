@import com.mycompany.app.Loop

@param Loop model 
@param String name
@param boolean verbose = false


@for(Loop.Entry entry : model.entries())
    <li>${entry.title()}</li>
@endfor

@if(verbose)
 ${name} 
@endif