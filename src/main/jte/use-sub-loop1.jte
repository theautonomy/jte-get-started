@import com.mycompany.app.Entries

@import gg.jte.support.ForSupport

@param Entries model 
@param String name
@param boolean verbose = false

@template.sub.sub-loop1(model, "Mark")
@template.sub.sub-loop1(model, "Mark", true)

@template.sub.sub-loop1(model=model, verbose=true, name="Mark")
