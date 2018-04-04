var html = "<button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\
  <span class=\"navbar-toggler-icon\"></span>\
</button>\
<a class=\"navbar-brand\" href=\"/\">AlphaFront</a>\
<div class=\"collapse navbar-collapse\" id=\"navbarNav\">\
  <ul class=\"navbar-nav\">\
	<li class=\"nav-item\">\
      <a class=\"nav-link\" href=\"index.html\">Home</a>\
    </li>\
    <li class=\"nav-item dropdown\">\
    <a class=\"nav-link dropdown-toggle\" href=\"#client\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\
      Client\
    </a>\
    <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\
      <a class=\"dropdown-item\" href=\"client.html\">new</a>\
    </div>\
    </li>\
    <li class=\"nav-item dropdown\">\
      <a class=\"nav-link dropdown-toggle\" href=\"#operator\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\
        Operators\
      </a>\
      <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\
        <a class=\"dropdown-item\" href=\"operators.html\">new</a>\
      </div>\
     </li>\
  </ul>\
</div>";

document.getElementById("main_menu").innerHTML = html;
document.getElementById("main_menu").className = "navbar";
document.getElementById("main_menu").className += " navbar-toggleable-md";
document.getElementById("main_menu").className += " navbar-light";
document.getElementById("main_menu").className += " bg-faded";
