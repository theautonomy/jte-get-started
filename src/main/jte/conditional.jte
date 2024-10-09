@import com.mycompany.app.Condition

@param Condition condition

@if(condition.entries().isEmpty())
    I have no entries!
@elseif(condition.entries().size() == 1)
    I have one entry!
@else
    I have ${condition.entries().size()} entries!
@endif