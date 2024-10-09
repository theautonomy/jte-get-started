@param String title
@param String ... elements
<h2>${title}</h2>
<ul>
@for(var element : elements)
    <li>${element}</li>
@endfor
</ul>