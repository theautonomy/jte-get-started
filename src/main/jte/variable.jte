@import com.mycompany.app.Loop

@param Loop model 

!{var entries = model.entries();}
!{var entry = model.entries().get(0);}

<%-- this doesn't work
for(Loop.Entry entry : entries)
    <li>${entry.title()}</li>
@endfor
--%>

Total number: ${entries.size()}
Entry at index 0: ${entry.title()}
