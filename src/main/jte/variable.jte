@import com.mycompany.app.Entries

@param Entries model 

!{var entries = model.entries();}
!{var entry = model.entries().get(0);}

<%-- this doesn't work
for(Entries.Entry entry : entries)
    <li>${entry.title()}</li>
@endfor
--%>

Total number: ${entries.size()}
Entry at index 0: ${entry.title()}
