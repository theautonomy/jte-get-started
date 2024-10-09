@import com.mycompany.app.Entries

@param Entries model 
@param Entries model1 

@for(Entries.Entry entry : model.entries())
    <li>${entry.title()}</li>
@endfor

@for(var entry : model1.entries())
  <tr>
    <td>${entry.title()}</td>
  </tr>
@else
  <tr>
    <td colspan="2">You have forgotten your groceries list at home!</td>
  </tr>
@endfor