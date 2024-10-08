@import com.mycompany.app.Loop

@import gg.jte.support.ForSupport

@param Loop model 
@param String name
@param boolean verbose = false

@template.sub.sub-loop1(model, "Mark")
@template.sub.sub-loop1(model, "Mark", true)

@template.sub.sub-loop1(model=model, verbose=true, name="Mark")
