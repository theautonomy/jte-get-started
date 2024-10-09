@import com.mycompany.app.Entries

@import gg.jte.support.ForSupport

@param Entries model 

@for(var entryLoop : ForSupport.of(model.entries()))
    <tr class="${(entryLoop.getIndex() + 1) % 2 == 0 ? "even" : "odd"}">
        ${entryLoop.get().title()}
    </tr>
@endfor


@for(Entries.Entry entry : model.entries())
    <li>${entry.title()}</li>
@endfor

@for(var entry : model.entries())
    <li>${entry.title()}</li>
@endfor

@for(int i = 0; i < 10; ++i)
    <li>i is ${i}</li>
@endfor

