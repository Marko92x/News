/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function ucitajTabelu(){
	
	$.ajax({
		type: "GET",
		url: "http://localhost:8084/cms-rest/rest/news/ispis",
		dataType: "json",
		
		success: function(response){

			table = '<table class="table" id="tbl"><tr  id="act"><th>ID</th><th>Title</th><th>Description</th></tr>';

			$.each(response, function(index, value) {
			   
			   table += '<tr><td id="'+ (index + 1) +'">' + value.id + '</td><td>' + value.title + '</td><td>' + value.description + '</td></tr>';
			  
			});

			document.getElementById('tabela').innerHTML = table;
			

		}
	});
}

$('document').ready(function(){
    ucitajTabelu();
});