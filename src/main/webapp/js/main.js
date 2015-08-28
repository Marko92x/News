/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function ucitajPrvu(){
	
	$.ajax({
		type: "GET",
		url: "http://localhost:8080/Turniri2/webresources/domen.prva/sort/" + sort,
		dataType: "json",
		
		success: function(response){

			table = '<table class="table" id="tbl"><tr  id="act"><th></th><th>RBr</th><th>Naziv</th><th>Mesto</th><th>Pobede</th><th>Izgubljene</th><th>Neresene</th><th>Poeni</th></tr>';

			$.each(response, function(index, value) {
			   
			   table += '<tr><td> <input type="checkbox" id="p' + value.id + '"></td><td id="prva'+ (index + 1) +'">' + (index + 1) + '</td><td>' + value.naziv + '</td><td>' + value.mesto.naziv + '</td><td data-type="text" data-placement="right" data-title="Enter username" id="xpp' + value.id + '">' + value.pobede + '</td><td data-type="text" data-placement="right" data-title="Enter username" id="xpi' + value.id + '">' + value.izgubljene + '</td><td data-type="text" data-placement="right" data-title="Enter username" id="xpn' + value.id + '">' + value.neresene + '</td><td data-type="text" data-placement="right" data-title="Enter username" id="xpr' + value.id + '">' + value.poeni + '</td></tr>';
			  
			});

			document.getElementById('prva_liga').innerHTML = table;
			pdfTable = table;

		}
	});
}