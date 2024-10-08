@import com.mycompany.app.Loop

@param Loop model 
@param Loop model1 

@for(Loop.Entry entry : model.entries())
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